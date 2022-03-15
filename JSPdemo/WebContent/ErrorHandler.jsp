<%@page isErrorPage = "true"  %>
<%= "There is Something wrong with  your input please reenter" %><br>
<%="The Error Details are "+exception.getMessage()%><br>
<a href ="errordemo.html">Back</a>