<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <script type="text/javascript">
  function validate()
  {
	  
  }
  </script>
</head>
<body>
  <form action> 
     <table>
        <tr>
           <td>Name</td>
           <td><input type ="text" name="name" Required></td>
           
        </tr>
         <tr>
           <td>Email</td>
           <td><input type="email" name ="email"></td>
           
        </tr>
         <tr>
           <td>Website</td>
           <td><input type = "text" name ="website" ></textarea></td>
           
        </tr>
         <tr>
           <td>Message</td>
           <td><textarea name="message"></textarea Required></td>
           
        </tr>
        <tr>
           <td><input type = "submit" value = "Submit" onclick="validate()"></td>
        </tr>
     </table>
  </form>

</body>
</html>