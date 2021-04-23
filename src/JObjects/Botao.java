package JObjects;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Main.Main;

public class Botao {
	private int x,y,w,h,aw,ah;
	private Color cor;
	private String text;
	private boolean mouseOver,mousePressed;
	private int borda;
	private int font;
	public Botao(int x, int y, int w, int h, int aw,int ah, String text, Color cor,int borda,int font) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.aw=aw;
		this.ah=ah;
		this.text=text;
		this.cor=cor;
		this.borda=borda;
		this.font=font;
	}
	public Botao(int x, int y, int w, int h, String text, Color cor,int borda,int font) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.text=text;
		this.cor=cor;
		this.borda=borda;
		this.font=font;
	}
	public void tick() {
		if(Main.menu.clicou) {
			if(Main.menu.mx>x && Main.menu.mx<x+w && Main.menu.my>y && Main.menu.my<y+h) {
					mousePressed=true;
			}	
		}else if(Main.menu.soltou) {
			Main.menu.soltou=false;
			if(Main.menu.mx>x && Main.menu.mx<x+w && Main.menu.my>y && Main.menu.my<y+h) {
					Main.menu.currentOption=0;
			}else {
				Main.menu.soltou=false;
			}	
		}else {
			if(Main.menu.mx>x && Main.menu.mx<x+w && Main.menu.my>y && Main.menu.my<y+h) {
				mouseOver=true;
			}
		}
	}
	public void render(Graphics g) {
		tick();
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.black);
		g.fillRoundRect(x-borda,y-borda, w+borda*2, h+borda*2, aw, ah);
		g.setColor(cor);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
		g.fillRoundRect(x-borda,y-borda, w+borda*2, h+borda*2, aw, ah);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
		g.fillRoundRect(x,y, w, h, aw, ah);
		g.setColor(Color.black);
		if(mousePressed) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
		}else if(mouseOver) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		}else{
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));
		}
		g.fillRoundRect(x,y, w, h, aw, ah);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
		g.setColor(Color.black);
		g.setFont(new Font("arial",Font.BOLD,font));
		g.drawString(text,(x+w/2-text.length()*font/4), y+h/2+5);
		
	}
}
