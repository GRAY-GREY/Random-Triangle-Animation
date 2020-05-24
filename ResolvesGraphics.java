import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JPanel;

public class ResolvesGraphics extends JPanel {
	
	private Point A;
	private Point B;
	private Point C;
	
	public ResolvesGraphics() {
		super();
		A = new Point(0, 0);
		B = new Point(0, 0);
		C = new Point(0, 0);
	}
	
	public void paintComponent(Graphics g) {	
		super.paintComponent(g);
		 
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		
		g.drawLine(A.getX(), A.getY(), B.getX(), B.getY());
		g.drawLine(A.getX(), A.getY(), C.getX(), C.getY());
		g.drawLine(B.getX(), B.getY(), C.getX(), C.getY());
	}
	
	public void setA(Point newPoint) {
		A = newPoint;
	}
	
	public void setB(Point newPoint) {
		B = newPoint;
	}

	public void setC(Point newPoint) {
		C = newPoint;
	}
	
}