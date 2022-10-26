<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheets" href="css/stylesheet.css">
    <title>Home   
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
  justify-content: center;
  margin-left: 7%;
  margin-right: 7%;
  border-radius: 25px; 
}

.flex-container > div {
  margin:25px;
  padding:1px;
  font-size: 10px;
}

a{
  color: black;
}

h5{
  text-align:center;
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

  <div class="topnav"
   id="myTopnav">
    <a href="homePage.jsp" class="active">Home</a>
    <a href="couponpromo.jsp">Promotions</a>
    <a href="userLogin">Login</a>
    <a href="viewcart.jsp">View Cart</a>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
      <i class="fa fa-bars"></i>
    </a>
  </div>



  <div class="title">
    <br>
    Home Page
    <br><br>
</div>

<div class="flex-container">
<div><img src="https://m.media-amazon.com/images/I/81D+KJkO4SL._AC_UF894,1000_QL80_.jpg" alt="image not found"
  width="150" height="225"></div>
<h5>Fight Club <br> <br>
  Showtimes <br> <br>
  Tuesday : 7pm 8pm 9pm <br>
  Thursday: 7pm 8pm 9pm <br>
  Friday  : 7pm 8pm 9pm <br>
  Saturday: 7pm 8pm 9pm <br>
  <a href="https://www.youtube.com/watch?v=qtRKdVHc-cE" target="_blank">>Movie Trailer</a>
  <br><a href="orderTicketsFightClub.jsp" target="_blank">Order Tickets Here</a>
</h5>
<div><img src="https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg" alt="image not found"
  width="150" height="225"></div>
<h5>The Godfather <br> <br>
  Showtimes <br> <br>
  Tuesday : 7pm 8pm 9pm <br>
  Thursday: 7pm 8pm 9pm <br>
  Friday  : 7pm 8pm 9pm <br>
  Saturday: 7pm 8pm 9pm <br>
  <a href="https://www.youtube.com/watch?v=UaVTIH8mujA" target="_blank">>Movie Trailer</a>
  <br><a href="orderTickets.jsp" target="_blank">Order Tickets Here</a>
</h5>
<div><img src="https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg" alt="image not found"
  width="150" height="225"></div>
<h5>The Dark Knight<br> <br>
  Showtimes <br> <br>
  Tuesday : 7pm 8pm 9pm <br>
  Thursday: 7pm 8pm 9pm <br>
  Friday  : 7pm 8pm 9pm <br>
  Saturday: 7pm 8pm 9pm <br>
  <a href="https://www.youtube.com/watch?v=EXeTwQWrcwY" target="_blank">>Movie Trailer</a>
  <br><a href="orderTickets.jsp" target="_blank">Order Tickets Here</a>
</div>



<div class="title">
  <br>
  Films Coming Soon
  <br> <br>
</div>


<div class="flex-container">
  <div><img src="https://upload.wikimedia.org/wikipedia/commons/b/b5/12_Angry_Men_%281957_film_poster%29.jpg" alt="image not found"
    width="150" height="225"></div>
  <h5>12 Angry Men<br>
    <br>
    <a href="https://www.youtube.com/watch?v=_13J_9B5jEk" target="_blank">>Movie Trailer</a>
  </h5>
    <div><img src="https://upload.wikimedia.org/wikipedia/en/6/67/Forrest_Gump_poster.jpg" alt="image not found"
    width="150" height="225"></div>
  <h5>Forrest Gump<br>
   <br>
    <a href="https://www.youtube.com/watch?v=bLvqoHBptjg" target="_blank">>Movie Trailer</a>
  </h5>
  <div><img src="https://upload.wikimedia.org/wikipedia/en/3/3b/Pulp_Fiction_%281994%29_poster.jpg" alt="image not found"
    width="150" height="225"></div>
  <h5>Pulp Fiction<br>
    <br>
    <a href="https://www.youtube.com/watch?v=s7EdQ4FqbhY" target="_blank">>Movie Trailer</a>
</h5>
</div>
<br>
<br>




    <div class="footer">
      <br>
      <small>Copyright - Company Name</small>
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