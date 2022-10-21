<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheets" href="css/stylesheet.css">
    <title>UserRegistration    
    </title>
    <meta name="viewport" content="width=device-width">

    <style>
      body{
        background:linear-gradient(grey,orange);
        height:100%;
      }
      .registration{
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
    <a href="homePage.html" class="active">Home</a>
    <a href="couponpromo.html">Promotions</a>
    <a href="userLogin.html">Login</a>
    <a href="viewcart.html">View Cart</a>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
      <i class="fa fa-bars"></i>
    </a>
  </div>


  <div class="title">
    Signup Page
</div>

<div class="registration">
    <form>
        <!-- Email input -->
        <div class="form-outline mb-4">
          <input type="email" id="" class="form-control" />
          <label class="form-label" for="form2Example1">Email address</label>
        </div>
      
        <!-- Password input -->
        <div class="form-outline mb-4">
          <input type="password" id="registrationPassword" class="form-control" />
          <label class="form-label" for="form2Example2">Password</label>
        </div>
      
          <!-- Password input2 -->
          <div class="form-outline mb-4">
            <input type="password" id="registrationPasswordConfirmation" class="form-control" />
            <label class="form-label" for="form2Example2">Confirm Password</label>
          </div>
        
        

        <!-- 2 column grid layout for inline styling -->
        <div class="row mb-4">
          <div class="col d-flex justify-content-center">
            <!-- Checkbox -->
          </div>
        </div>
      
      
        <!-- Submit button -->
        <button type="button" class="btn btn-secondary btn-block mb-4">Register</button>
      
      
        <!-- Register buttons -->
        <div class="text-center">
            <p> Already a Member? <a href="userLogin.html">Login</a></p>
            
            </div>
          </form>
</div>


<div class="footer">
  <br>
  <small>Copyright - Company Name</small>
  <br><br>

</div>

</html>