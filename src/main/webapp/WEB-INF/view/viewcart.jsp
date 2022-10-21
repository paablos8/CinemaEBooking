<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>
       <title>Your Cart</title> 
       <link rel="stylesheet" href="viewcart.css">
    </head>
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
    <body>  
      <div class="topnav" id="myTopnav">
        <a href="homePage.html" class="active">Home</a>
        <a href="couponpromo.html">Promotions</a>
        <a href="userLogin.html">Login</a>
        <a href="viewcart.html">View Cart</a>
        <a href="javascript:void(0);" class="icon" onclick="myFunction()">
          <i class="fa fa-bars"></i>
        </a>
      </div>

      <div class="title">
        Your Cart Summary
    </div>
    <div class='container'>
    <div class='window'>
      <div class='order-info'>
        <div class='order-info-content'>
          <h2>Order Summary</h2>
                  <div class='line'></div>
          <table class='order-table'>
            <tbody>
              <tr>
                
                <td>
                <span class='thin'>Adult Ticket</span>
                  <br> Enter MOvie TiTLe here<br> <span class='thin small'> Number of tickets: number here <br></span>
                  <button role= "RemoveBut">Remove</button>
                  <a href="orderTicketsFightClub.html">
                  <button role= "EditBut">Edit</button>
                  </a>
                </td>
  
              </tr>
              <tr>
                <td>
                  <br>
                  <div class='price'>EnTeR Price Here</div>
                </td>
              </tr>
            </tbody>
  
          </table>
          <div class='line'></div>
          <table class='order-table'>
            <tbody>
              <tr>
                
                <td>
                <span class='thin'>Youth Ticket</span>
                <br> Enter MOvie TiTLe here<br> <span class='thin small'> Number of tickets: number here <br></span>
                <button role= "RemoveBut">Remove</button>
                <a href="orderTicketsFightClub.html">
                  <button role= "EditBut">Edit</button>
                  </a>
                </td>
              </tr>
              <tr>
                <td>
                  <br>
                  <div class='price'>EnTeR Price Here</div>
                </td>
              </tr>
            </tbody>
          </table>
          <div class='line'></div>
          <table class='order-table'>
            <tbody>
              <tr>
                
                <td>
                <span class='thin'>Senior Ticket</span>
                <br> Enter MOvie TiTLe here<br> <span class='thin small'> Number of tickets: number here <br></span>
                <button role= "RemoveBut">Remove</button>
                <a href="orderTicketsFightClub.html">
                  <button role= "EditBut">Edit</button>
                  </a>
  
              </tr>
              <tr>
                <td>
                  <br>
                  <div class='price'>EnTeR Price Here</div>
                </td>
              </tr>
            </tbody>
          </table>
          <div class='line'></div>
          <div class='total'>
            <span style='float:left;'>
              <div class='thin dense'>Coupon(if Used)%</div>
              <div class='thin dense'>Tax</div>
              <div class='thin dense'>Subtotal</div>
              TOTAL
            </span>
            <span style='float:right; text-align:right;'>
              <div class='thin dense'>ent.couponCalchere</div>
              <div class='thin dense'>tax calc</div>
              <div class='thin dense'>Subto Calc</div>
              Total calc
            </span>
          </div>
  </div>
  </div>
          <div class='credit-info'>
            <div class='credit-info-content'>
              <table class='half-input-table'>
                <tr><td>Please enter your card information: </td></tr>
              </table>
              
              Card Number
              <input class='input-field'></input>
              Card Holder
              <input class='input-field'></input>
              <table class='half-input-table'>
                <tr>
                  <td> Expires
                    <input class='input-field'></input>
                  </td>
                  <td>CVC
                    <input class='input-field'></input>
                  </td>
                </tr>
              </table>
              <button class='pay-btn'>Checkout</button>
  
            </div>
  
          </div>
        </div>
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
</body>
</html>