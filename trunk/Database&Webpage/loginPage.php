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
  <a href="http://localhost/mainpage.php/">Home</a>
  <br>
  <a href="http://localhost/loginpage.php/">Login</a>
  <br>
  <a href="http://localhost/registerpage.php/">Register</a>
  </p>
  
  <!--Description-->
  <p>This is the Login page for VGRA!</p>
  
  <!--Login-->
  <html>
  <body>
  <p></p>
  <p>Login using existing user information.</p>
  
  <form action="LoginPage.php" method="get">
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
$con=mysqli_connect("localhost","root","thereisn0sp00n","vgra_database");
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
<th>Sign Up Date</th>
<th>Account Permissions</th>
</tr>";
session_start();
$_SESSION['username'] = $username;
$_SESSION['password'] = $password;
header("Location: http://localhost/userpage.php");
}
while($row = mysqli_fetch_array($result))
  {
  echo "<tr>";
  echo "<td>" . $row['id'] . "</td>";
  echo "<td>" . $row['username'] . "</td>";
  echo "<td>" . $row['password'] . "</td>";
  echo "<td>" . $row['email'] . "</td>";
  echo "<td>" . $row['sign_up_date'] . "</td>";
  echo "<td>" . $row['account_permissions'] . "</td>";
  echo "</tr>";
  }
echo "</table>";

mysqli_close($con);
 ?>
  </body>
</html>