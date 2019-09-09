/*
Muhammad Ahmad
mahmad4
project 3 
lab M/W 2:00-3:15
I did not collaborate with anyone and all the work is my own.
 */

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Main extends JComponent{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Fireworks");
		Fireworks canvas = new Fireworks();
		frame.add(canvas);
		
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}

}
