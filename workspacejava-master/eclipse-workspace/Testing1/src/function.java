import java.awt.*;  

public class function {
	public String name;
	
    function(String text) {
		name = text;
    }
	
	public String display() {
		return name;
	}
	
	 public void paint(Graphics g) {  
	       
	        g.create(100, 100, 23, 23);
	        g.drawImage(null, 0, 0, Color.RED, null);
	          
	    }

	
	

}
