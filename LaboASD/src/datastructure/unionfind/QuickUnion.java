package datastructure.unionfind;

/**
 * Union find implementation based on Quick Union.
 * Sets are initially singleton (they points to themselves as
 * the parent set). Then they change their parent when 
 * they are the second parameter of the union operation.
 * The complexity of union is constant.
 * The find operation traverses the tree from a set of interest 
 * to return the root set. The complexity is O(h), where h is the 
 * distance from the initial set to the root. The maximal h is n-1,
 * hence the worst complexity for find is O(n).
 *   
 * @param <D> type of the data object 
 */	
public class QuickUnion<D> implements UnionFind<D, QUnode<D>, QUset> {

	/**
	 * Creates an union find structure following the QuickUnion implementation
	 */	
	public QuickUnion() { }

	/**
	 Crea un insieme iniziale (singoletto) s
	 Crea un nodo che contiene il dato d e l'insieme s
	 Restituisci il nodo creato
	*/
	public QUnode<D> makeSet(D d) {
		QUset u = new QUset();
		QUnode<D> tmp = new QUnode(d, u);
		return tmp;
	}

	/**
	 Se s e t sono diversi e rappresentano correttamente insiemi
	 	(Ovvero hanno se stessi come parent)
	 	s diventa il parent di t
	 */
	public void union(QUset s, QUset t) {
		if (s.parent != t.parent)
			t.parent = s;
	}

	/**
	 Sia s il set del nodo n
	 A partire da s sali la catena di parent fino ad arrivare alla radice
	 	(ovvero un set che ha se stesso come parent)
	 Ritorna la radice
	 */
	public QUset find(QUnode<D> n) {
		QUset s = n.set;

		while (s.parent != s)
			s = s.parent;

		return s;
	}

}
