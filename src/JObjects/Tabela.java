package JObjects;

import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.Main;

public class Tabela {
	private int x, y, w, h;
	private String text;
	private boolean template = true;
	private String newText = "";
	private String textoSenha = "";
	private boolean mouseOver, clicou, clicouDentro;
	private int frames = 0, frames2 = 0;
	private int mx, my;
	private boolean senha;
	private int maxSize = 10;

	public Tabela(int x, int y, int w, int h, String text) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.text = text;
	}
	public void set(String text) {
		template=false;
		if (senha) {
			for(int i=text.length();i>0;i--) {
				textoSenha += "*";
			}
		}
		newText = text;
		
	}
	public String getTexto() {
		String newText1="";
		if(senha) {
			char[] trans=newText.toCharArray();
			for(int i=0;i<trans.length;i++) {
				trans[i]=(char) (trans[i]+10);
			}
			for(int i=0;i<trans.length;i++) {
				newText1=newText1+trans[i];
			}
			return newText1;
		}
		return newText;
	}
	public void setSenha() {
		senha = true;
	}

	public void setSize(int newSize) {
		maxSize = newSize;
	}

	public boolean mouseOver() {
		return mouseOver;
	}

	public void removeLetra() {
		newText = newText.substring(0, newText.length() - 1);
		textoSenha = textoSenha.substring(0, textoSenha.length() - 1);
	}

	public void addLetra(String letra) {
		if (newText.length() < maxSize) {
			if (senha) {
				textoSenha = textoSenha + "*";
			}
			newText = newText + letra;
		}
	}

	public boolean clicou() {
		return clicou;
	}
	public void clicar() {
		clicou = true;
		template = false;
	}

	public void desclicar() {
		clicou = false;
		if (newText == "") {
			template = true;
		}
	}

	public void tick() {
		frames++;
		if (frames >= 26) {
			frames = 0;
			frames2++;
			if (frames2 >= 2) {
				frames2 = 0;
			}
		}
		mx = Main.menu.getMouseX();
		my = Main.menu.getMouseY();
		if (Main.menu.pressionou()) {
			if (mx > x - 12 && mx < x + w && my > y - 9 && my < y + h) {
				clicouDentro = true;
			}
		}
		if (Main.menu.soltou()) {
			// soltou
			if (mx > x - 12 && mx < x + w && my > y - 9 && my < y + h) {
				// dentro
				if (clicouDentro) {
					clicouDentro = false;
					template = false;
					mouseOver = true;
					clicou = true;
				}
			} else {
				// fora
				mouseOver = false;
				if (newText == "") {
					template = true;
				} else {
					clicou = false;
				}

			}

		} else {
			// so movendo
			if (mx > x - 12 && mx < x + w && my > y - 19 && my < y + h) {
				// mouse em cima
				mouseOver = true;
			} else {
				// fora
				mouseOver = false;
			}
		}

	}

	public void render(Graphics g) {
		tick();
		int borda = 1;
		g.setColor(Color.black);
		g.fillRect(x - borda, y - borda, w + borda * 2, h + borda * 2);
		g.setColor(Color.white);
		g.fillRect(x, y, w, h);
		if (template) {
			g.setColor(Color.gray);
			g.setFont(new Font("arial", Font.BOLD, 13));
			g.drawString(text, x + 3, y + 13);
		} else {
			g.setColor(Color.black);
			g.setFont(new Font("arial", Font.BOLD, 13));
			if (senha) {
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString(textoSenha, x + 3, y + 18);
			} else {
				g.drawString(newText, x + 3, y + 13);
			}
			if (clicou) {
				if (frames2 == 1) {
					g.setFont(new Font("arial", Font.BOLD, 13));
					g.drawString("|", x + 3 + newText.length() * 7, y + 12);
				}
			}
		}

	}

}
