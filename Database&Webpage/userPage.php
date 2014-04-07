<!-- Caelan Alonge
Video Game Recommendation Application User Page
-->
<html>
<head>
<title>User Page</title>
<?php 
session_start();
$username = $_SESSION['username'];
?>
</head>
<body>
<?php
$con=mysqli_connect("localhost","root","thereisn0sp00n","vgra_database");
$result = mysqli_query($con,"SELECT * FROM members WHERE BINARY username = '".$username."'")
or die(mysql_error());

echo "<table border='1'>
<tr>
<th>Id</th>
<th>Username</th>
<th>Password</th>
<th>Email</th>
<th>Sign Up Date</th>
<th>Account Permissions</th>
</tr>";

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
?>
</body>
</html>

<html>
<body>
<form method="post" action="userpage.php">
<input type="submit" value="Logout" name="clicked">
</form>
<?php
$clicked = @$_POST['clicked'];
if(isset($clicked)){
	header("Location: http://localhost/mainpage.php");
}
?>
</body>
</html>