package school_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData
{
	public static void main(String[] args) 
	{
		Student student=new Student();
		DeleteData.dataDeleting(student);
	}
	public static void dataDeleting(Student student)
	{
		String url="jdbc:mysql://localhost:3306/coffee_store";
		String user="root";
		String pwd="SQLdeveloper@05";
	 try
		{
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	Connection con=DriverManager.getConnection(url,user,pwd);
		 	String sql="delete from backbencher where id=?";
		 	PreparedStatement statement=con.prepareStatement(sql);
		 	statement.setInt(1, 3);
		 	int i=statement.executeUpdate();
		 	if(i>0)
		 	{
		 		System.out.println("Deleted");
		 	}
}
	 catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
