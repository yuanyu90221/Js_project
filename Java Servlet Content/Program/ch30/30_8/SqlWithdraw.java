import java.sql.*;
public class SqlWithdraw
  {
   private Connection con;
   private String sql1, sql2;
   public SqlWithdraw(Connection con, String sql1, String sql2)
     {
      this.con = con;
      this.sql1 = sql1;
      this.sql2 = sql2;
     }
    public String toString()
    {
     int val, flag =0;
      StringBuffer sb = new StringBuffer();
      try
        {
          Statement statement = con.createStatement();
          con.setAutoCommit(false);

          statement.execute(sql1);

          ResultSet rs = statement.executeQuery(sql2);
          while(rs.next()) {
                val = rs.getInt("æl√B");
                if(val < 0) flag =1;
             }
          if(flag == 1) {
                sb.append("Balance is not enough and Rollbak!! ");
                con.rollback();
             }
          else
              sb.append("Transaction works successfully!!");

          con.commit();
          con.setAutoCommit(true);
        }
      catch (SQLException e)
       {
         sb.append("</TABLE><H1>SQL Exception Error:</H1> " +
                            e.getMessage());
        }
      return sb.toString();
    }
  }
