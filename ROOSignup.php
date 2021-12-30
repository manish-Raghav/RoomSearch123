<?php  
 $conn = mysqli_connect("localhost","root","","roomsever");
 

    if($conn ==TRUE)
  {echo "sucess manish raghav";}
  else
  {echo "unsucess" ;}

//   @$email=$_POST["Email"];
//   @$name=$_POST["Name"];

//   $query = "INSERT INTO `signup`(`Email`, `Name`) VALUES ('$email','$name')";
   
//   if(mysqli_query($conn ,$query))
//   {
//      $result["add"] = "Done";
//   }
//   else{
//    $result["add"] = "error ";
//   }
 
  
//   print(json_encode($result));




// $conn = mysqli_connect("localhost","root","","roomsdata");
// if (mysqli_connect_errno()) {
//   echo "Failed to connect to MySQL: " . mysqli_connect_error();
//   exit();
// }

//       $Email=$_POST["email"];
//        $name=$_POST["Name"];

// // Perform query
// if ($result = mysqli_query($con,  "INSERT INTO `signup`(`email`, `Name`) VALUES ('$Email','$name')")) {
//   echo "Returned rows are: " . mysqli_num_rows($result);
//   // Free result set
//   mysqli_free_result($result);
// }



?>   



