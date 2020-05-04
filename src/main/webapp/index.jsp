<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
 <div align="center">
  <h1>Welcome to online shop</h1>
  <br></br>
  <form action="/login" method="post">
   <input type="text" name="name" required placeholder="Enter your name">
   <br>
     <input type="checkbox" name="terms">I have read terms!
   <br></br>
   <button type="submit">Enter</button>
  </form>
   <%
                  Boolean loginFailed = (Boolean) request.getAttribute("loginFailed");
                  if (loginFailed != null && loginFailed) {
                      out.println("<h1 style='color:red'>TAKOGO USERA NE SUSHESTVUET!</h1>");
                  }
             %>
 </div>
</body>
</html>