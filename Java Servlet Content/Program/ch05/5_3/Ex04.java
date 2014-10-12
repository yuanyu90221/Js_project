import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex04 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    int a, b, c, d;

    a=b=c=d=10;
    
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex04</title></head><body>");
    out.println("前置遞增 ++a = " + ++a + "<br>");
    out.println("後置遞增 b++ = " + b++ + "<br>");
    out.println("前置遞減 --c = " + --c + "<br>");
    out.println("後置遞減 d-- = " + d-- + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }