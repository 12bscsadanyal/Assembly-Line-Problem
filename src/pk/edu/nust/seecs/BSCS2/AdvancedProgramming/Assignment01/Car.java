package pk.edu.nust.seecs.BSCS2.AdvancedProgramming.Assignment01;
import java.awt.Color;
import java.awt.Graphics2D;

public class Car {
	
	@SuppressWarnings("unused")
	private GUIForAssemblyLineProblem car;

	public Car(GUIForAssemblyLineProblem s) {
		
		this.car= s;
		}

	
	static int Y = 200;			
	private static final int Station_WIDTH = 50;		
	private static final int Station_HEIGHT = 50;		
	static int x = 20;
	int x_axis = 0;
	

	public void paint(Graphics2D g2d) {
		g2d.setColor(Color.blue);
		g2d.fillRect(x, Y, Station_WIDTH, Station_HEIGHT);
		
	}
	
	void move() throws InterruptedException {
		Y=150;
		x = 120;
		//System.out.println("x = "+x);
	}
	
	void movezero() throws InterruptedException {
		Y=150+100;
		x = 120;
		//System.out.println("x = "+x);
	}
	
	void moveOne() throws InterruptedException {
		Y=150;
		x = x+ 120;
		//System.out.println("x = "+x);
	}
	
	void moveTwo() throws InterruptedException {
		Y=250;
		x = x + 120;
		//System.out.println("x = "+x);
	}
}
