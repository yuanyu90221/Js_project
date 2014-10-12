import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ex66_select extends HttpServlet
  {
   private Connection con = null;
   public void init(ServletConfig config)  throws ServletException
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

       String startnumStr=req.getParameter("StartNum");
       String finishnumStr=req.getParameter("FinishNum");
       String sql="SELECT * FROM JavaBooks WHERE ½s¸¹>='" +
               startnumStr + "' AND ½s¸¹<='" +  finishnumStr + "';";
    
        out.println("<HTML><HEAD><TITLE>Locate</TITLE></HEAD>");
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