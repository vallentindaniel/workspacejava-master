package driveSchool;

import java.sql.Date;

public class User 
{
	private String user;
	private String password;
	private Date data;
	DbConnect Db;
	
	
	User(String user, String password, Date data)
	{
		this.user = user;
		this.password = password;
		this.data = data;
		Db = new DbConnect();
	}
	
	public void save() 
	{
		Db.insert(user,password,data);
	}
	

}








