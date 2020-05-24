import javax.swing.JFrame;

public class RandomAlgorithm {

	private JFrame frame;
	private ResolvesGraphics resolvesGraphics;
	private Triangle triangle;
	private int xBound, yBound, sleepTime;
	
	public RandomAlgorithm(int xBound, int yBound, int sleepTime) {
		this.xBound = xBound;
		this.yBound = yBound;
		this.sleepTime = sleepTime;
		triangle = new Triangle(new Point((int) (Math.random()*this.xBound), (int) (Math.random()*this.yBound)), new Point((int) (Math.random()*this.xBound), (int) (Math.random()*this.yBound)), new Point((int) (Math.random()*this.xBound), (int) (Math.random()*this.yBound)));
		resolvesGraphics = new ResolvesGraphics();
		frame = new JFrame();
		frame.setSize(xBound, yBound);
		frame.getContentPane().add(new ResolvesGraphics());
		frame.setVisible(true);
		frame.pack();
	}
	
	public Triangle getTriangle() {
		return triangle;
	}
	
	public void move(Point point) throws InterruptedException {
		int xDif = triangle.getD().getX() - point.getX(); //difference on x-axis between selected point and new point it's going to
		int yDif = triangle.getD().getY() - point.getY(); //difference y-axis between selected point and new point it's going to
		int curXDif = Integer.MIN_VALUE; //current differences to measure needed change of slope, see difspaceinterval
		int curYDif = Integer.MIN_VALUE;
		int difSpaceInterval = 0; //acts as a slope, think of it as the m in y=mx+b
		boolean larger = false; //true for x, false for y, more confusing but less bytes, LOoK aT ME i'M EFeCienT
		int counter = 1; //counts how many spaces have been moved by x and y

		boolean xDifRight = moveWhichWay(xDif); //true for right, false for left
		boolean yDifUp = moveWhichWay(yDif); //true for up, false for down
		
		System.out.println("Selected point: "+point.toString());
		
		while(counter-1 < (Math.abs(xDif)+Math.abs(yDif)) && (curXDif != 0 && curYDif != 0)) { //while the counter is below the threshold or while the current differences aren't 0, insinuating 'while there's still spaces for the point to move in the x or y direction'
			setPointsInFrame();
			curXDif = triangle.getD().getX() - point.getX();
			curYDif = triangle.getD().getY() - point.getY();
			if(curXDif == 0 || curYDif == 0) {
				difSpaceInterval = 0;
				if(curXDif == 0) {}
				else
					larger = true;
			}
			else
				if(curXDif/curYDif == 0) 
					difSpaceInterval = Math.abs(curYDif/curXDif)+1;	
				else {
					difSpaceInterval = Math.abs(curXDif/curYDif)+1;
					larger = true;
				}
			
			System.out.println(curXDif + " " + curYDif + " difSpaceInterval: " + difSpaceInterval);
			
			//---------------------------------------------------------------------------------------------
			//this portion just calculates when and how to move based on certain conditions such as if the x difference is larger or smaller than the y difference, and if the slope of the y and x difference
			
			if(larger && difSpaceInterval == 0) {
				xMove(point, xDifRight);
				Thread.sleep(sleepTime);
			}
			if(!larger && difSpaceInterval == 0) {
				yMove(point, yDifUp);
				Thread.sleep(sleepTime);
			}
			if(larger && difSpaceInterval != 0) {
				for(int i = 0; i < difSpaceInterval-1; i++) {
					System.out.println("x change");
					xMove(point, xDifRight);
					counter++;
				}
				yMove(point, yDifUp);
				Thread.sleep(sleepTime);
				System.out.println("y change");
				counter++;
				frame.repaint();
			}
			if(!larger && difSpaceInterval != 0) {
				for(int i = 0; i < difSpaceInterval-1; i++) {
					System.out.println("y change");
					yMove(point, yDifUp);
					counter++;
				}
				xMove(point, xDifRight);
				Thread.sleep(sleepTime);
				System.out.println("x change");
				counter++;
				frame.repaint();
			}
			System.out.println("Point prog: "+point.toString());
			System.out.println("Counter: " + counter);
		}
	}

	public boolean moveWhichWay(int dif) {
		if(dif >= 0)
			return true;
		return false;
	}
	
	public void xMove(Point point, boolean xDifRight) {
		if(xDifRight) 
			point.setX(point.getX()+1);
		else
			point.setX(point.getX()-1);
		setPointsInFrame();
	}
	
	public void yMove(Point point, boolean yDifUp) {
		if(yDifUp) 
			point.setY(point.getY()+1);
		else
			point.setY(point.getY()-1);
		setPointsInFrame();
	}
	
	public void setPointsInFrame() {
		resolvesGraphics.setA(triangle.getA());
		resolvesGraphics.setB(triangle.getB());
		resolvesGraphics.setC(triangle.getC());
		frame.getContentPane().add(resolvesGraphics);
		frame.repaint();
	}
	
}