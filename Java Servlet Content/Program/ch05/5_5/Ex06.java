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
    out.println("���� (false & true) ���G" + (false & true) + "<br>");
    out.println("���� (true | false) ���G" + (true | false) + "<br>");
    out.println("���� (!true) ���G" + (!true) + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }