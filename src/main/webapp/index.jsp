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
    <input type="text" name="userID" placeholder="UserID">
    <input type="password" name="userPassword" placeholder="UserPassword">
    <input type="submit" value="회원가입">
</form>

    </br>
<form action="deleteAction.jsp" method="post">
    <input type="text" name="deleteID" placeholder="UserID">
    <input type="submit" value="삭제">
</form>
</br>
<form action="update.jsp" method="post">
    <input type="text" name="userID" placeholder="변경 되는 아이디">
    <input type="text" name="userPassword" placeholder="변경되는 비밀번호">
    <input type="text" name="changeID" placeholder="수정할 아이디">
    <input type="submit" value="수정">
</form>

<form action="index.jsp" method="post">
    <select name="search" class="id" onselect="alert(`하이`);">
        <option value="안녕하세요">안녕하세요</option>
        <option value="ㅁㅁㅁㅁㅁ">ㅁㅁㅁㅁㅁ</option>
        <option value="dongho">dongho</option>
    </select>
    <input type="submit">
    <a href="http://localhost:8080/MinkProject_war_exploded/index.jsp">돌아기기</a>
</form>
<%
    request.setCharacterEncoding("UTF-8");
    String value=request.getParameter("search");
    System.out.println(value);

    UserDAO userDAO=new UserDAO();
    List<UserDTO> list =userDAO.getUsers();
    for (int i=0; i< list.size(); i++) {
    if(value==null||list.get(i).getUserID().equals(value)){
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
    }

%>

<script>

</script>
</table>
</div>
</body>
</html>