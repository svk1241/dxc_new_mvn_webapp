<%@page import ="java.util.ArrayList,com.dxc.spwebmvcdemo.bean.Member" isELIgnored="false"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
   Member m = (Member)request.getAttribute("memberObj");
   if(m==null) m = new Member();
  // ArrayList<Member> mlist = (ArrayList<Member>)request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action ="memberCrud" method=post>
        <table align = center width=50% bgcolor=blue>
        <tr>
           <th>Member Id</th>
           <td><input type = text name = memberId value="${member.memberId}"></td>
           </tr>
           <tr>
           <th>Member Name</th>
           <td><input type = text name =name value="${member.name}" > </td>
           </tr>
           <tr>
           <th>AadharNo</th>
           <td><input type = text name =aadharNo  value ="${member.aadharNo}" ></td>
           </tr>
           <tr>
           <th>Mobile No</th>
           <td><input type = text name = phone value ="${member.phone}"></td>
           </tr>
           <tr>
           <th>Email Id</th>
           <td><input type =text name=emailId value= "${member.emailId}"></td>
           </tr>
           <tr>
              <td><input type = submit value = Add name ="memberbutton"></td>
              <td><input type = submit value = Modify name="memberbutton"></td>
              <td><input type = submit value =Delete name="memberbutton"></td>
              <td><input type = submit value =Show name="memberbutton"></td>
              </tr>
         </table>
         <hr>
           <input type =submit value ="ShowAll" name ="memberbutton">
           <table align = center border =1>
              <tr>
                <th>Member Id</th>
                <th>Member Name</th>
                <th>AadharNo</th>
                <th>Mobile No</th>
                <th>Email Id</th>
                </tr>
               
                   <c:forEach var ="m" items="${memberList}">
                   <tr>
                     <td>${m.memberId }</td>
                     <td>${m.name }</td>
                     <td>${m.aadharNo }</td>
                     <td>${m.phone }</td>
                     <td>${m.emailId }</td>
                     </tr>
                     </c:forEach>
                    
                     
                
           </table>
    </form>

</body>
</html>