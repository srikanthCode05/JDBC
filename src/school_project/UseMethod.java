package school_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UseMethod 
{
	public static void main(String[] args) 
	{
		
		Student student=new Student();
		student.setId(3);
		student.setName("ashwin");
		student.setMarks(66);
		student.setLocation("Delhi");
		UseMethod.saveStudent(student);
	}
	public static void saveStudent(Student student)
	{
		String url="jdbc:mysql://localhost:3306/coffee_store";
		String user="root";
		String pwd="SQLdeveloper@05";
	 try
		{
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	Connection con=DriverManager.getConnection(url,user,pwd);
		 	String sql="insert into backbencher values(?,?,?,?)";
		 	PreparedStatement statement=con.prepareStatement(sql);
		 	statement.setInt(1,student.getId());
		 	statement.setString(2,student.getName());
		 	statement.setInt(3,student.getMarks());
		 	statement.setString(4,student.getLocation());
		 	
		 	int i=statement.executeUpdate();
		 	if(i>0)
		 	{
		 		System.out.println("updated");
		 	}
}
	 catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
