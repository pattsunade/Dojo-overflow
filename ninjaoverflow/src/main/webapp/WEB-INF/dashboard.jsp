<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Document</title>
</head>
<body class="container" style="background-color: mediumpurple">
     
    <div>
        <table class="table table-success table-striped">
    <thead>
        <tr>
            <th>Questions</th>
            <th>Tags</th>

        </tr>
    </thead>
    <tbody>
        <c:forEach items="${question}" var="question">
        <tr>
            <td><a href="/question/${question.id}">
                <c:out value="${question.question}"/></a></td>
            <td>
                <c:forEach items="${question.tags}" var="tag">
                    <c:out value="${tag.subject}"/>
                </c:forEach>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<footer>
    <button type="button" class="btn btn-success"><a class="text-dark" href="/question/new" >Agregar pregunta</a></button>
    
</footer>
    </div>


</body>
</html>