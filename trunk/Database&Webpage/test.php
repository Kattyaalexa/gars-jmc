<html>
<body>

<form action="test.php" method="get">
Name: <input type="text" name="name"><br>
E-mail: <input type="text" name="email"><br>
<input type="submit">
</form>

</body>
</html>

<html>
<body>
<?php 
//if(!isset($name)) $name = ' '; ?>
Welcome  <?php echo @$_GET["name"]; ?><br>
Your email address is: <?php echo @$_GET["email"]; ?>

</body>
</html>