import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex42 extends HttpServlet
 {
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");

    String val = request.getParameter("dir");
    File f = new File(val);

    out.println("<html><head><title>Ex42</title></head><body>");
    out.println("This is the Sub Page of Ex42" + "<br>");
    out.println("" + "<br>");

    if (f.mkdir())
        out.println("成功建立目錄 : " + val +"<br>");
    else
        out.println("建立目錄失敗" + "<br>");

    out.println("</body></html>");
    out.close();
   }
 }