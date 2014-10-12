import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex38 extends HttpServlet
 {
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");
    String[] val = request.getParameterValues("course");

    out.println("<html><head><title>Ex38</title></head><body>");
    out.println("This is the Sub Page of Ex38" + "<br>");
    out.println("" + "<br>");

    out.println("喜歡的課目： " + "<br>");
    for(int i=0; i<val.length; i++)
         out.println(val[i] + "<br>");

    out.println("</body></html>");
    out.close();
   }
 }