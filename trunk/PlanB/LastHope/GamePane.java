import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;



class GamePane extends JPanel
{
	private Game subject;
	private JLabel title;
	private JButton like;
	private JButton dislike;
	private User user;
	
	public GamePane(Game g, User u)
	{
		user=u;
		subject=g;
		title=new JLabel(subject.getGameTitle());
		like=new JButton("Like");
		dislike=new JButton("Dislike");
		like.addMouseListener(new likeclick());
		dislike.addMouseListener(new dislikeclick());
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(title);
		add(like);
		add(dislike);
		
	}

	private class likeclick implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent arg0) {
		user.addToFavs(subject);
		
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
	private class dislikeclick implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent arg0) {
		user.addToBlist(subject);
		
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
}