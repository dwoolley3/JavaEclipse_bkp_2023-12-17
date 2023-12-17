package hcc_2002_java_course;

/* WelcomeApplet.java: This is an example of Java applets */
import java.awt.Graphics;
import java.awt.*;
import java.util.Date;

public class WelcomeApplet extends java.applet.Applet
{
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g)
	{
		Date currentDate = new Date();
        g.drawString("Welcome to Java!", 10, 10);
        g.drawString("Another Message!", 10, 50);
        g.drawString(currentDate.toString(), 10, 80);
        setBackground(Color.cyan);
	}
}
