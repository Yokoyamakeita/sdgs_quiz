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
	<%if(currentCount < 3 ){ %>
	<link rel="stylesheet" href="question.css">
	<%}else if(currentCount < 6){ %>
	<link rel="stylesheet" href="question2.css">
	<%}else{ %>
	<link rel="stylesheet" href="question3.css">
	<%} %>
	<title>問題</title>
</head>
<body>



	<div class="question">
        <div class="ballon">
            <h2>問題</h2>
            <p><%=qe.getQuestion()%></p>
        </div>
    </div>

    <div class="buttom">
       <form method="post" action="AnswerServlet">
                <input class="yes" type="submit" name="btn" value="YES">
				<input class="no" type="submit" name="btn" value="NO">
        </form>
    </div>
    
    
</body>
</html>