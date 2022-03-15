<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"   prefix="form" %>
<!DOCTYPE html>
<html>
<body>
   <form:form action="showPerson">
       <table>
          <tr>
            <td><form:label path ="ssn">SSN</form:label></td>
            <td><form:input path ="ssn"/></td>
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
               <td><form:label path ="gender">Gender</form:label></td>
            <td>Male<form:radiobutton path ="gender" value ="M"/>
               Female<form:radiobutton path ="gender" value="F"/></td>
                 
            </tr>
            <tr>
            <td><form:label path ="education">Education</form:label></td>
              <td>
                 BTech<form:checkbox path="education" value="Btech"/>
                  MTech<form:checkbox path="education" value="Mtech"/>
                   MBA<form:checkbox path="education" value="MBA"/>
                    MCA<form:checkbox path="education" value="MCA"/>
                    </td>
            </tr>
               <tr>
                  <td><input type =submit value =Add name="personbutton"></td>
                  <td><input type =submit value =Modify name="personbutton"></td>
                  <td><input type =submit value =Delete name="personbutton"></td>
                  <td><input type =submit value =Show name="personbutton"></td>
                  </tr>
            
           
            <tr>
               <td><button type=submit>Submit</button></td>
               <td><button type=reset>Cancel</button></td>
            </tr>
       </table>
   </form:form>
</body>
</html>