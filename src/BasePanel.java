import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BasePanel extends JPanel implements MouseListener {

	public BasePanel() {
		setLayout(new GridLayout(2, 5, 0, 0));
	}
	
	 
		 
	 @Override
	public  void mouseClicked(MouseEvent e)
	 {
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
