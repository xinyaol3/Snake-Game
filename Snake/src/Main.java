import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) throws Exception {
		JPanel grid=new JPanel();
        grid.setLayout(new GridLayout(30, 30));
	    JButton[][]b=new JButton[30][30];
         GameSet gs=new GameSet(b);
         Algroithm al=new Algroithm();
         gs.boardSet(b);
         al.SnakeMoving(gs, "R", b);
        
	}
}
