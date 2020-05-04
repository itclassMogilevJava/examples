<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList,com.itclass.model.Good" %>
<!DOCTYPE html>
<html>
 <body>
  <div align="center">
      <form action="/order" method="post">
           <h1>Hello <%= request.getSession().getAttribute("name")%>!</h1>
           <label>Make your order</label>
           <%
                ArrayList<String> addedGoods = (ArrayList<String>) request.getSession().getAttribute("goods");
                if (addedGoods != null) {
                    out.println("<p>You have already chosen:</p>");
                    out.println("<ul>");
                    for (String good : addedGoods) {
                               out.println("<li>" + good + "</li>");
                    }
                    out.println("</ul>");
                }
           %>
           <br></br>
           <select name="good">
            <%
                ServletContext sc = request.getServletContext();
                ArrayList<Good> goods = (ArrayList<Good>)sc.getAttribute("goods");
                for(int i=0; i<goods.size(); i++){
                    out.println("<option>" + goods.get(i).getTitle() + " (" + goods.get(i).getPrice() + "$)</option>");
                }
            %>
           </select>
           <br></br>
           <button type="submit">Add item</button>
           <button type="submit" formaction="/resultPage.jsp">Submit</button>
      </form>
  </div>

 </body>
</html>
