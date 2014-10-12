import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex35 extends HttpServlet
 {
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");
    String val = request.getParameter("data");

    out.println("<html><head><title>Ex35</title></head><body>");
    out.println("This is the Sub Page of Ex35" + "<br>");
    out.println("" + "<br>");
    out.println("Data : " + val + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }