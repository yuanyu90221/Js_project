import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ex63_write extends HttpServlet
 {
  private Connection con = null;
  public void init(ServletConfig config) throws ServletException
    {
      try
         {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con = DriverManager.getConnection("jdbc:odbc:BookStore");
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

     String sql="INSERT INTO Books(編號,書名," +
                "作者,書價) VALUES (" +
                numberStr + "," + nameStr + "," +
                authorStr + "," + priceStr + ")" ;

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