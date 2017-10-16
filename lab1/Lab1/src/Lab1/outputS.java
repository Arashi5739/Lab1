package Lab1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class outputS
{
   public void showS()
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new PathComponentFrame();
               frame.setTitle("TextComponentTest");
               //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}
class PathComponentFrame extends JFrame
{
   public static final int TEXTAREA_ROWS = 8;
   public static final int TEXTAREA_COLUMNS = 20;

   public PathComponentFrame()
   {
      final JTextField Field1 = new JTextField();
      final JTextField Field2 = new JTextField();

      JPanel northPanel = new JPanel();
      northPanel.setLayout(new GridLayout(2, 2));
      northPanel.add(new JLabel("word1: ", SwingConstants.RIGHT));
      northPanel.add(Field1); 
      northPanel.add(new JLabel("word2: ", SwingConstants.RIGHT));
      northPanel.add(Field2);

      add(northPanel, BorderLayout.NORTH);

      final JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
      JScrollPane scrollPane = new JScrollPane(textArea);

      add(scrollPane, BorderLayout.CENTER);

      // add button to append text into the text area

      JPanel southPanel = new JPanel();

      JButton insertButton = new JButton("Finish");
      southPanel.add(insertButton);
      insertButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
            	Main main = new Main();
            	EdgeWeightDiGraph g = main.g;
            	textArea.append(main.calcShortestPath(Field1.getText(), Field2.getText()));
            }
         });

      add(southPanel, BorderLayout.SOUTH);
      pack();
   }
}


