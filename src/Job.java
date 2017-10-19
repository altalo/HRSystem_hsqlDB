import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Job {
	private String job_title;
	private String job_desc;
	
	public Job(){
		this.job_title=null;
		this.job_desc=null;
	}
	
	public Job(String title, String desc){
		this.job_title = title;
		this.job_desc = title;
	}
	
	public String getJobTitle(){
		return this.job_title;
	}
	
	public String getJobDesc(){
		return this.job_desc;
	}
	
	public void insertJob(Connection conn){
		try {
			Statement stat = conn.createStatement();
			stat.execute("INSERT INTO JOB VALUES('"+this.job_title+"','"+this.job_desc+"');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
