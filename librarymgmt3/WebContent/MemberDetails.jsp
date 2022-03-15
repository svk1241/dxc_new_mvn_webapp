<%@page import ="java.util.ArrayList,dxc.web.lib2.bean.Member" %>
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
    <form action ="MemberMgmtServlet" method=post>
        <table align = center width=50% bgcolor=blue>
        <tr>
           <th>Member Id</th>
           <td><input type = text name = memberId value=<%=m.getMemberId()%> ></td>
           </tr>
           <tr>
           <th>Member Name</th>
           <td><input type = text name =memname value=<%=m.getName() %> > </td>
           </tr>
           <tr>
           <th>Aahhar No</th>
           <td><input type = text name =adhno  value =<%=m.getAadaharNo() %> ></td>
           </tr>
           <tr>
           <th>Email Id</th>
           <td><input type =text name=emailId value= <%=m.getEmailId() %>  ></td>
           </tr>
           <tr>
           <th>Mobile No</th>
           <td><input type = text name = mobile value =<%=m.getPhone() %> ></td>
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
                <th>Aadhar No</th>
                <th>Mobile No</th>
                <th>Email Id</th>
                </tr>
               
                   <c:forEach var ="m" items="${memberList}">
                   <tr>
                     <td>${m.memberId }</td>
                     <td>${m.name }</td>
                     <td>${m.aadaharNo }</td>
                     <td>${m.phone }</td>
                     <td>${m.emailId }</td>
                     </tr>
                     </c:forEach>
                    
                     
                
           </table>
    </form>

</body>
</html>