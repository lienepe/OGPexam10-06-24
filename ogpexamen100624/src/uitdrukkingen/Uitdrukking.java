package uitdrukkingen;

import java.util.Iterator;

/**
 * @immutable
 */
public abstract class Uitdrukking {
	
	/**
	 * Behavioral subtyping bla bla
	 * @throws IllegalArgumentException | naam == null
	 * @post | 0 <= result
	 */
	public abstract int aantalVoorkomens(String naam);
	
	@Override
	public abstract boolean equals(Object obj);
	
	/*
	public Iterator<Uitdrukking> iteratorDeeluitdrukkingen() {
		return new Iterator<Uitdrukking>() {
			
		};
	}
	*/
}
