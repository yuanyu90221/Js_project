import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex56_1 extends HttpServlet
 {
  public synchronized void doPost(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");

    HttpSession session = request.getSession();
    session.setAttribute("testName", "English and ¤¤¤å");

    out.println("<html><head><title>Ex56_1</title></head><body>");
    out.println("This is the Sub Page of Ex56_1" + "<br>");
    out.println("" + "<br>");

    out.println("sessionAttribute : " + session.getAttribute("testName") + "<br>");

    out.println("<FORM METHOD=\"post\" ACTION=\"Ex56_2\">");
    out.println("<INPUT TYPE=\"submit\" VALUE=\"go to Sub Page\">");


    out.println("</body></html>");
    out.close();
   }
 }