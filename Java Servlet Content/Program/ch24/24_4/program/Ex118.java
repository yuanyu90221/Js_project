import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ex118 extends HttpServlet
  {
   private Connection con = null;
   public void init(ServletConfig config)  throws ServletException
     {
       try
         {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con = DriverManager.getConnection("jdbc:odbc:Bank118"); 
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

       String sql1 =  "UPDATE Deposit " +
                             " SET tran_out= " + outnumberStr + "," +
                                      " tran_in= " + innumberStr + "," +
                                      " tran_amount= " + amountStr +
                             " WHERE account_number=000 " + ";";

       String sql2 = "UPDATE Deposit " +
                             "SET tran_amount = DLookup('tran_amount', 'Deposit', " +
                                                                                " 'account_number = 000') " +
                             "WHERE account_number = (SELECT tran_out " +
                                                                            "FROM Deposit " +
                                                                            "WHERE account_number = 000) ";

        String sql3 = "UPDATE Deposit " +
                             "SET tran_amount = DLookup('tran_amount', 'Deposit', " +
                                                                              " 'account_number = 000') " +
                             "WHERE account_number = (SELECT tran_in " +
                                                                            "FROM Deposit " +
                                                                            "WHERE account_number = 000) ";

       String sql4 = "UPDATE Deposit " +
                                 "SET balance = balance - tran_amount " +
                                 "WHERE account_number = (SELECT tran_out " +
                                                                                 "FROM Deposit " +
                                                                                 "WHERE account_number = 000) ";

       String sql5 = "UPDATE Deposit " +
                                 "SET balance = balance + tran_amount " +
                                 "WHERE account_number = (SELECT tran_in " +
                                                                                 "FROM Deposit " +
                                                                                 "WHERE account_number = 000) ";


        out.println("<HTML><HEAD><TITLE>Ex118</TITLE></HEAD>");
        out.println("<BODY>");
        SqlTransaction result = new SqlTransaction(con, sql1, sql2, sql3, sql4, sql5);
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