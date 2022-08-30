<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.QuizInfoEntity" %>
<% ArrayList<QuizInfoEntity> quizList = (ArrayList<QuizInfoEntity>)session.getAttribute("quizlist"); %>
<% int currentCount = (int)session.getAttribute("currentcount"); %>
<% QuizInfoEntity qe = quizList.get(currentCount);%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="style.css">
	<title>問題</title>
</head>
<body>

	<!----- header----->
	 <header></header>
	 <nav></nav>
	 <!----- /header ----->
	 <!----- main ----->
	 <article>
	 <section>
	 	<h1>問題</h1>
		<p><%=qe.getQuestion()%></p>
		<form method="post" action="AnswerServlet">
			<input class="btmyes" type="submit" name="btn" value="YES">
			<input class="btmno" type="submit" name="btn" value="NO">
		</form>
	 </section>
	 </article>
	 <!----- /main ----->
	 <!----- footer ----->
	 <footer></footer>
	 <!----- /footer ----->
</body>
</html>