import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex17 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    int a, b, c, d, e, f, g;

    a=4; a = a>>1;
    b=-4; b = b>>1;
    c=4; c = c<<1;
    d=-4; d = d<<1;
    e=4; e = e>>>1;
    f=-4; f = f>>>1;
    g=4; g = g>>33;

    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex17</title></head><body>");
    out.println("4>>1 = " + a + "<br>");
    out.println("-4>>1 = " + b + "<br>");
    out.println("4<<1 = " + c + "<br>");
    out.println("-4<<1 = " + d + "<br>");
    out.println("4>>>1 = " + e + "<br>");
    out.println("-4>>>1 = " + f + "<br>");
    out.println("4>>33 = " + g + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }