import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class M_Authority extends HttpServlet
 {
   private Connection con = null;
   public void init(ServletConfig config)  throws ServletException
     {
       try
         {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con = DriverManager.getConnection("jdbc:odbc:Exam"); 
         }
       catch(Exception e){}
      }

  public synchronized void doGet(HttpServletRequest req,
                                                        HttpServletResponse res)
        throws ServletException, IOException
   {

    res.setContentType("text/html;charset=big5");
    ServletOutputStream sos=res.getOutputStream();
    PrintWriter out=new PrintWriter(sos,true);
    req.setCharacterEncoding("big5");

    String userStr = req.getParameter("user");
    String pwdStr = req.getParameter("pwd");

    String sql="SELECT * FROM Managers WHERE �m�W='" +
               userStr + "'AND �K�X='" + pwdStr +"';" ;

    HttpSession session = req.getSession();
    session.setAttribute("M_Authroity", "true");

    try
      {
       Statement statement = con.createStatement();
       ResultSet rs = statement.executeQuery(sql);
       boolean flag = false;
 
       while(rs.next())  flag = true;
       if (flag)
          {
           out.println("�޲z���{�Ҧ��\!!");
           out.println(userStr + "  �w����{���t��");
           out.println("<p></P>");
          }
       else
          res.sendRedirect("http://163.15.40.242:8080/examples/ManagerOpt.html");
      }
    catch (SQLException e)
      {
        e.getMessage();
      }    

     out.println("<html><head><title>M_Authority</title></head><body>");
    
     out.print("<li><p><a href = ");
     out.print("http://163.15.40.242:8080/examples/InsertStudent.html");
     out.print(">��J�ҥͰ򥻸��</a></p></li>");

     out.print("<li><p><a href = ");
     out.print("http://163.15.40.242:8080/examples/InsertScore.html");
     out.print(">��J�ҥͦ��Z���</a></p></li>");

     out.println("</body></html>");
     out.close();
   }

  public void destroy()
    {
    try
      {
       if (con != null) con.close();
      }
    catch (SQLException ignored) { }
    }
 
  public synchronized void doPost(HttpServletRequest req,
                                  HttpServletResponse res)
         throws ServletException, IOException
    {
    doGet(req, res);
    }
 }