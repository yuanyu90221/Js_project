import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex03 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    int x, y, z;

    x = 15;
    y = 'A';
    z = 2+3;  
    
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex03</title></head><body>");
    out.println("���w�ƭ�   x = " + x + "<br>");
    out.println("���w�r���� y = " + y + "<br>");
    out.println("���w�p��� x = " + z + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }