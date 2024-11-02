
import javax.swing.*;
import java.awt.*;

public class ShapeViewer {
	public static void main(String[] args) {
		// EventQueue.invokerLater reveal the graphics after everything has loaded
		// Without this, graphics may not appear properly!
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// use this frame object to add 2D objects to
					JFrame frame = new JFrame();

					// configure your frame's size, title, and close operation
					frame.setSize(1150, 800);		// TODO CHANGE THE WINDOW SIZE
					frame.setTitle("The Painted Ladies"); 	// TODO CHANGE THE WINDOW TITLE
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					// add objects into your frame
					ShapeComponent s = new ShapeComponent();
					frame.add(s);

					// lastly, set your frame visibility to true
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}