package pk.edu.nust.seecs.BSCS2.AdvancedProgramming.Assignment01;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

@SuppressWarnings("unused")
public class Stations {
	
	static int Y = 100;			// position of the recquet where it moves...
	private static final int Station_WIDTH = 100;		//width of the Racquet...
	private static final int Station_HEIGHT = 50;		//height of the Racquet...
	static int x = 120;
	int x_axis = 0;
	
	private GUIForAssemblyLineProblem stations;

	public Stations(GUIForAssemblyLineProblem s) {
		
			this.stations= s;
			}
	
	public static void paint(Graphics2D g2d) {
		g2d.setColor(Color.pink);
	
		for(int k=0; k<1200;k=k+120){
		g2d.fillRect(x+k, Y, Station_WIDTH, Station_HEIGHT);
		}
		g2d.setColor(Color.orange);		
		for(int k=0; k<1200;k=k+120){
		g2d.fillRect(x+k, Y+200, Station_WIDTH, Station_HEIGHT);
		}
		
	}

}
