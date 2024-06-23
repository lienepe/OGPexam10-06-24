package uitdrukkingen;

public abstract class DeeluitdrukkingIterator<T extends Uitdrukking> {
	
	public abstract boolean hasNext();
	public abstract T next();
}
