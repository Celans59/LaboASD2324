package datastructure.unionfind;

/**
 * Union find implementation based on Quick Find.
 * Nodes have a parent set, i.e. the set to which they belong.
 * Moreover, a node points to its brother node, in order
 * to have the possibility to traverses all the nodes in 
 * set. This is used to implement union: all the nodes in the
 * second set must change their parent set.
 * In this way, the complexity of union is proportional to the
 * size of the second set, i.e. O(n) given that sets contain
 * at most n elements.
 *
 * @param <D> type of the data object 
 */	
public class QuickFind<D> implements UnionFind<D, QFnode<D>, QFset<D>> {

	/**
	 * Creates an union find structure following the QuickFind implementation
	 */	
	public QuickFind() { }

	/**
	 Crea un nodo n che contiene d e con parent e next inizialmente null
	 Crea un set s che ha n sia come first sia come last
	 Inserisci s nel campo parent di n
	 Restituisci n
	*/
	public QFnode<D> makeSet(D d) {
		QFnode<D> n = new QFnode<>(d, null,  null);
		QFset<D> s = new QFset<> (n, n);
		n.parent = s;
		return n;
	}

	/**
	 Se s e t sono diversi
	 	scorri tutti i nodi di t e metti s nel campo parent
	 	aggiorna il campo next dell'ultimo nodo di s
	 	aggiorna il campo last di s
	*/
	public void union(QFset<D> s, QFset<D> t) {
		if (s != t) {
			QFnode<D> current = t.first;
			while (current != null) {
				current.parent = s;
				current = current.next;
			}
			s.last.next = t.first;
			s.last = t.last;
		}
	}

	/**
	 Restituisci il set nel campo parent del nodo n
	*/
	public QFset<D> find(QFnode<D> n) {
		return n.parent;
	}

}
