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
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%if(currentCount < 3 ){ %>
	<link rel="stylesheet" href="comment.css">
	<%}else if(currentCount < 6){ %>
	<link rel="stylesheet" href="comment2.css">
	<%}else{ %>
	<link rel="stylesheet" href="comment3.css">
	<%} %>
	<title>答え画面</title>
</head>
<body>

	  <div class="comment">
        <div class="ballon">
            <h1><%=ansTitle %></h1>
            <p><%=ansMessage %></p>
        </div>
    </div>

    <div class="buttom">
    	
    	<%if(currentCount < maxCount ){ %>
			<% session.setAttribute("currentcount", currentCount); %>
			<form method="post" action="NextQuestionServlet">
				<input class="next" type="submit" name="btn" value="次の問題へ進む">
			</form>			
		<%}else{ %>
			<form method="post" action="NextQuestionServlet">
				<input class="next" type="submit" name="btn" value="結果画面へ">
			</form>			
		<%} %>
    
    
    </div>
</body>
</html>