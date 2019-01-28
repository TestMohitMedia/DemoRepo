package MavenTest.com.MavenProject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection 
{
	//Set password
	// msqladmin.exe -u root password New Password;
	String url="jdbc:mysql://localhost:3306/";
	String driver="com.mysql.jdbc.Driver";
	String dbName="mysql";
	String userName="root";
	String password="";
	Connection conn;
	Statement st=null;
	ResultSet rs;
	
	public void connection() throws SQLException
	{
	   try {
		Class.forName(driver).newInstance(); //Create the object of driver class.
		conn=DriverManager.getConnection(url+dbName,userName,password);
		st=conn.createStatement();
		rs=st.executeQuery("select * from employee");
		while(rs.next())
		{
			System.out.println(rs.getString("Name")+" : "+rs.getInt("Age"));
		}
//-----------------------Prepared Statement Interface---------------------------------------------------------------
		PreparedStatement pt=conn.prepareStatement("select * from employee where name=? and age=? ");
		pt.setString(1,"John");
		pt.setInt(2, 310);
		rs=pt.executeQuery();
		System.out.println("-----------------------Prepared Statement Interface-----------------------------------------");
		while(rs.next())
		{
			System.out.println(rs.getString("Name")+" : "+rs.getInt("Age"));
		}
	  }
	   catch(Exception e)
	   {
		   e.getMessage();
	   }
//----------------STORED PROCEDURES-------CALLABLES Statement Interface---------------------------------------------------------------
	/*CallableStatement cstmt=conn.prepareCall("{call getTestData(?,?,?,?)}");
	   cstmt.registerOutParameter(1,java.sql.Types.INTEGER);
	   cstmt.setString(2,"Test");
	   cstmt.setString(3,"Test");
	   cstmt.setString(4,"Test");
	   cstmt.executeQuery();
	   Integer i=cstmt.getInt(1);
	   } catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if((conn!=null) && (!conn.isClosed()))
				conn.close();
		    
	}*/
	   
		
	}
	public static void main(String agrs[]) throws SQLException
	{
		DBConnection dbconn=new DBConnection();
		dbconn.connection();
	}

}
