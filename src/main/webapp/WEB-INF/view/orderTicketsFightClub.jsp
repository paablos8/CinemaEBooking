<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheets" href="css/stylesheet.css">
    <title>orderTicketsFC 
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
  background-color:orange;
  justify-content: center;
  margin-left: 400px;
  margin-right: 400px;
  border-radius: 25px; 
}

.flex-container > div {
  background: orange;
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
          
.seatingChart {
  align-items:center;

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
    <br>
    Fight Club
    <br>
    <h3><a href="https://www.youtube.com/watch?v=qtRKdVHc-cE" target="_blank">>Movie Trailer</a>
    </h3>
    <br>
</div>

<div class="flex-container">
<div><img src="movieCovers/fightClub.jpg" alt="image not found"
  width="200" height="300"></div>
  <br>
  Showtimes <br> <br>
  Tuesday : 7pm 8pm 9pm <br>
  Thursday: 7pm 8pm 9pm <br>
  Friday  : 7pm 8pm 9pm <br>
  Saturday: 7pm 8pm 9pm <br>
  
</h5>





</div>


<div class="login">

      Showing Avalible:
      <form>
          <div class="col-auto my-1">
            <label class="mr-sm-2" for="ticketDayOfWeek">Day</label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
              <option selected>Day</option>
              <option value="2">Tuesday</option>
              <option value="3">Thursday</option>
              <option value="3">Friday</option>
              <option value="3">Saturday</option>
            </select>
          </div>
          <div class="col-auto my-1">
            <label class="mr-sm-2" for="ticketTime">Time</label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
              <option selected>Time</option>
              <option value="1">7pm</option>
              <option value="2">8pm</option>
              <option value="3">9pm</option>
            </select>
          </div>          
          <div class="form-outline">
            <label class="form-label" for="numberOfTickets">Number of Tickets:</label>
            <input type="number" id="typeNumber" class="form-control" />
          </div>  
          <div class="col-auto my-1">
            <label class="mr-sm-2" for="ticketTime">Section Letter</label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
              <option selected>Section</option>
              <option value="1">A</option>
              <option value="2">B</option>
              <option value="3">C</option>
              <option value="4">D</option>
            </select>
          </div>          
          <div class="col-auto my-1">
            <label class="mr-sm-2" for="ticketTime">Seat Number</label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
              <option selected>Seat</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="1">4</option>
              <option value="1">5</option>
              <option value="1">6</option>
              <option value="1">7</option>
              <option value="1">8</option>
              <option value="1">9</option>
              <option value="1">10</option>
              
            </select>
          </div>          
          

          
          
            <a href="orderSummary.html">
            <button" class="btn btn-secondary btn-block mb-4">Submit</button>
        </a>
        <div><img src="movieCovers/seatingChart.png" alt="image not found"
          width="200" height="300" ></div>
      </div>
      

      </form>
            </div>

    </div>
    

    <br>
  <a href="homePage.html">
    <button" class="btn btn-secondary btn-block mb-4">Back to Home</button>
</a>

  
</div>

<br>
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