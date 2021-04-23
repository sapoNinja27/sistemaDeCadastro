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

public class Menu_de_Load {
	String slot1="Vazio.",slot2="Vazio.",slot3="Vazio.";
	String[] Menu = {"Vazio","Slot1","Slot2","Slot3","Sair"};
	int currentOption=0;
	public static boolean saveExists=false;
	public static boolean saveGame=false;
	
	
	public int mx,my;
	public void attMouse() {
		mx=Main.menu.mx;
		my=Main.menu.my;		
	}
	
	public void tick() {
		attMouse();
		File file=new File("save.txt");
		if(file.exists()) {
			saveExists=true;
		}else {
			saveExists=false;
		}
		//pra dele tar file=new File("save.txt"); file.delete();
		
		slot1=String.valueOf(file);
		if(Main.menu.soltou) {
			Main.menu.soltou=false;
			if(mx>720/3 && mx<720/3+100 && my>135 && my<135+20) {
				if(file.exists()) {
					String saver=Main.menu.loadGame(0);
					Main.menu.applySave(saver);
				}
			}else if(mx>720/3 && mx<720/3+100 && my>185 && my<185+20) {
				
			}else if(mx>720/3 && mx<720/3+100 && my>235 && my<125+20) {
				
			}else if(mx>583 && mx<583+62 && my>314 && my<314+24) {
				Main.menu.load=false;
			}else  {
				currentOption=0;
			}
		}else {
			if(mx>720/3 && mx<720/3+100 && my>135 && my<135+20) {
				currentOption=1;
			}else if(mx>720/3 && mx<720/3+100 && my>185 && my<185+20) {
				currentOption=2;
			}else if(mx>720/3 && mx<720/3+100 && my>235 && my<235+20) {
				currentOption=3;
			}else  if(mx>583 && mx<583+62 && my>314 && my<314+24) {
				currentOption=4;
			}else {
				currentOption=0;
			}
		}
		
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.black);
		g.fillRoundRect(720/3-40,65, 260+20, 200+20, 30, 50);
		g.setColor(Main.menu.beje);
		g.fillRoundRect(720/3-30,75, 260, 200, 30, 50);
		g.setColor(Color.black);
		g.fillRoundRect(580,312, 68, 28, 30, 50);
		if(Menu[currentOption]=="Sair"&& Main.menu.clicou) {
			g.setColor(Main.menu.Pressed);
			g.fillRoundRect(583,314, 62, 24, 30, 50);
		}else if(Menu[currentOption]=="Sair") {
			g.setColor(Main.menu.MouseOver);
			g.fillRoundRect(583,314, 62, 24, 30, 50);
		}else {
			g.setColor(Main.menu.Standart);
			g.fillRoundRect(583,314, 62, 24, 30, 50);
		}
		g.setColor(Color.black);
		if(Main.menu.idioma=="Portugues") {
			g.drawString("Carregar Jogo",720/3+55, 95);
			g.setColor(Color.black);
			g.drawString("Voltar", 599, 330);
			if(slot1=="Empty.") {
				slot1="Vazio.";
			}
			if(slot2=="Empty.") {
				slot2="Vazio.";
			}
			if(slot3=="Empty.") {
				slot3="Vazio.";
			}
		}else {
			if(slot1=="Vazio.") {
				slot1="Empty.";
			}
			if(slot2=="Vazio.") {
				slot2="Empty.";
			}
			if(slot3=="Vazio.") {
				slot3="Empty.";
			}
			g.drawString("Load Game",720/3+55, 95);
			g.setColor(Color.black);
			g.drawString("Back", 599, 330);
		}
		
		if(Menu[currentOption]=="Slot1"&& Main.menu.clicou) {
			g.setColor(Main.menu.Pressed);
			g.drawString(slot1, 720/3, 150);
		}else if(Menu[currentOption]=="Slot1") {
			g.setColor(Main.menu.MouseOver);
			g.drawString(slot1, 720/3, 150);
		}else {
			g.setColor(Main.menu.Standart);
			g.drawString(slot1, 720/3, 150);
		}
		if(Menu[currentOption]=="Slot2"&& Main.menu.clicou) {
			g.setColor(Main.menu.Pressed);
			g.drawString(slot2,720/3, 200);
		}else if(Menu[currentOption]=="Slot2") {
			g.setColor(Main.menu.MouseOver);
			g.drawString(slot2,720/3, 200);
		}else {
			g.setColor(Main.menu.Standart);
			g.drawString(slot2,720/3, 200);
		}
		if(Menu[currentOption]=="Slot3"&& Main.menu.clicou) {
			g.setColor(Main.menu.Pressed);
			g.drawString(slot3,720/3, 250);
		}else if(Menu[currentOption]=="Slot3") {
			g.setColor(Main.menu.MouseOver);
			g.drawString(slot3,720/3, 250);
		}else {
			g.setColor(Main.menu.Standart);
			g.drawString(slot3,720/3, 250);
		}		
	}
}
	

