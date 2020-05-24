
public class Triangle {

	private Point[] points;
	private Point D;
	
	public Triangle() {
		points = new Point[]{new Point(0,0), new Point(0,0), new Point(0,0)};
		D = new Point(0,0);
	}
	
	public Triangle(Point A, Point B, Point C) {
		points = new Point[]{A, B, C};
		D = new Point(0, 0);
	}

	public Point[] getPoints() {
		return points;
	}
	
	public Point getA() {
		return points[0];
	}
	
	public Point getB() {
		return points[1];
	}
	
	public Point getC() {
		return points[2];
	}

	public Point getD() {
		return D;
	}
	
	public void setA(Point A) {
		points = new Point[]{A, points[1], points[2]};
	}
	
	public void setB(Point B) {
		points = new Point[]{points[0], B, points[2]};
	}

	public void setC(Point C) {
		points = new Point[]{points[0], points[1], C};
	}

	public void setD(Point D) {
		this.D = D;
	}
	
	public String toString() {
		return points[0].toString() + " " + points[1].toString() + " " + points[2].toString() + "\n" + D.toString(); 
	}
	
}
