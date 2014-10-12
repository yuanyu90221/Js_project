import java.sql.*;
public class SqlTransaction
  {
   private Connection con;
   private String sql1, sql2, sql3, sql4, sql5;
   public SqlTransaction(Connection con, String sql1,  String sql2, 
                                        String sql3, String sql4,  String sql5)
     {
      this.con = con;
      this.sql1 = sql1;    this.sql2 = sql2;
      this.sql3 = sql3;    this.sql4 = sql4;
      this.sql5 = sql5;
     }
    public String toString()
    {
      boolean flag = false;
      StringBuffer sb = new StringBuffer();
      try
        {
          Statement statement = con.createStatement();
          con.setAutoCommit(false);
          statement.execute(sql1);    statement.execute(sql2);
          statement.execute(sql3);    statement.execute(sql4);
          statement.execute(sql5);
          con.commit();
          con.setAutoCommit(true);
          sb.append("Transaction works successfully!!");

        }
      catch (SQLException e)
       {
         sb.append("</TABLE><H1>SQL Exception Error:</H1> " +
                            e.getMessage());
        }
      return sb.toString();
    }
  }
