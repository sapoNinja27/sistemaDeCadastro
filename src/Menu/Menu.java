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
	Menu_de_Opcoes menOp=new Menu_de_Opcoes();
	Menu_de_Load menLo=new Menu_de_Load();
	Menu_ingame menIn=new Menu_ingame();
	int posx=0,posy=0;
	public String[] MenuPrincipal = {"Vazio","Cadastro","Buscar","Sair"};
	public int currentOption=0;
	boolean load;
	boolean opcoes;
	String idioma="Portugues";
	int volume=0;
	public Color Standart;
	public Color MouseOver;
	public Color Pressed;
	public Color beje;
	boolean sfx;
	boolean mus;
	
	public boolean clicou, soltou;
	public int mx,my;
	public boolean pause = false;
	public int pontosH=0,pontosA=0;
	
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
	public static void saveGame(String[] val1, int[] val2, int encode) {
		BufferedWriter write =null;
		try {
			write=new BufferedWriter(new FileWriter("save.txt"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		for(int i=0; i< val1.length;i++) {
			String current=val1[i];
			current+=":";
			char[] value = Integer.toString(val2[i]).toCharArray();
			for(int n=0; n<value.length;n++) {
				value[n]+=encode;
				current+=value[n];
			}
			try {
				write.write(current);
				if(i<val1.length-1) {
					write.newLine();
				}
			}catch(IOException e) {
				
			}
			try {
				write.flush();
				write.close();
			}catch(IOException e) {
				
			}
		}
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		Standart= new Color(255,0,0);
		MouseOver= new Color(200,0,0);
		Pressed= new Color(150,0,0);
		beje= new Color(211,228,255);
		g.setColor(beje);
		g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
		Graphics2D g2 = (Graphics2D) g;
		Botao cadastrar=new Botao(100,50, 97, 20,"Cadastrar", Color.white,2,15);
		Botao buscar=new Botao(220,50, 97, 20,"Buscar", Color.white,2,15);
		Botao sair=new Botao(550,300, 97, 20,"Sair", Color.white,2,15);
		cadastrar.render(g);
		sair.render(g);
		buscar.render(g);

	}
}
