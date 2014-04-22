import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;


class Libray extends JPanel implements MouseListener
{
	private BufferedImage bg;
	private JPanel searchbar;
	private JTextField searchfeild;
	private JButton searchb;
	private User user;
	private JPanel centerpane;
	private JButton recomendb;
	
	public Libray(User u)
	{
		user=u;
		centerpane=new JPanel();
		recomendb=new JButton("Recomend!");
		
		try {
			bg=ImageIO.read(new File("background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setLayout(new BorderLayout());
		searchbar=new JPanel();
		searchbar.setLayout(new BoxLayout(searchbar, BoxLayout.LINE_AXIS));

		searchfeild=new JTextField();
		searchb=new JButton("Search");
		searchb.addMouseListener(this);
		
		searchbar.add(searchfeild);
		searchbar.add(searchb);
		
		add(searchbar, BorderLayout.NORTH);
		centerpane.setLayout(new GridLayout(10, 1, 0, 0));
		
		add(centerpane, BorderLayout.CENTER);
		/*centerpane.add(new GamePane(new Game(1)));
		centerpane.add(new GamePane(new Game(1)));
		centerpane.add(new GamePane(new Game(1)));
		centerpane.add(new GamePane(new Game(1)));
		centerpane.add(new GamePane(new Game(1)));
		centerpane.add(new GamePane(new Game(1)));
		centerpane.add(new GamePane(new Game(1)));
		centerpane.add(new GamePane(new Game(1)));
		centerpane.add(new GamePane(new Game(1)));
		centerpane.add(new GamePane(new Game(1)));*/
		centerpane.setVisible(false);
		
		
		
	}
	
	protected void paintComponent(Graphics g)
	{

	    super.paintComponent(g);
	    g.drawImage(bg, 0, 0, null);
	    
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		centerpane.setVisible(false);
		LinkedList<Game> gl=Searcher.gameSearch(searchfeild.getText(), user.getAcceptedPlatforms());
		centerpane.removeAll();
		searchfeild.setText("Searching....");
		if(gl.size()>=10)
			for(int i=0; i<10;i++)
			{
				centerpane.add(new GamePane(gl.get(i), user));
			}
		else
			for(int i=0; i<gl.size();i++)
			{
				centerpane.add(new GamePane(gl.get(i), user));
			}
		searchfeild.setText("Done!");
		centerpane.setVisible(true);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}