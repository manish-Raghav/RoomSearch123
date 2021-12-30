<?php

$mani =mysqli_connect("localhost","root","","roomsever");
//$Email = $_POST['datamail'];
  
$quer ="SELECT * FROM roomdata";
 $row = mysqli_query($mani,$quer);
    
     while($ext =mysqli_fetch_array($row))
     {
         
       $data[]= $ext;

        

     }
     mysqli_close($mani);
     print(json_encode($data));




?>