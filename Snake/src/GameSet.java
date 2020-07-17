import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameSet {
    public JButton[][]b;
    JFrame f=new JFrame();
    JPanel grid=new JPanel();
    public GameSet(JButton[][]b) {
    	this.b=b;
    	grid.setLayout(new GridLayout(30, 30));
    }
    public void boardSet(JButton[][]b) {
        for (int i = 0; i < 30; i++) {
            for (int n = 0; n < 30; n++) {
            	JButton x=new JButton();
            	 if(i<27) {
            		x.setBackground(Color.BLACK);
            		x.setEnabled(false);
            		grid.add(x);
            		b[i][n]=x;
            	}
            	else if(i==27&&n==15) {
            		x.setText("U");
            		grid.add(x);
            		b[i][n]=x;
            	}
            	else if(i==28&&n==14) {
            		x.setText("L");
            		grid.add(x);
            		b[i][n]=x;
            	}
            	else if(i==28&&n==16) {
            		x.setText("R");
            		grid.add(x);
            		b[i][n]=x;
            	}
            	else if(i==29&&n==15) {
            		x.setText("D");
            		grid.add(x);
            		b[i][n]=x;
            	}
            	else {
                grid.add(x);
                b[i][n]=x;
            	}
            }
        }
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(grid);
        f.setTitle("Your Score is: "+0);
        f.pack();
        f.setVisible(true);
    }
    public void updateBoard(JButton[][]b,int score,boolean finish) {
    	for(int i=0;i<30;i++) {
    		for(int j=0;j<30;j++) {
    			grid.add(b[i][j]);
    		}
    	}
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(grid);
        if(finish) {
        	f.setTitle("Game Over :< Your Score is: "+score);
        }
        else {
        f.setTitle("Your Score is: "+score);
        }
        f.pack();
        f.setVisible(true);
    }
}
