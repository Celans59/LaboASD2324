package datastructure.unionfind;

/**
 * Union find implementation based on Quick Find with heuristic on the size.
 * It modifies the Quick Find implementation of the uniong operation by changing 
 * the parent set of the nodes in the smaller set.
 * In this way, the maximal number of changes in a sequence of n-1 union will
 * be O(n log n), hence the amortized cost of union is O(log n).
 *
 * @param <D> type of the data object 
 */	
public class QuickFindSize<D> extends QuickFind<D> {

	/**
	 * Creates an union find structure following the QuickFind implementation
	 * with heuristic on the size	
	 */	
	public QuickFindSize() { }

	/**
	 Crea un nodo n che contiene d e con parent e next inizialmente null
	 Crea un set (QFRset) s con n sia come first che come last e size 1
	 Inserisci s nel campo parent di n
	 Restituisci n
	*/
	public QFnode<D> makeSet(D d) {
		QFnode<D> n = new QFnode(d, null, null);
		QFRset<D> s = new QFRset(n, n, 1);
		n.parent = s;
		return n;
	}

	/**
	 (ATTENZIONE: per accedere al size di s e t serve fare un cast a QFRset)
	 Se s e t sono diversi
	 	Se il size di s è maggiore o uguale al size di t
	 	super.union.(s,t)
	 	aggiorna il size di s
	 Altrimenti
	 	super.union(t,s)
	 	aggiorna il size di t
	*/
	public void union(QFset<D> s, QFset<D> t) {
		if (s != t) {
			if (s instanceof QFRset && t instanceof QFRset && ((QFRset) s).size >= ((QFRset) t).size) {
				super.union(s, t);
				((QFRset) s).size += ((QFRset) t).size;
			} else {
				super.union(t, s);
				((QFRset) t).size += ((QFRset) s).size;
			}
		}
	}

}
