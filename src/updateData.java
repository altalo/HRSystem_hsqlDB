import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class updateData <T>{
	
	private T t;
	private String[] propertyNameList;
	private HashMap<String,String> methodList;
	
	//构造方法1
	public updateData(){
		this.propertyNameList = null;
		this.methodList = null;
	}
	
	//构造方法2
	public updateData(T t){
		this.t= t;
		try{
			Field[] field = this.t.getClass().getDeclaredFields();
			Method[] method = this.t.getClass().getMethods();
			
			this.propertyNameList = new String[field.length];
			this.methodList = new HashMap<String,String>();
			for(int i = 0;i <field.length; i++){
				this.propertyNameList[i] = field[i].getName();
			}
			for(Method x:method){
				this.methodList.put(x.getName(),x.getReturnType().toString());
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	private void executeStat(Connection c,String s){
		try {
			Statement stat = c.createStatement();
			stat.execute(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//取得对应函数的返回值
		private <K> K getUpdateData(Method method){
			K value = null;
			try {
				value = (K) method.invoke(t);
			}  catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return value;
		}	
		
	//更新操作
	public void upadte(Connection conn, int num){
		
		String att = propertyNameList[num];
		String FirstUpperAtt = att.substring(0, 1).toUpperCase()+ att.substring(1);	
		Method getvalue = null;
		Method getname = null;
		String name = null;
//		String returnDataType = null;
		
		try {
			getvalue = t.getClass().getMethod("get"+FirstUpperAtt);
			getname = t.getClass().getMethod("getComName");
//			returnDataType = this.methodList.get("get"+FirstUpperAtt);	
			name = (String) getname.invoke(t);
		} catch (NoSuchMethodException | SecurityException |IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		String sqlStat = "UPDATE "+ this.t.getClass().getName()+ " SET " + att +" ='" 
						+ this.getUpdateData(getvalue) + "' WHERE name = '"+ name +"';";
		System.out.println(sqlStat);
		this.executeStat(conn, sqlStat);
	}
}
