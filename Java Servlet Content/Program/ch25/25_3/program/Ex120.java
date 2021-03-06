import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ex120 extends HttpServlet
  {
   private Connection con = null;
   public void init(ServletConfig config)  throws ServletException
     {
       try
         {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con = DriverManager.getConnection("jdbc:odbc:Bank120"); 
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

       String numberStr=req.getParameter("Number");
       String amountStr=req.getParameter("Amount");
       String sql1 = "UPDATE Deposit " +
                           " SET balance=balance - " + amountStr  +
                           " WHERE account_number= " + numberStr + ";";

       String sql2 = "SELECT balance " +
                               "FROM Deposit " +
                               "WHERE account_number = " + numberStr + ";";

        out.println("<HTML><HEAD><TITLE>Ex120</TITLE></HEAD>");
        out.println("<BODY>");
        SqlTransaction result = new SqlTransaction(con, sql1, sql2);
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