package br.edu.ufape.grafos.grafo;

import br.edu.ufape.grafos.basica.Jogador;

public class Aresta {
	
	private Jogador origem;
	private Jogador destino;
	private int peso;
	
	public Aresta(Jogador origem, Jogador destino, int peso) {
		this.origem=origem;
		this.destino=destino;
		this.peso=peso;
	}

	
	public Jogador getOrigem() {
		return origem;
	}

	public void setOrigem(Jogador origem) {
		this.origem = origem;
	}

	public Jogador getDestino() {
		return destino;
	}

	public void setDestino(Jogador destino) {
		this.destino = destino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
}
