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

public class Menu_ingame {
	int posx=0,posy=0;
	public String[] Menus = {"Habilidades","Atributos","Personagens","Op��es"};
	public String[] Menu = {"Vazio","Back","Next","Sair"};
	public int currentOption=0,currentMenu=0;;
	boolean confirmacao;
	Habilidades hab= new Habilidades();
	Personagens pe= new Personagens();
	public int mx,my;
	
	
	public void attMouse() {
		mx=Main.menu.mx;
		my=Main.menu.my;		
	}
	public void tick() {
		attMouse();
		posx++;
		if(posx==2976-1440) {
			posx=0;
		}
		if(Main.menu.menIn.hab.con.confirmar) {
			Main.menu.menIn.hab.con.tick();
		}else {
			if(Main.menu.soltou) {
				if(mx>583 && mx<583+80 && my>30 && my<24+30) {
					currentMenu++;
					if(currentMenu>3) {
						currentMenu=0;
					}
					Main.menu.soltou=false;
				}else if(mx>50 && mx<80+80 && my>30 && my<30+24) {
					currentMenu--;
					if(currentMenu<0) {
						currentMenu=3;
					}
					Main.menu.soltou=false;
				}else if(mx>583 && mx<583+80 && my>314 && my<314+24) {
					Main.gameState="NORMAL";
					Main.menu.soltou=false;
				}else {
					currentOption=0;
				}
			}else {
				if(mx>583 && mx<583+80 && my>30 && my<24+30) {
					currentOption=2;
				}else if(mx>50 && mx<80+80 && my>30 && my<30+24) {
					currentOption=1;
				}else if(mx>583 && mx<583+80 && my>314 && my<314+24) {
					currentOption=3;
				}else {
					currentOption=0;
				}
			}
		}
		if(Menus[currentMenu]=="Habilidades") {
			if(Main.menu.menIn.hab.con.confirmar) {
				Main.menu.menIn.hab.con.tick();
			}else {
				hab.tick();
			}
		}else if(Menus[currentMenu]=="Atributos") {
			if(Main.menu.menIn.at.con.confirmar) {
				Main.menu.menIn.at.con.tick();
			}else {
				at.tick();
			}
		}else if(Menus[currentMenu]=="Personagens") {
			pe.tick();
		}else if(Menus[currentMenu]=="Op��es") {
			Main.menu.menOp.tick();
		}
	}
	public void render(Graphics g) {
		if(Main.player.personagem=="Tai") {
			//menu do tai
			g.drawImage(Main.fundoT.getSprite(posx, posy, 1440, 720), 0, 0,720,360, null);
			Main.menu.Standart= new Color(255,0,0);
			Main.menu.MouseOver= new Color(200,0,0);
			Main.menu.Pressed= new Color(150,0,0);
			Main.menu.beje= new Color(247,212,212);
		}else if(Main.player.personagem=="Ace") {
			//menu do ace
			g.drawImage(Main.fundoA.getSprite(posx, posy, 1440, 720), 0, 0,720,360, null);
			Main.menu.Standart= new Color(132,132,132);
			Main.menu.MouseOver= new Color(102,102,102);
			Main.menu.Pressed= new Color(76,76,76);
			Main.menu.beje= new Color(212,212,212);
		}else if(Main.player.personagem=="Sander") {
			//menu do sander
			g.drawImage(Main.fundoS.getSprite(posx, posy, 1440, 720), 0, 0,720,360, null);
			Main.menu.Standart= new Color(155,62,0);
			Main.menu.MouseOver= new Color(102,40,0);
			Main.menu.Pressed= new Color(51,20,0);
			Main.menu.beje= new Color(247,212,212);
			
		}
		g.setColor(Color.black);
		g.fillRoundRect(580,312, 86, 28, 30, 50);
		g.fillRoundRect(47,28, 86, 28, 30, 50);
		g.fillRoundRect(580,28, 86, 28, 30, 50);
		
		if(Menu[currentOption]=="Sair" && Main.menu.clicou) {
			g.setColor(Main.menu.Pressed);
			g.fillRoundRect(583,314, 80, 24, 30, 50);
		}else if(Menu[currentOption]=="Sair") {
			g.setColor(Main.menu.MouseOver);
			g.fillRoundRect(583,314, 80, 24, 30, 50);
		}else{
			g.setColor(Main.menu.Standart);
			g.fillRoundRect(583,314, 80, 24, 30, 50);
		}
		if(Menu[currentOption]=="Back" && Main.menu.clicou) {
			g.setColor(Main.menu.Pressed);
			g.fillRoundRect(50,30, 80, 24, 30, 50);
		}else if(Menu[currentOption]=="Back") {
			g.setColor(Main.menu.MouseOver);
			g.fillRoundRect(50,30, 80, 24, 30, 50);
		}else{
			g.setColor(Main.menu.Standart);
			g.fillRoundRect(50,30, 80, 24, 30, 50);
		}
		if(Menu[currentOption]=="Next" && Main.menu.clicou) {
			g.setColor(Main.menu.Pressed);
			g.fillRoundRect(583,30, 80, 24, 30, 50);
		}else if(Menu[currentOption]=="Next") {
			g.setColor(Main.menu.MouseOver);
			g.fillRoundRect(583,30, 80, 24, 30, 50);
		}else{
			g.setColor(Main.menu.Standart);
			g.fillRoundRect(583,30, 80, 24, 30, 50);
		}
		g.setColor(Color.black);
		g.setFont(new Font("arial",Font.BOLD,12));
		if(Main.menu.idioma=="Portugues") {
			g.drawString("Sair", 610, 330);
		}else if(Main.menu.idioma=="English") {
			g.drawString("Exit", 610, 330);
		}
		if(Menus[currentMenu]=="Habilidades") {
			hab.render(g);
			g.setColor(Color.black);
			g.setFont(new Font("arial",Font.BOLD,18));
			if(Main.menu.idioma=="Portugues") {
				g.drawString("Habilidades:", 720/2-60, 46);
			}else if(Main.menu.idioma=="English") {
				g.drawString("Skills:", 720/2-45, 46);
			}
			g.setFont(new Font("arial",Font.BOLD,12));
			g.setColor(Color.black);
			if(Main.menu.idioma=="Portugues") {
				g.drawString("Op��es", 65, 46);
				g.drawString("Atributos", 597,46);
			}else if(Main.menu.idioma=="English") {
				g.drawString("Options", 65, 46);
				g.drawString("Attributes", 597,46);
			}
		}else if(Menus[currentMenu]=="Atributos") {
			at.render(g);
			g.setColor(Color.black);
			g.setFont(new Font("arial",Font.BOLD,18));
			if(Main.menu.idioma=="Portugues") {
				g.drawString("Atributos:", 720/2-50, 46);
			}else if(Main.menu.idioma=="English") {
				g.drawString("Attributes:", 720/2-50, 46);
			}
			g.setFont(new Font("arial",Font.BOLD,12));
			g.setColor(Color.black);
			if(Main.menu.idioma=="Portugues") {
				g.drawString("Habilidades", 59, 46);
				g.drawString("Personagens", 586,46);
			}else if(Main.menu.idioma=="English") {
				g.drawString("Skills", 73, 46);
				g.drawString("Characters", 590,46);
			}
		}else if(Menus[currentMenu]=="Personagens") {
			pe.render(g);
			g.setColor(Color.black);
			g.setFont(new Font("arial",Font.BOLD,18));
			if(Main.menu.idioma=="Portugues") {
				g.drawString("Personagens:", 720/2-65, 46);
			}else if(Main.menu.idioma=="English") {
				g.drawString("Characters:", 720/2-60, 46);
			}
			g.setFont(new Font("arial",Font.BOLD,12));
			g.setColor(Color.black);
			if(Main.menu.idioma=="Portugues") {
				g.drawString("Atributos", 64, 46);
				g.drawString("Op��es", 600,46);
			}else if(Main.menu.idioma=="English") {
				g.drawString("Attributes", 64, 46);
				g.drawString("Options", 600,46);
			}
		}else if(Menus[currentMenu]=="Op��es") {
			Main.menu.menOp.render(g);
			g.setColor(Color.black);
			g.setFont(new Font("arial",Font.BOLD,18));
			if(Main.menu.idioma=="Portugues") {
				g.drawString("Op��es:", 720/2-50, 46);
			}else if(Main.menu.idioma=="English") {
				g.drawString("Options:", 720/2-50, 46);
			}
			g.setFont(new Font("arial",Font.BOLD,12));
			g.setColor(Color.black);
			if(Main.menu.idioma=="Portugues") {
				g.drawString("Personagens", 54, 46);
				g.drawString("Habilidades", 592,46);
			}else if(Main.menu.idioma=="English") {
				g.drawString("Characters", 59, 46);
				g.drawString("Skills", 607,46);
			}
		}	
	}
}
