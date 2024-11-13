package datastructure.graph;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implementation of graphs using adjacent lists
 * @param <D> type of the data object in the graph vertexes
 */	
public class GraphAL<D> implements Graph<D> {

	/** number of vertexes */
	protected int n;

	/** number of edges */
	protected int m;
	
	/** list of vertexes */
	protected ArrayList<VertexAL<D>> vertexes;

	/**
   	 * Constructs a graph with implementation using adjacent lists
	 */		
	public GraphAL(){
		n = 0;
		m = 0;
		vertexes = new ArrayList<VertexAL<D>>();
	}

	/**
	 Ritorna il numero di vertici
	*/
	public int vertexNum() {
		return n;
	}

	/**
	 Ritorna il numero di archi
	*/
	public int edgeNum() {
		return m;
	}

	/**
	 Crea un nuovo arraylist v di vertici
	 Riempi v con con i vertici presenti in vertexes
	 Restituisci v
	*/
	public ArrayList<Vertex<D>> vertexes() {
		ArrayList<Vertex<D>> v = new ArrayList<>();
		for (int i = 0; i < vertexes.size(); i++) {
			v.add(vertexes.get(i));
		}
		return v;
	}

	/**
	 Crea un arrayList di archi l
	 Per ogni vertice in vertexes
	 	Per ogni arco nella lista di adiacenza del vertice considerato
	 		Copia l'arco in l
	 Restituisci l
	*/
	public ArrayList<Edge<D>> edges() {
		ArrayList<Edge<D>> l = new ArrayList<>();
		for (int i = 0; i < vertexes.size(); i++) {
			VertexAL<D> v = vertexes.get(i);
			for(int j = 0; j < v.adjac.size(); j++){
				l.add(v.adjac.get(j));
			}
		}
		return l;
	}

	/**
	 Restituisci la lunghezza della lista di adiacenza di v
	*/
	public int outDegree(Vertex<D> v) {
		if (v instanceof VertexAL<D>) {
			VertexAL<D> vv = (VertexAL<D>) v;
			return vv.adjac.size();
		}	else
				return -1;

	}

	/**
	 Crea un nuovo arrayList l di archi
	 Riempi l con gl'archi nella lista di adiacenza di v
	 Restituisci l
	*/
	public ArrayList<Edge<D>> outEdges(Vertex<D> v) {
		ArrayList<Edge<D>> l = new ArrayList<>();
		if (v instanceof VertexAL<D>) {
			VertexAL<D> vv = (VertexAL<D>) v;
			for(Edge<D> edge : vv.adjac){
				l.add(edge);
			}
		}
		return l;
	}

	/**
	 Per ogni arco nella lista di adiacenze di x
	 	Se l'arco ha destinazione y restituisci l'arco
	 Restituisci null
	 */
	public Edge<D> areAdjacent(Vertex<D> x, Vertex<D> y) {
		if (x instanceof VertexAL<D> && y instanceof VertexAL<D>) {
			VertexAL<D> xx = (VertexAL<D>) x;
			for (Edge<D> edge : xx.adjac) {
				if(edge.dest.equals(y))
					return edge;
			}
		}
		return null;
	}

	/**
	 Crea un VertexAL v che contiene data e di indice n
	 Inserisci il nuovo vertice v in vertexes
	 Incrementa n
	 Restituisci v
	*/
	public Vertex<D> addVertex(D data) {
		VertexAL<D> v = new VertexAL<>(data, n);
		vertexes.add(v);
		n++;
		return v;
	}

	/**
	 Inserisci il vertice e nella lista di adiecenze di e.source
	 Incrementa m
	*/
	public void addEdge(Edge<D> e) {
		if(e.source instanceof VertexAL<D>){
			VertexAL<D> vertexS = (VertexAL) e.source;
			vertexS.adjac.add(e);
			m++;
		}
	}
	
	public void removeVertex(Vertex<D> v) {
		VertexAL<D> vAL = (VertexAL<D>)v;
		m = m - vAL.adjac.size();
		n = n - 1;
		if (vAL.index == n) {
			vertexes.remove(n);
		} else {
			VertexAL<D> vert = vertexes.remove(n);
			vert.index = vAL.index;
			vertexes.set(vert.index,vert);
		}
		Edge<D> e;
		for (int i=0; i<vertexes.size(); i++) {
			Iterator<Edge<D>> it = (vertexes.get(i)).adjac.iterator();
			while (it.hasNext()) { 
				e = it.next();
				if (e.dest == v) {
					it.remove();
					m = m - 1;
				}
			}					
		}
	}

	/**
	 Rimuovi l'arco e dalla lista di adiacenze di e.source
	 Se la cancellazione è avvenuta con successo decrementa m
	*/
	public void removeEdge(Edge<D> e) {
		if (e.source instanceof VertexAL<D>) {
			VertexAL<D> vertexS = (VertexAL<D>) e.source;
			if (vertexS.adjac.remove(e))
				m--;
		}
	}

	/**
	 *  Returns the index of a vertex
     *  @param v vertex
	 *  @return the index of the vertex v
	 */	
	protected int index(VertexAL<D> v) {
		return v.index;
	}

	/**
	 *  Returns the vertex with a given index
     *  @param i the index
	 *  @return the vertex v with index i
	 */		
 	protected VertexAL<D> vertex(int i) {
		if (i < 0 || i >= n) return null;
		return vertexes.get(i);
 	}

}
