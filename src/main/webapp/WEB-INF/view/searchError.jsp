<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheets" href="css/stylesheet.css">
    <title>Home   
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
      body{
        background:linear-gradient(grey,orange);
        height:100%;
      }
      .login{
        border-radius:25px;
        background-color:lightgrey;
        width:50%;
        padding: 14px 20px;
        margin-left: auto;
        margin-right: auto;
        margin-top: 50px;
        text-align:center;
      }
      .title{
        font-size:50px;
        text-align: center;
        font-family:'Roboto', sans-serif;
      }
      .topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}
.topNavLogout a {
  float: right;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: orange;
  color: white;
}

.topnav .icon {
  display: none;
}

@media screen and (max-width: 600px) {
  .topnav a:not(:first-child) {display: none;}
  .topnav a.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }
}

.flex-container {
  display:flex;
  justify-content: center;
  margin-left: 7%;
  margin-right: 7%;
  border-radius: 25px; 
}

.flex-container > div {
  margin:25px;
  padding:1px;
  font-size: 10px;
}

a{
  color: black;
}

h5{
  text-align:center;
}


.footer{
    position:fixed;
    left:0;
    bottom:0;
    width:100%;
    text-align:center;
    background-color:#333;
    color: white;  
}

.search-container {
  border-radius:25px;
  width:50%;
  padding: 14px 20px;
  margin-left: auto;
  margin-right: auto;
  text-align:center;
}


.search-container button {
  padding: 6px 10px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}




    </style>
  </head>

<body>

  <div class="topnav" id="myTopnav">
    <a href="homePage" class="active">Home</a>
    <a href="promotionHome">Promotions</a>
    <a href="viewcart">View Cart</a>
    <div class="topNavLogout" id="logout">
    <a href="userLogin">Login</a>
    <a href="loginSuccess">${currentUser.firstName}</a>
  </div>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
      <i class="fa fa-bars"></i>
    </a>
  </div>
<br><br>



  <div class="title">
    <br>
    No results found!
    <br><br>


</div>



<div class="title" style="font-size:35px">
  Search Again
</div>
<div class="search-container">
    <form action="/searchResults">
      <input type="text" placeholder="Search:" name="search" style="width: 300px;">
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
  </div>

  <div class="footer">
    <br>
    <small>Copyright - Company Name</small>
    <br><br>
  
</div>

</body>