package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import JObjects.Botao;
import Main.Main;

public class Menu {
	private Login login =new Login();
	private Color Standart;
	private Color MouseOver;
	private Color Pressed;
	private Color beje;
	String state="Login";
	private Botao cadastrar=new Botao(100,50, 97, 20,"Cadastrar", Color.white,2,15);
	private Botao buscar=new Botao(220,50, 97, 20,"Buscar", Color.white,2,15);
	private Botao sair=new Botao(550,300, 97, 20,"Sair", Color.white,2,15);
	private int mx,my;
	private boolean pressionou,soltou,moveu;
	public Menu() {
		Main.botoes.add(cadastrar);
		Main.botoes.add(buscar);
		Main.botoes.add(sair);
	}
	public void mover() {
		moveu=true;
		soltou=false;
	}
	public void soltar() {
		pressionou=false;
		soltou=true;
	}
	public void pressionar() {
		pressionou=true;
		moveu=false;
	}
	public boolean pressionou() {
		return pressionou;
	}
	public boolean moveu() {
		return moveu;
	}
	public boolean soltou() {
		return soltou;
	}
	public void setMouse(int mx, int my) {
		this.mx=mx;
		this.my=my;
	}
	public int getMouseX() {
		return mx;
	}
	public int getMouseY() {
		return my;
	}
	public static void applySave(String str){
		String[] spl=str.split("/");
		for(int i=0; i< spl.length; i++) {
			String[] spl2= spl[i].split(":");
			switch(spl2[0]) {
			case "level":
				Main.gameState="NORMAL";
				break;
			}
		}
	}
	public static String loadGame(int encode) {
		String line= "";
		File file = new File("save.txt");
		if(file.exists()) {
			try {
				String singleLine=null;
				BufferedReader reader=new BufferedReader(new FileReader("save.txt"));
				try {
					while((singleLine=reader.readLine())!=null) {
						String[] trans=singleLine.split(":");
						char[] val=trans[1].toCharArray();
						trans[1]="";
						for(int i=0; i<val.length;i++) {
							val[i]-=encode;
							trans[1]+=val[i];
						}
						line+=trans[0];
						line+=":";
						line+=trans[1];
						line+="/";
					}
				}catch(IOException e) {
					
				}
			}catch(FileNotFoundException e) {
				
			}
		}
		return line;
	}
	
	public void tick() {
		if(sair.clicou()) {
			System.exit(1);
		}
	}
	
	public void render(Graphics g) {
		Standart= new Color(255,0,0);
		MouseOver= new Color(200,0,0);
		Pressed= new Color(150,0,0);
		beje= new Color(211,228,255);
		g.setColor(beje);
		g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
		Graphics2D g2 = (Graphics2D) g;
		if(state.equals("Login")) {
			login.render(g);
		}
		if(state.equals("Menu")) {
			cadastrar.render(g);
			sair.render(g);
			buscar.render(g);
		}
		
	}
}
