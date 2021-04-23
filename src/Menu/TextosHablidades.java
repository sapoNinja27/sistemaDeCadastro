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

public class TextosHablidades {
		int x,y;
		public void render(Graphics g ) {
		Graphics2D g2 = (Graphics2D) g;
		Color Standart= new Color(255,0,0);
		Color MouseOver= new Color(200,0,0);
		Color Pressed= new Color(150,0,0);
		Color beje= new Color(247,212,212);
		g.setColor(Color.BLACK); 
		x=-25;
		y=10;
		if(Main.menu.idioma=="Portugues") {
			if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Vazio"  ) {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 185,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 165);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Tai se enfurece em combate com", 485+x, 85+y);
				g.drawString("inimigos, recebendo resistencias", 485+x, 110+y);
				g.drawString("e dano de ataque por acumulo", 485+x, 135+y);
				g.drawString("de furia.", 485+x, 160+y);
				g.drawString("Furia tamb�m pode ser usada", 485+x, 185+y);
				g.drawString("para usar habilidades.", 485+x, 210+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Tempestade de Socos1") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 185,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 165);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Tempestade de socos nivel 1:", 485+x, 85+y);
				g.drawString("Tai dispara uma rajada de socos", 485+x, 110+y);
				g.drawString("a sua frente, causando dano a", 485+x, 135+y);
				g.drawString("todos os inimigos nessa area.", 485+x, 160+y);
				g.drawString("Custa furia para ser usado.", 485+x, 185+y);
				g.drawString("Para usar pressione |?|.", 485+x, 210+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Tempestade de Socos2") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 85,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 65);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Tempestade de socos nivel 2:", 485+x, 85+y);
				g.drawString("Aumenta o alcance da habilidade.", 485+x, 110+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Tempestade de Socos3") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 160,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 140);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Tempestade de socos nivel 3:", 485+x, 85+y);
				g.drawString("Apos usar essa habilidade, Tai", 485+x, 110+y);
				g.drawString("recebe um escudo baseado no ", 485+x, 135+y);
				g.drawString("dano causado.", 485+x, 160+y);
				g.drawString("O escudo dura 5 segundos.", 485+x, 185+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Bloquear1") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 185,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 165);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Bloquear nivel 1:", 485+x, 85+y);
				g.drawString("Tai ganha a habilidade de repelir", 485+x, 110+y);
				g.drawString("um ataque inimigo.", 485+x, 135+y);
				g.drawString("Custa furia apenas se usado", 485+x, 160+y);
				g.drawString("contra um golpe inimigo.", 485+x, 185+y);
				g.drawString("Para usar pressione |R| .", 485+x, 210+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Bloquear2") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 185,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 165);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Bloquear nivel 2:", 485+x, 85+y);
				g.drawString("Tai reune sua furia e lan�a um ", 485+x, 110+y);
				g.drawString("golpe em �rea que expulsa os", 485+x, 135+y);
				g.drawString("inimigos proximos.", 485+x, 160+y);
				g.drawString("Aumenta o custo em furia.", 485+x, 185+y);
				g.drawString("Perde a capacidade de bloquear.", 485+x, 210+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Bloquear3") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 185,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 165);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Bloquear nivel 3:", 485+x, 85+y);
				g.drawString("Tai eleva sua furia ao maximo ", 485+x, 110+y);
				g.drawString("aumentando o dano de repelir.", 485+x, 135+y);
				g.drawString("Destroi o escudo equipado e", 485+x, 160+y);
				g.drawString("se cura no valor restante dele.", 485+x, 185+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Fortalecer1") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 225,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 205);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Fortalecer nivel 1:", 485+x, 85+y);
				g.drawString("Tai fortalece o seu proximo golpe ", 485+x, 110+y);
				g.drawString("fazendo causar o dobro de dano.", 485+x, 135+y);
				g.drawString("Custa furia para ser usado.", 485+x, 160+y);
				g.drawString("Se a barra de furia estiver cheia", 485+x, 185+y);
				g.drawString("fortalecer � automaticamente", 485+x, 210+y);
				g.drawString("usado.", 485+x, 235+y);
				g.drawString("Para usar pressione |?|.", 485+x, 260+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Fortalecer2") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 160,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 140);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Fortalecer nivel 2:", 485+x, 85+y);
				g.drawString("Atacar usando fortalecer agora", 485+x, 110+y);
				g.drawString("gera um escudo baseado no ", 485+x, 135+y);
				g.drawString("dano causado.", 485+x, 160+y);
				g.drawString("O escudo dura 2 segundos.", 485+x, 185+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Fortalecer3") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 205,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 185);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Fortalecer nivel 3:", 485+x, 85+y);
				g.drawString("Fortalecer deixa de custar furia.", 485+x, 110+y);
				g.drawString("Tai usa passivamente os", 485+x, 135);
				g.drawString("atributos de fortalecer a cada 3", 485+x, 160+y);
				g.drawString("ataques.", 485+x, 185);
				g.drawString("Tai recebe menos dano de", 485+x, 210+y);
				g.drawString("oponentes que n�o esta atacando.", 485+x, 235+y);
			}
		}else {
			if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Vazio"  ) {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 160,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 140);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Tai gets enraged while in combat ", 485+x, 85+y);
				g.drawString("with enemys receiving resistance ", 485+x, 110+y);
				g.drawString("and attack damage per fury stack.", 485+x, 135+y);
				g.drawString("Fury can also be used to use", 485+x, 160+y);
				g.drawString("skills.", 485+x, 185+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Tempestade de Socos1") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 185,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 165);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Punch storm level 1:", 485+x, 85+y);
				g.drawString("Tai launches a flury of punches", 485+x, 110+y);
				g.drawString("in frontof him, causing damage to", 485+x, 135+y);
				g.drawString("all enemies in the area.", 485+x, 160+y);
				g.drawString("Cost fury to be used.", 485+x, 185+y);
				g.drawString("Press |?| to use.", 485+x, 210+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Tempestade de Socos2") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 85,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 65);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Punch storm level 2:", 485+x, 85+y);
				g.drawString("Increases skill range.", 485+x, 110+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Tempestade de Socos3") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 160,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 140);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Punch storm level 3:", 485+x, 85+y);
				g.drawString("After using this ability, Tai receive", 485+x, 110+y);
				g.drawString("a shield based in the damage  ", 485+x, 135+y);
				g.drawString("done.", 485+x, 160+y);
				g.drawString("The shield stand 5 seconds.", 485+x, 185+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Bloquear1") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 185,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 165);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Block level 1:", 485+x, 85+y);
				g.drawString("Tai gains the ability to avoid an ", 485+x, 110+y);
				g.drawString("enemy attack.", 485+x, 135+y);
				g.drawString("Cost fury only if used against a", 485+x, 160+y);
				g.drawString("enemy attack.", 485+x, 185+y);
				g.drawString("Press |R| to use .", 485+x, 210+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Bloquear2") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 185,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 165);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Block level 2:", 485+x, 85+y);
				g.drawString("Tai gathers his fury and launches", 485+x, 110+y);
				g.drawString("an area attack that expels nearby ", 485+x, 135+y);
				g.drawString("enemies.", 485+x, 160+y);
				g.drawString("Increase fury cost.", 485+x, 185+y);
				g.drawString("Loses the ability to block.", 485+x, 210+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Bloquear3") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 185,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 165);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Block level 3:", 485+x, 85+y);
				g.drawString("Tai increases his fury to the ", 485+x, 110+y);
				g.drawString("maximum increasing the damage ", 485+x, 135+y);
				g.drawString("of the area attack. ", 485+x, 160+y);
				g.drawString("Destroys the equipped shield and  ", 485+x, 185+y);
				g.drawString("healing himself for the remaining amount.", 485+x, 210+y);
				g.drawString("healing himself for the remaining amount.", 485+x, 210+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Fortalecer1") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 225,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 205);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Strengthen 1:", 485+x, 85+y);
				g.drawString("Tai fortalece o seu proximo golpe ", 485+x, 110+y);
				g.drawString("fazendo causar o dobro de dano.", 485+x, 135+y);
				g.drawString("Custa furia para ser usado.", 485+x, 160+y);
				g.drawString("Se a barra de furia estiver cheia", 485+x, 185+y);
				g.drawString("fortalecer � automaticamente", 485+x, 210+y);
				g.drawString("usado.", 485+x, 235+y);
				g.drawString("Para usar pressione |?|.", 485+x, 260+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Fortalecer2") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 160,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 140);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Fortalecer nivel 2:", 485+x, 85+y);
				g.drawString("Atacar usando fortalecer agora", 485+x, 110+y);
				g.drawString("gera um escudo baseado no ", 485+x, 135+y);
				g.drawString("dano causado.", 485+x, 160+y);
				g.drawString("O escudo dura 2 segundos.", 485+x, 185+y);
			}else if(Main.menu.menIn.hab.Menu[Main.menu.menIn.hab.currentOption]=="Fortalecer3") {
				g.setColor(Color.black);
				g.fillRoundRect(470+x,50+y, 220, 205,30,30);
				g.setColor(beje);
				g.fillRect(480+x,60+y, 200, 185);
				g.setFont(new Font("arial",Font.BOLD,12));
				g.setColor(Color.black);
				g.drawString("Fortalecer nivel 3:", 485+x, 85+y);
				g.drawString("Fortalecer deixa de custar furia.", 485+x, 110+y);
				g.drawString("Tai usa passivamente os", 485+x, 135);
				g.drawString("atributos de fortalecer a cada 3", 485+x, 160+y);
				g.drawString("ataques.", 485+x, 185);
				g.drawString("Tai recebe menos dano de", 485+x, 210+y);
				g.drawString("oponentes que n�o esta atacando.", 485+x, 235+y);
			}
		}
		
	}
}
