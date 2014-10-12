import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex37 extends HttpServlet
 {
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");
    String val = request.getParameter("course");

    out.println("<html><head><title>Ex37</title></head><body>");
    out.println("This is the Sub Page of Ex37" + "<br>");
    out.println("" + "<br>");
    out.println("最喜歡的課目： " + val + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }