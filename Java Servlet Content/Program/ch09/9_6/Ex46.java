import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex46 extends HttpServlet
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

    out.println("<html><head><title>Ex46</title></head><body>");
    out.println("This is the Sub Page of Ex46" + "<br>");
    out.println("" + "<br>");

    if (f.delete())
        out.println("成功刪除檔案 : " + val +"<br>");
    else
        out.println("刪除檔案失敗" + "<br>");

    out.println("</body></html>");
    out.close();
   }
 }