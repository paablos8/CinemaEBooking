<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheets" href="css/stylesheet.css">
        <title>UserLogin    
        </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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


    <div class="title">
        Reset Password
    </div>
    <div class="login">
    <form:form method="POST" modelAttribute="resetPassword">
    <div class="MyForm form-group">
        
        
            <!-- new password input -->
            <div class="form-outline mb-4"></div>
                <form:input type="password" class="form-control" id="password" path="password" placeholder="Enter new password" />
                <label class="form-label" for="form2Example1">New Password</label>    
            </div>


        <!-- Submit button -->
        <form:button type="submit" class="btn btn-secondary btn-block mb-4"></a>confirm back to login</form:button>
        
    </form>
    </div>

    <div class="footer">
        <br>
        <small>Copyright - MovieHub</small>
        <br><br>
    </div>
    </div>
</form:form>
</div>

</body>
    
</html>