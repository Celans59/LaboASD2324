package datastructure.dictionary;

import datastructure.tree.AVLTree;

/**
 * Implementation of the Dictionary data structure with underlying AVL Tree representation.
 * @param <K> type of the key value
 * @param <D> type of the data object
 */
public class AVLDictionary<K extends Comparable<K>,D> extends AVLTree<K,D> implements Dictionary<K,D> {
	/**
	 * Creates an empty Dictionary
	 */
	public AVLDictionary() {
		super();
	}

	/** Inserts the mapping (<code>key</code>,<code>data</code>) into the dictionary; Cost: O(logn)
	 *  <p>
	 *  Duplicated keys are not allowed: if key is already in the dictionary, the associated data is overwritten.
	 *  <code>Null</code> key values are not allowed, while <code>null</code> data values are allowed.
	 *  @param key key value
	 *  @param data data mapped to the key value
	 *  @throws IllegalStateException if the <code>key</code> paramenter is <code>null</code>
 	 */
	@Override
	public void insert(K key, D data) throws IllegalStateException {
		AVLNode u = (AVLNode) searchNode(key);

		if(u != null)
			u.data = data;
		else
			super.insert(key, data);
	}

	/** Returns the data mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the Dictionary; Cost: O(logn)
	 *  @param key the key value to search
	 *  @return the data mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the Dictionary
	 */
	@Override
  public D search(K key) {
		return super.search(key);
	}

	/** Removes the mapping (<code>key</code>,<code>data</code>) from the dictionary and
	 *  returns the <code>data</code>; Cost: &Theta;(logn)
	 *  <p>
	 *  No action performed if the key is not in the dictionary
	 *  @param key the key value to search
	 *  @return the data mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the Dictionary
	 */
	@Override
  public D delete(K key) {
		return super.delete(key);
	}

	/**
	 * Returns the number of (<code>key</code>,<code>data</code>) mappings in the dictionary; Cost: O(1)
	 * @return number of key-data mappings in the tree
	 */
	public int size() {
		return super.size();
	}

	/**
	 * Returns <code>true</code> if the dictionary is empty; Cost: O(1)
	 * @return <code>true</code> if the dictionary is empty
	 */
	public boolean isEmpty() {
		return super.isEmpty();
	}
/* 
	@Override
	public void insert(K key, D data)throws IllegalStateException{

		if(key != null){
			@SuppressWarnings("unchecked")
			AVLNode u = (AVLNode) searchInsertPosition(key);

			if(u != null && u.key.equals(key)){
				u.data = data;
			} else {
				localInsert(u, key, data);
				localUpdate(u);
			}
		}

	}

	@SuppressWarnings("unchecked")
	public D searchInsertPosition(K key) {
		AVLNode prev = null;
		BTNode curr = (AVLNode) root;

		while(curr != null && !(curr.key.equals(key))){
			prev = (AVLNode) curr;
			if(key.compareTo(curr.key) < 0)
				curr = curr.left;
			else	
				curr = curr.right;
		}

		if(curr != null)
			return (D) curr;
		else	
			return (D) prev;
	}

	public void localInsert (BTNode u, K key, D data){
		BTNode v = new AVLNode(key, data);

		if(u == null)
			root = v;
		else if(key.compareTo(u.key) < 0)
				u.left = v;
			else
				u.right = v;
			
		v.parent = u;
		size++;
	}
	
	public void localUpdate (BTNode u){
		AVLNode p = (AVLNode) u.parent;

		while(p != null && p.balanceFactor() != 2){
			p.updateHeight();
			p = (AVLNode) p.parent;
		}

		if(p != null){
			p.super.update();
		}
	}
*/
}
