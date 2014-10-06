package goebel;

import java.awt.*;
import java.util.Calendar;

import javax.swing.*;

/**
 * Zeichnen der Analoguhr
 * @author Melanie Goebel
 * @version 2014-10-03
 */
public class UhrDisplay extends JPanel{
	private int mittelpunkt;
	private int durchmesser;
	private Control c = new Control(this);
	private String[] date;
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight()); // Hintergrund in grau
		g.setColor(new Color(152,223,243));
		if(this.getWidth()>=this.getHeight()){ // Damit sich die Uhr anpasst und zu kein Oval wird
			durchmesser = this.getHeight();
			mittelpunkt = durchmesser/2;
		}else{
			durchmesser = this.getWidth();
			mittelpunkt = durchmesser/2;
		}
		g.fillOval(0, 0, durchmesser, durchmesser); // Die Uhr
		g.setColor(Color.BLACK);
		g.fillOval(durchmesser/2-durchmesser/80, durchmesser/2-durchmesser/80, durchmesser/40, durchmesser/40); // Den Mittelpunkt kennzeichnen
		for (int i = 0; i < 12; i++) { // Die Striche fuer die Stunden
			g.drawLine(c.gradToX(i*360/12,durchmesser,durchmesser/2),c.gradToY(i*360/12,durchmesser,durchmesser/2),c.gradToX(i*360/12,durchmesser,(int)(durchmesser/2.5)),c.gradToY(i*360/12,durchmesser,(int)(durchmesser/2.5)));
		}
		for (int i = 0; i < 60; i++) { // Die Striche fuer die Minuten
			g.drawLine(c.gradToX(i*360/60,durchmesser,durchmesser/2),c.gradToY(i*360/60,durchmesser,durchmesser/2),c.gradToX(i*360/60,durchmesser,(int)(durchmesser/2.1)),c.gradToY(i*360/60,durchmesser,(int)(durchmesser/2.1)));
		}
	    date = c.getDate();
	    g.drawRect(mittelpunkt+mittelpunkt/4, mittelpunkt-mittelpunkt/11, durchmesser/4, durchmesser/10);
	    g.setFont(new Font("Arial",Font.PLAIN,mittelpunkt/10));
	    g.drawString(date[3]+","+date[2]+"."+date[1], mittelpunkt+(int)(mittelpunkt/3.5), mittelpunkt+mittelpunkt/20);
	}
	
}