
public class ConstructPoints {
	
	private RandomAlgorithm animationAlgorithm;
	private int xBound;
	private int yBound;
	
	public ConstructPoints(int xBound, int yBound, int sleepTime) throws InterruptedException {
		this.xBound = xBound;
		this.yBound = yBound;
		animationAlgorithm = new RandomAlgorithm(xBound, yBound, sleepTime);
		startRunning();
	}
	
	public void startRunning() throws InterruptedException {
		while(true) {
			animationAlgorithm.getTriangle().setD(new Point((int) (Math.random()*xBound), (int) (Math.random()*yBound)));
			while(pointDEqualToAnotherPoint())
				animationAlgorithm.getTriangle().setD(new Point((int) (Math.random()*xBound), (int) (Math.random()*yBound)));
			System.out.println(animationAlgorithm.getTriangle().toString());
			animationAlgorithm.move(animationAlgorithm.getTriangle().getPoints()[(int) (Math.random()*3)]);
			System.out.println(animationAlgorithm.getTriangle().toString()+"\n\nNEW\n\n");
		}
			
	}
	
	public boolean pointDEqualToAnotherPoint() {
		for(int i = 0; i<3; i++)
			if(animationAlgorithm.getTriangle().getD().getX() == animationAlgorithm.getTriangle().getPoints()[i].getX() && animationAlgorithm.getTriangle().getD().getY() == animationAlgorithm.getTriangle().getPoints()[i].getY())
				return true;
		return false;
	}
	
}
