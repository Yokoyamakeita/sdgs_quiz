<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% int maxCount = (int)session.getAttribute("maxcount"); %>
<% int ansCount = (int)session.getAttribute("anscount"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%if(ansCount < 7 ){ %>
	<link rel="stylesheet" href="end.css">
	<%}else{ %>
	<link rel="stylesheet" href="end2.css">
	<%} %>
	<title>結果表示</title>
</head>
<body>
	 <div class="logo">
        <img src="./images/logo.gif" alt="ロゴ画面">
    </div>

    <div class="result">
        <div class="ballon">
            <h1>正答数は<%=ansCount %>です。（<%= maxCount%>問満点）</h1>
        </div>
    </div>

    <div class="row">
    	<div class="button">
            <a href="top.jsp">TOP画面へ！！</a>
        </div>
        
        
        <%if(ansCount < 7 ){ %>
        <div class="hiyoko">
         	<img src="./images/endhiyo.png">
        </div>
        <%}else{ %>
        <div class="hiyoko">
            <img src="./images/hiyoko.png">
        </div>
        <%} %>
    </div>
    
	 
</body>
</html>