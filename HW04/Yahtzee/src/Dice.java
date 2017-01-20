import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * In this class the JFrame is created
 * When you click the STOP button the 6 dice are set to true and stop
 * *need to add start button!
 * @author zgoold17
 *
 */

public class Dice {
	//main
	public static void main(String[] args){
		Dice dice = new Dice();
	}	
	//variables to stop the dice, create the threads
	public static boolean stopDice = false;
	Threads[] thread2 = new Threads[5];
	//create JFrame
	public Dice(){
		JFrame frame = new JFrame();
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		//BUTTON
		JButton button = new JButton("STOP");
		frame.add(button);
		
		
		//5 threads and 5 labels
		for (int i = 0; i < 5; i++){
			JLabel l1 = new JLabel();
			thread2[i] = new Threads(l1);
			frame.add(l1);
		}
		
		
		//what happens when clicked on button
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (stopDice == false){
					stopDice = true;
				}
			}
		});
	
		
		//threads
		Thread[] thread1 = new Thread[5];
		for (int i = 0; i < 5; i++){
			thread1[i] = new Thread(thread2[i]);
			thread1[i].start();
			
			try{
				Thread.sleep(100);
			} catch (InterruptedException ex) {System.out.println("UT OH");}
		}	
		//LET THERE BE LIGHT
		frame.setVisible(true);
	}
	

	
	
}
