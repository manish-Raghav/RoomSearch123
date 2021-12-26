
<?php
      include 'ROOSignup.php';


        $email=$_POST['email'] ?? "";
       //$uname =$_POST['Name'] ?? "";
       
        $uadress =$_POST['adress'] ?? "";
        $uphone =$_POST['phone'] ?? "";
        $urant =$_POST['rent']  ?? "";
        $countpeople = $_POST['tanentcount'] ?? "";
        $descripttion =$_POST['des'] ?? "";

        $encodedimag1 = $_POST['img1'] ?? "";
        $encodedimag2 = $_POST['img2'] ?? "";
        $encodedimag3 = $_POST['img3'] ?? "";

       //  $image1 =$_FILES['']
    

          // $firstloc =$_FILES['image1']['tmp_name'] ?? "";
          // $secondloc =$_FILES['image2']['tmp_name'] ?? "";
          // $thirdloc = $_FILES['image3']['tmp_name'] ?? "";
         // $forthloc =$_FILES['image4']['tmp_name'] ?? "";

         // //   $firstsize = $_FILES['image1']['size'];
    // //   $secondsize = $_FILES['image2']['size'];
    // //   $thirdsize = $_FILES['image3']['size'];
    // //   $fourthsize = $_FILES['image4']['size'];


           $firstname = "IMG".rand().".jpg";
           $secondname ="IMG".rand().".jpg";
           $thirdname ="IMG".rand().".jpg";
          // $fourthname =$_FILES['image4']['name']  ?? "";
          // $firstname = "manishfirstimage";
          // $secondname ="manshsecondimage";
          // $thirdname = "thirdimage";

          $firstdesi ="imageupload/".$firstname;
          $seconddesi ="imageupload/".$secondname;
           $thirddesi ="imageupload/".$thirdname;
        //  $fourthdesi ="imageupload/".$fourthname;
       
        //$email ="karansing123@";

            
           // $movedata1= move_uploaded_file($firstloc,"upload\tj.jpg");

        //    ,`img1`, `img2`, `img3`
        //    ,'$firstdesi' , '$seconddesi' , '$thirddesi' 
        if($email != null && $uadress != null && $uphone !=null)
        {

          $myquery ="INSERT INTO `roomdata`(`email`, `adress`, `phone`, `rent`, `tanentcount`, `des`, `img1`, `img2`, `img3`) VALUES
          ('$email',' $uadress','$uphone',' $urant' , '$countpeople' , '$descripttion'  , '$firstname' , ' $secondname' , '$thirddesi' )";


             if(mysqli_query($conn, $myquery))
            {
  file_put_contents($firstdesi, base64_decode( $encodedimag1));
  file_put_contents($seconddesi, base64_decode( $encodedimag2));
  file_put_contents($thirddesi, base64_decode( $encodedimag3));

  // $movedata1= move_uploaded_file($firstloc,$firstdesi);
  // $movedata2= move_uploaded_file($,$seconddesi);
  //  $movedata3= move_uploaded_file($thirdloc,$thirddesi);
 //    $movedata4= move_uploaded_file($forthloc,$fourthdesi);
          
 $responce ="your data is uploaded ";
    
     
     }   
 else{
  $responce =  "fill again your data";

        }

              }  
              else{
                  $responce =" fill all information ";
              }  
              echo  $responce;                  
  


        mysqli_close($conn);
       // print(json_encode($result));

 ?> 










  

