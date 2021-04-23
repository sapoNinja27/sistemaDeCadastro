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

public class Menu_de_Opcoes  {
	
	String[] Menu = {"Vazio","Volume","Efeitos","Musica","Idioma","Sair"};
	int currentOption=0;
	public int mx,my;
	int x;
	int volume;
	
	public void attMouse() {
		mx=Main.menu.mx;
		my=Main.menu.my;		
	}
	
	public void tick() {
		x=20;
		attMouse();
		if(Main.menu.soltou) {
			Main.menu.soltou=false;
			if(Main.menu.pause) {
				if(mx>279 && mx<279+165 && my>314 && my<314+24) {
					Main.menu.pause=false;
					Main.gameState="MENU";
					World.restartGame("level"+1+".png");
				}
			}
			if(mx>583+20 && mx<583+20+62 && my>314 && my<314+24) {
				Main.menu.opcoes=false;
			}else if(mx>720/2+20 && mx<720/2+20+100 && my>85 && my<85+20) {
				currentOption=1;
				Main.menu.volume=volume;
				
			}else if(mx>720/2+20 && mx<720/2+25+20 && my>135 && my<135+20) {
				if(Main.menu.sfx) {
					Main.menu.sfx=false;
				}else {
					Main.menu.sfx=true;
				}
			}else if(mx>720/2-2+20 && mx<720/2-2+20+29 && my>133+50 && my<133+50+24) {
				if(Main.menu.mus) {
					Main.menu.mus=false;
				}else {
					Main.menu.mus=true;
				}
			}else if(mx>720/3+100-10+20 && mx<720/3+20+100-10+80 && my>250-15 && my<250-15+20) {
				if(Main.menu.idioma=="English") {
					Main.menu.idioma="Portugues";
				}else if(Main.menu.idioma=="Portugues") {
					Main.menu.idioma="English";
				}
			}else {
				currentOption=0;
			}
		}else {

			int x= Main.menu.volume;
			if(mx>583+20 && mx<583+20+62 && my>314 && my<314+24) {
				if(!Main.menu.pause) {
					currentOption=5;
				}
			}else if(mx>720/2+20 && mx<720/2+20+100 && my>85 && my<85+20) {
				currentOption=1;
				volume=mx-720/2-20;
			}else if(mx>720/2+20 && mx<720/2+20+25 && my>135 && my<135+20) {
				currentOption=2;
			}else if(mx>720/2+20-2 && mx<720/2-2+20+29 && my>133+50 && my<133+50+24) {
				currentOption=3;
			}else if(mx>720/3+100+20+20-10 && mx<720/3+100+20+20-10+80 && my>250-15 && my<250-15+20) {
				currentOption=4;
			}else {
				if(mx>279 && mx<279+165 && my>314 && my<314+24) {
					currentOption=5;
				}else {
				 	currentOption=0;
				}
				Main.menu.volume=x;
			}
		}
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.black);
		g.fillRoundRect(720/3+20-40,65, 260+20, 200+20, 30, 50);
		g.setColor(Main.menu.beje);
		g.fillRoundRect(720/3+20-30,75, 260, 200, 30, 50);
		
		
		//volume
		g.setColor(Color.black);
		g.fillRect(720/2+20,85, 99, 20);
		
		if(Menu[currentOption]=="Volume") {
			g.setColor(Main.menu.MouseOver);
			g.fillRect(720/2+20,85, volume, 20);
		}else {
			g.setColor(Main.menu.Standart);
			g.fillRect(720/2+20,85, Main.menu.volume, 20);
		}
		g.setColor(Color.black);
		
		if(!Main.menu.pause) {
			g.fillRoundRect(580+20,312, 68, 28, 30, 50);
			if(Menu[currentOption]=="Sair"&& Main.menu.clicou) {
				g.setColor(Main.menu.Pressed);
				g.fillRoundRect(583+20,314, 62, 24, 30, 50);
			}else if(Menu[currentOption]=="Sair") {
				g.setColor(Main.menu.MouseOver);
				g.fillRoundRect(583+20,314, 62, 24, 30, 50);
			}else {
				g.setColor(Main.menu.Standart);
				g.fillRoundRect(583+20,314, 62, 24, 30, 50);
			}
		}else {
			g.fillRoundRect(580-80-100-124,312, 170, 28, 30, 50);
			if(Menu[currentOption]=="Sair"&& Main.menu.clicou) {
				g.setColor(Main.menu.Pressed);
				g.fillRoundRect(583-80-100-124,314, 165, 24, 30, 50);
			}else if(Menu[currentOption]=="Sair") {
				g.setColor(Main.menu.MouseOver);
				g.fillRoundRect(583-80-100-124,314, 165, 24, 30, 50);
			}else {
				g.setColor(Main.menu.Standart);
				g.fillRoundRect(583-80-100-124,314, 165, 24, 30, 50);
			}
		}
		g.setColor(Color.black);
		g.fillRoundRect(720/2+20-2,133, 29, 24, 30, 50);
		if(Main.menu.sfx) {
			if(Menu[currentOption]=="Efeitos"&& Main.menu.clicou) {
				g.setColor(Main.menu.Pressed);
				g.fillRoundRect(720/2+20,135, 25, 20, 30, 50);
			}else if(Menu[currentOption]=="Efeitos") {
				g.setColor(Main.menu.MouseOver);
				g.fillRoundRect(720/2+20,135, 25, 20, 30, 50);
			}else {
				g.setColor(Main.menu.Standart);
				g.fillRoundRect(720/2+20,135, 25, 20, 30, 50);
			}
		}else {
			if(Menu[currentOption]=="Efeitos"&& Main.menu.clicou) {
				g.setColor(Main.menu.Pressed);
				g.fillRoundRect(720/2+20,135, 25, 20, 30, 50);
			}else if(Menu[currentOption]=="Efeitos") {
				g.setColor(Main.menu.MouseOver);
				g.fillRoundRect(720/2+20,135, 25, 20, 30, 50);
			}else {
				g.setColor(Main.menu.MouseOver);
				g.fillRoundRect(720/2+20,135, 25, 20, 30, 50);
			}
		}
		g.setColor(Color.black);
		if(!Main.menu.sfx) {
			g.drawString("On",720/3+20+124, 150);
		}else {
			g.drawString("Off",720/3+20+124, 150);
		}
		g.setColor(Color.black);
		g.fillRoundRect(720/2-2+20,133+50, 29, 24, 30, 50);
		if(Main.menu.mus) {
			if(Menu[currentOption]=="Musica"&& Main.menu.clicou) {
				g.setColor(Main.menu.Pressed);
				g.fillRoundRect(720/2+20,185, 25, 20, 30, 50);
			}else if(Menu[currentOption]=="Musica") {
				g.setColor(Main.menu.MouseOver);
				g.fillRoundRect(720/2+20,185, 25, 20, 30, 50);
			}else {
				g.setColor(Main.menu.Standart);
				g.fillRoundRect(720/2+20,185, 25, 20, 30, 50);
			}
		}else {
			if(Menu[currentOption]=="Musica"&& Main.menu.clicou) {
				g.setColor(Main.menu.Pressed);
				g.fillRoundRect(720/2+20,185, 25, 20, 30, 50);
			}else if(Menu[currentOption]=="Musica") {
				g.setColor(Main.menu.MouseOver);
				g.fillRoundRect(720/2+20,185, 25, 20, 30, 50);
			}else {
				g.setColor(Main.menu.MouseOver);
				g.fillRoundRect(720/2+20,185, 25, 20, 30, 50);
			}
		}
		g.setColor(Color.black);
		if(!Main.menu.mus) {
			g.drawString("On",720/3+20+124, 200);
		}else {
			g.drawString("Off",720/3+20+124, 200);
		}
		if(Menu[currentOption]=="Idioma"&& Main.menu.clicou) {
			g.setColor(Main.menu.Pressed);
			g.drawString(Main.menu.idioma,720/3+20+100+20, 250);
		}else if(Menu[currentOption]=="Idioma") {
			g.setColor(Main.menu.MouseOver);
			g.drawString(Main.menu.idioma,720/3+20+100+20, 250);
		}else {
			g.setColor(Main.menu.Standart);
			g.drawString(Main.menu.idioma,720/3+20+100+20, 250);
		}
		g.setColor(Color.black);
		if(Main.menu.idioma=="Portugues") {
			g.drawString("Volume:",720/3+20, 100);
			g.drawString("Efeitos Sonoros:", 720/3+20, 150);
			g.drawString("Musica:",720/3+20, 200);
			g.drawString("Idioma:",720/3+20, 250);
			g.setColor(Color.black);
			if(!Main.menu.pause) {
				g.drawString("Voltar", 618, 330);
			}else {
				g.drawString("Sair para o menu principal", 599-82-105-124, 330);
			}
		}else {
			g.drawString("Volume:",720/3+20, 100);
			g.drawString("Sound Efects:", 720/3+20, 150);
			g.drawString("Music:",720/3+20, 200);
			g.drawString("Language:",720/3+20, 250);
			g.setColor(Color.black);
			if(!Main.menu.pause) {
				g.drawString("Back", 619, 330);
			}else {
				g.drawString("Exit to the main menu", 599-82-105-109, 330);
			}
		}
			
		}
}
