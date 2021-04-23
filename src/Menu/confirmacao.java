package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Main.Main;
import World.World;

public class confirmacao {
	String[] Menu= {"Vazio","Sim","Não"};
	int currentOption=0;
	int mx,my;
	int x,y;
	boolean confirmar;
	String tipo="A2";
	String golpe;
	int nivel;
	boolean ok;
	int bot;
	
	
	public void tick() {
		mx=Main.menu.mx;
		my=Main.menu.my;
		x=-250;
		y=50;
		if(confirmar) {
			if(Main.menu.soltou) {
				Main.menu.soltou=false;
				if(mx>503-250 && mx<503-250+34 && my>202+y && my<202+50+16) {
					confirmar=false;
					if(golpe=="tempestade de socos") {
						Main.player.H1[nivel-1]=true;
						Main.menu.pontosH--;
					}else if(golpe=="bloquear") {
						Main.player.H2[nivel-1]=true;
						Main.menu.pontosH--;
					}else if(golpe=="fortalecer") {
						Main.player.H3[nivel-1]=true;
						Main.menu.pontosH--;
					}
					if(golpe=="A1") {
						Main.player.A1[nivel-1]=true;
						Main.menu.pontosA--;
					}else if(golpe=="A2") {
						Main.player.A2[nivel-1]=true;
						Main.menu.pontosA--;
					}else if(golpe=="A3") {
						Main.player.A3[nivel-1]=true;
						Main.menu.pontosA--;
					}
				}else if(mx>613-250 && mx<613-250+34 && my>202+50 && my<202+50+16) {
					confirmar=false;
					bot=0;
				}
			}else {
				if(mx>503-250 && mx<503-250+34 && my>202+y && my<202+50+16) {
					currentOption=1;
				}else if(mx>613-250 && mx<613-250+34 && my>202+50 && my<202+50+16) {
					currentOption=2;
				}else {
					currentOption=0;
				}
			}
		}
		
	}
	public void confirmar(String golpe, int nivel, String tipo, int bot) {
		confirmar=true;
		this.golpe=golpe;
		this.nivel=nivel;
		this.tipo=tipo;
		this.bot=bot;
		
	}
	public void render(Graphics g ) {
		Graphics2D g2 = (Graphics2D) g;
		Color Standart= new Color(255,0,0);
		Color MouseOver= new Color(200,0,0);
		Color Pressed= new Color(150,0,0);
		Color beje= new Color(247,212,212);
		g.setColor(Color.BLACK); 
		if(confirmar) {
			if(tipo=="A2") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 185,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 165);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Tem certeza?", 100+190, 85+y);
				g.drawString("Gastar 1 ponto de Habilidade ", 500+x, 120+y);
				if(golpe!="tempestade de socos") {
					g.drawString("para evoluir "+golpe, 500+x, 140+y);
					g.drawString("para o nivel "+nivel+"?", 500+x, 160+y);
				}else {
					g.drawString("para evoluir tempestade de ", 500+x, 140+y);
					g.drawString("socos para o nivel "+nivel+"?", 500+x, 160+y);
				}
			}else if(tipo=="Atributo") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 185,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 165);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Tem certeza?", 100+190, 85+y);
				g.drawString("Gastar 1 ponto de atributo", 500+x, 120+y);
				g.drawString("evoluir "+golpe+" para o nivel ", 500+x, 140+y);
				g.drawString(nivel+"?", 500+x, 160+y);
				
			}
			g.fillRoundRect(500+x,200+y, 40, 20,30,30);
			g.fillRoundRect(610+x,200+y, 40, 20,30,30);
			
			if(Menu[currentOption]=="Sim" && Main.menu.clicou) {
				g.setColor(Pressed);
				g.fillRoundRect(503+x,202+y, 34, 16,30,30);
			}else if(Menu[currentOption]=="Sim") {
				g.setColor(MouseOver);
				g.fillRoundRect(503+x,202+y, 34, 16,30,30);
			}else {
				g.setColor(Standart);
				g.fillRoundRect(503+x,202+y, 34, 16,30,30);
			}
			if(Menu[currentOption]=="Não" && Main.menu.clicou) {
				g.setColor(Pressed);
				g.fillRoundRect(613+x,202+y, 34, 16,30,30);
			}else if(Menu[currentOption]=="Não") {
				g.setColor(MouseOver);
				g.fillRoundRect(613+x,202+y, 34, 16,30,30);
			}else {
				g.setColor(Standart);
				g.fillRoundRect(613+x,202+y, 34, 16,30,30);
				
			}
			g.setColor(Color.black);
			g.drawString("Sim",509+x,214+y);
			g.drawString("Não",620+x,214+y);
		}
		
		
	}
}
	
	