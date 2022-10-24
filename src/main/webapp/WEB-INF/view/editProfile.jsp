<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheets" href="css/stylesheet.css">
    <title>editProfile    
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

.row:after {
  content: "";
  display: table;
  clear: both;
}

.column {
  float: left;
  width: 50%;
  padding: 10px;
  border-radius:25px;
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

    </style>
  </head>

<body>

  <div class="topnav" id="myTopnav">
    <a href="homePage.jsp" class="active">Home</a>
    <a href="couponpromo.jsp">Promotions</a>
    <a href="userLogin.jsp">Login</a>
    <a href="viewcart.jsp">View Cart</a>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
      <i class="fa fa-bars"></i>
    </a>
  </div>


  <div class="title">
    Edit Account
</div>

<div class="login">
  <div class="row">
    <div class="column" style="background-color:#aaa; text-align: right;">
      <p>Name</p>
      <p>Password</p>
      <p>Address</p>
      <br>
      <p>Card Number</p>
      <p>CVN</p>
      <p>Card Expiration</p>
      <br>
    </div>
    <div class="column" style="background-color:#bbb; text-align: left;">
      <input type="text" id="changeName" name="changeName" placeholder="sampleName">
      <p></p>
      <input type="text" id="changePassword" name="changePassword" placeholder="samplePassword">
      <p></p>
      <input type="text" id="changeAddress" name="changeAddress" placeholder="sampleAddress">
      <p></p>
      <input type="text" id="changeCardNumber" name="changeCardNumber" placeholder="sampleCardNumber">
      <p></p>
      <input type="text" id="changePassword" name="changePassword" placeholder="sampleCVN">
      <p></p>
      <input type="text" id="changeAddress" name="changeAddress" placeholder="sampleExpiration">
      <p></p>
    </div>
  </div>
    <br>
    <a href="editProfile.jsp">
    <button" class="btn btn-secondary btn-block mb-4">Confirm Changes</button>
</a>
  
</div>

<div class="footer">
  <br>
  <small>Copyright - Company Name</small>
  <br><br>

</div>

    <script>
      function myFunction() {
        var x = document.getElementById("myTopnav");
        if (x.className === "topnav") {
          x.className += " responsive";
        } else {
          x.className = "topnav";
        }
      }
      </script>
      



</html>