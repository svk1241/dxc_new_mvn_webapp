
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 
 <script lang ="javascript">
 function setFocus()
 {
	   document.getElementById("nme").focus();
	 
 }
 
 	function validate()
 {
       var sname;
       var email;
       var web;
       var message;
       <!--name = document.forms[0].sname.value;-->
       sname = document.getElementById("nme").value;
      email = document.getElementById("emailId").value;
      web = document.getElementById("wSite").value;
      message = document.getElementById("msg").value;
      console.log("sanme:::"+sname);
      console.log("email:::"+email);
      console.log("web:::"+web);
      console.log("messagee:::"+message);
 
     if(sname.length == 0)
      {
    	 document.getElementById("msg1").hidden=false;
    	 document.getElementById("nme").focus();
      }
     else
    	 document.getElementById("msg1").hidden=true;
        <!-- alert("please enter the  name");-->
    if(email.length == 0)
     {
    	 document.getElementById("msg2").hidden=false;
    	 document.getElementById("emailId").focus();
     }
     else
    	 document.getElementById("msg2").hidden=true;
        
   	 
   	 <!-- alert("please enter the email");-->
   	 if(web.length == 0)
     {
    	 document.getElementById("msg3").hidden=false;
    	 document.getElementById("wSite").focus();
     }
     else
    	 document.getElementById("msg3").hidden=true;
   	 
   	if(message.length == 0)
    {
  	 document.getElementById("msg4").hidden=false;
  	 document.getElementById("msg").focus();
    }
   else
  	 document.getElementById("msg4").hidden=true;
     
     
 
 }
 </script>
</head>
<body onload="setFocus()">
  <form action ="FormServlet">
     <table align ="center" >
         <tr>
              <td>Name</td>
               <td><input type ="text" id="nme" name="name" Required ></td>
                <td><label id ="msg1" hidden style="color:red">The Field Is Required</label></td>
           </tr>
           <tr>
               <td>Email</td>
              <td><input type="email" id ="emailId" name="email" Required ></td>
               <td><label id ="msg2" hidden style="color:red">Valid Email Address is required</label></td>
           </tr>
           <tr>
              <td>Website</td>
              <td><input type="url" id ="wSite" name="website" Required></td>
               <td><label id ="msg3" hidden style="color:red">Valid Url  is required</label></td>
           </tr>
           <tr>
               <td>Message</td>
               <td><textarea  id="msg" name="message" Required></textarea></td>
                <td><label id ="msg4" hidden style="color:red">The Field Is Required</label></td>
           </tr>
           <tr>
              <td><input type="submit" value ="Submit" onclick="validate()" name="formSubmit" ></td>
              <td><input type="reset" value ="Cancel"></td>
           </tr>
     </table>
  </form>
</body>
</html>