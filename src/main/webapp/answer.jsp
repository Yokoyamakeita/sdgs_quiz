<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.QuizInfoEntity" %>
<% ArrayList<QuizInfoEntity> quizList = (ArrayList<QuizInfoEntity>)session.getAttribute("quizlist"); %>
<% int currentCount = (int)session.getAttribute("currentcount"); %>
<% int maxCount = (int)session.getAttribute("maxcount"); %>
<% int ansCount = (int)session.getAttribute("anscount"); %>
<% QuizInfoEntity qe = quizList.get(currentCount);%>
<% String ansTitle = (String)session.getAttribute("anstitle"); %>
<% String ansMessage = qe.getExplanation(); %>
<% currentCount = currentCount + 1; %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="style.css">
	<title>答え画面</title>
</head>
<body>
	<!----- header----->
	 <header></header>
	 <nav></nav>
	 <!----- /header ----->
	 <!----- main ----->
	 <article>
	 <section>
	 	<%--正解有無を表示 --%>
		<h1><%=ansTitle %></h1>
		<%--解答説明を表示 --%>
		<p><%=ansMessage %></p>
	
		<%if(currentCount < maxCount ){ %>
			<% session.setAttribute("currentcount", currentCount); %>
			<form method="post" action="NextQuestionServlet">
				<input class="btm" type="submit" name="btn" value="次の問題へ進む">
			</form>			
		<%}else{ %>
			<form method="post" action="NextQuestionServlet">
				<input class="btm" type="submit" name="btn" value="結果画面へ">
			</form>			
		<%} %>
		
	 </section>
	 </article>
	 <!----- /main ----->
	 <!----- footer ----->
	 <footer></footer>
	 <!----- /footer ----->
</body>
</html>