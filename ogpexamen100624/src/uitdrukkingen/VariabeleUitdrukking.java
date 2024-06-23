package uitdrukkingen;

import java.util.function.Consumer;

/**
 * @immutable
 * @invar | getNaam() != null
 */
public class VariabeleUitdrukking extends Uitdrukking {

	/**
	 * @invar | naam != null
	 */
	private String naam;
	
	/**
	 * @throws IllegalArgumentException | naam == null
	 * @post | getNaam() == naam
	 */
	public VariabeleUitdrukking(String naam) {
		if (naam == null)
			throw new IllegalArgumentException();
		this.naam = naam;
	}
	
	public String getNaam() {
		return naam;
	}
	
	@Override
	/**
	 * @throws IllegalArgumentException | naam == null
	 * @post | !(getNaam() == naam) || result == 1
	 * @post | getNaam() == naam || result == 0
	 */
	public int aantalVoorkomens(String naam) {
		if (naam == null)
			throw new IllegalArgumentException();
		if (naam == this.naam)
			return 1;
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof VariabeleUitdrukking v && v.naam == naam;
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
		consumer.accept(this);
	}
}
