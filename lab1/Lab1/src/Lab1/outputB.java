package Lab1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class outputB
{
   public void showB()
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new TextComponentFrame();
               frame.setTitle("TextComponentTest");
               frame.setVisible(true);
            }
         });
   }
}
class TextComponentFrame extends JFrame
{
   public static final int TEXTAREA_ROWS = 8;
   public static final int TEXTAREA_COLUMNS = 20;

   public TextComponentFrame()
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

      JPanel southPanel = new JPanel();

      JButton insertButton = new JButton("Finish");
      southPanel.add(insertButton);
      insertButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
            	BridgeWords BW = new BridgeWords();
            	textArea.append(BW.queryBridgeWords(Field1.getText(), Field2.getText()));
            }
         });

      add(southPanel, BorderLayout.SOUTH);
      pack();
   }
}


