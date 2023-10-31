package br.edu.ufape.grafos.grafo;

import java.util.List;
import java.util.Map;


import br.edu.ufape.grafos.basica.Jogador;
import br.edu.ufape.grafos.basica.Posicao;

public interface InterfaceGrafo {
	
	
	void adicionarVertice(Jogador vertice);

	void adicionarAresta(Jogador origem, Jogador destino);
	
	List<Jogador> listarAdjacencias(Jogador vertice);
	
	int getIndiceVertice(Jogador vertice);
	
	int calcularPeso(Jogador origem, Jogador destino);
	
	void AtualizarArestaComPeso(Aresta aresta);
	
	int calcularDistancia(Jogador origem, Jogador destino);

	void imprimir();

	int getNumeroVertices();
	
	public Jogador[] getVertices();
}
