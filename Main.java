//Muhammad Ahmad

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
