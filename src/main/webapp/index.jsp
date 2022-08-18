<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="User.UserDAO" %>
<%@ page import="User.UserDTO" %>
<%@ page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
Hello World!

<form action="JoinAction.jsp" method="post">
    <input type="text" name="userID">
    <input type="password" name="userPassword">
    <input type="submit" value="회원가입">
    <input type="submit" value="삭제">
    <input type="submit" value="수정">
</form>

</body>
</html>