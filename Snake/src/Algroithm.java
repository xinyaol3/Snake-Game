import java.awt.Color;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Algroithm {
	List<List<Integer>>body=new ArrayList<>();
	ArrayList<Integer>pos=new ArrayList<>();
	List<Integer>food=new ArrayList<>();
	int score=0;
	public Algroithm() {
		pos.add(15);
		pos.add(13);
		body.add(new ArrayList<>(pos));
		pos.clear();
		pos.add(15);
		pos.add(14);
		body.add(new ArrayList<>(pos));
		pos.clear();
		pos.add(15);
		pos.add(15);
		body.add(new ArrayList<>(pos));
		pos.clear();
		food=getFood();
	}
	public List<Integer> getFood(){
		Random rand=new Random();
		int x=rand.nextInt(27);
		int y=rand.nextInt(30);
		food.add(x);
		food.add(y);
		if(body.contains(food)) {
			getFood();
		}
		return food;
	}
    public void SnakeMoving(GameSet gs,String direction,JButton[][]b) throws Exception {
    	int nextX=0;
    	int nextY=0;
    	//System.out.println(body);
    	if(direction.equals("R")) {
    		nextX=body.get(body.size()-1).get(0);
    		nextY=body.get(body.size()-1).get(1)+1;
    		pos.add(nextX);
    		pos.add(nextY);
    		if(nextY>=b.length||(body.contains(pos)&&(body.get(0).get(0)!=nextX||body.get(0).get(1)!=nextY))) {
    			gs.updateBoard(b,score,true);
    			throw new Exception("GameOver");
    		}
    		else {
    		body.add(new ArrayList<>(pos));
    		if(pos.get(0)!=food.get(0)||pos.get(1)!=food.get(1)) {
    		   body.remove(0);
    		}
    		else {
    			score+=10;
    			food.clear();
    			food=getFood();
    		}
    		pos.clear();
    			for(int i=0;i<27;i++) {
    				for(int j=0;j<30;j++) {
    					pos.add(i);
    					pos.add(j);
    					if(body.contains(pos)||(food.get(0)==i&&food.get(1)==j)) {
    						b[i][j].setBackground(Color.RED);
    					}
    					else {
    						b[i][j].setBackground(Color.BLACK);
    					}
    					pos.clear();
    				}
    			}
    				pos.clear();
    				gs.updateBoard(b,score,false);
    				Thread.sleep(1000);
    				if(b[27][15].getModel().isPressed()) {
    					SnakeMoving(gs,"U",b);
    				}
    				else if(b[29][15].getModel().isPressed()) {
    					SnakeMoving(gs,"D",b);
    				}
    				SnakeMoving(gs,"R",b);
    		}
    	}
    	else if(direction.equals("L")) {
    		nextX=body.get(body.size()-1).get(0);
    		nextY=body.get(body.size()-1).get(1)-1;
    		pos.add(nextX);
    		pos.add(nextY);
    		if(nextY<0||(body.contains(pos)&&(body.get(0).get(0)!=nextX||body.get(0).get(1)!=nextY))) {
    		   gs.updateBoard(b, score, true);
    		   throw new Exception("GameOver");
    		}
    		else {
    		body.add(new ArrayList<>(pos));
    		if(pos.get(0)!=food.get(0)||pos.get(1)!=food.get(1)) {
    		      body.remove(0);
    		}
    		else {
    			score+=10;
    			food.clear();
    			food=getFood();
    		}
    		pos.clear();
    			for(int i=0;i<27;i++) {
    				for(int j=0;j<30;j++) {
    					pos.add(i);
    					pos.add(j);
    					if(body.contains(pos)||(food.get(0)==i&&food.get(1)==j)) {
    						b[i][j].setBackground(Color.RED);
    					}
    					else {
    						b[i][j].setBackground(Color.BLACK);
    					}
    					pos.clear();
    				}
    			}
    				pos.clear();
    				gs.updateBoard(b,score,false);
    				Thread.sleep(1000);
    				if(b[27][15].getModel().isPressed()) {
    					SnakeMoving(gs,"U",b);
    				}
    				else if(b[29][15].getModel().isPressed()) {
    					SnakeMoving(gs,"D",b);
    				}
    				SnakeMoving(gs,"L",b);
    		}
    	}
    	else if(direction.equals("U")) {
    		nextX=body.get(body.size()-1).get(0)-1;
    		nextY=body.get(body.size()-1).get(1);
    		pos.add(nextX);
    		pos.add(nextY);
    		if(nextX<0||(body.contains(pos)&&(body.get(0).get(0)!=nextX||body.get(0).get(1)!=nextY))) {
    		      gs.updateBoard(b, score, true);
    		      throw new Exception("GameOver");
    		}
    		else {
    		body.add(new ArrayList<>(pos));
    		if(pos.get(0)!=food.get(0)||pos.get(1)!=food.get(1)) {
    		       body.remove(0);
    		}
    		else {
    			score+=10;
    			food.clear();
    		    food=getFood();
    		}
    		pos.clear();
    			for(int i=0;i<27;i++) {
    				for(int j=0;j<30;j++) {
    					pos.add(i);
    					pos.add(j);
    					if(body.contains(pos)||(food.get(0)==i&&food.get(1)==j)) {
    						b[i][j].setBackground(Color.RED);
    					}
    					else {
    						b[i][j].setBackground(Color.BLACK);
    					}
    					pos.clear();
    				}
    			}
    				pos.clear();
    				gs.updateBoard(b,score,false);
    				Thread.sleep(1000);
    				if(b[28][14].getModel().isPressed()) {
    					SnakeMoving(gs,"L",b);
    				}
    				else if(b[28][16].getModel().isPressed()) {
    					SnakeMoving(gs,"R",b);
    				}
    				else if(b[29][15].getModel().isPressed()) {
    					SnakeMoving(gs,"D",b);
    				}
    				SnakeMoving(gs,"U",b);
    		}
    	}
    	else if(direction.equals("D")) {
    		nextX=body.get(body.size()-1).get(0)+1;
    		nextY=body.get(body.size()-1).get(1);
    		pos.add(nextX);
    		pos.add(nextY);
    		if(nextX>=27||(body.contains(pos)&&(body.get(0).get(0)!=nextX||body.get(0).get(1)!=nextY))) {
    			gs.updateBoard(b, score, true);
    			throw new Exception("GameOver");
    		}
    		else {
    		body.add(new ArrayList<>(pos));
    		if(pos.get(0)!=food.get(0)||pos.get(1)!=food.get(1))
    		     body.remove(0);
    		else {
    			score+=10;
    			food.clear();
    			food=getFood();
    		}
    		pos.clear();
    			for(int i=0;i<27;i++) {
    				for(int j=0;j<30;j++) {
    					pos.add(i);
    					pos.add(j);
    					if(body.contains(pos)||(food.get(0)==i&&food.get(1)==j)) {
    						b[i][j].setBackground(Color.RED);
    					}
    					else {
    						b[i][j].setBackground(Color.BLACK);
    					}
    					pos.clear();
    				}
    			}
    				pos.clear();
    				gs.updateBoard(b,score,false);
    				Thread.sleep(1000);
    				if(b[28][14].getModel().isPressed()) {
    					SnakeMoving(gs,"L",b);
    				}
    				else if(b[28][16].getModel().isPressed()) {
    					SnakeMoving(gs,"R",b);
    				}
    				else if(b[27][15].getModel().isPressed()) {
    					SnakeMoving(gs,"U",b);
    				}
    				SnakeMoving(gs,"D",b);
    		}
    	}
    }
}
