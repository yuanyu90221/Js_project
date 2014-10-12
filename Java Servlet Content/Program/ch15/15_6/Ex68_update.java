import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ex68_update extends HttpServlet
 {
  private Connection con = null;
  public void init(ServletConfig config) throws ServletException
    {
      try
         {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con = DriverManager.getConnection("jdbc:odbc:Bookch15");
          }
       catch(Exception e){}
      }

  public synchronized void doGet(HttpServletRequest req,
                                                       HttpServletResponse res)
               throws ServletException, IOException
    {
     ServletOutputStream sos=res.getOutputStream();
     res.setContentType("text/html;charset=big5");
     PrintWriter out = new PrintWriter(sos, true);
     req.setCharacterEncoding("big5");

     String numberStr = req.getParameter("Number");
     String nameStr = req.getParameter("Name");
     String authorStr = req.getParameter("Author");
     String priceStr = req.getParameter("Price");

      String sql="UPDATE JavaBooks SET " +
                       "編號='" + numberStr +
                       "', 書名='" + nameStr +
                       "', 作者='" + authorStr +
                       "', 書價=" + priceStr +
                       " WHERE 編號='" + numberStr + "';" ;

     out.println("<HTML><HEAD><TITLE>Books update</TITLE></HEAD>");
     out.println("<BODY>");
     SqlResult result = new SqlResult(con, sql);
     out.println(result);
     out.println("</BODY></HTML>");
     }

  public void destroy()
    {
     try { if (con != null) con.close(); }
     catch (SQLException ignored) { }
    }

  public synchronized void doPost(HttpServletRequest req,
                     HttpServletResponse res)
  throws ServletException, IOException
    {
     doGet(req, res);
    }
  }