package jdbc_employee_prc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc_employee_prc.dto.Employee;

public class EmployeeDao {

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");// load and Register
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_mvc_prc", "root",
				"root");//estb connection
		return connection;
	}

	public void insertEmployee(Employee e) throws Exception {
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("insert into employee values (?,?,?,?,?)");
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setInt(3, e.getSalary());
		ps.setString(4, e.getEmail());
		ps.setString(5, e.getPassword());

		ps.executeUpdate();
		System.out.println("Employee is Created");

	}
	
	public void updateEmployee(int id, Employee e) throws Exception {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("Update employee set name=?,salary=?,email=?,password=? where id=?");
		ps.setString(1, e.getName());
		ps.setInt(2,e.getSalary());
		ps.setString(3, e.getEmail());
		ps.setString(4,e.getPassword());
		
		ps.setInt(5, id);
		
		ps.executeUpdate();
		System.out.println("Updated");
		
		
	}
	
	public void selectEmployee(int id) throws Exception {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			System.out.println("Id = "+rs.getInt(1));
			System.out.println("Name = "+rs.getString(2));
			System.out.println("Salary = "+rs.getInt(3));
			System.out.println("Email = "+rs.getString(4));
			System.out.println("password = "+rs.getString(5));
			
		}
		
	}
	public void getAllEmployee() throws Exception {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from employee");		
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			System.out.println("Id = "+rs.getInt(1));
			System.out.println("Name = "+rs.getString(2));
			System.out.println("Salary = "+rs.getInt(3));
			System.out.println("Email = "+rs.getString(4));
			System.out.println("password = "+rs.getString(5));
			System.out.println("============================================================");		
		}
		
	}

}
