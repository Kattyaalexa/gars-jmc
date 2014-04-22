<?php
 
class DB_Functions {
 
    private $db;
 
    //put your code here
    // constructor
    function __construct() {
        require_once 'DB_Connect.php';
        // connecting to database
        $this->db = new DB_Connect();
        $this->db->connect();
    }
 
    // destructor
    function __destruct() {
         
    }
 
    /**
     * Storing new user
     * returns user details
     */
    public function storeUser($name, $email, $password) {
        $result = mysql_query("INSERT INTO members(username, password, email) VALUES('$name', '$password', '$email')");
        // check for successful store
        if ($result) {
            // get user details 
            $result = mysql_query("SELECT * FROM members WHERE username = '$name'");
            // return user details
            return mysql_fetch_array($result);
        } else {
            return false;
        }
    }
 
    /**
     * Get user by username and password
     */
    public function getUserByUsernameAndPassword($name, $password) {
        $result = mysql_query("SELECT * FROM members WHERE username = '$name' AND password = '$password'") or die(mysql_error());
        // check for result 
        $no_of_rows = mysql_num_rows($result);
        if ($no_of_rows > 0) {
            $result = mysql_fetch_array($result);
            return $result;
            }
        } else {
            // user not found
            return false;
        }
    }
 
    /**
     * Check user is existed or not
     */
    public function isUserExisted($name) {
        $result = mysql_query("SELECT username from users WHERE username = '$name'");
        $no_of_rows = mysql_num_rows($result);
        if ($no_of_rows > 0) {
            // user existed 
            return true;
        } else {
            // user not existed
            return false;
        }
    }
}
 
?>