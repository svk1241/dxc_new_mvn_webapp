<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"   prefix="form" %>
<!DOCTYPE html>
<html>
<body>
   <form:form action="studentCrud">
       <table>
          <tr>
            <td><form:label path ="srNo">Student Roll No</form:label></td>
            <td><form:input path ="srNo"/></td>
            </tr>
            <tr>
               <td><form:label path ="name">Name</form:label></td>
            <td><form:input path ="name"/></td>
            </tr>
            <tr>
               <td><form:label path ="age">Age</form:label></td>
            <td><form:input path ="age"/></td>
            </tr>
            <tr>
               <td><form:label path ="address">Address</form:label></td>
            <td><form:input path ="address"/></td>
            </tr>
             <tr>
               <td><form:label path ="phone">Phone No</form:label></td>
            <td><form:input path ="phone"/></td>
            </tr>
            
               <tr>
                  <td><input type =submit value =Add name="studentSubmit"></td>
                  <td><input type =submit value =Show name="studentSubmit"></td>
                  </tr>
            
           
           <!-- <tr>
               <td><button type=submit>Submit</button></td>
               <td><button type=reset>Cancel</button></td>
            </tr>-->
       </table>
   </form:form>
</body>
</html>