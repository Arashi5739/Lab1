package Lab1;

import java.awt.*;
import javax.swing.*;

public class outputP
{
	public  void sp()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new ImageFrame();
				frame.setTitle("ImageTest");
				frame.setVisible(true);
            }
        });
	}
}

class ImageFrame extends JFrame
{
	public ImageFrame()
	{
		add(new ImageComponent());
		pack();
	}
}

class ImageComponent extends JComponent
{
	Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
	private  final int DEFAULT_WIDTH = screenSize.width/2;
	private  final int DEFAULT_HEIGHT =  screenSize.height;

	private Image image;

	public ImageComponent()
	{
		image = new ImageIcon("C:\\Users\\zipeng\\Desktop\\pic\\dotGif.gif").getImage();
	}

	public void paintComponent(Graphics g)
	{
		if (image == null) return;
		g.drawImage(image, 0, 0, null);   
	}
   
	public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}

