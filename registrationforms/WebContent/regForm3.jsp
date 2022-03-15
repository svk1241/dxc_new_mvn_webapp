<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <script type = "javascript">
      
      function setFocus()
      {
    	  document.getElementById("name").focus();
    	  document.getElementById("email").focus();
    	  document.getElementById("website").focus();
    	  document.getElementById("message").focus();
    	  
    	 
      }
      function fName()
      {
    	  var txt = document.getElementById("name").value;
    	  if(txt.length==0)
    		  {
    		  document.getElementById("msg1").hidden = false;
    		  document.getElementById("name").focus();
    		  }
    	  else 
    		  document.getElementById("msg1").hidden=true;
      }
      function eMail()
      {
    	  var txt = document.getElementById("email").value;
    	  if(txt.length==0)
    		  {
    		  document.getElementById("msg2").hidden = false;
    		  document.getElementById("email").focus();
    		  }
    	  else 
    		  document.getElementById("msg2").hidden=true;
      }
      function wSite()
      {
    	  var txt = document.getElementById("website").value;
    	  if(txt.length==0)
    		  {
    		  document.getElementById("msg3").hidden = false;
    		  document.getElementById("website").focus();
    		  }
    	  else 
    		  document.getElementById("msg3").hidden=true;
      }
      function message()
      {
    	  var txt = document.getElementById("message").value;
    	  if (txt.length==0)
    		  {
    		  document.getElementById("msg4").hidden = false;
    		  document.getElementById("message").focus();
    		  }
    	  else 
    		  document.getElementById("msg4").hidden=true;
      }
 </script>
</head>
<form>
<body onload ="setFocus()">
  <table align =center>
     <tr>
        <td>Name</td>
        <td><input type =text id ="name" onblur="fName()"></td>
        <td><label id ="msg1" hidden style="color:red">This filed is required</label>
     </tr>
      <tr>
        <td>Email</td>
         <td><input type =text id ="email" onblur ="eMail()"></td>
          <td><label id ="msg2" hidden style="color:red">This filed is required</label>
     </tr>
      <tr>
        <td>Website</td>
         <td><input type =text id ="website" onblur="wSite()"></td>
          <td><label id ="msg3" hidden style="color:red">This filed is required</label>
     </tr>
      <tr>
        <td>Message</td>
         <td><textarea id ="message" onblur ="message()"></textarea></td>
          <td><label id ="msg4" hidden style="color:red">This filed is required</label>
     </tr>
     <tr>
       <td> <input type = submit value ="Submit" onclick="validate()"></td>
     </tr>
  </table>

</body>
</form>
</html>