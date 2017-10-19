import java.sql.*;
import javax.swing.*;

public class EM_System{
	public static void main (String args[]){
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:./src/EMDB","SA","");
			if(conn != null){
				System.out.println("Success");
			}
			Company com = new Company();
			com.setComName("testName");
			com.setSize(100);
			com.insertCompany(conn);
		
			PreparedStatement stat = conn.prepareStatement("SELECT * FROM Company;");
			ResultSet rs = stat.executeQuery();
			
			while (rs.next()){
				System.out.println(rs.getString(1));
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
