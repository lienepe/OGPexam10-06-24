package uitdrukkingen;

/**
 * @immutable
 * @invar | getLinker() != null
 * @invar | getRechter() != null
 */
public class Optelling extends Uitdrukking{

	/**
	 * @invar | linker != null
	 * @invar | rechter != null
	 */
	private Uitdrukking linker;
	private Uitdrukking rechter;
	
	/**
	 * @throws IllegalArgumentException | linker == null || rechter == null
	 * @post | getLinker() == linker
	 * @post | getRechter() == rechter
	 */
	public Optelling(Uitdrukking linker, Uitdrukking rechter) {
		if (linker == null || rechter == null)
			throw new IllegalArgumentException();
		this.linker = linker;
		this.rechter = rechter;
	}
	
	public Uitdrukking getLinker() {
		return linker;
	}
	
	public Uitdrukking getRechter() {
		return rechter;
	}
	
	@Override
	/**
	 * @throws IllegalArgumentException | naam == null
	 * @post | result == getLinker().aantalVoorkomens(naam) + getRechter().aantalVoorkomens(naam)
	 */
	public int aantalVoorkomens(String naam) {
		if (naam == null)
			throw new IllegalArgumentException();
		return linker.aantalVoorkomens(naam) + rechter.aantalVoorkomens(naam);
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Optelling o && o.linker.equals(linker) && o.rechter.equals(rechter);
	}
}
