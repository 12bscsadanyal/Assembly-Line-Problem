package pk.edu.nust.seecs.BSCS2.AdvancedProgramming.Assignment01;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class GUIForAssemblyLineProblem extends JPanel{

	static GUIForAssemblyLineProblem yt = new GUIForAssemblyLineProblem();
	Stations stations = new Stations(this);
	static Car car = new Car(yt);
	int Life = 1;
	public final static AudioClip BackGround =
			Applet.newAudioClip(GUIForAssemblyLineProblem.class.getResource("danyal.wav"));
	@SuppressWarnings("static-access")
	public  void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		car.paint(g2d);
		stations.paint(g2d);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.setColor(Color.black);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		for(int e= 0; e<1500;e=e+120){
			g2d.drawString(""+String.valueOf(Life), 165+e, 100);
			Life++;
		}
		g2d.setColor(Color.black);
		Life=1;
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		for(int e= 0; e<1500;e=e+120){
			g2d.drawString(""+String.valueOf(Life), 165+e, 372);
			Life++;
		}
		Life=1;

	}






	public GUIForAssemblyLineProblem() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String [] args) throws InterruptedException{
		JFrame frame = new JFrame("Assembly Line Problem");
		GUIForAssemblyLineProblem game = new GUIForAssemblyLineProblem();
		frame.add(game);
		frame.setSize(1370, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		int[] a1 = {7 , 9 , 3 , 4 , 8 , 4 , 1 , 1 , 1 , 1};
		int[] a2 = {8 , 5 , 6 , 4 , 5 , 7 , 1 , 1 , 1 , 1};
		int[] t1 = {2 , 3 , 1 , 3 , 4 , 0 , 0 , 0 , 0};
		int[] t2 = {2 , 1 , 2 , 2 , 1 , 0 , 0 , 0 , 0};
		int e1=2,e2=4,x1=3,x2=3,f,l,k;
		int[] f1,f2,l1,l2;
		f1=new int[10];
		f2=new int[10];
		l1=new int[10];
		l2=new int[10];
		f1[0]=e1+a1[0];
		f2[0]=e2+a2[0];
		System.out.println("\n\nAssembly times for stations on line 1");
		System.out.print("Station\t\t:");
		for (int i=0;i<10;i++)
			System.out.print(" "+(i+1));
		System.out.print("\nAssembly Time\t:");
		for(int i=0;i<10;i++)
			System.out.print(" "+a1[i]);
		System.out.println("\n\nAssembly times for stations on line 2");
		GUIForAssemblyLineProblem.BackGround.loop();

		//System.out.println("Assembly times for stations on line 1");
		System.out.print("Station\t\t:");
		for (int i=0;i<10;i++)
			System.out.print(" "+(i+1));
		System.out.print("\nAssembly Time\t:");
		for(int i=0;i<10;i++)
			System.out.print(" "+a2[i]);
		System.out.println();
		
		if(f1[0]<f2[0]){
			l1[0]=1;
		}else{
			l2[0]=2;
		}
		
		for(int j=1;j<10;j++)
		{
			if((f1[j-1]+a1[j]) <=(f2[j-1]+t2[j-1]+a1[j]))
			{
				f1[j]=f1[j-1]+a1[j];
				l1[j]=1;
			}
			else
			{
				f1[j]=f2[j-1]+t2[j-1]+a1[j]; 
				l1[j]=2;
			}
			if((f2[j-1]+a2[j])<=(f1[j-1]+t1[j-1]+a2[j]))
			{
				f2[j]=f2[j-1]+a2[j];
				l2[j]=2;
			}
			else
			{
				f2[j]=f1[j-1]+t1[j-1]+a2[j];
				l2[j]=1;
			}
		}

		if(f1[9]+x1 < f2[9]+x2)
		{
			f=f1[9]+x1;
			l=1;
			l1[0]=1;
		}
		else
		{
			f=f2[9]+x2;
			l=2;
			l2[0]=2;
		}

		System.out.println("\n\n");
		System.out.print("f1\t:");
		for(int i=0;i<10;i++)
			System.out.print(f1[i]+ " ");
		System.out.println();
		System.out.print("f2\t:");
		for(int i=0;i<10;i++)
			System.out.print(f2[i]+ " ");
		System.out.println();
		System.out.println();
		System.out.print("l1\t:");
		for(int i=0;i<10;i++)
			System.out.print(l1[i]+ " ");
		System.out.println();
		System.out.print("l2\t:");
		for(int i=0;i<10;i++)
			System.out.print(l2[i]+ " ");

		System.out.println();
		System.out.println();
		System.out.println("Entry Times e1="+e1+" and e2="+e2);
		System.out.println("Exit Times x1="+x1+" and x2="+x2);
		System.out.println();
		System.out.println("Optimal Time is: "+f);
		System.out.println("Optimal line is: "+l);

		System.out.println("\n\nOptimal Path\n");
		k=l;
		Thread.sleep(5000);
		for(int j=0;j<10;j++)
		{

			if (k==1)
			{
				k=l1[j];
				System.out.println("Line "+k+" Station "+(j+1)+" ");
				if(k==1){
					car.moveOne();
					game.repaint();
					Thread.sleep(2000);

				}else if(k==2){
					car.moveTwo();
					game.repaint();
					Thread.sleep(2000);
				}
			}
			else
			{
				k=l2[j];
				System.out.println("Line "+k+" Station "+(j+1)+" ");
				if(k==2){
				car.moveTwo();
				game.repaint();
				Thread.sleep(2000);

			}else if(k==1){
				car.moveOne();
				game.repaint();
				Thread.sleep(2000);
			}
			}
		}
		//System.out.println();
		
		GUIForAssemblyLineProblem.BackGround.stop();
	}

}
