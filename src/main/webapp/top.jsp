<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="style.css">

<title>スタート画面</title>
</head>
<body>
	<!----- header----->
	 <header></header>
	 <nav></nav>
	 <!----- /header ----->
	 <!----- main ----->
	 <article>
	 <section>
	 
	 	<h1>SDGsクイズ</h1>
		<img src="sdg_poster_ja_2021.png">
		<form method="post" action="QuizServlet">
			<input class="btm" type="submit" value="スタート">
		</form>
	 </section>
	 </article>
	 <!----- /main ----->
	 <!----- footer ----->
	 <footer></footer>
	 <!----- /footer ----->
</body>
</html>