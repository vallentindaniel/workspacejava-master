/**
 * 
 */
package driveSchool;


import java.sql.*;
/**
 * @author valentin
 *
 */
public class Conect {
   private String user;
   private String password;
   private String url;
   
   Conect(){
	   user = "00307732_drive_school";
	   password = "307732_drive_school";
	   url = "jdbc:mysql://hosting2035506.online.pro:3306/00307732_drive_school";
   }
   
	// id questions a b c  answer
	public void selectx() {
	
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(url,user,password);  
	
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select* from users");  
			
			while(rs.next()) 
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
		    
		
		
	}
	
	
	
}
