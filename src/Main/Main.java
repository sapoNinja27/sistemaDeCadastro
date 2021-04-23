package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Menu.Menu;

public class Main extends Canvas implements Runnable,KeyListener,MouseListener,MouseMotionListener{
	public static int TILE_SIZE=64;
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private Thread thread;
	private boolean isRunning = true;
	public static final int WIDTH = 180*4;
	public static final int HEIGHT = 90*4;
	public static final int SCALE = 2;
	private BufferedImage image;
	public static Random rand;
	
	public static String gameState = "MENU";
	public static Menu menu;
	
	public Main(){
//		requestFocus();
		rand = new Random();
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		initFrame();
		//Inicializando objetos.
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		menu = new Menu();
	}
	
	public void initFrame(){
		frame = new JFrame("Dragon Soul I");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		Image imagem=null;
		try {
			LocalDate myObj = LocalDate.now(); 
			String data= String.valueOf(myObj);
			String mes= data.substring(5, 7);
			String dia= data.substring(8, 10);
//			imagem=ImageIO.read(getClass().getResource("/icone-jogo/icon.png"));
			if(mes.equals("12") && dia.equals("25")) {
				imagem=ImageIO.read(getClass().getResource("/icone-jogo/iconNatalino.png"));
			}else {
				imagem=ImageIO.read(getClass().getResource("/icone-jogo/icon.png"));
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		Toolkit toolkit =Toolkit.getDefaultToolkit();
		Image image= toolkit.getImage(getClass().getResource("/icone-jogo/icon.png"));
		Cursor c= toolkit.createCustomCursor(image, new Point(0,0), "img");
		
		frame.setIconImage(imagem);
//		frame.setAlwaysOnTop(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	public synchronized void stop(){
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		Main game = new Main();
		game.start();
	}
	
	public void tick(){
		menu.tick();
	}
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0,WIDTH,HEIGHT);
		menu.render(g);
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0,WIDTH*SCALE,HEIGHT*SCALE,null);
		g.setFont(new Font("arial",Font.BOLD,20));
		bs.show();
	}
	
public void run() {
		long lastTime = System.nanoTime();
		double amongOfTicks = 60.0;
		double delta = 0;
		double ns = 1000000000 / amongOfTicks;
		int frames = 0;
		double timer = System.currentTimeMillis();
		while(isRunning) {
			
			long now = System.nanoTime();
			delta+= (now-lastTime)/ns;
			lastTime= now;
			if(delta>=1) {
				tick();
				render();
				frames++;
				delta--;				
			}
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS:"+ frames);
				frames=0;
				timer+=1000;
			}
		}
		
		stop();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_X){
		}
		if(e.getKeyCode() == KeyEvent.VK_P){
		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		menu.mx=e.getX()/2;
		menu.my=e.getY()/2;
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		menu.clicou=true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		menu.mx=e.getX()/2;
		menu.my=e.getY()/2;
		menu.clicou=false;	
		menu.soltou=true;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
//  nao
		
	}

	
}
