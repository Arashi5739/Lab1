package Lab1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class outputG
{
   public void showG()
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new SizedFrame();
               frame.setTitle("outputG");
               frame.setVisible(true);
            }
         });
   }
}

class SizedFrame extends JFrame
{
	public static final int TEXTAREA_ROWS = 30;
	public static final int TEXTAREA_COLUMNS = 40;
	public SizedFrame()
	   {
		final JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
	      JScrollPane scrollPane = new JScrollPane(textArea);

	      add(scrollPane, BorderLayout.CENTER);
		 JPanel southPanel = new JPanel();

	      JButton insertButton = new JButton("CreateGraph");
	      southPanel.add(insertButton);
	      insertButton.addActionListener(new ActionListener()
	         {
	            public void actionPerformed(ActionEvent event)
	            {
	            	Main main = new Main();
	            	EdgeWeightDiGraph g = main.g;
	            	textArea.append(g.showDirectedGraph());
	            }
	         });

	      add(southPanel, BorderLayout.SOUTH);
	      pack();
	   }
}
