import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex57_2 extends HttpServlet
 {
  public synchronized void doPost(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");

    HttpSession session = request.getSession();

    out.println("<html><head><title>Ex57_2</title></head><body>");
    out.println("This is the Sub Page of Ex57_2" + "<br>");
    out.println("" + "<br>");

    out.println("sessionAttribute : " + session.getAttribute("testName") + "<br>");

    out.println("</body></html>");
    out.close();
   }
 }