import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex06 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex06</title></head><body>");
    out.println("測試 (false & true) 為：" + (false & true) + "<br>");
    out.println("測試 (true | false) 為：" + (true | false) + "<br>");
    out.println("測試 (!true) 為：" + (!true) + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }