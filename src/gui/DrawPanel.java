package gui;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public static int N = 16, w = 565;
	DrawPanel(){
		super();
		
	}
	
	public void paint(Graphics g){
		for(Component comp:getComponents()){
			comp.paint(g);
		}
	}	
	
	public void reDraw(int x, int y, int n){
		DrawPanel.N = n;
		removeAll();
		if(n == 2){
			fillPart(0, 0,1,1,x,y,2);
		}
		else fillPart(0,0,n-1,n-1,x,y,n);
		validate();
		updateUI();
		
	}
	
	public void fillPart(int kx, int ky,int vx,int vy,int x,int y,int n){
		if(2 == vx-kx+1){
			if(x == kx && y == ky){
				add(new Mozaik(3,x+1,y+1));
			}else if(vx == x && vy == y){
				add(new Mozaik(1,x-1,y-1));
			}else if(kx == x && vy == y){
				add(new Mozaik(2,x+1,y-1));
			}else if(vx == x && ky == y){
				add(new Mozaik(0,x-1,y+1));
			}
		}else{
			int size = (vx-kx+1)/2;
			if(x == kx && y == ky){
				add(new Mozaik(3,kx+size,ky+size));
				fillPart(kx,ky,kx+size-1,ky+size-1,kx,ky,size);
				fillPart(kx+size,ky,vx,ky+size-1,kx+size,ky+size-1,size);
				fillPart(kx,ky+size,kx+size-1,vy,kx+size-1,ky+size,size);
				fillPart(kx+size,ky+size,vx,vy,kx+size,ky+size,size);
			}else if(vx == x && vy == y){
				add(new Mozaik(1,kx+size-1,ky+size-1));
				fillPart(kx,ky,kx+size-1,ky+size-1,kx+size-1,ky+size-1,size);
				fillPart(kx+size,ky,vx,ky+size-1,kx+size,ky+size-1,size);
				fillPart(kx,ky+size,kx+size-1,vy,kx+size-1,ky+size,size);
				fillPart(kx+size,ky+size,vx,vy,vx,vy,size);
			}else if(kx == x && vy == y){
				add(new Mozaik(2,kx+size,ky+size-1));
				fillPart(kx,ky,kx+size-1,ky+size-1,kx+size-1,ky+size-1,size);
				fillPart(kx+size,ky,vx,ky+size-1,kx+size,ky+size-1,size);
				fillPart(kx,ky+size,kx+size-1,vy,kx,vy,size);
				fillPart(kx+size,ky+size,vx,vy,kx+size,ky+size,size);
			}else if(vx == x && ky == y){
				add(new Mozaik(0,kx+size-1,ky+size));
				fillPart(kx,ky,kx+size-1,ky+size-1,kx+size-1,ky+size-1,size);
				fillPart(kx+size,ky,vx,ky+size-1,vx,ky,size);
				fillPart(kx,ky+size,kx+size-1,vy,kx+size-1,ky+size,size);
				fillPart(kx+size,ky+size,vx,vy,kx+size,ky+size,size);
			}else if(x<kx+size && y< ky+size){
				add(new Mozaik(3,kx+size,ky+size));
				fillPart(kx,ky,kx+size-1,ky+size-1,x,y,size);
				fillPart(kx+size,ky,vx,ky+size-1,kx+size,ky+size-1,size);
				fillPart(kx,ky+size,kx+size-1,vy,kx+size-1,ky+size,size);
				fillPart(kx+size,ky+size,vx,vy,kx+size,ky+size,size);
			}else if(x>=kx+size && y< ky+size){
				add(new Mozaik(0,kx+size-1,ky+size));
				fillPart(kx,ky,kx+size-1,ky+size-1,kx+size-1,ky+size-1,size);
				fillPart(kx+size,ky,vx,ky+size-1,x,y,size);
				fillPart(kx,ky+size,kx+size-1,vy,kx+size-1,ky+size,size);
				fillPart(kx+size,ky+size,vx,vy,kx+size,ky+size,size);
			}else if(x <kx+size && y>= ky+size){
				add(new Mozaik(2,kx+size,ky+size-1));
				fillPart(kx,ky,kx+size-1,ky+size-1,kx+size-1,ky+size-1,size);
				fillPart(kx+size,ky,vx,ky+size-1,kx+size,ky+size-1,size);
				fillPart(kx,ky+size,kx+size-1,vy,x,y,size);
				fillPart(kx+size,ky+size,vx,vy,kx+size,ky+size,size);
			}else if(x >=kx+size && y>= ky+size){
				add(new Mozaik(1,kx+size-1,ky+size-1));
				fillPart(kx,ky,kx+size-1,ky+size-1,kx+size-1,ky+size-1,size);
				fillPart(kx+size,ky,vx,ky+size-1,kx+size,ky+size-1,size);
				fillPart(kx,ky+size,kx+size-1,vy,kx+size-1,ky+size,size);
				fillPart(kx+size,ky+size,vx,vy,x,y,size);
			}
		}
	}
	
	public void setN(int n){
		DrawPanel.N = n;
	}
}
