import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ex116 extends HttpServlet
  {
   private Connection con = null;
   public void init(ServletConfig config)  throws ServletException
     {
       try
         {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con = DriverManager.getConnection("jdbc:odbc:Bank116"); 
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

       String outnumberStr=req.getParameter("OutNumber");
       String innumberStr=req.getParameter("InNumber");
       String amountStr=req.getParameter("Amount");

       String sql = "UPDATE Deposit " +
                           " SET tran_out= " + outnumberStr + "," +
                                  " tran_in= " + innumberStr + "," +
                                  " tran_amount= " + amountStr +
                           " WHERE account_number=000 " + ";";

        out.println("<HTML><HEAD><TITLE>Ex116</TITLE></HEAD>");
        out.println("<BODY>");
        SqlTransaction result = new SqlTransaction(con, sql);
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