import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex02 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    int x=2, y=3, z;
    z = x * y;
    
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex02</title></head><body>");
    out.println("x乘以y 之結果為 ： " + z);
    out.println("</body></html>");
    out.close();
   }
 }