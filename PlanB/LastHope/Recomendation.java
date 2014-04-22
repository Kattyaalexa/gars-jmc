import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;



class Recomendation extends JPanel
{
	private BufferedImage bg;
	JLabel Publisher;
	public Recomendation()
	{
		
	
	}
	public void display(User user)
	{
		Recommender recs=new Recommender(user);
	
		recs.recomend();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		try{
		JButton header = new JButton("Your Top Recomendation");
		JLabel gtitle=new JLabel("Title: "+recs.getRecomendation().getGameTitle());
		gtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel pform=new JLabel("Platform: "+recs.getRecomendation().getPlatform());
		pform.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel genera=new JLabel("Genera: "+recs.getRecomendation().getGenera()[0]);
		genera.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel Publisher=new JLabel("Publisher: "+recs.getRecomendation().getPublisher());
		Publisher.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		header.setEnabled(false);
		header.setForeground(Color.BLACK);
		header.setBackground(Color.WHITE);
		header.setAlignmentY(Component.TOP_ALIGNMENT);
		header.setFont(new Font("Tahoma", Font.BOLD, 23));
		header.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(header);
		add(gtitle);
		add( pform);
		add(genera);
		}
		catch(Exception e)
		{
			Publisher=new JLabel(e.getLocalizedMessage());
		}
		add(Publisher);
		try {
			bg=ImageIO.read(new File("background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void paintComponent(Graphics g)
	{

	    super.paintComponent(g);
	    g.drawImage(bg, 0, 0, null);
	    
	}
}