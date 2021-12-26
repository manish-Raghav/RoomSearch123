<?php

  include 'ROOSignup.php';

    @$email = $_POST['Email'];
    @$name = $_POST['Name'];
    

    $sql = "INSERT INTO `signup`(`Email`, `Name`) VALUES ('$email','$name')";

      $amni = mysqli_query($conn, $sql);

     if($amni == true )
       { 
            $responce ="your api working";
       }

        else {
          $responce ="your api not working";
        }
        echo $responce;
?>