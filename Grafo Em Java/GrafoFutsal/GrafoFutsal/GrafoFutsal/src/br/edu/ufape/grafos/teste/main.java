package br.edu.ufape.grafos.teste;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufape.grafos.basica.Jogador;
import br.edu.ufape.grafos.basica.Posicao;
import br.edu.ufape.grafos.grafo.Dijkstra;
import br.edu.ufape.grafos.grafo.Grafo;


public class main {

	public static void main(String[] args) {
		
		Grafo grafo = new Grafo();
		Dijkstra dji= new Dijkstra(grafo);
		List<Jogador> caminho = new ArrayList<>();
		Posicao primeiroJogador = new Posicao(3);
		Jogador GoleiroA = new Jogador("Goleiro_Time_A", primeiroJogador);
		grafo.adicionarVertice(GoleiroA);
		
		Posicao segundoJogador = new Posicao(4);
		Jogador David = new Jogador("David", segundoJogador);
		grafo.adicionarVertice(David);
		
		Posicao terceiroJogador = new Posicao(5);
		Jogador Carlos = new Jogador("Carlos", terceiroJogador);
		grafo.adicionarVertice(Carlos);
		
		Posicao quartoJogador = new Posicao(4);
		Jogador Jose = new Jogador("Jose", quartoJogador);
		grafo.adicionarVertice(Jose);
		
		Posicao quintoJogador = new Posicao(6);
		Jogador Allef = new Jogador("Allef", quintoJogador);
		grafo.adicionarVertice(Allef);

		Posicao sextoJogador = new Posicao(7);
		Jogador GoleiroB = new Jogador("Goleiro_Time_B", sextoJogador);
		grafo.adicionarVertice(GoleiroB);
		
		grafo.adicionarAresta(GoleiroA, David);
		grafo.adicionarAresta(GoleiroA, Carlos);
		grafo.adicionarAresta(GoleiroA, Jose);
		grafo.adicionarAresta(David, Carlos);
		grafo.adicionarAresta(Jose, Carlos);
		grafo.adicionarAresta(Carlos, Allef);
		grafo.adicionarAresta(Allef, GoleiroB);
		grafo.adicionarAresta(Jose, GoleiroB);

		caminho=dji.encontrarMenorCaminho(GoleiroA, GoleiroB);
		
		dji.Imprimir();
		
		
	}

}
