package br.edu.ufape.grafos.basica;

public class Jogador {
	
	private String nome;
	private Posicao posicao;
	
	public Jogador(String nome, Posicao posicao) {
		this.nome=nome;
		this.posicao=posicao;
	}
	
	public Jogador() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}
	
	public Posicao getPosicao() {
		return posicao;
	}
	
	
	
	
}
