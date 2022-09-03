<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="top.css">

<title>スタート画面</title>
</head>
<body>
	 
	 
	 <div class="wrapper">
	 
        <div class="logo">
            <img src="images/logo.gif" alt="logo">
        </div>
		
		<h1>SDGsクイズ</h1>
		
        <div class="hiyoko">
            <img src="images/tophiyo.png" class="image" alt="ひよこ">
        </div>

        <div class="form">
        <form method="post" action="QuizServlet">
            <input type="submit" value="クイズスタート" class="button">
        </form>
        </div>
    </div>
	 
	 
	 
	 
	 
	 
</body>
</html>