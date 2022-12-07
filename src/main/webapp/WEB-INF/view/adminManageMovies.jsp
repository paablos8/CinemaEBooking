<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheets" href="css/stylesheet.css">
    <title>Manage Movies  
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
a{
color: black;
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
.manageCard{
  text-align: center;
  border-radius:25px;
  background-color: #333;
  margin-left:30%;
  margin-right:30%;
  padding-top: 15px;
  padding-left: 15px;
  padding-right: 15px;
  padding-bottom: 15px;
  color: lightgrey;
}
.manageCard a {
  color: lightgrey;
}

  .centerElement{
    text-align:center;
  }

    </style>
  </head>

<body>

  <div class="topnav" id="myTopnav">
    <a href="homePage" class="active">Home</a>
    <a href="viewPromotion"> Manage Promotions</a>
    <a href="adminManageMovies">Manage Movies</a>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
      <i class="fa fa-bars"></i>
    </a>
  </div>

 <div class="title">
    Manage Movies
</div>
<br>
  <div class="manageCard">  
<section>
    <h2>${movie0}</h2>
    
        <a href="link.com" target="_blank">${remove0}</a>
        <a href="link.com" target="_blank">${edit0}</a>
        <a href="scheduleMovie?movie=${movie0}" target="_blank">${schedule0}</a>
    </div>
        <hr> 
    </div>
  </section>
</div>

<div class="manageCard">  
  <section>
    <h2>${movie1}</h2>
    
        <a href="link.com" target="_blank">${remove1}</a>
        <a href="link.com" target="_blank">${edit1}</a>
        <a href="scheduleMovie?movie=${movie1}" target="_blank">${schedule1}</a>
    </div>
        <hr> 
    </div>
  </section>
</div>
<div class="manageCard">    
<section>
    <h2>${movie2}</h2>
    
        <a href="link.com" target="_blank">${remove2}</a>
        <a href="link.com" target="_blank">${edit2}</a>
        <a href="scheduleMovie?movie=${movie2}" target="_blank">${schedule2}</a>
    </div>
        <hr> 
    </div>
  </section>
</div>
<div class="manageCard">  

  <section>
    <h2>${movie3}</h2>
    
        <a href="link.com" target="_blank">${remove3}</a>
        <a href="link.com" target="_blank">${edit3}</a>
        <a href="scheduleMovie?movie=${movie3}" target="_blank">${schedule3}</a>
    </div>
        <hr> 
    </div>
  </section>
</div>
<div class="manageCard">  
  <section>
    <h2>${movie4}</h2>
    
        <a href="link.com" target="_blank">${remove4}</a>
        <a href="link.com" target="_blank">${edit4}</a>
        <a href="scheduleMovie?movie=${movie4}" target="_blank">${schedule4}</a>
    </div>
        <hr> 
    </div>
  </section>
</div>
<div class="manageCard">  
  <section>
    <h2>${movie5}</h2>
    
        <a href="link.com" target="_blank">${remove5}</a>
        <a href="link.com" target="_blank">${edit5}</a>
        <a href="scheduleMovie?movie=${movie5}" target="_blank">${schedule5}</a>
    </div>
        <hr> 
    </div>
  </section>
</div>
<div class="manageCard">  
  <section>
    <h2>${movie6}</h2>
    
        <a href="link.com" target="_blank">${remove6}</a>
        <a href="link.com" target="_blank">${edit6}</a>
        <a href="scheduleMovie?movie=${movie6}" target="_blank">${schedule6}</a>
    </div>
        <hr> 
    </div>
  </section>
</div>
<div class="manageCard">  
  <section>
    <h2>${movie7}</h2>
    
        <a href="link.com" target="_blank">${remove7}</a>
        <a href="link.com" target="_blank">${edit7}</a>
        <a href="scheduleMovie?movie=${movie7}" target="_blank">${schedule7}</a>
    </div>
        <hr> 
    </div>
  </section>
</div>
<div class="manageCard">  
  <section>
    <h2>${movie8}</h2>
    
        <a href="link.com" target="_blank">${remove8}</a>
        <a href="link.com" target="_blank">${edit8}</a>
        <a href="scheduleMovie?movie=${movie8}" target="_blank">${schedule8}</a>
    </div>
        <hr> 
    </div>
  </section>
</div>
<div class="manageCard">  
  <section>
    <h2>${movie9}</h2>
    
        <a href="link.com" target="_blank">${remove9}</a>
        <a href="link.com" target="_blank">${edit9}</a>
        <a href="scheduleMovie?movie=${movie9}" target="_blank">${schedule9}</a>
    </div>
        <hr> 
    </div>
  </section>
  <div>

    <div class="centerElement">
<section>
  
        <a href="addMovie"><button class='add-btn'>Add New Movie</button></a>

      </div>
      <br><br><br>
      
      <div class="centerElement">
        <a href="adminHome"><button role= "Back2Home-butt">Back to Admin Home</button></a>
      </div>
    
      <br><br><br><br><br><br><br>
    </div>
      <div class="footer">
        <br>
        <small>Copyright - MovieHub</small>
        <br><br>
        </div>
     </body>
</section>
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