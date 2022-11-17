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
        background:linear-gradient(grey,orange);
        height:auto;
      }
      .promotionCard{
        border-radius:25px;
        background-color:lightgrey;
        width:50%;
        padding: 14px 20px;
        margin-left: auto;
        margin-right: auto;
        margin-top: 50px;
        text-align:center;
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
.buttonCenter {
            margin-top:45px;
            align-content:center;
            margin-left: 30%;
            margin-right: 30%;
          }
    </style>
  </head>

<body>

  <div class="topnav" id="myTopnav">
    <a href="homePage" class="active">Home</a>
    <a href="promotionHome">Promotions</a>
    <a href="userLogin">Login</a>
    <a href="viewcart">View Cart</a>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
      <i class="fa fa-bars"></i>
    </a>
  </div>



  <div class="title">
    <h1>Coupons and Promotions</h1>
       <h5>Available coupons are limited to one coupon per cart and showtime</h5>
</div>
<section>
  <div class="promotionCard">
  <h2>${promo1_code}</h2>
  <div>
      <div>
       <p> <h3>${promo1_percentOff} % off!!</h3>
      <br>
      Starts at: ${promo1_startDate} and expires at: ${promo1_expirationDate}</p><br>
      </div>
    <div>
      <!--<button role= "RemoveBut">Remove</button>--> 
      <!--<button role= "EditBut">Edit this Coupon</button>--> 
<a href="editPromotion?promotion=${promo1_code}" target="_blank">Edit Promotion</a> 
      <!--<form action="editPromotion?promotion=${promo1_code}">--> 
        <!--<button type="submit">Edit Promotions</button>--> 
     <!--</form>--> 
    </div>
  </div>
      <hr> 
  </div>
</section>

<section>
  <h2>${promo0_code}</h2>
  <div>
      <div>
       <p> <h3>${promo0_percentOff} % off!!</h3>
      <br>
       (Present order confirmation reciept in order to redeem.)
       <br>
       Starts at: ${promo0_startDate} and expires at: ${promo0_expirationDate}</p><br>
      </div>
    <div>
      <button role= "RemoveBut">Remove</button>
      <a href="editPromotion?promotion=${promo0_code}" target="_blank">Edit Promotion</a>
      <!--<form action="editPromotion?promotion=${promo0_code}">-->
        <button type="submit">Edit Promotions</button>
     </form>
  </div>
      <hr> 
  </div>
</section>

<section>
  <h2>${promo2_code}</h2>
  <div>
      <div>
       <p> <h3>${promo1_percentOff} % off!!</h3>
      <br>
      Starts at: ${promo2_startDate} and expires at: ${promo2_expirationDate}</p><br>
      </div>
      <div>
        <button role= "RemoveBut">Remove</button>
        <button role= "EditBut">Edit this Coupon</button>
        <a href="editPromotion?promotion=${promo2_code}" target="_blank">Edit Promotion</a>
    </div>
      <hr> 
  </div>
</section>
<section>
    <div class='coupon-info-content'>
    
        <a href="addPromotion"><button class='add-btn'>Add New Promotion</button></a>

      </div>
</section>

<br><br><br>
      <div>
        <a href="AdminHome"><button role= "Back2Home-butt">Back to Admin Home</button></a>
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