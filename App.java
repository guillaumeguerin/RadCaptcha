package maps.radcaptcha;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

import maps.radcaptcha.MyCanvas;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
		MyCanvas.createCaptcha();
    }
}

class MyCanvas {

	  public static void createCaptcha() {

	    	BufferedImage img = new BufferedImage(300, 100, BufferedImage.TYPE_INT_RGB);
	    	//g2dObject.drawImage(img, null, 0, 0);
	    	Graphics2D g2 = img.createGraphics();

	        Color backgroundColor = getRandomColor();
	        g2.setColor(backgroundColor);
	        g2.fillRect(0, 0, 300, 200);
	        
	        int width2 = 300 - getRandomInteger(1, 102);
	        int height2 = 200 - getRandomInteger(1, 102);
	        backgroundColor = getRandomColor();
	        g2.setColor(backgroundColor);
	        g2.fillRect(10, 0, width2, height2);
	        
	        width2 = 300 - getRandomInteger(102, 181);
	        height2 = 200 - getRandomInteger(102, 172);
	        backgroundColor = getRandomColor();
	        g2.setColor(backgroundColor);
	        g2.fillRect(30, 20, width2, height2);
	        
	        width2 = 300 - getRandomInteger(182, 240);
	        height2 = 200 - getRandomInteger(172, 180);
	        backgroundColor = getRandomColor();
	        g2.setColor(backgroundColor);
	        g2.fillRect(40, 40, width2, height2);
	        
	        g2.setColor(getRandomColor());
	        g2.drawLine(getRandomInteger(0, 20), getRandomInteger(0, 20), getRandomInteger(0, 120), getRandomInteger(0, 120));
	        g2.setColor(getRandomColor());
	        g2.drawLine(getRandomInteger(20, 40), getRandomInteger(20, 70), getRandomInteger(70, 120), getRandomInteger(70, 120));
	        g2.setColor(getRandomColor());
	        g2.drawLine(getRandomInteger(100, 120), getRandomInteger(0, 20), getRandomInteger(0, 160), getRandomInteger(80, 180));
	        g2.setColor(getRandomColor());
	        g2.drawLine(getRandomInteger(100, 220), getRandomInteger(0, 20), getRandomInteger(0, 180), getRandomInteger(0, 180));
	        g2.setColor(getRandomColor());
	        g2.drawLine(getRandomInteger(100, 120), getRandomInteger(0, 20), getRandomInteger(0, 110), getRandomInteger(90, 180));
	        g2.setColor(getRandomColor());
	        g2.drawLine(getRandomInteger(80, 220), getRandomInteger(0, 20), getRandomInteger(0, 70), getRandomInteger(45, 200));
	        g2.setColor(getRandomColor());
	        g2.drawLine(getRandomInteger(60, 220), getRandomInteger(0, 20), getRandomInteger(0, 20), getRandomInteger(60, 200));
	        g2.setColor(getRandomColor());
	        g2.drawLine(getRandomInteger(60, 220), getRandomInteger(0, 20), getRandomInteger(0, 100), getRandomInteger(10, 200));
	        g2.setColor(getRandomColor());
	        g2.drawLine(getRandomInteger(60, 220), getRandomInteger(0, 20), getRandomInteger(0, 180), getRandomInteger(10, 120));
	        g2.setColor(getRandomColor());
	        g2.drawLine(getRandomInteger(160, 220), getRandomInteger(0, 20), getRandomInteger(0, 120), getRandomInteger(10, 120));
	        g2.setColor(getRandomColor());
	        g2.setColor(getRandomColorForText());
	        
	        String fileName = getRandomString();
	        int initialX = getRandomInteger(0, 25);
	        for(int i=0; i<fileName.length(); i++) {
	        	Font font = new Font("Garamond", Font.PLAIN, 20);    
		        AffineTransform affineTransform = new AffineTransform();
		        affineTransform.rotate(Math.toRadians(getRandomInteger(25, 49)), 28, 80);
		        Font rotatedFont = font.deriveFont(affineTransform);
		        g2.setFont(rotatedFont);
	        	g2.drawString(""+fileName.charAt(i), initialX + i * 35, getRandomInteger(30, 60));
	        }
	        g2.drawLine(getRandomInteger(160, 220), getRandomInteger(0, 20), getRandomInteger(0, 120), getRandomInteger(70, 120));
	        g2.setColor(getRandomColor());
	        g2.drawLine(getRandomInteger(160, 220), getRandomInteger(0, 20), getRandomInteger(0, 160), getRandomInteger(80, 120));
	        g2.setColor(getRandomColor());
	        g2.drawLine(getRandomInteger(60, 220), getRandomInteger(0, 20), getRandomInteger(0, 120), getRandomInteger(10, 120)); 
	        
	        g2.drawLine(getRandomInteger(160, 220), getRandomInteger(100, 120), getRandomInteger(100, 120), getRandomInteger(70, 120));
	        g2.setColor(getRandomColor());
	        g2.drawLine(getRandomInteger(160, 220), getRandomInteger(100, 120), getRandomInteger(0, 160), getRandomInteger(80, 120));
	        g2.setColor(getRandomColor());
	        g2.drawLine(getRandomInteger(0, 50), getRandomInteger(0, 100), getRandomInteger(250, 300), getRandomInteger(0, 20));
	        g2.drawLine(getRandomInteger(0, 50), getRandomInteger(0, 100), getRandomInteger(250, 300), getRandomInteger(0, 20));
	        g2.drawLine(getRandomInteger(0, 50), getRandomInteger(0, 100), getRandomInteger(250, 300), getRandomInteger(0, 100));
	        g2.drawLine(getRandomInteger(0, 50), getRandomInteger(0, 100), getRandomInteger(250, 300), getRandomInteger(0, 100));
	        
	        g2.dispose();

	        g2.drawImage(img, null, 0, 0);
	    	try {
				ImageIO.write(img, "PNG", new File(fileName + ".PNG"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       }

	  
	  private static int getRandomInteger(int aStart, int aEnd){	  
		  	SecureRandom random = new SecureRandom();
		    return random.nextInt(aEnd-aStart+1)+aStart;
	  }
	  
	  private static Color getRandomColor() {
		  int red = getRandomInteger(140,255);
	      int green = getRandomInteger(140,255);
	      int blue = getRandomInteger(140,255);
	      return new Color(red, green, blue);
	  }
	  
	  private static Color getRandomColorForText() {
		  int red = getRandomInteger(100,150);
	      int green = getRandomInteger(100,150);
	      int blue = getRandomInteger(100,150);
	      return new Color(red, green, blue);
	  }
	  
	  private static String getRandomString() {
		  String text = "";
		  for(int i = 0; i<6; i++) {
			  text += (char) getRandomInteger(64,90);
		  }
		  return text;
	  }
}
