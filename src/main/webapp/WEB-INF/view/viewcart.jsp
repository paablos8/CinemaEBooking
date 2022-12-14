
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
    margin-left: auto;
    margin-right: auto;
    border-radius: 25px;
    padding: 14px 20px;
    flex-wrap: wrap;
    flex-direction: column;
    
    
  }
  
  .flex-container3 {
    display:flex;
    background-color:orange;
    justify-content:center;
    flex-wrap: wrap;
    margin-left: auto;
    margin-right: auto;
    border-radius: 25px;
    float:right; 
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

    .dropdown-container{
    display: flex;
    background-color: rgb(126, 126, 126);
    margin-left: 365px;
    margin-right: 395px;
    margin-top: 10px;
    border-radius: 25px;
    padding: 14px 14px;
    text-align: center;
    flex-wrap: wrap;
    align-content: center;
    flex-direction: column;
    }

    .card{
      width:auto;
      height:auto;
      background-color:#fff;
      box-shadow:0px 15px 30px rgba(0,0,0,0.1);
      border-radius:10px;
      overflow:hidden;
      margin: 14px;
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

.footer{
    position:fixed;
    left:0;
    bottom:0;
    width:100%;
    text-align:center;
    background-color:#333;
    color: white;  
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


      <div class="title">
        Your Cart Summary
    </div>

    <div class='dropdown-container'>
    <span style='float:center; font-size: 24px;'>
    <form:form method="POST" modelAttribute="submitCheckout">
    <label class="mr-sm-2" for="paymentCard">Select the card you want to use:</label>
              <form:select  path="cardID">
                <form:option value="1"  label="1" />
                <form:option value="2"  label="2" />
                <form:option value="3"  label="3" /> 
              </form:select>
            </span>
    </div>

    <div class='section'>
      <div class='flex-container'>
        <div class='order-info-content'>
          <h2>Order Summary</h2>
          <span class='thin'>${movie}</span>
          <br>Adult Ticket<br> <span class='thin small'> Showtime: ${showtime} <br></span>
          Subtotal Cost: $7.00
          
        </td>
      </tr>
      
      <br><br>
    
        <td>
        <span class='thin'>${movie}</span>
        <br>Adult Ticket<br> <span class='thin small'> Showtime: ${showtime} <br></span>
        Subtotal Cost: $7.00
      </tr>
    
        <br><br>

        <td>
        <span class='thin'>${movie}</span>
        <br>Youth Ticket<br> <span class='thin small'> Showtime: ${showtime} <br></span>
        Subtotal Cost: $5.00

        <br><br>
  Have a Promo Code? Enter Here:<br>
  <form:input class='input-field' path="promoCode" />
          <br>
          ${promotionResult}
        
</div>
  
</div>
  <div class='flex-container3'>
<div class='total'>
    <span style='float:left;'>
      <div class='thin dense'>Tax</div>
      <div class='thin dense'>Subtotal</div>
      TOTAL
    </span>
    <span style='float:right; text-align:right; margin-left: 25px;'>
      <div class='thin dense'>$1.33</div>
      <div class='thin dense'>$19.00</div>
      $20.33
    <br> <br>
    <form:button type="submit" class="btn btn-secondary btn-block mb-4">Submit Changes</form:button>
    </form:form>

  </span>  
  </div>
 </div>

 <div class='flex-container2'>
  <span style='float:center';>
    Your Wallet:
    </span>
<br>  
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
</div>

<div class="card"> <div class="info"> 
<span>Tertiary Card Information</span> 
</div> 

<div class="forms"> 
<div class="inputs"> 
<span>Name on Card</span> 
<input type="text" readonly value="${card3Name}"> </div> 

<div class="inputs"> 
<span>Number</span> 
<input type="text" readonly value="${card3Number}"> </div> 
</div>
</div>



</div>

</div>

<br><br><br><br><br><br>
<div class="footer">
  <br>
  <small>Copyright - MovieHub</small>
  <br><br>
</div>

</body>

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