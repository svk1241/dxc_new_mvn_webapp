<!DOCTYPE html>
<html>
<head>
 <script type="text/javascript">
    function crudMember(buttonValue)
    {
    	var t1 = document.forms[0].memberId.value;
    	var t2 = document.forms[0].memname.value;
    	var t3 = document.forms[0].adhno.value;
    	var t4 = document.forms[0].mobile.value;
    	var t5 = document.forms[0].emailId.value;
    	var requestObj  =  new XMLHttpRequest();
    	requestObj.onreadystatechange=function()
    	{
    	    if(requestObj.readyState==4 && requestObj.status==200)
    	    {
    	         if(buttonValue=="Show")
    	         {
    	        	var jsonObj = JSON.parse(requestObj.responseText);
    	        	document.forms[0].memberId.value=jsonObj.memberId;
    	        	document.forms[0].memname.value=jsonObj.name;
    	        	document.forms[0].adhno.value=jsonObj.aadahar;
    	        	document.forms[0].mobile.value=jsonObj.phone;
    	        	document.forms[0].emailId.value=jsonObj.emailId;
    	        	//alert(jsonObj,memberName);
    	         }
    	         else
    	    	    document.getElementById("message").innerHTML=requestObj.responseText;
    	    }
    	}
    	requestObj.open("POST","MemberMgmtAjaxServlet",true);
    	requestObj.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    	requestObj.send("memberId="+t1+"&memname="+t2+"&adhno="+t3+"&mobile="+t4+"&emailId="+t5+"&memberbutton="+buttonValue);
    }
    function getAllMembers()
    {
    	var tb1 = document.getElementById("membersTable");
    	var requestObj = new XMLHttpRequest();
    	requestObj.onreadyststechange = function()
    	{
    		if(requestObj.readyState==4 && requestObj.status==200)
    			{
    			    var memberXml = new DOMParser().parseFromString(requestObj.responseText, "text/xml");
    			    var memberObj = memberXml.getElementsByTagName("Member");
    			    for(var i=0;i<memberObj.length;i++)
    			    {
    			    	var row = tb1.insertRow(i+1);
    			    	for(var j=0;j<memberObj[i].childNodes.length;j++)
    			    		{
    			    		   var cell = row.insertCell(j);
    			    		   cell.innerHTML = memberObj[i].childNodes[j].childNodes[0].nodeValue;
    			    		}
    			    	//var x= x+ memberObj[i].childNodes[1].nodeValue+"";
    			    }
    			    
    			}
    	}
    		requestObj.open("POST","MemberMgmtAjaxServlet",true);
    		requestObj.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    		requestObj.send("memberbutton=ShowAll");
    	
    }
 </script>
</head>
<body>
  <form>
     <table align=center width=50% bgcolor=blue>
      <tr>
        <th>Member Id</th>
        <td><input type=text name=memberId value=0></td>
      <td><label id="message"></label></td>
      </tr>
      <tr>
        <th>Member Name</th>
        <td><input type=text name=memname value=""></td>
      </tr>
      <tr>
        <th>Aadhar No.</th>
        <td><input type=text name=adhno value=""></td>
      </tr>
      <tr>
        <th>Mobile No.</th>
        <td><input type=text name=mobile value=0></td>
      </tr>
      <tr>
        <th>Email Id</th>
        <td><input type=text name=emailId value=""></td>
      </tr>
     <tr>
        <td><input type=button value=Add    name="memberbutton"  onclick="crudMember(this.value)"></td>
        <td><input type=button value=Modify name="memberbutton"  onclick="crudMember(this.value)"></td>
        <td><input type=button value=Delete name="memberbutton"  onclick="crudMember(this.value)"></td>
        <td><input type=button value=Show   name="memberbutton"  onclick="crudMember(this.value)"></td>
        <td><input type=reset  value=Clear></td>
      </tr>
     </table>
     <hr>
     <input type=button value="ShowAll"  name="memberbutton" onclick="getAllMembers()">
     <table align=center border=1  id ="memberTable">
       <tr>
        <th>Member Id</th>
        <th>Member Name</th>
        <th>Aadhar No</th>
        <th>Mobile No</th>
        <th>Email Id</th>
       </tr>
     </table>
  </form>
</body>
</html>