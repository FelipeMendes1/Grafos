package br.edu.ufape.grafos.grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ufape.grafos.basica.Jogador;
import br.edu.ufape.grafos.basica.Posicao;

public class Grafo implements InterfaceGrafo{
	
	 private Map<Posicao, Jogador> mapa = new HashMap<>();
	 private List<Aresta> arestas = new ArrayList<>();
	 
	 
	public Map<Posicao, Jogador> getMapa() {
		return mapa;
	}


	public List<Aresta> getArestas() {
		return arestas;
	}

	

	@Override
	public void adicionarVertice(Jogador vertice) {
		mapa.put(vertice.getPosicao(), vertice);		
	}

	
	@Override
	public List<Jogador> listarAdjacencias(Jogador vertice) {
		List<Jogador>adjacentes=new ArrayList<>();
		for(Aresta i : arestas) {
			if(i.getOrigem().equals(vertice)) {
				adjacentes.add(i.getDestino());
			}
		}
		return adjacentes;
	}

	@Override
	public int getIndiceVertice(Jogador vertice) {
		int index=0;
		for(Posicao posi : mapa.keySet()){
			if(posi.equals(vertice.getPosicao())) {
				index=posi.getPosicao();
			}
		}
		return index;
	}

	@Override
	public int calcularDistancia(Jogador origem, Jogador destino) {
		int x=origem.getPosicao().getPosicao();
		int y=destino.getPosicao().getPosicao();
		int distancia=y-x;
		return distancia;
	}
	
	@Override
	public int calcularPeso(Jogador origem, Jogador destino) {
		int peso = calcularDistancia(origem, destino);
		return peso;
	}
	@Override
	public void adicionarAresta(Jogador origem, Jogador destino) {
		Aresta nova = new Aresta(origem, destino, calcularPeso(origem,destino));
		arestas.add(nova);
		}


	@Override
	public void AtualizarArestaComPeso(Aresta aresta) {
		for(Aresta x : arestas) {
			if(x.getOrigem().equals(aresta.getOrigem()) && x.getDestino().equals(aresta.getDestino())) {
				x.setPeso(aresta.getPeso());
			}
		}
	}

	

	@Override
	public void imprimir() {
		for(Posicao i : mapa.keySet()){
				System.out.println(mapa.get(i).getNome() +" Posicao: " +mapa.get(i).getPosicao().getPosicao() );
		}
	}

	@Override
	public int getNumeroVertices() {
		int quantiVertices=0;
		for(Posicao x:mapa.keySet()) {
			quantiVertices++;
		}
		return quantiVertices;
	}

	@Override
	public Jogador[] getVertices() {
		Jogador []vertices = new Jogador[getNumeroVertices()];
		int index=0;
		for(Posicao i : mapa.keySet()) {
			vertices[index]=mapa.get(i);
			index++;
		}
		return vertices;
	}
	
	

	
	

}
