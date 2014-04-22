import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.Color;



class LoginScreen extends JPanel
{

	/**
	 * 
	 */
	private BufferedImage bg;
	private BufferedImage logopic;
	private JLabel logo;
	private JTextField uname;
	private JPasswordField pword;
	
	
	private static final long serialVersionUID = 1L;
	
	public LoginScreen()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		logo=new JLabel();
		uname=new JTextField();
		
		uname.setText("UserName");
		pword=new JPasswordField();
		pword.setText("Password");
		pword.setMinimumSize(new Dimension(50, 10));
		pword.setMaximumSize(new Dimension(150, 22));
		uname.setMinimumSize(new Dimension(50, 10));
		uname.setMaximumSize(new Dimension(150, 22));
		logo.setAlignmentX(Component.CENTER_ALIGNMENT);
		logo.setVerticalAlignment(SwingConstants.TOP);
		uname.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pword.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setSize(400, 600);
		
		
		try 
		{
			
			bg=ImageIO.read(new File("background.png"));
			logopic=ImageIO.read(new File("logo.png"));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		logo.setIcon(new ImageIcon( logopic));
		this.add(logo);
		this.add(uname);

		this.add(pword);
	}
	
	
	@Override
	 protected void paintComponent(Graphics g)
	{

	    super.paintComponent(g);
	    g.drawImage(bg, 0, 0, null);
	    
	}
	
}