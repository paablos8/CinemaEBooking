<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheets" href="css/stylesheet.css">
    <title>EditCard  
    </title>
    <meta name="viewport" content="width=device-width">

    <style>
      body{
        background:linear-gradient(grey,orange);
        height:220%;
      }
      .registration1{
        border-radius:25px;
        background-color:lightgrey;
        width:50%;
        padding: 14px 20px;
        margin-left: auto;
        margin-right: auto;
        margin-top: 15px;
        padding-bottom: 5px;

        text-align:center;
        float:left;
      }
      .registration2{
        border-radius:25px;
        background-color:lightgrey;
        width:50%;
        padding: 14px 20px;
        margin-left: auto;
        margin-right: auto;
        margin-top: 15px;
        padding-bottom: 20px;
        text-align:center;
        float:right;
      }
      .title{
        font-size:45px;
        text-align: center;
      }
      .text-center{
        text-align:center;
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
.footer{
    position:fixed;
    left:0;
    bottom:0;
    width:100%;
    text-align:center;
    background-color:#333;
    color: white;  
}
.help-tip{
    position: static;
    text-align: center;
    background-color: #BCDBEA;
    border-radius: 50%;
    width: 24px;
    height: 24px;
    font-size: 14px;
    line-height: 26px;
    cursor: default;
}
.help-tip:before{
    content:'?';
    font-weight: bold;
    color:#fff;
}
.help-tip:hover p{
    display:block;
    transform-origin: 100% 0%;
    -webkit-animation: fadeIn 0.3s ease-in-out;
    animation: fadeIn 0.3s ease-in-out;
}
.help-tip p{    /* The tooltip */
    display: none;
    text-align: center;
    background-color: #1E2021;
    padding: 20px;
    width: 300px;
    position: absolute;
    border-radius: 3px;
    box-shadow: 1px 1px 1px rgba(0, 0, 0, 0.2);
    right: -4px;
    color: #FFF;
    font-size: 13px;
    line-height: 1.4;
}
.help-tip p:before{ /* The pointer of the tooltip */
    float: right;
    content: '';
    width:0;
    height: 0;
    border:6px solid transparent;
    border-bottom-color:#1E2021;
    right:10px;
    top:-12px;
}
.help-tip p:after{ /* Prevents the tooltip from being hidden */
    width:100%;
    height:40px;
    content:'';
    position: absolute;
    top:-40px;
    left:0;
}
/* CSS animation */
@-webkit-keyframes fadeIn {
    0% { 
        opacity:0; 
        transform: scale(0.6);
    }
    100% {
        opacity:100%;
        transform: scale(1);
    }
}
@keyframes fadeIn {
    0% { opacity:0; }
    100% { opacity:100%; }
}
.buttonCenter {
            margin-top:45px;
            align-content:center;
            margin-left: 30%;
            margin-right: 30%;
          }
.buttonPassword {
            align-content:center;
            margin-left: 10%;
            margin-right: 10%;
            padding-bottom: 10px;
          }

.editCardTitle {
  font-size:35px;
  text-align: center; 
}
   </style>
  </head>
<body>
  <div class="topnav" id="myTopnav">
    <a href="homePage" class="active">Home</a>
    <a href="#promotions">Promotions</a>
    
    <div class="topNavLogout" id="logout">
    
    <a href="logoutSuccess">Logout</a>
  </div>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
      <i class="fa fa-bars"></i>
    </a>
  </div>
  <div class="title">
    Add Card Information
</div>

<div class="editCardTitle">
  Card 1
</div>
<div class="registration1">
    
    <label class="form-label" for="form2Example1"><u>Card Information</u></label> 
    <%--@elvariable id="editCardForm" type=""--%>
    <form:form method="POST" modelAttribute="editCard">
        <form:input type="name" class="form-control" id="nameOnCard" path="nameOnCard" placeholder="${card0.nameOnCard}" />
        <label class="form-label" for="form2Example1">Name on Card</label> 
    
        <form:input type="name" class="form-control" id="cardNumber" path="cardNumber" placeholder="${card0.cardNumber}" />
        <label class="form-label" for="form2Example1">Card Number</label> 

        <form:input type="name" class="form-control" id="cvv" path="cvv" placeholder="${card0.cvv}" />
        <label class="form-label" for="form2Example1">CVV</label> 
 
        <form:input type="name" class="form-control" id="expirationDate" path="expirationDate" placeholder="${card0.expirationDate}"/>
        <label class="form-label" for="form2Example1">Card Expiration Date</label> 
</div>

    <div class="registration2">
      <label class="form-label" for="form2Example1"><u>Billing Address</u></label> 

      <form:input type="name" class="form-control" id="street" path="street" placeholder="${card0.street}" />
      <label class="form-label" for="form2Example1">Street Address</label> 
      
        
        <form:input type="name" class="form-control" id="city" path="city" placeholder="${card0.city}" />
        <label class="form-label" for="form2Example1">City</label> 
        
        <form:input type="name" class="form-control" id="state" path="state" placeholder="${card0.state}" />
        <label class="form-label" for="form2Example1">State</label> 

        <form:input type="name" class="form-control" id="zip" path="zip" placeholder="${card0.zip}" />
        <label class="form-label" for="form2Example1">Zip</label>
</div>

<br><br>  

<div class="editCardTitle">
  Card 2
</div>
<div class="registration1">
    <label class="form-label" for="form2Example1"><u>Card Information</u></label> 

        <form:input type="name" class="form-control" id="nameOnCard" path="nameOnCard" placeholder="${card1.nameOnCard}" />
        <label class="form-label" for="form2Example1">Name on Card</label> 
    
        <form:input type="name" class="form-control" id="cardNumber" path="cardNumber" placeholder="${card1.cardNumber}" />
        <label class="form-label" for="form2Example1">Card Number</label> 

        <form:input type="name" class="form-control" id="cvv" path="cvv" placeholder="${card1.cvv}" />
        <label class="form-label" for="form2Example1">CVV</label> 
 
        <form:input type="name" class="form-control" id="expirationDate" path="expirationDate" placeholder="${card1.expirationDate}" />
        <label class="form-label" for="form2Example1">Card Expiration Date</label> 
</div>

    <div class="registration2">
      <label class="form-label" for="form2Example1"><u>Billing Address</u></label> 

      <form:input type="name" class="form-control" id="street" path="street" placeholder="${card1.street}" />
      <label class="form-label" for="form2Example1">Street Address</label> 
      
        
        <form:input type="name" class="form-control" id="city" path="city" placeholder="${card1.city}" />
        <label class="form-label" for="form2Example1">City</label> 
        
        <form:input type="name" class="form-control" id="state" path="state" placeholder="${card1.state}" />
        <label class="form-label" for="form2Example1">State</label> 

        <form:input type="name" class="form-control" id="zip" path="zip" placeholder="${card1.zip}" />
        <label class="form-label" for="form2Example1">Zip</label> 
</div>

<br><br>  

<div class="editCardTitle">
  Card 3
</div>
<div class="registration1">
    <label class="form-label" for="form2Example1"><u>Card Information</u></label> 

        <form:input type="name" class="form-control" id="nameOnCard" path="nameOnCard" placeholder="${card2.nameOnCard}" />
        <label class="form-label" for="form2Example1">Name on Card</label> 
    
        <form:input type="name" class="form-control" id="cardNumber" path="cardNumber" placeholder="${card2.cardNumber}" />
        <label class="form-label" for="form2Example1">Card Number</label> 

        <form:input type="name" class="form-control" id="cvv" path="cvv" placeholder="${card2.cvv}" />
        <label class="form-label" for="form2Example1">CVV</label> 
 
        <form:input type="name" class="form-control" id="expirationDate" path="expirationDate" placeholder="${card2.expirationDate}" />
        <label class="form-label" for="form2Example1">Card Expiration Date</label> 
</div>

    <div class="registration2">
      <label class="form-label" for="form2Example1"><u>Billing Address</u></label> 

      <form:input type="name" class="form-control" id="street" path="street" placeholder="${card2.street}" />
      <label class="form-label" for="form2Example1">Street Address</label> 
      
        
        <form:input type="name" class="form-control" id="city" path="city" placeholder="${card2.city}" />
        <label class="form-label" for="form2Example1">City</label> 
        
        <form:input type="name" class="form-control" id="state" path="state" placeholder="${card2.state}" />
        <label class="form-label" for="form2Example1">State</label> 

        <form:input type="name" class="form-control" id="zip" path="zip" placeholder="${card2.zip}" />
        <label class="form-label" for="form2Example1">Zip</label> 
</div>

<br><br>  
<!-- Submit button --> 
<div class="buttonCenter">
   <form:button type="submit" class="btn btn-secondary btn-block mb-4">Submit Changes</form:button>
  </form:form>
</div>
<br><br>
<div class="footer">
  <br>
  <small>Copyright - MovieHub</small>
  <br><br>
</div>

</html>