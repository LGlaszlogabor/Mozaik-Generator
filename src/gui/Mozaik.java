package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Mozaik extends JComponent{
	private static final long serialVersionUID = 1L;
	private int type, x, y;
	Mozaik(int type, int x, int y){
		this.type = type;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0);
		if(type == 0){			
			drawSquare(x, y, arg0, Color.GREEN);
			drawSquare(x, y-1, arg0, Color.GREEN);
			drawSquare(x+1, y, arg0, Color.GREEN);
		}else if(type == 1){
			drawSquare(x, y, arg0, Color.RED);
			drawSquare(x+1, y, arg0, Color.RED);
			drawSquare(x, y+1, arg0, Color.RED);
		}else if(type == 2){
			drawSquare(x, y, arg0, Color.BLUE);
			drawSquare(x-1, y, arg0, Color.BLUE);
			drawSquare(x, y+1, arg0, Color.BLUE);
		}else if(type == 3){
			drawSquare(x, y, arg0, Color.YELLOW);
			drawSquare(x-1, y, arg0, Color.YELLOW);
			drawSquare(x, y-1, arg0, Color.YELLOW);
		}		
	}
	
	private void drawSquare(int x, int y, Graphics g,Color c){
		int size = 565/(DrawPanel.N+2);
		int absX = x*size, absY = y*size;
		g.setColor(c);
		g.fillRect(absX,absY,size,size);
		g.setColor(Color.BLACK);
		g.drawRect(absX,absY,size,size);			
	}
}
