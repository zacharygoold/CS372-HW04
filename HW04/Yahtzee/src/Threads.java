import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.util.Random;

/**
 * Threads creates all of the pictures and asigns them to imageIcons to 
 * be randomized and picked
 * Also contains Runnable
 * @author zgoold17
 *
 */


public class Threads implements Runnable{
	private JLabel label;
	Image i1 ,i2, i3, i4, i5, i6;
	ImageIcon ii1, ii2, ii3, ii4, ii5, ii6;
	int count = 0;
	public static int[] counters = new int[5];
	
	public Threads(JLabel label){
		try{
			URL url1 = new URL ("http://www.wpclipart.com/recreation/games/dice/die_face_1.png");
			URL url2 = new URL ("http://www.wpclipart.com/recreation/games/dice/die_face_2.png");
			URL url3 = new URL ("http://www.wpclipart.com/recreation/games/dice/die_face_3.png");
			URL url4 = new URL ("http://www.wpclipart.com/recreation/games/dice/die_face_4.png");
			URL url5 = new URL ("http://www.wpclipart.com/recreation/games/dice/die_face_5.png");
			URL url6 = new URL ("http://www.wpclipart.com/recreation/games/dice/die_face_6.png");
			//get images from URL
			Image i1 = Toolkit.getDefaultToolkit().getImage(url1);
			Image i2 = Toolkit.getDefaultToolkit().getImage(url2);
			Image i3 = Toolkit.getDefaultToolkit().getImage(url3);
			Image i4 = Toolkit.getDefaultToolkit().getImage(url4);
			Image i5 = Toolkit.getDefaultToolkit().getImage(url5);
			Image i6 = Toolkit.getDefaultToolkit().getImage(url6);
			//Scale them all the same so that they match
			i1 = i1.getScaledInstance(50,50, Image.SCALE_DEFAULT);
			i2 = i2.getScaledInstance(50,50, Image.SCALE_DEFAULT);
			i3 = i3.getScaledInstance(50,50, Image.SCALE_DEFAULT);
			i4 = i4.getScaledInstance(50,50, Image.SCALE_DEFAULT);
			i5 = i5.getScaledInstance(50,50, Image.SCALE_DEFAULT);
			i6 = i6.getScaledInstance(50,50, Image.SCALE_DEFAULT);
			//put them into icons so they are easily placed
			ii1 = new ImageIcon (i1);
			ii2 = new ImageIcon (i2);
			ii3 = new ImageIcon (i3);
			ii4 = new ImageIcon (i4);
			ii5 = new ImageIcon (i5);
			ii6 = new ImageIcon (i6);
			
			this.label = label;
			
		} catch (Exception ex){System.out.println("UT OH");;}
	}

	/**
	 * @param Runnable
	 * randomizes a number and increments count every time the dice is stopped
	 */
	public void run(){
		ImageIcon icons[] = {ii1, ii2, ii3, ii4, ii5, ii6};
		Random rnd = new Random();
		int i = 0;
		
		while (Dice.stopDice == false){
			i = rnd.nextInt(6);
			label.setIcon(icons[i]);
			count = i + 1;
			try{
				Thread.sleep(100);
			} catch (InterruptedException ex) {System.out.println("UT OH");}
		}
		
	}
	
}
