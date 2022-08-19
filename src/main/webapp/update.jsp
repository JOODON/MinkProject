<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="User.UserDAO" %>
<%@ page import="User.UserDTO" %>
<%@ page import="java.io.PrintWriter" %>

<%
        request.setCharacterEncoding("UTF-8");

        String userID=null;
        String userPassword=null;
        String changeID=null;

        if(request.getParameter("userID") != null){
            userID=(String) request.getParameter("userID");
        }
        if(request.getParameter("userPassword") != null){
            userPassword=(String) request.getParameter("userPassword");
        }
        if(request.getParameter("changeID") != null){
            changeID=(String) request.getParameter("changeID");
        }

        if(userID.equals("") || userPassword.equals("")||changeID.equals("")){
            PrintWriter script=response.getWriter();
            script.println("<script>");
            script.println("alert('입력 안된 사항이 있습니다!')");
            script.println("location.href='index.jsp'");
            script.println("</script>");
            script.close();
            return;
        }
        UserDTO userDTO=new UserDTO(userID,userPassword);
        UserDAO userDAO=new UserDAO();
        int insertCount=userDAO.update(userDTO,changeID);

        if(insertCount==1){
            PrintWriter script=response.getWriter();
            script.println("<script>");
            script.println("alert('변경에 성공하였습니다.')");
            script.println("location.href='index.jsp'");
            script.println("</script>");
            script.close();
            return;
        }
%>
