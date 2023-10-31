package br.edu.ufape.grafos.grafo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import br.edu.ufape.grafos.basica.Jogador;

public class Dijkstra {
	
	private Grafo grafo;
	private List<Jogador> caminho = new ArrayList<>();
	
	Map<Jogador, Integer> distancia = new HashMap<>();
    Map<Jogador, Jogador> sucessores = new HashMap<>();
    PriorityQueue<Jogador> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(distancia::get));
   
	public Dijkstra(Grafo grafo) {
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
		 
		  if(auxiliar!=destino && auxiliar!=null) {
		  AdicionaSucessor(auxiliar);
		  caminho.add(sucessores.get(auxiliar));
		  }
		  auxiliar=sucessores.get(auxiliar);
		  if(auxiliar!=destino && auxiliar!=null) {
			  AdicionaSucessor(auxiliar);
			  caminho.add(sucessores.get(auxiliar));
			  }
		  
		  
		  
	        return caminho;
	}
	
	public void Imprimir() {
		List<Aresta>arestas=new ArrayList<>();
		arestas=grafo.getArestas();
		System.out.println("Vertices: ");
		grafo.imprimir();
		System.out.println("\nArestas: ");
		for(Aresta i: arestas) {
			System.out.println(i.getOrigem().getNome() + "|" + i.getDestino().getNome()+" peso: "+ i.getPeso() );
		}
		System.out.println("\nO menor caminho passa por: ");
		for(Jogador atual : caminho) {
			
			System.out.println(atual.getNome());
		}
	}
	
	
}
