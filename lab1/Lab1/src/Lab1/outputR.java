package Lab1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class outputR
{
   public void showR()
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new RandomFrame();
               frame.setTitle("outputR");
               //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

class RandomFrame extends JFrame
{
	public static final int TEXTAREA_ROWS = 20;
	public static final int TEXTAREA_COLUMNS = 40;
	public RandomFrame()
	   {
		final JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
	      JScrollPane scrollPane = new JScrollPane(textArea);

	      add(scrollPane, BorderLayout.CENTER);
		 JPanel southPanel = new JPanel();

	      JButton insertButton = new JButton("RandomWalk");
	      southPanel.add(insertButton);
	      insertButton.addActionListener(new ActionListener()
	         {
	            public void actionPerformed(ActionEvent event)
	            {
	            	randomWalk a = new randomWalk();
	            	textArea.append(a.randomWalk());
	            }
	         });

	      add(southPanel, BorderLayout.SOUTH);
	      pack();
	   }
}
