<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Model.*"%>
 <%
  Stat stat=(Stat)application.getAttribute("stat");
  Qs qs=(Qs)session.getAttribute("qs");
  String userAns=qs ==null? "":qs.getUserAns();
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>暗算君</title>
</head>
<body>
<h1>暗算にチャレンジ</h1>
<p>正答数:<%=stat.getCorrect() %>　誤答数:<%=stat.getWrong() %></p>
<form action="calc" method="post">
<p><%=qs.getqString() %><input type="number" name="ans" value="<%=userAns%>"><input type="submit" value="送信"></p>
</form>
<%if(qs.getUserAns() !=null){ %>
<p><%=qs.getqString()+qs.getCorrectAns()  %></p>
<p><%=qs.isCorrect()?"正解":"不正解" %>
<p><a href="calc">Retry</a></p>
<%} %>
</body>
</html>
