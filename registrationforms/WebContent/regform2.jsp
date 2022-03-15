
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 
 <script lang ="javascript">
 function setFocus()
 {
	 document.getElementById("empNo").focus();
	 
 }
 
 	function validate()
 {
       var empNo;
       var empName;
       empNo = document.forms[0].empNo.value;
      empName = document.getElementById("empName").value;
      console.log("empNo:::"+empNo);
     console.log("empName:::"+empName);
 
     if(empNo == "")
      {
         alert("please enter the employee no");
    	 document.getElementById("empNo").focus();
    	 return false;
      }
     if(empName == "")
     {
        alert("please enter the employee name");
   	 document.getElementById("empName").focus();
   	 return false;
     }
     return true;
 
 }
 </script>
</head>
<body onload="setFocus()">
  <form action ="#">
     <table align ="center" >
         <tr>
           <td>Employee No</td>
           <td><input type ="text" id="empNo" name="empNo"></td>
           </tr>
           <tr>
           <td>Employeee Name</td>
            <td><input type ="text" id ="empName" name="empName"></td>
           </tr>
           <tr>
              <td><input type="submit" value ="Submit" onclick="validate()"></td>
              <td><input type="reset" value ="Cancel"></td>
           </tr>
     </table>
  </form>
</body>
</html>