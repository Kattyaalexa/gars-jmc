<!-- Caelan Alonge
Video Game Recommendation Application User Page
-->
<html>
<head>
<title>User Page</title>
<?php 
//session_start();
$username = $_SESSION['username'];
?>
</head>
<body>
<?php
$con=mysqli_connect("fdb7.biz.nf","1661085_garsdata","garsjmcpassword1","1661085_garsdata");
$result = mysqli_query($con,"SELECT * FROM members WHERE BINARY username = '".$username."'")
or die(mysql_error());

echo "<table border='1'>
<tr>
<th>Id</th>
<th>Username</th>
<th>Password</th>
<th>Email</th>
</tr>";

while($row = mysqli_fetch_array($result))
  {
  echo "<tr>";
  echo "<td>" . $row['id'] . "</td>";
  echo "<td>" . $row['username'] . "</td>";
  echo "<td>" . $row['password'] . "</td>";
  echo "<td>" . $row['email'] . "</td>";
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
	header("Location: http://garsjmc.co.nf/userpage.php");
}
?>
</body>
</html>