<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Profile</title>
</head>
<body style="background-color: rgb(75, 119, 200)">
    <div class="container text-center">	
		<h1 class="display-2">${question.question }</h1>
	</div>
	<br>
	<div class="container">
		<h4 class="h4 font-weight-normal">
				Tags: 
			<c:forEach items="${question.tags}" var="tag">
			    <button class="btn btn-warning">${tag.subject}</button>
			 </c:forEach>
        </h4>
        <div class="container">
		    <div class="row">
			    <div class="col">
				    <table class="table table-warning table-striped">
					  <thead>
						    <tr>
						      <th scope="col">Answers: </th>
						    </tr>
						</thead>
                        <tbody>
						    <c:forEach items="${question.answers}" var="answer">
                                <tr>
                                      <td class="text-info"> ${answer.answer}</td>
                                </tr>
						    </c:forEach>
						</tbody>
                    </table>
                </div>
                <div class="col">
					<p>
                         <form:form action="" method="POST" modelAttribute="answerR">
						<form:label cssClass="font-weight-normal" path="answer">Add your Answer</form:label>
						<form:textarea cssClass="form-control" rows="3" path="answer"/>
					</p>
                    <button type="submit" class="btn btn-warning">Add Answer</button>
					</form:form>
					<p>
						
					</p>
			</div>
        </div>
    </div>
		

	
</body>

</html>