<?php
header('Content-Type:application/json; charset=utf-8');


$url = $_SERVER["REQUEST_URI"];

switch($url) {
    case "/":
        echo "hello php";
    break;
    case "/health":
        echo json_encode(array(
            "status"=> "UP",
        ));
    break;
    case "/getUser":
        echo json_encode(array(
            "username" => "php",
            "password" => "php"
        ));
}
exit;

?>