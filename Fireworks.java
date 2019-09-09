import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;

import javax.swing.GroupLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class Fireworks extends JComponent implements ActionListener, ChangeListener{

	public FlowLayout layout;
	protected JPanel panel_north = new JPanel();			//	north panel
	protected JPanel panel_east = new JPanel();				// east panel
	
	protected JLabel label, label1, label2, label3, label4, label5;			// labels
	protected JButton button;							// for start button
	protected JRadioButton blue, red, green, black, magenta, orange;		// color of fireworks radio  buttons
	protected JRadioButton e_l, e_c, e_h, e_p, e_car, e_1, e_2; 	// type of explosions of fireworks
	protected JSlider time, s_angle, s_speed;			// Sliders for time, angle and speed
	

	
	protected double tt; 		// time assigned 
	protected double t = 0.0; 	// time passed
	protected Timer timer;		// timer
	protected Color color;		// color of launch
	protected double angle;		// angle of launch
	protected double speed;		// speed of launch
	
	protected double temp_x = 0.0;
	protected double temp_y = getHeight();
	protected double new_x;
	protected double new_y;
	protected Random rand = new Random();		// used for horse tail explosion
	
	protected int exp_type;			// choosing type of explosion
	
	
	
	public Fireworks(){
		
		timer = new Timer(200, new TimerCallback());  // 0.2 seconds
		
		// Layout of the main GUI
		setLayout(new BorderLayout());
		
		// north and east side of border layout (box layout)
		panel_north.setLayout(new BoxLayout(panel_north, BoxLayout.Y_AXIS));
		panel_east.setLayout(new BoxLayout(panel_east, BoxLayout.Y_AXIS));
		
		// 2 panels with the north panel
		JPanel p_1 = new JPanel(new FlowLayout());
		JPanel p_2 = new JPanel(new FlowLayout());
		
		// Launch angle
		label = new JLabel("Angle   ");
		p_1.add(label);
		
		s_angle = new JSlider(1, 89);
		s_angle.addChangeListener(this);
		p_1.add(s_angle);
		
		
		// launch speed
		label1 = new JLabel("Speed   ");
		p_1.add(label1);
		
		s_speed = new JSlider(0, 150);
		s_speed.addChangeListener(this);
		p_1.add(s_speed);
		
		
		// time
		label5 = new JLabel("Time   ");
		p_2.add(label5);
		
		time = new JSlider(1, 10);
		time.addChangeListener(this);
		p_2.add(time);
		
		
		// Adding both panels to the north panel
		panel_north.add(p_1);
		panel_north.add(p_2);
		
		//Color
		label2 = new JLabel("Color : ");
		panel_east.add(label2);
		
		ButtonGroup group = new ButtonGroup();
		
		blue = new JRadioButton("Blue");
		blue.setActionCommand("blue");
		blue.addActionListener(this);
		group.add(blue);
		panel_east.add(blue);
		
		red = new JRadioButton("Red");
		red.setActionCommand("red");
		red.addActionListener(this);
		group.add(red);
		panel_east.add(red);
		
		green = new JRadioButton("Green");
		green.setActionCommand("green");
		green.addActionListener(this);
		group.add(green);
		panel_east.add(green);
		
		black = new JRadioButton("Black");
		black.setActionCommand("black");
		black.addActionListener(this);
		group.add(black);
		panel_east.add(black);
		
		magenta = new JRadioButton("Magenta");
		magenta.setActionCommand("magenta");
		magenta.addActionListener(this);
		group.add(magenta);
		panel_east.add(magenta);
		
		orange = new JRadioButton("Orange");
		orange.setActionCommand("orange");
		orange.addActionListener(this);
		group.add(orange);
		panel_east.add(orange);
		
		//types of fireworks explosions
		ButtonGroup group1 = new ButtonGroup();
		
		label3 = new JLabel(" ");
		panel_east.add(label3);
		
		label4 = new JLabel("Explosion");
		panel_east.add(label4);
		
		e_l = new JRadioButton("Simple explosion");
		e_l.setActionCommand("e_l");
		e_l.addActionListener(this);
		group1.add(e_l);
		panel_east.add(e_l);
		
		e_c = new JRadioButton("Mini circles");
		e_c.setActionCommand("e_c");
		e_c.addActionListener(this);
		group1.add(e_c);
		panel_east.add(e_c);
		
		e_h = new JRadioButton("Horse Tail");
		e_h.setActionCommand("e_h");
		e_h.addActionListener(this);
		group1.add(e_h);
		panel_east.add(e_h);
		
		e_p = new JRadioButton("Palm Tree");
		e_p.setActionCommand("e_p");
		e_p.addActionListener(this);
		group1.add(e_p);
		panel_east.add(e_p);
		
		e_car = new JRadioButton("Car");
		e_car.setActionCommand("e_car");
		e_car.addActionListener(this);
		group1.add(e_car);
		panel_east.add(e_car);
		
		e_1 = new JRadioButton("New Year");
		e_1.setActionCommand("e_1");
		e_1.addActionListener(this);
		group1.add(e_1);
		panel_east.add(e_1);
		
		e_2 = new JRadioButton("'mines'");
		e_2.setActionCommand("e_2");
		e_2.addActionListener(this);
		group1.add(e_2);
		panel_east.add(e_2);
		
		//START BUTTON//
		button = new JButton("Start");
		button.setActionCommand("Start");
		button.addActionListener(this);
		panel_east.add(button);
		
		// adding panels to border layout
		add(panel_north, BorderLayout.NORTH);
		add(panel_east, BorderLayout.EAST);	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String action = arg0.getActionCommand();
		switch (action){			// Radio buttons (color and explosion)
			case "Start":
				timer.start();
				repaint();
				break;
			case "blue":
				color = Color.BLUE;
				break;
			case "red" :
				color = Color.RED;
				break;
			case "green" :
				color = Color.GREEN;
				break;
			case "black" :
				color = Color.BLACK;
				break;
			case "magenta" :
				color = Color.MAGENTA;
				break;	
			case "orange" :
				color = Color.ORANGE;
				break;
			case "e_l" :
				exp_type = 1;
				break;
			case "e_c" :
				exp_type = 2;
				break;
			case "e_h" :
				exp_type = 3;
				break;
			case "e_p" :
				exp_type = 4;
				break;
			case "e_car" :
				exp_type = 5;
				break;
			case "e_1" :
				exp_type = 6;
				break;
			case "e_2" :
				exp_type = 7;
				break;
		}
		
	}
	
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		Object src1 = arg0.getSource();
		// Updating sliders and time, angle, speed variables
		if (src1.equals(time)){
			tt = time.getValue();
			label5.setText("Time: " + tt);
		}
		else if(src1.equals(s_angle)){
			angle = s_angle.getValue();
			label.setText("Angle: " + angle);
			angle = Math.toRadians(angle);
		}
		else if (src1.equals(s_speed)){
			speed = s_speed.getValue();
			label1.setText("Speed: " + speed);
		}
	}
	
	
	protected class TimerCallback implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			repaint();			// repaint
		}
	}
	
	
	@Override
	public void paintComponent (Graphics g){
		t = t + (timer.getDelay())/1000.0;     									// time delay in seconds  
		new_x = (speed*Math.cos(angle)*t);									// new x position 
		new_y =  getHeight() - (((speed*(Math.sin(angle))*t) - (0.5*9.81*t*t)));		// new y position 
		g.setColor(color);		// setting color
		if (t > tt){			// Comparing current time with the time assigned
			
			if (exp_type == 1){
				//  The lines one //
				g.drawLine((int)new_x, (int)new_y-2, (int)new_x, (int)new_y-7);
				g.drawLine((int)new_x+1, (int)new_y-1, (int)new_x+6, (int)new_y-6);
				g.drawLine((int)new_x+2, (int)new_y, (int)new_x+7, (int)new_y);
				g.drawLine((int)new_x+1, (int)new_y+1, (int)new_x+6, (int)new_y+6);
				g.drawLine((int)new_x, (int)new_y+2, (int)new_x, (int)new_y+7);
				g.drawLine((int)new_x-1, (int)new_y+1, (int)new_x-6, (int)new_y+6);
				g.drawLine((int)new_x-2, (int)new_y, (int)new_x-7, (int)new_y);
				g.drawLine((int)new_x-1, (int)new_y-1, (int)new_x-6, (int)new_y-6);
			}
			else if (exp_type == 2){
				// mini circles//
				g.fillOval((int)new_x+3, (int)new_y, 3, 3);
				g.fillOval((int)new_x-3, (int)new_y, 3, 3);
				g.fillOval((int)new_x, (int)new_y+3, 3, 3);
				g.fillOval((int)new_x, (int)new_y-3, 3, 3);
			}
			else if (exp_type == 3){
				// Horse tail one // 
				for (int i = 0; i < 15; i++){
					g.drawArc((int)new_x+rand.nextInt(12), (int)new_y+rand.nextInt(10), 15, 20, 75, -160);
				}
				for (int i = 0; i < 15; i++){
					g.drawArc((int)new_x-rand.nextInt(12), (int)new_y+rand.nextInt(10), 15, 20, 75, 180);
				}
			}
			else if (exp_type == 4){
				// Palm	//
				g.drawLine((int)new_x, (int)new_y+2, (int)new_x, (int)new_y+14);
				g.drawLine((int)new_x, (int)new_y-3, (int)new_x, (int)new_y-14);
				//g.drawLine((int)new_x+1, (int)(new_y-2.5), (int)new_x+7, (int)new_y-5);
				//g.drawLine((int)new_x-1, (int)(new_y-2.5), (int)new_x-7, (int)new_y-5);
				g.drawLine((int)new_x+1, (int)(new_y-0.5), (int)new_x+13, (int)(new_y-0.5));
				g.drawLine((int)new_x-1, (int)(new_y-0.5), (int)new_x-13, (int)(new_y-0.5));
				
				g.drawLine((int)new_x+2, (int)(new_y-2.5), (int)new_x+12, (int)(new_y-9.5));
				g.drawLine((int)new_x-2, (int)(new_y-2.5), (int)new_x-12, (int)(new_y-9.5));
			}
			else if (exp_type == 5){
				// CAR //
				g.fillRect((int)new_x, (int)new_y, 8, 6);
				g.fillRect((int)new_x+8, (int)new_y-6, 13, 12);
				g.fillRect((int)new_x+21, (int)new_y, 8, 6);
				g.setColor(Color.BLACK);
				g.fillOval((int)new_x+5, (int)new_y+5, 4, 4);
				g.fillOval((int)new_x+20, (int)new_y+5, 4, 4);
				g.setColor(Color.YELLOW);
				g.fillOval((int)new_x+29, (int)new_y+1, 2, 2);
				g.fillOval((int)new_x+29, (int)new_y+3, 2, 2);
			}
			else if (exp_type == 6){
				// Happy new year //
				g.drawLine((int)new_x, (int)new_y-2, (int)new_x, (int)new_y-7);
				g.drawLine((int)new_x+1, (int)new_y-1, (int)new_x+6, (int)new_y-6);
				g.drawLine((int)new_x+2, (int)new_y, (int)new_x+7, (int)new_y);
				g.drawLine((int)new_x+1, (int)new_y+1, (int)new_x+6, (int)new_y+6);
				g.drawLine((int)new_x, (int)new_y+2, (int)new_x, (int)new_y+7);
				g.drawLine((int)new_x-1, (int)new_y+1, (int)new_x-6, (int)new_y+6);
				g.drawLine((int)new_x-2, (int)new_y, (int)new_x-7, (int)new_y);
				g.drawLine((int)new_x-1, (int)new_y-1, (int)new_x-6, (int)new_y-6);
				
				g.drawString("HAPPY NEW", (int)new_x+8, (int)new_y);
				g.drawString("    YEAR  ", (int)new_x+8, (int)new_y+10);
				
				g.drawLine((int)new_x+82+4, (int)new_y-2, (int)new_x+82+4, (int)new_y-7);
				g.drawLine((int)new_x+83+4, (int)new_y-1, (int)new_x+88+4, (int)new_y-6);
				g.drawLine((int)new_x+84+4, (int)new_y, (int)new_x+89+4, (int)new_y);
				g.drawLine((int)new_x+83+4, (int)new_y+1, (int)new_x+88+4, (int)new_y+6);
				g.drawLine((int)new_x+82+4, (int)new_y+2, (int)new_x+82+4, (int)new_y+7);
				g.drawLine((int)new_x+81+4, (int)new_y+1, (int)new_x+76+4, (int)new_y+6);
				g.drawLine((int)new_x+80+4, (int)new_y, (int)new_x+75+4, (int)new_y);
				g.drawLine((int)new_x+81+4, (int)new_y-1, (int)new_x+76+4, (int)new_y-6);
				
			}
			else if (exp_type == 7){
				//SPIDER//
				g.fillOval((int)new_x, (int)new_y, 3, 3);
				g.fillOval((int)new_x+3, (int)new_y+3, 3, 3);
				g.fillOval((int)new_x+6, (int)new_y+6, 3, 3);
				g.fillOval((int)new_x+9, (int)new_y+9, 3, 3);
				g.fillOval((int)new_x+3, (int)new_y-3, 3, 3);
				g.fillOval((int)new_x+6, (int)new_y-6, 3, 3);
				g.fillOval((int)new_x+9, (int)new_y-9, 3, 3);
				g.fillOval((int)new_x-3, (int)new_y+3, 3, 3);
				g.fillOval((int)new_x-6, (int)new_y+6, 3, 3);
				g.fillOval((int)new_x-9, (int)new_y+9, 3, 3);
				g.fillOval((int)new_x-3, (int)new_y-3, 3, 3);
				g.fillOval((int)new_x-6, (int)new_y-6, 3, 3);
				g.fillOval((int)new_x-9, (int)new_y-9, 3, 3);
				g.fillOval((int)new_x, (int)new_y+3, 3, 3);
				g.fillOval((int)new_x, (int)new_y+6, 3, 3);
				g.fillOval((int)new_x, (int)new_y+9, 3, 3);
				g.fillOval((int)new_x+3, (int)new_y, 3, 3);
				g.fillOval((int)new_x+6, (int)new_y, 3, 3);
				g.fillOval((int)new_x+9, (int)new_y, 3, 3);
				g.fillOval((int)new_x-3, (int)new_y, 3, 3);
				g.fillOval((int)new_x-6, (int)new_y, 3, 3);
				g.fillOval((int)new_x-9, (int)new_y, 3, 3);
				g.fillOval((int)new_x, (int)new_y-3, 3, 3);
				g.fillOval((int)new_x, (int)new_y-6, 3, 3);
				g.fillOval((int)new_x, (int)new_y-9, 3, 3);
			}
			timer.stop();
			// changing the variables back to original for next launch
			t = 0;
			new_x = 0;
			new_y = 0;
			temp_x = 0;
			temp_y = getHeight();
		}
		else{	// drawing fireworks projectile	
			g.drawLine((int)temp_x, (int)temp_y, (int)new_x, (int)new_y);					
			temp_x = new_x;
			temp_y = new_y;
		}
	}
}
