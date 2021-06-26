/**
 * 
 */
package com.piatra.play;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
//import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author valentin
 *
 */
public class prepare {
	public boolean event;
	public static JPanel p1 ;
	public static JPanel p2;
	public static JPanel p3 ;
	public static JPanel p4 ;
	public static JPanel pr ;
	
	
	
	
	 public static void square(JPanel p,JPanel panel,JFrame frame,int x, int y, Float c1, Float c2, Float c3) {
		 panel.setBorder(new LineBorder(new Color(0, 255, 255), 1, true));
		 panel.setBackground(new Color(c1, c2, c3));
		 panel.setBounds(x, y, 23, 23);
		 frame.getContentPane().add(panel);
		 p.add(panel);
	}
	 
public static void f1(JPanel p,JFrame frame, int x, int y) {
		 
		 Random rand = new Random();
		 Float r = rand.nextFloat();
		 Float g = rand.nextFloat();
		 Float b = rand.nextFloat();
		 
		 int x1,x2;
		 int y1,y2;
		 x1= x;
		 x2 = x1-23;
		 y1= y;
		 y2= y1+23;
		 
		  p1 = new JPanel();
		  p2 = new JPanel();
		  p3 = new JPanel();
		  p4 = new JPanel();
		 
		 square(p,p1, frame, x1, y1, r, g, b);
		 square(p,p2, frame, x2, y1, r, g, b);
		 square(p,p3, frame, x1, y2, r, g, b);
		 square(p,p4, frame, x2, y2, r, g, b);
	 }
	 
     
     
     
	 
	 
	 
	
	 
	 
	 
	 
	 
	 
	
	

}







/*

									   |
									   |  
									   |  0 0            #     ##
									   |  0 0            ##    ##           
									   |                
									   |   ##   ##      #    #
									   |   #     #     ##    # 
									   |                     #
									   |                      
									   |      ###                 
									   |                         
									   |                          
									   |                  
									   |                    
									   |                        
									   |                           
                _______________________|_________________________________________
                                       |
                                       |
                                       |
                                    

(x,y)-> x= link_left  y=link_ right  
 
 x= 0 nu are legatura , 1 are legatura la stanga,-1 are legatura la dreapta        
 y= 0 nu are legatura, 1, are legatura in sus, -1 are legatura in jos        
         
   0,0  
   0,
    
    





*/