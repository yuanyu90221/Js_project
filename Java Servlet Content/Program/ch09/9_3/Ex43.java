import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex43 extends HttpServlet
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

    out.println("<html><head><title>Ex43</title></head><body>");
    out.println("This is the Sub Page of Ex43" + "<br>");
    out.println("" + "<br>");

    if (f.createNewFile())
        out.println("���\�إ߷s�ɮ� : " + val +"<br>");
    else
        out.println("�إ߷s�ɮץ���" + "<br>");

    out.println("</body></html>");
    out.close();
   }
 }