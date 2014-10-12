import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ex68_selectpage extends HttpServlet
  {
  public synchronized void doGet(HttpServletRequest req,
                                                       HttpServletResponse res)
           throws ServletException, IOException
    {
      String numberStr=req.getParameter("Number");
      String sql="SELECT *  FROM JavaBooks WHERE �s��='" +
                          numberStr + "';" ;
 
      Connection con = null;
      Statement statement = null;
      ResultSet rs = null;
      res.setContentType("text/html");
      ServletOutputStream sos=res.getOutputStream();
      PrintWriter out=new PrintWriter(sos,true);
      try
        {
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          con = DriverManager.getConnection("jdbc:odbc:Bookch15");
          statement = con.createStatement();
          rs = statement.executeQuery(sql);
          ResultSetMetaData rsmd = rs.getMetaData();
          int colCount = rsmd.getColumnCount();
  
          out.println("<HTML>");
          out.println("<HEAD><TITLE>Books</TITLE></HEAD>");
          out.println("<BODY>");
          rs.next();
          out.println("<FORM ACTION=Ex68_update " +
                             "METHOD=post>");
          out.println("�s���G<INPUT TYPE=text NAME=Number " +
                             "VALUE=" + numberStr + "><BR>");
          out.println("�ѦW�G<INPUT TYPE=text NAME=Name " +
                             "VALUE=" + rs.getString("�ѦW") + "><BR>");
          out.println("�@�̡G<INPUT TYPE=text NAME=Author " +
                             "VALUE=" + rs.getString("�@��") + "><BR>");
          out.println("�ѻ��G<INPUT TYPE=text NAME=Price " +
                             "VALUE=" + rs.getString("�ѻ�") + "> <BR>");
          out.println("<INPUT TYPE=submit VALUE=\"���e\">");
          out.println("<INPUT TYPE=reset VALUE=\"����\">");
          out.println("</BODY></HTML>");
         }
      catch(Exception e){}
      finally
      {
        try
          {
            if (con != null) con.close();
           }
        catch (SQLException ignored) { }
        }
    }
  public synchronized void doPost(HttpServletRequest req,
                                                        HttpServletResponse res)
         throws ServletException, IOException
     {
       doGet(req, res);
      }
  }

