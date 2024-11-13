package datastructure.priorityqueue;

import java.util.ArrayList;

/**
 * Priority queue implementation based on d-heap
 * @param <K> type of the key value
 * @param <D> type of the data object 
 */	
public class DHeap<K extends Comparable<K>, D> implements PriorityQueue<K, D, DHeapNode<K,D>>{
	
	/** ArrayList containing the priority queue nodes 
	 *  Useful methods on ArrayList<E>:                   
	 *  boolean add(E e)
	 * 		Appends the specified element to the end of this list
	 *  E 		get(int index)
	 *		Returns the element at the specified position in this list
	 *  E 		set(int index, E element)
	 *		Replaces the element at the specified position in this list 
	 *		with the specified element.
	 * 	E 		remove(int index)
	 *		Removes the element at the specified position in this list.	
	 */	
	private ArrayList<DHeapNode<K,D>> nodes;

    /** Number of elements in the priority queue */
	private int n;

    /** Degree of the d-heap */	
	private int d;

	/**
	 * Creates an empty d-heap (default value of the degree = 4)
	 */
	public DHeap(){
		this(4);
	}

	/**
	 * Creates an empty d-heap
	 * @param d the degree of the d-heap
	 */
	public DHeap(int d){
		this.nodes = new ArrayList<DHeapNode<K,D>>();
		this.d = d;
		this.n = 0;
	}

	/**
	 public D findMin() {
		se il d-heap è vuoto return null
		leggi il nodo in prima posizione e restituisci il dato contenuto
	 }
	*/

	public D findMin() {
		if(isEmpty())
			return null;
			else {
				return nodes.get(0).getData();
			}
	}

	/**
	 public DHeapNode<K,D> insert(K key, D data) {
	 	crea nodo per contenere key e data
	 		(ricorda che DheapNode contiene anche l'indice del nodo nel d-heap)
		 inserisci il nuovo nodo alla fine dell'arraylist
		 incrementa il parametro n (dimensione del d-heap)
		 MoveUp del nuovo nodo
		 restituisci il nuovo nodo inserito
	 }
	*/
	public DHeapNode<K,D> insert(K key, D data) {
		DHeapNode<K,D> tmp = new DHeapNode<>(key, data, n);
		nodes.add(tmp);
		n++;
		moveUp(tmp);
		return tmp;
	}

	/**
	 public D delete(DHeapNode<K,D> node) {
		se il d-heap è vuoto return null
		rimuovi l'ultimo nodo dall'arraylist e salvalo in una variabile u
	 		decrementa il parametro n (dimensione del d-heap)
		se n>0 allora
			inserisci il nodo u nella posizione del nodo da cancellare
				(ricorda che DheapNode contiene anche l'indice del nodo
	 				nel d-heap, che quindi deve essere aggiornato)
			MoveUp del nodo u
			MoveDown del nodo u
		return node.getData()
	 }
	*/
	public D delete(DHeapNode<K,D> node) {
		if (isEmpty())
			return null;
		else {
			DHeapNode<K,D> u = nodes.get(n - 1);
			nodes.remove(n - 1);
			n--;
			if (!isEmpty()) {
				swap(u, node);
				moveUp(u);
				moveDown(u);
			}
		}
		return node.getData();
	}

	/**
	 public D deleteMin() {
	 	se il d-heap è vuoto return null
	 	leggi il primo nodo del d-heap e salvalo in una variabile min delete(min)
	 	return min.getData()
	 }
	*/
	public D deleteMin() {
		if (isEmpty())
			return null;
			else {
				DHeapNode<K,D> min = nodes.get(0);
				nodes.remove(0);
				return min.getData();
		}
	}

	/**
	 public void increaseKey(K newKey, DHeapNode<K,D> node) {
	 	se la nuova chiave è maggiore della precedente
			aggiorna la chiave di node
			MoveDown di node
	 }
	 */
	 public void increaseKey(K newKey, DHeapNode<K,D> node) {
		if(node.getKey().compareTo(newKey) < 0){
			node.setKey(newKey);
			moveDown(node);
		}
	}

	/**
	 public void decreaseKey(K newKey, DHeapNode<K,D> node) {
	 se la nuova chiave è minore della precedente
	 aggiorna la chiave di node
	 MoveUp di node
	 }
	 */
	public void decreaseKey(K newKey, DHeapNode<K,D> node) {
		if(node.getKey().compareTo(newKey) > 0){
			node.setKey(newKey);
			moveUp(node);
		}
	}

	public boolean isEmpty() {
        if (n == 0)
			return true;
        else
			return false;
	}

	/**
	 * Move a priority queue node up to re-fix the heap 
	 */	
	private void moveUp(DHeapNode<K,D> v) {
		DHeapNode<K,D> f = father(v);
		while (v.getIndex() > 0 && (v.getKey()).compareTo(f.getKey()) < 0) {
			swap(v, f);
			f = father(v);
		}
	}

	/**
	 * Move a priority queue node down to re-fix the heap 
	 */
	private void moveDown(DHeapNode<K,D> v) {
		DHeapNode<K,D> min = minSon(v);
		while(min != null && (v.getKey()).compareTo(min.getKey()) > 0) {
			swap(v, min);
			min = minSon(v);			
		}
	}

	/**
	 * Swaps two nodes in the ArrayList 
	 */
	private void swap(DHeapNode<K,D> n1, DHeapNode<K,D> n2) {
		nodes.set(n1.getIndex(),n2);
		nodes.set(n2.getIndex(),n1);
		int temp = n1.getIndex();
		n1.setIndex(n2.getIndex());
		n2.setIndex(temp);
	}

	/**
	 * Returns the father node of a given priority queue node
	 * (returns null in case such node is the root)	  
	 */	
	private DHeapNode<K,D> father(DHeapNode<K,D> v) {
		if (v.getIndex() == 0) return null;
		return nodes.get( (v.getIndex()-1)/d );
	}

	/**
	 * Returns the son node with minimal key of a given priority queue node
	 * (returns null in case such node is a leaf)	  
	 */
	private DHeapNode<K,D> minSon(DHeapNode<K,D> v) {
		int f = (d * (v.getIndex())) + 1;
		if (f >= n) return null;
		DHeapNode<K,D> min = nodes.get(f);
		for (int i=f+1; (i < f+d) && (i < n); i++) {
			if ( ((nodes.get(i)).getKey()).compareTo(min.getKey()) < 0 )
				min = nodes.get(i);
		}
		return min;
	}

}
