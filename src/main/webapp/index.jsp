<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="User.UserDAO" %>
<%@ page import="User.UserDTO" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        .table{
            margin-top: 5px;
        }
        table{
            border: 1px solid #494747;
            width: 300px;
            margin: auto;
        }
        th{
            border: none;
            border-bottom: 1px solid #494747;

        }
        .id{
            border-bottom: 1px solid #494747;
            border-right: 1px solid #494747;
        }
        .idtext{
            border-right: 1px solid #494747;
        }
        td{
            border: none;
            text-align: center;

        }
    </style>
</head>
<body>
Hello World!

<form action="JoinAction.jsp" method="post">
    <input type="text" name="userID">
    <input type="password" name="userPassword">
    <input type="submit" value="회원가입">
</form>
    </br>
<form action="deleteAction.jsp" method="post">
    <input type="text" name="deleteID">
    <input type="submit" value="삭제">
</form>
<form action="#" method="post">
    </br>
    <input type="text" name="correctID">
    <input type="submit" value="수정">
</form>
<%
    UserDAO userDAO=new UserDAO();
    List<UserDTO> list =userDAO.getUsers();
    for (int i=0; i< list.size(); i++) {


%>
<div class="table">
    <table border="1px">
        <th class="id">아이디</th>
        <th class="password">비밀번호</th>
    <tr>
        <td class="idtext"><%= list.get(i).getUserID()%></td>
        <td class="passwordtext"><%= list.get(i).getUserPassword()%></td>
    </tr>
<%
        }
%>
</table>
</div>
</body>
</html>