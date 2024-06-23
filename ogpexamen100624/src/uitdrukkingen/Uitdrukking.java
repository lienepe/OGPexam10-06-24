package uitdrukkingen;

import java.util.Iterator;
import java.util.function.Consumer;

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
	
	
	public abstract DeeluitdrukkingIterator<? extends Uitdrukking> iteratorDeeluitdrukkingen();
	
	public abstract void forEachVariabekeUitdrukking(Consumer<? super Uitdrukking> consumer);
}
