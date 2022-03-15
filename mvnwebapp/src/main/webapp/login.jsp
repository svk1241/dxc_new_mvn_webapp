<!DOCTYPE html>
<html>
<head>
    <script type ="text/javascript">
       function submitLoginForm()
    {
    	
    	var requestObj = new XMLHttpRequest();
    	var txt1 = document.forms[0].uid.value;
    	var txt2 = document.forms[0].pwd.value;
    	requestObj.onreadystatechange = function()
    	{
    		if(requestObj.readyState==4 && requestObj.status==200)
    			document.getElemenetById("message").innerHTML=requestObj.responseText;
    	}
    	//requestObj.open ("GET","AS?uid="+txt1+"&pwd="+txt2,true);
    	requestObj.open("POST","AS",true);
    	requestObj.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    	requestObj.send("uid="+txt1+"&pwd="+txt2)
    	//requestObj.send();
    }
    </script>
</head>
  <body  onload = "javascript:document.forms[0].uid.focus()">
  <h1 style ="text-align:center"><%=new java.util.Date() %></h1>
  <video controls width =300px height = 300px>
    <source src ="sabkadaaman.mp4"  type ="video/mp4"/>
  </video>
   <form action ="AS" > 
       <table  width = 50%   align = center bgcolor=blue>
      <tr>
        <th>Username</th>
        <td><input type = text name ="uid" required placeholder=Username></td>
        <td><label id = "message"></label></td>
          </tr>
          <tr>
             <th>Password</th>
          <td><input type =password name ="pwd" required placeholder=Password></td>
       </tr>
       <tr>
          <td> <input type =button value = Login onclick ="submitLoginForm()"></td>
          <td> <input type =reset value = Clear></td>
          </tr>
          
       </table>
   </form>

</body>
</html>