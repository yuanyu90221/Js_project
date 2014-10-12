import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex26 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    int a=1;

    do
      {
       a++;
      } while(a<=3);

    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex26</title></head><body>");
    out.println("a = " + a + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }