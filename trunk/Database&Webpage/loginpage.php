<!-- Caelan Alonge
Video Game Recommendation Application Login Page
-->
<html>
  <head>
  <title>Login</title>
  </head>
  <body>
 
 <!--Title-->
  <div id="container" style="width:500px">
  <div id="header" style="background-color:#F3F781;">
  <h1 style="margin-bottom:0;">Video Game Recommendation Application Login</h1></div>
  
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
  <p>This is the Login page for VGRA!</p>
  
  <!--Login-->
  <html>
  <body>
  <p></p>
  <p>Login using existing user information.</p>
  
  <form action="loginpage.php" method="get">
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
echo "<table border='1'>
<tr>
<th>Id</th>
<th>Username</th>
<th>Password</th>
<th>Email</th>
</tr>";
}
while($row = mysqli_fetch_array($result))
  {
  echo "<tr>";
  echo "<td>" . $row['id'] . "</td>";
  echo "<td>" . $row['username'] . "</td>";
  echo "<td>" . $row['password'] . "</td>";
  echo "<td>" . $row['email'] . "</td>";
  echo "</tr>";
  }
echo "</table>";

mysqli_close($con);
 ?>
  </body>
</html>