import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex47 extends HttpServlet
 {
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");

    String val = request.getParameter("fil");
    File f = new File(val);

    out.println("<html><head><title>Ex47</title></head><body>");
    out.println("This is the Sub Page of Ex47" + "<br>");
    out.println("" + "<br>");

    if (f.delete())
        out.println("成功刪除目錄 : " + val +"<br>");
    else
        out.println("刪除目錄失敗" + "<br>");

    out.println("</body></html>");
    out.close();
   }
 }