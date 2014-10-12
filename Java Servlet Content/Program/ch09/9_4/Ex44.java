import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex44 extends HttpServlet
 {
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");

    String val_fil = request.getParameter("fil");
    String val_filedata = request.getParameter("filedata");
    BufferedWriter fout = new BufferedWriter(new FileWriter(val_fil));

    out.println("<html><head><title>Ex44</title></head><body>");
    out.println("This is the Sub Page of Ex44" + "<br>");
    out.println("" + "<br>");

    fout.write(val_filedata);
    fout.newLine();
    fout.close();

    out.println("已成功將資料寫入檔案");
    out.println("</body></html>");
    out.close();
   }
 }