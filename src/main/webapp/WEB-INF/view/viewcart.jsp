<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>
       <title>Your Cart</title> 
       <link rel="stylesheet" href="stylesheet.css">
    
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
    background-color:orange;
    justify-content: center;
    flex-wrap: wrap;
    margin-left: auto;
    margin-right: auto;
    border-radius: 25px; 
    padding: 14px 20px;
    text-align:center;
    float:left;
  }
  
  .flex-container2 {
    display: flex;
    background-color: rgb(126, 126, 126);
    margin-left: 500px;
    margin-right: auto;
    margin-top: 45px;
    border-radius: 25px;
    padding: 14px 20px;
    text-align: center;
    flex-wrap: wrap;
    flex-direction: column;
    align-content: center;
  }
  
  .flex-container3 {
    display:flex;
    background-color:orange;
    justify-content:center;
    flex-wrap: wrap;
    margin-left: auto;
    margin-right: auto;
    margin-top: 25px;
    border-radius: 25px;
    float:left; 
  }

.flex-container > div {
    background: orange;
    margin:25px;
    padding:.5px;
    font-size: 19px;
  }
  
    .flex-container2 > div {
    background: rgb(126, 126, 126);
    margin:25px;
    padding:.5px;
    font-size: 14px;
    }
  
    .flex-container3 > div {
    background: orange;
    margin:25px;
    padding:.5px;
    font-size: 19px;
    }

    .card{
      width:350px;
      height:250px;
      background-color:#fff;
      box-shadow:0px 15px 30px rgba(0,0,0,0.1);
      border-radius:10px;
      overflow:hidden;
    }
      .card .info
      {padding:15px;display:flex;justify-content:space-between;border-bottom:1px solid #e1dede;
        background-color:#e5e5e5}
        .card .info button
        {height:30px;width:80px;border:none;
          color:#fff;border-radius:4px;background-color:#000;
          cursor:pointer;text-transform:uppercase}
          .card .forms
          {padding:10px}
          .card .inputs
          {display:flex;flex-direction:column;margin-bottom:10px}
          .card .inputs span{font: size 20px;}
          .card .inputs input{height:24px;padding:0px 10px;font-size:17px;box-shadow:none;outline:none}
          .card .inputs input[type="text"][readonly]{border: 2px solid rgba(0,0,0,0)}
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
     
     
      <div class="topnav" id="myTopnav">
        <a href="homePage" class="active">Home</a>
        <a href="promotionHome">Promotions</a>
        <a href="userLogin">Login</a>
        <a href="viewcart">View Cart</a>
        <a href="javascript:void(0);" class="icon" onclick="myFunction()">
          <i class="fa fa-bars"></i>
        </a>
      </div>


      
<body>
      <div class="title">
        Your Cart Summary
    </div>
    <div class='section'>
      <div class='flex-container'>
        <div class='order-info-content'>
          <h2>Order Summary</h2>
          <span class='thin'>Adult Ticket</span>
          <br> Enter MOvie TiTLe here<br> <span class='thin small'> Number of tickets: number here <br></span>
          Subtotal Cost: EnTeR Price Here
          
        </td>
      </tr>
      
      <br><br>
    

  
  <table class='order-table'>
    <tbody>
      <tr>
        
        <td>
        <span class='thin'>Youth Ticket</span>
        <br> Enter MOvie TiTLe here<br> <span class='thin small'> Number of tickets: number here <br></span>
        Subtotal Cost: EnTeR Price Here
      </tr>
    
    </tbody>
  </table>
  <div class='line'></div> <br>
  <table class='order-table'>
    <tbody>
      <tr>
        
        <td>
        <span class='thin'>Senior Ticket</span>
        <br> Enter MOvie TiTLe here<br> <span class='thin small'> Number of tickets: number here <br></span>
        Subtotal Cost: EnTeR Price Here

      </tr>
      
    </tbody>
  </table>
  </div>
</div>
<div class='flex-container2'>
    
      <div> Wallet </div>
      <table class='half-input-table'>
        <tr><td>Please select your card of purchase: </td></tr>
      </table>

      <div class="card"> <div class="info"> 
            <span>Primary Card Information</span> 
            </div> 
            
            <div class="forms"> 
            <div class="inputs"> 
            <span>Name on Card</span> 
            <input type="text" readonly value="${card1Name}"> </div> 
            
            <div class="inputs"> 
            <span>Number</span> 
            <input type="text" readonly value="${card1Number}"> </div> 
        
      </div>
      <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="checkoutcard1"  />
        <label class="form-check-label" for="checkoutcard1"> Select card as Form of Payment </label>
    </div>
    </div>
    <div class="card"> <div class="info"> 
      <span>Secondary Card Information</span> 
      </div> 
      
      <div class="forms"> 
      <div class="inputs"> 
      <span>Name on Card</span> 
      <input type="text" readonly value="${card2Name}"> </div> 
      
      <div class="inputs"> 
      <span>Number</span> 
      <input type="text" readonly value="${card2Number}"> </div> 
  
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="checkoutcard2"  />
  <label class="form-check-label" for="checkoutcard2"> Select card as Form of Payment </label>
</div>
</div>
<div class="card"> <div class="info"> 
  <span>Tertiary Card Information</span> 
  </div> 
  
  <div class="forms"> 
  <div class="inputs"> 
  <span>Name on Card</span> 
  <input type="text" readonly value="${card3ame}"> </div> 
  
  <div class="inputs"> 
  <span>Number</span> 
  <input type="text" readonly value="${card3Number}"> </div> 

</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="checkoutcard3" />
  <label class="form-check-label" for="checkoutcard3"> Select card as Form of Payment </label>
</div>
</div>

</div>

 <br>
  <div class='flex-container3'>
<div class='total'>
    <span style='float:left;'>
      <div class='thin dense'>Coupon(if Used)%</div>
      <div class='thin dense'>Tax</div>
      <div class='thin dense'>Subtotal</div>
      TOTAL
    </span>
    <span style='float:right; text-align:right; margin-left: 50px;'>
      <div class='thin dense'>ent.couponCalchere</div>
      <div class='thin dense'>tax calc</div>
      <div class='thin dense'>Subto Calc</div>
      Total calc
    <br> <br>
    <button class='pay-btn'>Checkout</button>
  </span>  
  </div>
 </div>
</div>
      
        
  
  </body>

  <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
  <div class="footer">
    <br>
    <small>Copyright - MovieHub</small>
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