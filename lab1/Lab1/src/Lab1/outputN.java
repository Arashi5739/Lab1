package Lab1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class outputN
{
   public void showN()
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new NewtextComponentFrame();
               frame.setTitle("TextComponentTest");
               //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

class NewtextComponentFrame extends JFrame
{
   public static final int TEXTAREA_ROWS = 8;
   public static final int TEXTAREA_COLUMNS = 20;

   public NewtextComponentFrame()
   {
      final JTextField textField = new JTextField();

      JPanel northPanel = new JPanel();
      northPanel.setLayout(new GridLayout(1, 2));
      northPanel.add(new JLabel("New text: ", SwingConstants.RIGHT));
      northPanel.add(textField);

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
            	NewText NT = new NewText();
            	String s = NT.generateNewText(textField.getText());
            	textArea.append(s);
            }
         });

      add(southPanel, BorderLayout.SOUTH);
      pack();
   }
}




