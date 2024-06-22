package uitdrukkingen;

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
}
