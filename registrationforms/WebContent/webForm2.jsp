<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <script type="text/javascript">
   function setFocus()
   {
	   document.getElementById("uid").focus();
   }
     function validate()
     {
    	 var name;
    	 var pswd;
    	 var uid;
    	 var email;
    	 var add;
    	 var zip;
    	 var txt;
    	 var country;
    	 
    	 uid =document.getElementById("uid").value;
    	 pswd = document.getElementById("pswd").value;
    	 name = document.getElementById("uname").value;
    	 email=document.getElementById("mail").value;
    	 add = document.getElementById("add").value;
    	 zip = document.getElementById("num").value;
    	 txt = document.getElementById("txt").value;
    	 country =document.getElemenyById("country").value;
    	 
        
    	 
    	 if(uid.length==0)
    		 {
    		 document.getElementById("msg1").hidden=false;
    		 document.getElementById("uid").focus();
    		 
    	     }
    	 else 
    		  
    		 document.getElementById("msg1").hidden=true;
    	 if(pswd.length==0)
		 {
		 document.getElementById("msg2").hidden=false;
		 document.getElementById("pswd").focus();
		 
	     }
	 else 
		  
		 document.getElementById("msg2").hidden=true;
    	 if(name.length==0)
    		 {
    		 document.getElementById("msg3").hidden=false;
    		 
    		 document.getElementById("uname").focus();
    		 }
    	 else 
    		 document.getElementById("msg3").hidden=true;
    	 if(add.length==0)
		 {
		 document.getElementById("msg4").hidden=false;
		 document.getElementById("add").focus();
		 
	     }
	 else 
		  
		 document.getElementById("msg4").hidden=true;
    	 if(zip.length==0)
		 {
		 document.getElementById("msg6").hidden=false;
		 document.getElementById("num").focus();
		 
	     }
	 else 
		  
		 document.getElementById("msg6").hidden=true;
    	 if(email.length==0)
		 {
		 document.getElementById("msg5").hidden=false;
		 document.getElementById("mail").focus();
		 
	     }
	 else 
		  
		 document.getElementById("msg5").hidden=true;
    	
    	
    	 if(txt.length==0)
		 {
		 document.getElementById("msg7").hidden=false;
		 document.getElementById("txt").focus();
		 
	     }
	 else 
		  
		 document.getElementById("msg7").hidden=true;
    	 if(txt.length==0)
		 {
		 document.getElementById("msg8").hidden=false;
		 document.getElementById("country").focus();
		 
	     }
	 else 
		  
		 document.getElementById("msg8").hidden=true;
    	 
    	
    		}
    /* function handleData()
	 {
	     var form_data = new FormData(document.querySelector("form"));
	     
	     if(!form_data.has("langs[]"))
	     {
	         document.getElementById("chk_option_error").style.visibility = "visible";
	       return false;
	     }
	     else
	     {
	         document.getElementById("chk_option_error").style.visibility = "hidden";
	       return true;
	     }
	     
	 }*/
   </script>
</head>
   <body onload="setFocus()">
   <!--<form onsubmit="return handleData()" >-->
   <form action ="Form2Servlet">
       <table   align= center>
       <tr>
         <td>UserId</td>
          <td><input type ="text" id="uid" name ="name" Required pattern=".{5,12}" maxlength="12"></td>
          <td><label id ="msg1" hidden style ="color:red">Required and Length must be 5to 12</label></td>
    </tr>
       <tr>
         <td>Password</td>
         <td><input type = "password" id="pswd" name = "pass" Required pattern=".{7,12}"maxlength="12"  ></td>
         <td><label id ="msg2" hidden style ="color:red">Required and Length must be 7 to 12</label></td>
   </tr>
       <tr>
         <td>Name</td>
         <td><input type="text" id ="uname" name="name" Required></td>
         <td><label id ="msg3" hidden style ="color:red">Required and Alphabet only</label></td>
    </tr>
       <tr>
         <td>Address</td>
         <td><input type ="text" id ="add" name ="add" ></td>
         <td><label id ="msg4" hidden style ="color:red">Optional</label></td>
    </tr>
      <tr>
   
        <td><label for ="country" id="country">country :</label><span style="color: red !important; ">*</span> </td>
  
        <!--<td> <div class="dropdown" id="country" name="country" Please choose country  >-->
         <td> <select>
             <option>Please select a country   </option>
             <option >India</option>
             <option>United States</option>
             <option>United Kingdom</option>
             <option>Australia</option>
             <option>Europe</option>
             <option>Japan</option>
             </select>
             <td><label id ="msg8" hidden style ="color:red">Required</label></td>
             </td>
           
           
       </tr>
            <tr>
              <td>Zip Code</td>
              <td><input type="number" id="num" name="num" Required></td>
               <td><label id ="msg6" hidden style ="color:red">Required and Must  be  numeric only</label></td>
      </tr>
           <tr>
             <td>Email</td>
             <td><input type="email" id="mail" name="mail" Required></td>
             <td><label id ="msg5" hidden style ="color:red">Required and Must  be  a Valid Mail</label></td>
         
      </tr>
           <tr>
               <td><label>Sex :</label></td>
               <td > <input type="radio" name="male">Male
                <input type="radio" name="male">Female</td>
                 
       </tr>
          <tr> <td>  
          
           <div style="visibility:hidden; color:red; " id="chk_option_error">
                      Please select at least one language.
                 </div>
                
                 <div>
              <label>Language :</label>
            <td> <input type="checkbox" name="langs[]" id="langs_javascript" value="english" align="right"> 
             <label >English</label>
             <input type="checkbox" name="langs[]" id="langs_javascript" value="non english" > 
             <label>Non English</label></td>
         </div>
              <!--<td><label>Language :</label></td>
               <td> 
               <input name="test[]" type ="checkbox" required>English
               <input name="text[]" type ="checkbox">Non English-->
               </td>
        </tr>
          
     
             <tr>
                <td>About</td>
               <td><textarea id ="txt" name ="txt" ></textarea></td>
               <td><label id ="msg7" hidden style ="color:red">Optional</label></td>
      </tr>
          
            <tr>
               <td><input type ="submit" value ="Submit" onclick="validate()" name="formSubmit"></td>
              <td></td>
   </tr>
 
 </table>
 </form>

</body>
</html>