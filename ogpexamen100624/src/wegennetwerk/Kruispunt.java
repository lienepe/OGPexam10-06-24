package wegennetwerk;

import java.util.HashSet;
import java.util.Set;

/**
 * @invar | getVertrekkendeWegen() != null
 * @invar | getAankomendeWegen() != null
 * @invar | getVertrekkendeWegen().stream().allMatch(w -> w != null && w.getStartkruispunt() == this)
 * @invar | getAankomendeWegen().stream().allMatch(w -> w!= null && w.getEindkruispunt() == this)
 */
public class Kruispunt {

	/**
	 * @invar | vertrekkendeWegen != null
	 * @invar | aankomendeWegen != null
	 * @invar | vertrekkendeWegen.stream().allMatch(w -> w != null && w.startkruispunt == this)
	 * @invar | aankomendeWegen.stream().allMatch(w -> w != null && w.eindkruispunt == this)
	 * @representationObject
	 * @peerObjects
	 */
	Set<Weg> vertrekkendeWegen = new HashSet<Weg>();
	/**
	 * @representationObject
	 * @peerObjects
	 */
	Set<Weg> aankomendeWegen = new HashSet<Weg>();
	
	/**
	 * @peerObjects
	 */
	public Set<Weg> getVertrekkendeWegen() {
		return new HashSet<Weg>(vertrekkendeWegen);
	}
	
	/**
	 * @peerObjects
	 */
	public Set<Weg> getAankomendeWegen() {
		return new HashSet<Weg>(aankomendeWegen);
	}
	
}
