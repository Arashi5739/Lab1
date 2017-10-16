package Lab1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ButtonTest
{
   public void GUI()
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new ButtonFrame();
               frame.setTitle("ButtonTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
      
   }
}
class ButtonFrame extends JFrame
{
   private JPanel buttonPanel;
   private static final int DEFAULT_WIDTH = 320;
   private static final int DEFAULT_HEIGHT = 500;

   public ButtonFrame()
   {      
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // create buttons
      JButton igButton = new JButton("creategraph");
      JButton sgButton = new JButton("showgraph");
      JButton fbButton = new JButton("findbridge");
      JButton fnButton = new JButton("findnewtext");
      JButton spButton = new JButton("shortestpath");
      JButton rwButton = new JButton("randomwalk");

      buttonPanel = new JPanel();

      // add buttons to panel
      buttonPanel.add(igButton);
      buttonPanel.add(sgButton);
      buttonPanel.add(fbButton);
      buttonPanel.add(fnButton);
      buttonPanel.add(spButton);
      buttonPanel.add(rwButton);
            // button action: switch to the new look and feel

      add(buttonPanel);
      
      ButtonAction ig = new ButtonAction(1);
      igButton.addActionListener(ig);
      
      ButtonAction sg = new ButtonAction(2);
      sgButton.addActionListener(sg);
      
      ButtonAction fb = new ButtonAction(3);
      fbButton.addActionListener(fb);
      
      ButtonAction fn = new ButtonAction(4);
      fnButton.addActionListener(fn);
      
      ButtonAction sp = new ButtonAction(5);
      spButton.addActionListener(sp);
      
      ButtonAction rw = new ButtonAction(6);
      rwButton.addActionListener(rw);
      //look and feel
      String plaf = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
      try
      {
    	  UIManager.setLookAndFeel(plaf);
    	  SwingUtilities.updateComponentTreeUI(ButtonFrame.this);
    	  //pack();
      }
      catch (Exception e)
      {
    	  e.printStackTrace();
      }
   }

class ButtonAction implements ActionListener
 {
	int f;
	public ButtonAction(int i)
     {
         f = i;
     }
	public void actionPerformed(ActionEvent event)
    {
       //buttonPanel.setBackground();
		switch (f)
		{
		case 1:
			outputG og = new outputG();
			og.showG();
			Graph sg = new Graph();
			sg.showG();
			break;
		case 2:
			outputP s = new outputP();
			s.sp();
			break;
		case 3:
			outputB fb = new outputB();
			fb.showB();
			break;
		case 4:
			outputN fn = new outputN();
			fn.showN();
			break;
		case 5:
			outputS sp = new outputS();
			sp.showS();
			break;
		case 6:
			outputR rw = new outputR();
			rw.showR();
			randomWalk r = new randomWalk();
			try{
				r.write();
			} catch (Exception e) {
			}
			break;
		default:
			break;
				
		}
    }
 }
}