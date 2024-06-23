package uitdrukkingen;

import java.util.function.Consumer;

/**
 * @immutable
 */
public class LetterlijkeUitdrukking extends Uitdrukking {

	private int waarde;
	
	/**
	 * @post | getWaarde() == waarde
	 */
	public LetterlijkeUitdrukking(int waarde) {
		this.waarde = waarde;
	}
	
	public int getWaarde() {
		return waarde;
	}
	
	@Override
	/**
	 * @throws IllegalArgumentException | naam == null
	 * @post | result == 0
	 */
	public int aantalVoorkomens(String naam) {
		if (naam == null)
			throw new IllegalArgumentException();
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof LetterlijkeUitdrukking l && l.waarde == waarde;
	}
	
	@Override
	public DeeluitdrukkingIterator<Uitdrukking> iteratorDeeluitdrukkingen() {
		return new DeeluitdrukkingIterator<Uitdrukking>() {
			
			@Override
			public boolean hasNext() {
				return false;
			}
			
			@Override
			public Uitdrukking next() {
				return null;
			}
		};
	}
	
	@Override
	public void forEachVariabekeUitdrukking(Consumer<? super Uitdrukking> consumer) {
				
	}
}
