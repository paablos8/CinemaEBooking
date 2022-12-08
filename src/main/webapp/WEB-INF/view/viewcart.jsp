
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheets" href="css/stylesheet.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <title>viewCart    
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
      body{
        background:linear-gradient(grey,orange);
        height:auto;
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


    background-color:#333;
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
    float:right; 
  }

.flex-container > div {
    background: orange;
    margin:25px;
    padding:.5px;
    font-size: 19px;
    font-family:'Roboto', sans-serif;
  }
  
    .flex-container2 > div {
    background: rgb(126, 126, 126);
    margin:25px;
    padding:.5px;
    font-size: 14px;
    font-family:'Roboto', sans-serif;
    }
  
    .flex-container3 > div {
    background: orange;
    margin:25px;
    padding:.5px;
    font-size: 19px;
    font-family:'Roboto', sans-serif;
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

  .search-container {
  margin-top:12px;
  float: right;
}


.search-container button {
  float: right;
  padding: 6px 10px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.flex-container {
  display:flex;
  background-color:lightgray;
  justify-content: center;
  margin-left: 7%;
  margin-right: 7%;
  border-radius: 25px; 
}

    </style>

  </head>
  <div class="topnav" id="myTopnav">
    <a href="homePage" class="active">Home</a>
    <a href="promotionHome">Promotions</a>
    <div class="topNavLogout" id="logout">
      <a href="loginSuccess">${currentUser.firstName}</a>
      <div class="search-container">
      <form action="/searchResults">
        <input type="text" placeholder="Search:" name="search">
        <button type="submit"><i class="fa fa-search"></i></button>
      </form>
    </div>
    </div>
  </div>

<body>
      <div class="title">
        Your Cart Summary
    </div>
    
    
    <form:form method="POST" modelAttribute="submitCheckout">
    <label class="mr-sm-2" for="paymentCard">Select the card you want to use:</label>
              <form:select  path="cardID">
                <form:option value="1"  label="1" />
                <form:option value="2"  label="2" />
                <form:option value="3"  label="3" /> 
              </form:select>
            
    
    <div class='section'>
      <div class='flex-container'>
        <div class='order-info-content'>
          <h2>Order Summary</h2>
          <span class='thin'>Adult Ticket</span>
          <br> Enter MOvie Title here<br> <span class='thin small'> Number of tickets: number here <br></span>
          Subtotal Cost: Enter Price Here
          
        </td>
      </tr>
      
      <br><br>
    

  
        
        <td>
        <span class='thin'>Youth Ticket</span>
        <br> Enter MOvie TiTLe here<br> <span class='thin small'> Number of tickets: number here <br></span>
        Subtotal Cost: EnTeR Price Here
      </tr>
    
        <br><br>

        <td>
        <span class='thin'>Senior Ticket</span>
        <br> Enter MOvie TiTLe here<br> <span class='thin small'> Number of tickets: number here <br></span>
        Subtotal Cost: EnTeR Price Here

        <br><br>
  Have a Promo Code? Enter Here:<br>
  <form:input class='input-field' path="promoCode" />
  <button class='pay-btn'>Add Promo</button>
          <br>
        </form:form>
</div>
  
</div>
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