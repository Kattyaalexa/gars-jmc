<!-- Caelan Alonge
Video Game Recommendation Application Register Page
-->
<html>
  <head>
  <title>Register</title>
  </head>
  <body>
 
 <!--Title-->
  <div id="container" style="width:500px">
  <div id="header" style="background-color:#FA5858;">
  <h1 style="margin-bottom:0;">Video Game Recommendation Application Register</h1></div>
  
  <!--Links-->
  <p>
  <a href="http://garsjmc.co.nf/">Home</a>
  <br>
  <a href="http://garsjmc.co.nf/loginpage.php">Login</a>
  <br>
  <a href="http://garsjmc.co.nf/registerpage.php">Register</a>
  <br>
  <a href="http://garsjmc.co.nf/removepage.php">Remove</a>
  </p>
  
  <!--Description-->
  <p>This is the registration page for VGRA!</p>
  
  <!--Login-->
  <p></p>
  <p>Register a new user.</p>
  <form name="input" action="registerpage.php" method="get">
  Username: <input type="text" name="username"><br>
  Password: <input type="password" name="password"><br>
  Email: <input type="text" name="email"><br>
  <input type="submit" value="Submit">
  </form>
  
<html>
<body>
<?php
$username = @$_GET["username"];
$password = @$_GET["password"];
$email = @$_GET["email"];

 ?>
</body>
</html>

<?php 
$con=mysqli_connect("fdb7.biz.nf","1661085_garsdata","garsjmcpassword1","1661085_garsdata");
// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }
  
if($username != ""){
$sql = mysqli_query($con,"INSERT INTO members (username, password, email)
VALUES ('$username', '$password', '$email')")or die(mysql_error());
$username = "";
$password = "";
$email = "";
}
mysqli_close($con);
 ?>
  
  </body>
</html>