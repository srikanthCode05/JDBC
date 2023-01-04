package school_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SaveStudent
{
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/coffee_store";
		String user="root";
		String pwd="SQLdeveloper@05";
	 try
		{
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	Connection con=DriverManager.getConnection(url,user,pwd);
		 	String sql="insert into backbencher values(?,?,?,?)";
		 	PreparedStatement statement=con.prepareStatement(sql);
		 	System.out.println("enter id");
		 	int id=input.nextInt();
		 	statement.setInt(1, id);
		 	System.out.println("enter name");
		 	String name=input.next();
		 	statement.setString(2, name);
		 	System.out.println("enter marks");
		 	int marks=input.nextInt();
		 	statement.setInt(3, marks);
		 	System.out.println("enter location");
		 	String location=input.next();
		 	statement.setString(4,location);
		 	
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

