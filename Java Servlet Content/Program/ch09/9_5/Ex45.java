import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex45 extends HttpServlet
 {
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");

    String val_fil = request.getParameter("fil");
    BufferedReader fin = new BufferedReader(new FileReader(val_fil));
    int msg;

    out.println("<html><head><title>Ex45</title></head><body>");
    out.println("This is the Sub Page of Ex45" + "<br>");
    out.println("" + "<br>");

    while ((msg = fin.read()) != -1)
         out.println((char)msg);

    fin.close();
    out.println("</body></html>");
    out.close();
   }
 }