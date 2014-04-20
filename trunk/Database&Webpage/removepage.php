<!-- Caelan Alonge
Video Game Recommendation Application Remove Page
-->

<html>
<head>
<title>Remove</title>
</head>
<body>
  
<!--Title-->
<div id="container" style="width:500px">
<div id="header" style="background-color:#F3F781;">
<h1 style="margin-bottom:0;">Video Game Recommendation Application Remove</h1></div>
  
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
  <p>Remove users from the database</p>
  
  <form action="removepage.php" method="get">
  Username: <input type="text" name="username"><br>
  Password: <input type="password" name="password">
  <input type="submit">
  </form>
  </body>
  </html>
  
<html>
<body>
<?php
$username = @$_GET["username"];
$password = @$_GET["password"]; ?>
</body>
</html>

  <?php 
$con=mysqli_connect("fdb7.biz.nf","1661085_garsdata","garsjmcpassword1","1661085_garsdata");
// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }
  

$result = mysqli_query($con,"SELECT * FROM members WHERE BINARY username = '".$username."'
AND BINARY password = '".$password."' ")
or die(mysql_error());
$num_results = mysqli_num_rows($result);

if($num_results > 0){
$sql = mysqli_query($con,"DELETE FROM members WHERE username = '".$username."'")
or die(mysql_error());
$username = "";
$password = "";
mysqli_close($con);
}
 ?>
  </body>
</html>