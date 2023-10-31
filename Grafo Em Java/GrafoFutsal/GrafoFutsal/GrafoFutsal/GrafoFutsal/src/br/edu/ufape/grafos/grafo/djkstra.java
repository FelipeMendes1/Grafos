package br.edu.ufape.grafos.grafo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import br.edu.ufape.grafos.basica.Jogador;

public class djkstra {
	
	private Grafo grafo;
	private List<Jogador> caminho = new ArrayList<>();
	private int pesoTotal=0;
	Map<Jogador, Integer> distancia = new HashMap<>();
    Map<Jogador, Jogador> sucessores = new HashMap<>();
    PriorityQueue<Jogador> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(distancia::get));
   
	public djkstra(Grafo grafo) {
		this.grafo=grafo;
	}
	
	public void Inicializar(Jogador origem) {
		 //Inicialize a distância de todos os vértices como infinito, exceto a origem
	        for (Jogador vertice : grafo.getVertices()) {
	        	
	            if (vertice.equals(origem)) {
	                distancia.put(vertice,0);
	            } else {
	                distancia.put(vertice,9999);
	            }
	            
	            filaPrioridade.add(vertice);
	        }
	       
	}
	public void AdicionaSucessor(Jogador origem) {
		 List<Jogador> adjacentes=grafo.listarAdjacencias(origem);
		 Jogador sucessoratual=new Jogador(); 
		 sucessoratual=adjacentes.get(0);
		 
		 int dist_atual=0;
		 dist_atual=distancia.get(sucessoratual);
		
		 for(Jogador x:adjacentes) {
			 if(distancia.get(x)< dist_atual) {
				 dist_atual=distancia.get(x);
				 sucessoratual=x;
			 }
		 }
		 sucessores.put(origem, sucessoratual);
	}
	
	public void AtualizarDistancias() {
		int novaDistancia=0;
		 while(filaPrioridade.isEmpty()==false) {
			  Jogador atual=filaPrioridade.poll();
		      List<Jogador> adj=grafo.listarAdjacencias(atual);
		       
		       for(Jogador x : adj) {
		        	 novaDistancia=distancia.get(atual)+grafo.calcularDistancia(atual, x);
		        	 if(novaDistancia<distancia.get(x)) {
		        		 distancia.remove(x);
		        		 distancia.put(x, novaDistancia);
		        		
		        		 filaPrioridade.add(x);
		        	 }	 	 
		        }
		  }
	}
	
	public List<Jogador>encontrarMenorCaminho(Jogador origem, Jogador destino ){
		  Jogador auxiliar=new Jogador();
		  Jogador auxiliar2=new Jogador();
		  int flag=0;
		  Inicializar(origem);
		  AtualizarDistancias(); 
		 
		  caminho.add(origem);
		  
		  AdicionaSucessor(origem);
		  caminho.add(sucessores.get(origem));
		  auxiliar=sucessores.get(origem);//sucessor da origem
		  AdicionaSucessor(auxiliar);
		  caminho.add(sucessores.get(auxiliar));
		  
		  caminho.add(destino);
	        return caminho;
	}
}
