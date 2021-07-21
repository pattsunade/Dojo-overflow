package com.patriciadelgado.ninjaoverflow.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.patriciadelgado.ninjaoverflow.Models.Answer;
import com.patriciadelgado.ninjaoverflow.Models.Question;
import com.patriciadelgado.ninjaoverflow.Models.Tag;
import com.patriciadelgado.ninjaoverflow.services.AnswerService;
import com.patriciadelgado.ninjaoverflow.services.QuestionService;
import com.patriciadelgado.ninjaoverflow.services.TagService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {
    private final QuestionService questionService;
    private final TagService tagService;
    private final AnswerService answerService;
   
   
    public QuestionController(QuestionService questionService, TagService tagService, AnswerService answerService) {
        this.questionService = questionService;
        this.tagService = tagService;
        this.answerService = answerService;
    }

    @RequestMapping("/dashboard")
    public String dashboard(@ModelAttribute("question") Question question, Model model) {
        List<Question> questions = questionService.allQuestion();
        model.addAttribute("question", questions);
        return "dashboard.jsp";
    }
    
    @GetMapping("/question/new")
    public String newQuestion(
            @ModelAttribute("questionQ") Question questionQ) {
        return "createQuestion.jsp";
        }
    @PostMapping("/question/new")
    public String create(@RequestParam(value = "tagString") String tagString,
    @Valid @ModelAttribute("questionQ") Question questionQ,
            BindingResult result) {
        if (result.hasErrors()) {
            return "createQuestion.jsp";
        }
        questionService.createQuestion(questionQ);//guardar pregunta
        String[] tg = new String[3];// numero de palabras
        tg = tagString.split(",");//separa con comas las cositas
        for (String string : tg) {//for mamadisimo
            string.toLowerCase();//convierte los tag a chiquitos
            string = string.trim();// borra los espacios de los costados
            if (tagService.findTag(string) == null) {
                Tag t = new Tag(string);
                tagService.createTag(t);//si el tag no existe te la crea By Saimon :slight_smile:
            }
            questionQ.setTag(tagService.findTag(string));
            questionQ.getTags().add(tagService.findTag(string));// esto hace lo mismo que lo del model By Saimon >:c
        }
        questionService.createQuestion(questionQ);//guardar pregunta c:

        //     questionService.createQuestion(question);
        //     Tag tags = new Tag(tagString);
        //     tagService.createTag(tags);
        //     question.setTag(tags);
        //     questionService.createQuestion(question);
        //     return "redirect:/dashboard";
        // }
        return "redirect:/dashboard";
    }
     

         @RequestMapping("/question/{id}")
         public String show(@PathVariable("id") Long id, Model model, @ModelAttribute("answerR") Answer answer) {
             Question question = questionService.findQuestion(id);
             List<Tag> tags = question.getTags();
             List<Answer> answers = question.getAnswers();
             model.addAttribute("question", question);
             model.addAttribute("tag", tags);
             model.addAttribute("answer", answers);
             return "show.jsp";
         }

         @PostMapping("/question/{id}")
         public String answer(@PathVariable("id") Long id, @Valid @ModelAttribute("answerR") Answer answer,
         BindingResult result) {
             Question question = questionService.findQuestion(id);
             if (result.hasErrors()) {
                 return "show.jsp";
             } else {
                 answer.setQuestion(question);
                 answer = answerService.createAnswer(answer);
                 return "redirect:/question/" + question.getId();
             }
         }
         
    //     @PostMapping("/answer/new")
	// public String create(@Valid @ModelAttribute("answer") Answer answer, 
    // BindingResult result, Model model,
	// 		@RequestParam("questionId") Long questionId) {
	// 	if (result.hasFieldErrors()) {
    //         Question question = questionService.findQuestion(questionId);
	// 		model.addAttribute("question", question);
	// 		return "redirect:/question/show/" + questionId;
	// 	} else {
	// 		answerService.createAnswer(answer);
	// 		return "redirect:/";
	// 	}
    
}
     
     

