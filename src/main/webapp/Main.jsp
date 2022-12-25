<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro">
  <link rel="stylesheet" type="text/css" href="CSS/header.css">
  <title>Header</title>
  <script src="https://kit.fontawesome.com/fa77013e69.js" crossorigin="anonymous"></script>
  <script src="JS/header.js" defer></script>
</head>
<style>
  header{
    margin:20px;

  }
  body{
    font-family: 'Source Sans Pro'
  }

  .navbar {
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .navbar__menu {
    display: flex;
    list-style:none;
    padding-left: 0;
  }

  .navbar__menu li {
    padding: 8px 12px;
  }

  .navbar__menu li:hover {
    background-color: #CEBABA;
    border-radius: 4px;
  }

  .navbar__toogleBtn {
    display: none;
    position: absolute;
    right: 32px;
    font-size: 24px;
    color: #CEBABA;
  }

  @media screen and (max-width: 768px) {
    .navbar {
      flex-direction: column;
      padding: 8px 24px;
    }

    .navbar__menu {
      display: none;
      flex-direction: column;
      align-items: center;
      width: 100%;
    }

    .navbar__menu li{
      width: 100%;
      text-align: center;
      margin: 3px;
    }

    .navbar__toogleBtn {
      display: block;
    }

    .navbar__menu.active {
      display: flex;
    }
  }
</style>
<body>
<header>
  <nav class="navbar">
    <div class="navbar__logo">
      <a href="index.jsp"><img src='CSS/FMlogo.png'></a>
    </div>

    <ul class="navbar__menu">
      <li><a href="#">Become An Artist</a></li>
      <li><a href="Account/signup.jsp">Join</a></li>  <!-- 각 기능이 있는 파일 링크 걸기 -->
      <li><a href="Account/login.jsp">Login</a>  </li>

      <li><a href="#">Become An Artist</a></li>
      <li><a href="mypage.jsp">My Page</a></li>
      <li><a href="cart.jsp">Cart</a></li>
      <li><a href="Account/logout.jsp">Logout</a></li>

      <li><a href="#">Become An Artist</a></li>
      <li><a href="mypage_admin.jsp">My Page</a></li>
      <li><a href="Account/logout.jsp">Logout</a></li>

    </ul>
    <a href="#" class="navbar__toogleBtn">
      <i class="fa-solid fa-bars"></i>
    </a>
  </nav>
</header>
<hr>
<ul>
  <li style="width: 80%;margin: 0 auto" >
    <img src="#" width="300px"height="300px">
    <p>Music Title</p>
    <p>Happy Hopeful</p>
    <p>008BPM</p>
    <p>0:00</p>
  </li>
  <li></li>
</ul>
</body>
</html>