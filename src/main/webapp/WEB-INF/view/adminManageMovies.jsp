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
        background-color: grey;
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
    Mangage Movies
</div>
  <section>
    <h2>Fight Club</h2>
    <div>
        <div>
         <p> <h3>Showtimes <br>
            Tuesday : 7pm 8pm 9pm <br>
            Thursday: 7pm 8pm 9pm <br>
            Friday : 7pm 8pm 9pm <br>
            Saturday: 7pm 8pm 9pm <br>
        <br>
        Directed by: David Fincher</p><br>
        </div>
        <div>
            Genre: Action
        </div>
      <div>
        <button role= "RemoveBut">Remove</button>
        <button role= "EditBut">Edit Movie details</button>
    </div>
        <hr> 
    </div>
  </section>

  <section>
    <h2>Forrest Gump</h2>
    <div>
        <div>
         <p> <h3>Showtimes <br>
            Tuesday : 7pm 8pm 9pm <br>
            Thursday: 7pm 8pm 9pm <br>
            Friday : 7pm 8pm 9pm <br>
            Saturday: 7pm 8pm 9pm <br>
        <br>
        Directed by: Robert Zemeckis</p><br>
        </div>
        <div>
            Genre: Comedy
        </div>
      <div>
        <button role= "RemoveBut">Remove</button>
        <button role= "EditBut">Edit Movie details</button>
    </div>
        <hr> 
    </div>
  </section>

  <section>
    <h2>Pulp Fiction</h2>
    <div>
        <div>
         <p> <h3>Showtimes <br>
            Tuesday : 7pm 8pm 9pm <br>
            Thursday: 7pm 8pm 9pm <br>
            Friday : 7pm 8pm 9pm <br>
            Saturday: 7pm 8pm 9pm <br>
        <br>
        Directed by: Quentin Tarantino</p><br>
        </div>
        <div>
            Genre: Action
        </div>
      <div>
        <button role= "RemoveBut">Remove</button>
        <button role= "EditBut">Edit Movie details</button>
    </div>
        <hr> 
    </div>
  </section>

  <section>
    <h2>The Godfather</h2>
    <div>
        <div>
         <p> <h3>Showtimes <br>
            Tuesday : 7pm 8pm 9pm <br>
            Thursday: 7pm 8pm 9pm <br>
            Friday : 7pm 8pm 9pm <br>
            Saturday: 7pm 8pm 9pm <br>
        <br>
        Directed by: Francis Ford Coppola</p><br>
        </div>
        <div>
            Genre: Action, Crime
        </div>
      <div>
        <button role= "RemoveBut">Remove</button>
        <button role= "EditBut">Edit Movie details</button>
    </div>
        <hr> 
    </div>
  </section>

  <section>
    <h2>The Dark Knight</h2>
    <div>
        <div>
         <p> <h3>Showtimes <br>
            Tuesday : 7pm 8pm 9pm <br>
            Thursday: 7pm 8pm 9pm <br>
            Friday : 7pm 8pm 9pm <br>
            Saturday: 7pm 8pm 9pm <br>
        <br>
        Directed by: Christopher Nolan</p><br>
        </div>
        <div>
            Genre: Action, crime
        </div>
      <div>
        <button role= "RemoveBut">Remove</button>
        <button role= "EditBut">Edit Movie details</button>
    </div>
        <hr> 
    </div>
  </section>

  <section>
    <h2>12 Angry Men</h2>
    <div>
        <div>
         <p> <h3>Showtimes <br>
            Tuesday : 7pm 8pm 9pm <br>
            Thursday: 7pm 8pm 9pm <br>
            Friday : 7pm 8pm 9pm <br>
            Saturday: 7pm 8pm 9pm <br>
        <br>
        Directed by: Sidney Lumet</p><br>
        </div>
        <div>
            Genre: Drama
        </div>
      <div>
        <button role= "RemoveBut">Remove</button>
        <button role= "EditBut">Edit Movie details</button>
    </div>
        <hr> 
    </div>
  </section>
 

<section>
  <%--@elvariable id="login" type=""--%>
      <form:form method="POST" modelAttribute="movie">
    <div class='movive-info-content'>
      
        <table class='half-input-table'>
          <tr><td>To add or edit, please enter new movie information: </td></tr>
        </table>
        
        Movie Title
        <input type="text" path="movieTitle" placeholder="Enter Movie Title" />
        <table class='half-input-table'>
          <tr>

            <td> Category
              <input class='input-field' placeholder="Enter Category"></input>
            </td>

            <td> Cast 
              <input class='input-field' placeholder="Add Cast"></input>
            </td>

            <td> Director 
              <input class='input-field' placeholder="Enter Director"></input>
            </td>
            
            <td> Producer
              <input class='input-field' placeholder="Enter Producer"></input>
            </td>

            <td> Synopsis 
              <input class='input-field' placeholder="Enter Synopsis"></input>
            </td>

            <td> Review 
              <input class='input-field' placeholder="Enter Review"></input>
            </td>

            <td> Trailer Picture
              <input class='input-field' placeholder="Insert TrailerPicture"></input>
            </td>

            <td> Trailer Video 
              <input class='input-field' placeholder="Enter link to an trailer video"></input>
            </td>

            <td> Film Rating Code
              <input class='input-field' placeholder="Film Rating COde"></input>
            </td>
            
            <td>Showtimes
                <input class='input-field' placeholder="Select Showtimes"></input>
              </td>
          </tr>
        </table>
        <button class='add-btn'>Add New Movie</button>

      </div>
      <br><br><br>
      <div>
        <a href="adminHome"><button role= "Back2Home-butt">Back to Admin Home</button></a>
      </div>
      <br><br><br><br><br><br><br>

      <div class="footer">
        <br>
        <small>Copyright - Company Name</small>
        <br><br>
        </div>
     
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