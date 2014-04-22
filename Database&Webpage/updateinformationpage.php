<!-- Caelan Alonge
GameOn Update Page
-->
<html>
<head>
<title>Update</title>
</head>
<body>
 
<!--Title-->
<div id="container" style="width:500px">
<div id="header" style="background-color:#F3F781;">
<h1 style="margin-bottom:0;">Update User Information</h1></div>
 
<!--Links-->
<p>
<a href="http://garsjmc.co.nf/">Home</a>
<br>
<a href="http://garsjmc.co.nf/loginpage.php">Login</a>
<br>
<a href="http://garsjmc.co.nf/registerpage.php">Register</a>
<br>
<a href="http://garsjmc.co.nf/removepage.php">Remove</a>
<br>
<a href="http://garsjmc.co.nf/updateinformationpage.php">Update Information</a>
</p>
  
<!--Description-->
<p>Update Your Account Information Here</p>
  
<!--Update Password-->
<html>
<body>
<p></p>
<p>Change Password</p>
<form action="updateinformationpage.php" method="get">
Username: <input type="text" name="usernamep"><br>
Current Password: <input type="password" name="currentpasswordp"><br>
New Password: <input type="password" name="newpassword">
<input type="submit">
</form>
</body>
</html>
  
<!--Update Email-->
<html>
<body>
<p></p>
<p>Change Email</p>
<form action="updateinformationpage.php" method="get">
Username: <input type="text" name="usernamee"><br>
Password: <input type="password" name="currentpassworde"><br>
New Email: <input type="text" name="newemail">
<input type="submit">
</form>
</body>
</html>
  
<html>
<body>
<?php
$usernamep = @$_GET["usernamep"];
$usernamee = @$_GET["usernamee"];
$currentpasswordp = @$_GET["currentpasswordp"]; 
$currentpassworde = @$_GET["currentpassworde"];
$newpassword = @$_GET["newpassword"];
$newemail = @$_GET["newemail"];
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
  

$result = mysqli_query($con,"SELECT * FROM members WHERE BINARY username = '".$usernamep."'
AND BINARY password = '".$currentpasswordp."' ")
or die(mysql_error());
$num_results = mysqli_num_rows($result);

if($num_results > 0 && $newpassword !=""){
$changepassword = mysqli_query($con,"Update members SET password = '".$newpassword."' WHERE BINARY username = '".$usernamep."'
AND BINARY password = '".$currentpasswordp."' ")
or die(mysql_error());
}
mysqli_close($con);
 ?>
 
 <?php 
$con=mysqli_connect("fdb7.biz.nf","1661085_garsdata","garsjmcpassword1","1661085_garsdata");
// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }
  

$result = mysqli_query($con,"SELECT * FROM members WHERE BINARY username = '".$usernamee."'
AND BINARY password = '".$currentpassworde."' ")
or die(mysql_error());
$num_results = mysqli_num_rows($result);

if($num_results > 0 && $newemail !=""){
$changeemail = mysqli_query($con,"Update members SET email = '".$newemail."' WHERE BINARY username = '".$usernamee."'
AND BINARY password = '".$currentpassworde."' ")
or die(mysql_error());
}
mysqli_close($con);
 ?>
</body>
</html>