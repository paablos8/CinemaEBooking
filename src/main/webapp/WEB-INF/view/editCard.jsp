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
        height:110%;
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
@import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');*
{padding: 0;
  margin: 0;
  font-family:'Poppins', sans-serif}
  .container{
    
    height:auto;
    display:flex;
    justify-content:center;
    align-items:center;
  }
    .card{
      width:350px;
      height:75vh;
      background-color:#fff;
      box-shadow:0px 15px 30px rgba(0,0,0,0.1);
      border-radius:10px;
            
    }
      .card .info
      {padding:15px;display:flex;justify-content:space-between;border-bottom:1px solid #e1dede;
        background-color:#e5e5e5}
        .card .info button
        {height:30px;width:80px;border:none;
          color:#fff;border-radius:4px;background-color:#000;
          cursor:pointer;text-transform:uppercase}
          .card .forms
          {padding:15px}
          .card .inputs
          {display:flex;flex-direction:column;margin-bottom:10px}
          .card .inputs span{font-size:12px}
          .card .inputs input{height:40px;padding:0px 10px;font-size:17px;box-shadow:none;outline:none}
          .card .inputs input[type="text"][readonly]{border: 2px solid rgba(0,0,0,0)}


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
    Edit Account
</div>

<div class="container">
    <div class="card"> <div class="info"> 
      <span>Edit Account Information</span> 
      <button id="savebutton">edit</button> </div> 
      <div class="forms"> 
      <div class="inputs"> 
      <span>Name</span> 
      <input type="text" readonly value="SampleFirst"> </div> 
      <div class="inputs"> 
      <span>Address</span> 
      <input type="text" readonly value="SampleAddress"> </div> 
      <div class="inputs"> 
      <span>City</span> 
      <input type="text" readonly value="City"> </div> 
      <div class="inputs"> 
      <span>State</span> 
      <input type="text" readonly value="State"> </div> 
      <div class="inputs"> 
      <span>Country</span>
      <input type="text" readonly value="Country"> </div> 
        
      
        <a href="editProfile">
          <button" class="btn btn-secondary btn-block mb-4">Confirm Changes</button>
      </a>
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

      var savebutton = document.getElementById('savebutton');
var readonly = true;
var inputs = document.querySelectorAll('input[type="text"]');
savebutton.addEventListener('click',function(){
    
     for (var i=0; i<inputs.length; i++) {
     inputs[i].toggleAttribute('readonly');
     };

    if (savebutton.innerHTML == "edit") {
      savebutton.innerHTML = "save";
         } else {
      savebutton.innerHTML = "edit";
      }  
});
      </script>
      



</html>