import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Company {
	
	private String comName;
	private int size;
	private String projectType;
	private String tax;
	private String overTime;
	private String weekend;
	private String region;
	private String address;
	private String educationBk;
	
	public Company(){
		this.comName = this.projectType 
					= this.tax = this.overTime 
					= this.region = this.address 
					= this.educationBk =null;
		this.size = 0;
	}
	
	public Company(String name, int size, String projectType, String tax, String overTime, String weekend, String region,String address, String educationBk){
		this.comName = name;
		this.size = size;
		this.projectType = projectType;
		this.tax = tax;
		this.overTime = overTime;
		this.weekend = weekend;
		this.region = region;
		this.address = address;
		this.educationBk = educationBk;
	}
	
	public void setComName(String name){
		this.comName = name;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public void setPojectType(String pt){
		this.projectType = pt;
	}
	
	public void setTax(String tax){
		this.tax = tax;
	}
	
	public void setOverTime(String overTime){
		this.overTime = overTime;
	}
	
	public void setWeekend(String weekend){
		this.weekend = weekend;
	}
	
	public void setRegion(String region){
		this.region = region;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setEducationBk(String edu){
		this.educationBk = edu;
	}
	
	public String getComName(){
		return this.comName;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public String getProjectType(){
		return this.projectType;
	}
	
	public String getTax(){
		return this.tax;
	}
	
	public String getOverTime(){
		return this.overTime;
	}
	
	public String getWeekend(){
		return this.weekend;
	}
	
	public String getRegion(){
		return this.region;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getEducationBk(){
		return this.educationBk;
	}
	
	private void executeStat(Connection c,String s){
		try {
			Statement stat = c.createStatement();
			stat.execute(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertCompany(Connection conn){
		String sqlStat = "INSERT INTO COMPANY VALUES('"
													+this.comName
													+"','"+this.size
													+"','"+this.projectType
													+"','"+this.tax
													+"','"+this.overTime
													+"','"+this.weekend
													+"','"+this.region
													+"','"+this.address
													+"','"+this.educationBk
													+"');";
//		if(this.size!=0){
//			sqlStat = sqlStat + "','" +this.size;
//		}
//		if(this.projectType!=null){
//			sqlStat = sqlStat + "','" +this.projectType;
//		}
//		if(this.tax!=null){
//			sqlStat = sqlStat + "','" +this.tax;
//		}
//		if(this.overTime!=null){
//			sqlStat = sqlStat + "','" +this.overTime;
//		}
//		if(this.weekend!=undenfined){
//			sqlStat = sqlStat + "','" +this.weekend;
//		}
//		if(this.tax!=null){
//			sqlStat = sqlStat + "','" +this.tax;
//		}
//		if(this.tax!=null){
//			sqlStat = sqlStat + "','" +this.tax;
//		}
		this.executeStat(conn, sqlStat);
	}
	
	public void printStat(){
		System.out.println("INSERT INTO C VALUES('"
				+this.comName
				+"','"+this.tax
				+"','"+this.overTime
				+"','"+this.weekend
				+"','"+this.region
				+"','"+this.address
				+"','"+this.educationBk
				+"');");
	}
}
