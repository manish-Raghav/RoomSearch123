<?php
    // include 'ROOSignup.php';
	 $mani =mysqli_connect("localhost","root","","roomsever");
//$Email = $_POST['datamail'];
  


        // if($_SERVER['REQUEST_METHOD'] =='POST')
        //     {
    
     
			$result = array();
			$result['data'] = array();
			$quer ="SELECT * FROM roomdata";
         $roomserver = mysqli_query($mani,$quer);
	
            
			while($row = mysqli_fetch_array($roomserver))
			{
		
		    $index['email']      = $row['0'];
		    $index['adress']   = $row['1'];
			$index['phone']      = $row['2'];
		    $index['rent']   = $row['3'];
			$index['tanentcount']      = $row['4'];
		    $index['des']   = $row['5'];
			$index['img1']      = $row['6'];
		    $index['img2']   = $row['7'];
			$index['img3']   = $row['8'];
				
			array_push($result['data'], $index);
			
				
			}
			
		    echo json_encode($result);
			mysqli_close($mani);
	


            // }	
?>