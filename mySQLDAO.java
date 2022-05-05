package jdbc_test;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.Statement;

public class mySQLDAO {
	public void connectToDB(String jobname) {
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?charaterEncoding=latin1", "root","Anshul@99");
			Statement stmt = con.createStatement();
			ResultSet rs =  stmt.executeQuery("select avg(salary) from employee where job_name='"+jobname+"' ");
			System.out.println("avg(salary)");
			while(rs.next())
				System.out.println(rs.getDouble(1));
			    
			con.close();
		
	}catch(Exception e) {
		System.out.println(e);
	}
 }
	public void connectToDB1() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?charaterEncoding=latin1", "root","Anshul@99");
			Statement stmt = con.createStatement();
			ResultSet rs =  stmt.executeQuery("select * from employee where(commission>salary);");
			System.out.println("commission>salary");
			while(rs.next())
				System.out.println(rs.getInt(1));
			con.close();
		
	}catch(Exception e) {
		System.out.println(e);
	}
 }
	public void connectToDB2() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?  ycharaterEncoding=latin1", "root","Anshul@99");
			Statement stmt = con.createStatement();
			ResultSet rs =  stmt.executeQuery("select*from employee where (salary*1.25)>3000;");
			System.out.println("greaterthan 3000");
			while(rs.next())
				System.out.println(rs.getDouble(1));
			con.close();
		
	}catch(Exception e) {
		System.out.println(e);
	}
 }
	public void connectToDB3() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?charaterEncoding=latin1", "root","Anshul@99");
			Statement stmt = con.createStatement();
			ResultSet rs =  stmt.executeQuery("Select emp_name from employee where timestampDiff(Year , hire_date , curdate()) >27");
			System.out.println("greaterthen>27");
			while(rs.next())
				System.out.println(rs.getString(1));
			con.close();
		
	}catch(Exception e) {
		System.out.println(e);
	}
 }

public static void main(String[] args) {
	mySQLDAO dao = new mySQLDAO();
	dao.connectToDB("analyst");
	
	dao.connectToDB1();
	
	dao.connectToDB2();
	
	dao.connectToDB3();
}
}
