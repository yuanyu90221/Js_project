import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex21 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    int a, b, x, y, z;

    a=9; b=10;

    x = a&b;
    y = a|b;
    z = a^b;

    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex21</title></head><body>");
    out.println("9 & 10 = " + x + "<br>");
    out.println("9 | 10 = " + y + "<br>");
    out.println("9 ^ 10 = " + z + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }