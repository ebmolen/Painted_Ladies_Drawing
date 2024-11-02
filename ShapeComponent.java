import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;

// Used official java documentation as a resource.

public class ShapeComponent extends JComponent {

	public void paintComponent(Graphics g) {
		// Casts g as a Graphics2D object, allows us to draw/fill with shape objects
		Graphics2D g2 = (Graphics2D) g;

		// Changing these values allows you to move the whole picture.  This is the top left corner of the picture.
		int startX = 50;
		int startY = 10;


		// sky
		Rectangle sky = new Rectangle(startX + 10, startY, 960, 757);
		g2.setColor(new Color(205, 239, 247));
		g2.draw(sky);
		g2.fill(sky);

		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Lucida Handwriting", Font.PLAIN, 50));
		g2.drawString("San Francisco, CA", startX + 40, startY + 70);


		// Painted Ladies
		Color primary1 = new Color(224, 144, 196);
		Color accent1 = new Color(153, 230, 240);

		Color primary2 = new Color(165, 232, 177);
		Color accent2 = new Color(234, 237, 140);

		Color primary3 = new Color(247, 255, 87);
		Color accent3 = new Color(99, 1, 24);

		Color primary4 = new Color(245, 149, 66);
		Color accent4 = new Color(6, 149, 189);

		Color primary5 = new Color(142, 177, 230);
		Color accent5 = new Color(99, 1, 24);

		Color primary6 = new Color(181, 167, 141);
		Color accent6 = new Color(51, 39, 16);


		paintedLady(startX + 10, startY + 200, 160, primary1, accent1, g);
		paintedLady(startX + 170, startY + 170, 160, primary2, accent2, g);
		paintedLady(startX + 330, startY + 140, 160, primary3, accent3, g);
		paintedLady(startX + 490, startY + 110, 160, primary4, accent4, g);
		paintedLady(startX + 650, startY + 80, 160, primary5, accent5, g);
		paintedLady(startX + 810, startY + 50, 160, primary6, accent6, g);


		//sidewalk
		int[] sideX = {startX + 10, startX + 970, startX + 970, startX + 10};
		int[] sideY = {startY + 527, startY + 347, startY + 407, startY + 587};
		Polygon sideWalk = new Polygon(sideX, sideY, 4);
		g2.setColor(new Color(138, 135, 128));
		BasicStroke thin = new BasicStroke(1);
		g2.setStroke(thin);
		g2.draw(sideWalk);
		g2.fillPolygon(sideWalk);

		// grass and Alamo Square Park (a park is just a big "garden" ...right?)
		int[] grassX = {startX + 10, startX + 970, startX + 970, startX + 10};
		int[] grassY = {startY + 587, startY + 407, startY + 757, startY + 757};

		Polygon grass = new Polygon(grassX, grassY, 4);
		g2.setColor(new Color(28, 117, 6));
		g2.draw(grass);
		g2.fillPolygon(grass);

		// sign for Alamo Square Park
		Rectangle post = new Rectangle(startX + 750, startY + 550, 10, 150);
		g2.setColor(Color.BLACK);
		g2.draw(post);
		g2.fill(post);

		Rectangle flag = new Rectangle(startX + 750, startY + 550, 100, 50);
		g2.setColor(Color.BLACK);
		g2.draw(flag);
		g2.fill(flag);
		g2.setColor(Color.white);
		g2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		g2.drawString("Alamo Square", startX + 755, startY + 580);

		// trees
		tree(startX + 40, startY + 500, 20, g);

		tree (startX + 170, startY + 364, 15, g);

		tree (startX + 490, startY + 306, 15, g);

		tree (startX + 810, startY + 247, 15, g );

		tree (startX + 600, startY + 510, 25, g);

		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		g2.drawString("Elisabeth Molen", startX + 790, startY + 740);

	}

	public void paintedLady(int x, int y, int width, Color primaryColor, Color accentColor, Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		paintedLadyRoof(x, y, width, primaryColor, accentColor, g);
		paintedLadyBody(x, (int) (y + (13.0 * width) / 24), width, primaryColor, accentColor, g);
	}

	public void paintedLadyRoof(int x, int y, int width, Color primaryColor, Color accentColor, Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		int height = (int) (0.5 * width);

		int[] x1 = {x, (int) (x + width / 2.0), x + width};
		int[] y1 = {y + height, y, y + height};
		Polygon outer = new Polygon(x1, y1, 3);
		BasicStroke thick = new BasicStroke(3);
		g2.setColor(Color.BLACK);
		g2.setStroke(thick);
		g2.draw(outer);
		g2.setColor(Color.white);
		g2.fillPolygon(outer);

		int[] x2 = {(int) (x + width / 8.0), (int) (x + width / 2.0), (int) (x + (7.0 * width) / 8.0)};
		int[] y2 = {(int) (y + (7.0 * height) / 8.0), (int) (y + height / 8.0), (int) (y + (7.0 * height) / 8.0)};
		Polygon inner = new Polygon(x2, y2, 3);
		g2.setColor(Color.BLACK);
		BasicStroke thin = new BasicStroke(2);
		g2.setStroke(thin);
		g2.draw(inner);
		g2.setColor(primaryColor);
		g2.fillPolygon(inner);

		Rectangle roof1 = new Rectangle((int) (x + (5.0 * width) / 12.0), (int) (y + (5.0 * height) / 12.0),
				width / 6, width / 6);
		g2.setColor(Color.BLACK);
		g2.draw(roof1);
		g2.setColor(new Color(217, 219, 222));
		g2.fill(roof1);
		g2.setStroke(thin);
		Line2D.Double yBar = new Line2D.Double((int) (x + width / 2.0), (int) (y + (5.0 * height) / 12.0),
				(int) (x + width / 2.0), (int) (y + ((5.0 * height) / 12.0) + width / 6.0));
		g2.setColor(Color.BLACK);
		g2.draw(yBar);
		Line2D.Double xBar = new Line2D.Double((int) (x + (5.0 * width) / 12.0), (int) (y + ((5.0 * height) / 12.0) + width / 12.0),
				(int) (x + (7.0 * width) / 12.0), (int) (y + ((5.0 * height) / 12.0) + width / 12.0));
		g2.setColor(Color.BLACK);
		g2.draw(xBar);

		Rectangle bar = new Rectangle(x, y + height, width, (int) (height / 12.0));
		g2.setColor(Color.BLACK);
		g2.setStroke(thin);
		g2.draw(bar);
		g2.setColor(accentColor);
		g2.fill(bar);
	}

	public void paintedLadyBody(int x, int y, int width, Color primaryColor, Color accentColor, Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		BasicStroke thin = new BasicStroke(2);

		//frame
		int height = (int) (width * 1.5);
		int[] x3 = {x, x + width, x + width, x};
		int[] y3 = {y, y, (int) (y + ((7.0) * height) / 8.0), y + height};
		Polygon frame = new Polygon(x3, y3, 4);
		g2.setColor(Color.BLACK);
		g2.setStroke(thin);
		g2.draw(frame);
		g2.setColor(primaryColor);
		g2.fill(frame);

		//trim
		int[] x4 = {x, x + width, x + width, (int) (x + (11.00 / 12.00) * width), (int) (x + (width / 12.0)), x};
		int[] y4 = {y, y, (int) (y + (height / 12.0)), (int) (y + (height / 18.0)),
				(int) (y + (height / 18.0)), (int) (y + (height / 12.0))};

		Polygon edge = new Polygon(x4, y4, 6);
		g2.setColor(Color.BLACK);
		g2.setStroke(thin);
		g2.draw(edge);
		g2.setColor(Color.white);
		g2.fill(edge);

		// trim 2
		int[] x5 = {x, x + width, x + width, (int) (x + (11.00 / 12.00) * width), (int) (x + (width / 12.0)), x};
		int[] y5 = {(int)(y + height/3.1), (int) (y + height/3.1), (int) (y + (height / 16.0) + height/3.1), (int) (y + (height / 22.0) + height/3.1),
				(int) (y + (height / 22.0) + height/3.1), (int) (y + (height / 16.0) + height/3.1)};

		Polygon edge2 = new Polygon(x5, y5, 6);
		g2.setColor(Color.BLACK);
		g2.setStroke(thin);
		g2.draw(edge2);
		g2.setColor(Color.white);
		g2.fill(edge2);

		// windows
		bodyWindow((int) (x + width / 8.0), (int) (y + height / 8.0), (int) (width / 4.0), (int) (width / 4.0), g);

		bodyWindow((int) (x + (25.0 / 40.0) * width), (int) (y + height / 8.0),
				(int) (width / 4.0), (int) (width / 4.0), g);

		bodyWindow((int) (x + (25.0 / 40.0) * width), (int) (y + height / 2.5),
				(int) (width / 4.0), (int) (width / 4.0), g);

		// front door
		Rectangle2D.Double doorFrame = new Rectangle2D.Double(x + width / 8.0, y + height / 2.5 + width / 8.0,
				width / 4.0, height / 6.0);
		g2.setColor(Color.BLACK);
		g2.setStroke(thin);
		g2.draw(doorFrame);
		g2.setColor(Color.white);
		g2.fill(doorFrame);

		Rectangle2D.Double doorBody = new Rectangle2D.Double(x + width/8.0 + (width/4.0)/6.0, y + height / 2.5 + width / 8.0,
				(2.0/3.0) *(width/4.0),height/6.0);
		g2.setColor(Color.BLACK);
		g2.setStroke(thin);
		g2.draw(doorBody);
		g2.setColor(accentColor);
		g2.fill(doorBody);

		Arc2D.Double doorTop = new Arc2D.Double(x + width / 8.0, y + height / 2.5,
				width / 4.0, width / 4.0, 0, 180, Arc2D.OPEN);
		g2.setColor(Color.BLACK);
		g2.setStroke(thin);
		g2.draw(doorTop);
		g2.setColor(Color.white);
		g2.fill(doorTop);

		Arc2D.Double innerDoorTop = new Arc2D.Double(x + width / 8.0 + (1.0/3.0)*(width/8.0), y + height / 2.5 + (1.0/3.0) * (width/8.0),
				width / 6.0, width / 6.0, 0, 180, Arc2D.CHORD);
		g2.setColor(Color.BLACK);
		g2.setStroke(thin);
		g2.draw(innerDoorTop);
		g2.setColor(accentColor);
		g2.fill(innerDoorTop);

		// stairs
		Rectangle2D.Double stairs = new Rectangle2D.Double(x + width / 8.0, y + height / 2.5 + width / 8.0 + height / 6.0,
				width / 4.0, height / 3.0);
		g2.setColor(Color.GRAY);
		g2.setStroke(thin);
		g2.draw(stairs);
		g2.fill(stairs);
		double topStairs = y + height / 2.5 + width / 8.0 + height / 6.0;
		double newY = topStairs + ((height / 3.0) / 7.0);
		g2.setColor(Color.BLACK);
		for (int i = 0; i < 8; i++) {
			Line2D.Double rung = new Line2D.Double(x + width/8.0, newY, x + width/8.0 + width/4.0, newY);
			g2.draw((rung));
			newY += ((height / 3.0) / 7.0);
		}

		// garage door
		Rectangle2D.Double garageDoor = new Rectangle2D.Double(x + width / 2.0, y + height * (3.0 / 5.0),
				width / 2.3, width / 2.0);
		g2.setColor(Color.BLACK);
		g2.setStroke(thin);
		g2.draw(garageDoor);
		g2.setColor(Color.white);
		g2.fill(garageDoor);


		double rollY = y + height * (3.0/5.0) + (width/2.0) / 7.0;
		for (int i = 0; i < 4; i++) {
			Rectangle2D.Double bar = new Rectangle2D.Double(x + width/2.0 + (width/2.3)/8, rollY,
					(width/2.3) * (3.0/4.0), (width/2.0)/7);
			g2.setColor(new Color(217, 219, 218));
			g2.draw(bar);
			g2.fill(bar);
			rollY += (width/2.0) * (2.0/7.0);
		}
	}

	public void bodyWindow(int x, int y, int width, int height, Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		BasicStroke thin = new BasicStroke(2);

		Rectangle windowFrame = new Rectangle(x, y, width, height);
		g2.setColor(Color.BLACK);
		g2.draw(windowFrame);
		g2.setColor(new Color(217, 219, 222));
		g2.fill(windowFrame);
		g2.setStroke(thin);
		Line2D.Double yBar = new Line2D.Double((int) (x + width / 2.0), y,
				(int) (x + width / 2.0), (int) (y + height));
		g2.setColor(Color.BLACK);
		g2.draw(yBar);
		Line2D.Double xBar = new Line2D.Double(x, (int) (y + height / 2.0), (int) (x + width), (int) (y + height / 2.0));
		g2.setColor(Color.BLACK);
		g2.draw(xBar);
	}

	public void tree(int x, int y, int width, Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		int[] xvals = {x, x + width, x + width, x};
		int[] yvals = {y, y, (int) (y + 9 * width - (3.0 / 16) * width), y + 9 * width};
		Polygon trunk = new Polygon(xvals, yvals, 4);
		g2.setColor(new Color(74, 54, 2));
		g2.draw(trunk);
		g2.fill(trunk);

		Ellipse2D.Double leaf1 = new Ellipse2D.Double(x - width, y - width, 2.5 * width, 2.5 * width);
		g2.setColor(new Color(2, 74, 28));
		g2.draw(leaf1);
		g2.fill(leaf1);
		Ellipse2D.Double leaf2 = new Ellipse2D.Double(x, y - width, 2.5 * width, 2.5 * width);
		g2.draw(leaf2);
		g2.fill(leaf2);
		Ellipse2D.Double leaf3 = new Ellipse2D.Double(x - width/2.0,y + width/3.0, 2.5 *width, 2.5 * width);
		g2.draw(leaf3);
		g2.fill(leaf3);
	}



	private static final long serialVersionUID = 1L;

}
