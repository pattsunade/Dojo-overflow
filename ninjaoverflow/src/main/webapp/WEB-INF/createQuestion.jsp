<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

    <title>Nueva Pregunta</title>
</head>
<body  style="background-color: rosybrown">
    <div class="container text-center">	
		<h1 class="display-4">Cual es su pregunta?</h1>
	</div>
	<br>
	<div class="container" row >
		<form:form action="/question/new" method="POST" modelAttribute="questionQ">
			<p>
				<form:label class="font-weight-bold" path="question">Pregunta</form:label>
				<form:textarea class="form-control" rows="3" path="question"/>
			</p>
		
			<p>
				<label for="tagString">Tag</label>
				<input type="text" class="form-control col-4" name="tagString">
				
			</p>
				<br>
				<button type="submit" class="btn btn-danger">Enviar</button>
			</p>
			
		</form:form>
	</div>
	</div>
</body>
</html>