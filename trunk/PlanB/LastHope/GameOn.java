import java.applet.Applet;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class GameOn extends Applet
{
	
	

	/**
	 * 
	 */
	private JButton recomendb;
	private JButton loginb;
	private static final long serialVersionUID = 1L;
	private LoginScreen login;
	private Libray search;
	private User user;
	private Recomendation reco;
	private CardLayout cl;
	private GameOn current;
	private JButton reset;
	public void init()
	{
		user=new User();
		cl=new CardLayout(0, 0);
		setSize(400,600);
		setLayout(cl);
		login=new LoginScreen();
		loginb=new JButton("login");
		loginb.addMouseListener(new loginclick());
		login.add(loginb);
		search=new Libray(user);
		recomendb=new JButton("Recomend!");
		search.add(recomendb, BorderLayout.SOUTH);
		reco=new Recomendation();
		recomendb.addMouseListener(new recoclick());
		reset=new JButton("Reset");
		reset.addMouseListener(new resetclick());
		current=this;
		
		
		add(login,"login");
		add(reco, "reco");
		add(search, "search");
		
		
	}
	private class loginclick implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
		   cl.show(current, "search");
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	private class recoclick implements MouseListener
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				 reco.display(user);
				 reco.add(reset);
	
				 cl.show(current, "reco");
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		
	}
	
	private class resetclick implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			 cl.show(current, "login");
			 user=new User();
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
}

}

