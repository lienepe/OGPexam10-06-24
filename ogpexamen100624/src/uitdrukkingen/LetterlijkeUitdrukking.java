package uitdrukkingen;

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
}
