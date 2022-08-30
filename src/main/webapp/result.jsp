<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% int maxCount = (int)session.getAttribute("maxcount"); %>
<% int ansCount = (int)session.getAttribute("anscount"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="style.css">
	<title>結果表示</title>
</head>
<body>
	<!----- header----->
	 <header></header>
	 <nav></nav>
	 <!----- /header ----->
	 <!----- main ----->
	 <article>
	 <section>
	 	<h1>正答数は<%=ansCount %>です。（<%= ++maxCount%>問満点）</h1>
		<form method="post" action="QuizServlet">
			<input class="btm" type="submit" value="もう一回する">
		</form>			
	 </section>
	 </article>
	 <!----- /main ----->
	 <!----- footer ----->
	 <footer></footer>
	 <!----- /footer ----->
</body>
</html>