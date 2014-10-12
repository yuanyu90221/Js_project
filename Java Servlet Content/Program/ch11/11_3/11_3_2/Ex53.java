import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class Ex53 extends HttpServlet
 {
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    String cokData=null;

    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");

    Cookie[] cok = request.getCookies();

    out.println("<html><head><title>Ex53</title></head><body>");
    out.println("This is the Sub Page of Ex53" + "<br>");
    out.println("" + "<br>");

    out.println("讀取Cookie : " + "<br>");
    for(int i=0; i<cok.length; i++)
       {
         if(cok[i].getName().equals("msg"))
           {
             cokData = cok[i].getValue();
             out.println(cokData);
             }
          else
          out.println("無Cookie共享資料");
          }

    out.println("</body></html>");
    out.close();
   }
 }