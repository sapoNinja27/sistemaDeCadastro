package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import JObjects.Botao;
import Main.Main;

public class Buscar {
	Botao edit = new Botao(550, 210, 97, 20, "Editar", Color.white, 2, 15);
	Botao excluir = new Botao(550, 240, 97, 20, "Excluir", Color.white, 2, 15);
	Botao voltar = new Botao(550, 270, 97, 20, "Voltar", Color.white, 2, 15);

	public Buscar() {
		Main.botoes.add(excluir);
		Main.botoes.add(edit);
		Main.botoes.add(voltar);
	}

	public void tick() {
		if (voltar.clicou()) {
			Main.menu.state = "Menu";
			Main.menu.resetar();
			Main.botoes.remove(voltar);
		}
	}

	public void render(Graphics g) {
		tick();
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("arial", Font.BOLD, 30));
		g.drawString("Pesquisar ", 50, 40);
		edit.render(g);
		excluir.render(g);
		voltar.render(g);
	}
}
