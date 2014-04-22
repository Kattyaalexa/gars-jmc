<!-- Caelan Alonge
GameOn Home Page
-->
<html>
<head>
<title>Home</title>
</head>
<body>

<!--Title-->
<div id="container" style="width:500px">
<div id="header" style="background-color:#9FF781;">
<h1 style="margin-bottom:0;">GameON Home</h1></div>

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
<p>This is the main page for the GameON Video Game Recommendation Android Application</p>
</body>
</html>

<?php
/**
 * File to handle all API requests
 * Accepts GET and POST
 * 
 * Each request will be identified by TAG
 * Response will be JSON data
 
  /**
 * check for POST request 
 */
if (isset($_POST['tag']) && $_POST['tag'] != '') {
    // get tag
    $tag = $_POST['tag'];
 
    // include db handler
    require_once 'include/DB_Functions.php';
    $db = new DB_Functions();
 
    // response Array
    $response = array("tag" => $tag, "success" => 0, "error" => 0);
 
    // check for tag type
    if ($tag == 'login') {
        // Request type is check Login
        $name = $_POST['name'];
        $password = $_POST['password'];
 
        // check for user
        $user = $db->getUserByUsernameAndPassword($name, $password);
        if ($user != false) {
            // user found
            // echo json with success = 1
            $response["success"] = 1;
            $response["user"]["name"] = $user["name"];
            $response["user"]["email"] = $user["email"];
            echo json_encode($response);
        } else {
            // user not found
            // echo json with error = 1
            $response["error"] = 1;
            $response["error_msg"] = "Incorrect username or password!";
            echo json_encode($response);
        }
    } else if ($tag == 'register') {
        // Request type is Register new user
        $name = $_POST['name'];
        $email = $_POST['email'];
        $password = $_POST['password'];
 
        // check if user is already existed
        if ($db->isUserExisted($name)) {
            // user is already existed - error response
            $response["error"] = 2;
            $response["error_msg"] = "User already existed";
            echo json_encode($response);
        } else {
            // store user
            $user = $db->storeUser($name, $email, $password);
            if ($user) {
                // user stored successfully
                $response["success"] = 1;
                $response["user"]["name"] = $user["name"];
                $response["user"]["email"] = $user["email"];
                echo json_encode($response);
            } else {
                // user failed to store
                $response["error"] = 1;
                $response["error_msg"] = "Error occured in Registartion";
                echo json_encode($response);
            }
        }
    } else {
        echo "Invalid Request";
    }
} else {
    echo "Access Denied";
}
?>