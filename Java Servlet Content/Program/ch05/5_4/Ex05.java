import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex05 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    int a, b;

    a=3;
    b=2;
    
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex05</title></head><body>");
    out.println("代刚 (a == b) " + (a==b) + "<br>");
    out.println("代刚 (a != b) " + (a!=b) + "<br>");
    out.println("代刚 (a >  b) " + (a >b) + "<br>");
    out.println("代刚 (a <  b) " + (a <b) + "<br>");
    out.println("代刚 (a >= b) " + (a>=b) + "<br>");
    out.println("代刚 (a <= b) " + (a==b) + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }