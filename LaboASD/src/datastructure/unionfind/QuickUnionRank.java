package datastructure.unionfind;

/**
 * Union find implementation based on Quick Union with heuristic on the rank.
 * It modifies the Quick Union implementation by changing the parent of the
 * root of the tree with minimal height. This heurisitcs guarantees that
 * the trees will have a depth which is at most logarithmic in their size.
 * In this way the complexity of find is O(log n). 
 *
 * @param <D> type of the data object 
 */	
public class QuickUnionRank<D> extends QuickUnion<D> {

	/**
	 * Creates an union find structure following the QuickUnion implementation
	 * with heuristic on the rank
	 */
	public QuickUnionRank() { }

	/**
	 Crea un insieme iniziale (di tipo QURst) s
	 Crea un nodo che contiene il dato d e l'insieme s
	 Restituisce il nodo creato
	*/
	public QUnode<D> makeSet(D d) {
		QURset s = new QURset();
		QUnode<D> tmp = new QUnode(d, s);
		return tmp;
	}

	/**
	 (ATTENZIONE: per accedere al rank di s e t serve fare un cast a QURset)
	 Se s e t coincidono return
	 Se s e t hanno rank uguale
	 	super.union.(s,t)
	 	aggiorna il rank di s
	 Altrimenti se s ha rank maggiore di t
	 	super.union.(s,t)
	 Altrimenti se t ha rank maggiore di d
	 	super.union(t,s)
	 */
	public void union(QUset s, QUset t) {
		if (s == t)
			return;

		if( s instanceof QURset && t instanceof QURset && ((QURset)s).rank == ((QURset)t).rank ) {
			super.union(s,t);
			((QURset)s).rank++;
		}	else if (((QURset)s).rank == ((QURset)t).rank )
				super.union(s,t);
				else
					super.union(t,s);
	}

}
