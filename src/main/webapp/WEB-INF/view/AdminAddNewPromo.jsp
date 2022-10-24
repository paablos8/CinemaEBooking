<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheets" href="css/stylesheet.css">
    <title> Edit Promos    
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
      body{
        background-color: grey;
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
    <h1>Coupons and Promotions</h1>
       <h5>Available coupons are limited to one coupon per cart and showtime</h5>
</div>
<section>
  <h2>SEASONAL COUPON</h2>
  <div>
      <div>
       <p> <h3>20% off on Tuesday showtimes!!</h3>
      <br>
      Expires: 0ct. 27, 2022</p><br>
      </div>
    <div>
      <button role= "RemoveBut">Remove</button>
      <button role= "EditBut">Edit this Coupon</button>
  </div>
      <hr> 
  </div>
</section>

<section>
  <h2>BOGO FREE POPCORN</h2>
  <div>
      <div>
       <p> <h3>Get One order of popcorn free with the purchase of an order of popcorn of the same size!!</h3>
      <br>
       (Present order confirmation reciept in order to redeem.)
       <br>
       Expires: 0ct. 14, 2022</p><br>
      </div>
    <div>
      <button role= "RemoveBut">Remove</button>
      <button role= "EditBut">Edit this Coupon</button>
  </div>
      <hr> 
  </div>
</section>

<section>
  <h2>HOLIDAY SPECIAL</h2>
  <div>
      <div>
       <p> <h3>Get 15% off yout total purchase on Holiday and Holiday Weekend bookings!!</h3>
      <br>
      Expires: Dec. 30, 2022</p><br>
      </div>
      <div>
        <button role= "RemoveBut">Remove</button>
        <button role= "EditBut">Edit this Coupon</button>
    </div>
      <hr> 
  </div>
</section>
<section>
    <div class='coupon-info-content'>
        <table class='half-input-table'>
          <tr><td>To add or edit, please enter new promotion information: </td></tr>
        </table>
        
        Coupon Title
        <input class='input-field'></input>
        Description
        <input class='input-field'></input>
        <table class='half-input-table'>
          <tr>
            <td> Discount Percentage 
              <input class='input-field'></input>
            </td>
            <td> Start date
                <input class='input-field'></input>
              </td>
            <td>End date
              <input class='input-field'></input>
            </td>
        
          </tr>
        </table>
        <button class='add-btn'>Add New Coupon</button>

      </div>
</section>

<br><br><br>
      <div>
        <a href="AdminHome.jsp"><button role= "Back2Home-butt">Back to Admin Home</button></a>
      </div>
      <br><br><br><br><br><br><br>

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