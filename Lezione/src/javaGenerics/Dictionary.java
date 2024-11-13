package javaGenerics;

/**
 * Implementazione di una interfaccia 
 * generica per la struttura dati Dizionario
 * con tipi generici (da Java 5.0 in poi)
 */
public interface Dictionary<K,D> {

	public D    search(K key);

	public void insert(K key, D data);
	
	public void delete(K key);

}
