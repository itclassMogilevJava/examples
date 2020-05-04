<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList, javax.servlet.ServletContext" %>
<!DOCTYPE html>
<html>

<body>
 <div align="center">
  <h1>
   Dear <%=request.getSession().getAttribute("name")%>, your order:
  </h1>
  <ul>
   <%
       ArrayList<String> goods = (ArrayList<String>) request.getSession().getAttribute("goods");
        int total = 0;
        for (String good : goods){
              out.println("<li>" + good + "</li>");
                  total += Double.parseDouble(good.substring(good.lastIndexOf('(') + 1,
                                        good.lastIndexOf('$')).trim());
          }
          out.println("<li> Total summ: " + total + "</li>");
   %>


  </ul>

 </div>
</body>
</html>
