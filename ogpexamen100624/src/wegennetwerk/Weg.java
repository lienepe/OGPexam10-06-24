package wegennetwerk;

import java.util.Set;
import java.util.stream.Collectors;

import logicalcollections.LogicalSet;

/**
 * @invar | getStartkruispunt() == null || getStartkruispunt().getVertrekkendeWegen().contains(this)
 * @invar | getEindkruispunt() == null || getEindkruispunt().getAankomendeWegen().contains(this)
 */
public class Weg {
	
	/**
	 * @invar | startkruispunt == null || startkruispunt.vertrekkendeWegen.contains(this)
	 * @invar | eindkruispunt == null || eindkruispunt.aankomendeWegen.contains(this)
	 * @peerObject
	 */
	Kruispunt startkruispunt = null;
	/**
	 * @peerObject
	 */
	Kruispunt eindkruispunt = null;
	
	/**
	 * @peerObject
	 */
	public Kruispunt getStartkruispunt() {
		return startkruispunt;
	}
	
	/**
	 * @peerObject
	 */
	public Kruispunt getEindkruispunt() {
		return eindkruispunt;
	}
	
	/**
	 * @throws IllegalArgumentException | kruispunt == null
	 * @throws IllegalArgumentException | getStartkruispunt() != null
	 * @mutates_properties | getStartkruispunt(), kruispunt.getVertrekkendeWegen()
	 * @post | getStartkruispunt() == kruispunt
	 * @post | kruispunt.getVertrekkendeWegen().equals(LogicalSet.plus(old(kruispunt.getVertrekkendeWegen()), this))
	 */
	public void setStartkruispunt(Kruispunt kruispunt) {
		if (startkruispunt != null)
			throw new IllegalArgumentException();
		if (kruispunt == null)
			throw new IllegalArgumentException();
		startkruispunt = kruispunt;
		kruispunt.vertrekkendeWegen.add(this);
	}
	
	/**
	 * @pre | kruispunt != null
	 * @pre | getEindkruispunt() == null
	 * @mutates_properties | getEindkruispunt(), kruispunt.getAankomendeWegen()
	 * @post | getEindkruispunt() == kruispunt
	 * @post | kruispunt.getAankomendeWegen().equals(LogicalSet.plus(old(kruispunt.getAankomendeWegen()), this))
	 */
	public void setEindkruispunt(Kruispunt kruispunt) {
		eindkruispunt = kruispunt;
		kruispunt.aankomendeWegen.add(this);
	}
	
	/**
	 * @pre | getStartkruispunt() != null
	 * @mutates_properties | getStartkruispunt(), getStartkruispunt().getVertrekkendeWegen()
	 * @post | getStartkruispunt() == null
	 * @post | old(getStartkruispunt()).getVertrekkendeWegen().equals(LogicalSet.minus(old(getStartkruispunt().getVertrekkendeWegen()), this))
	 */
	public void ontkoppelStartkruispunt() {
		startkruispunt.vertrekkendeWegen.remove(this);
		startkruispunt = null;
	}
	
	/**
	 * @pre | getEindkruispunt() != null
	 * @mutates_properties | getEindkruispunt(), getEindkruispunt().getAankomendeWegen()
	 * @post | getEindkruispunt() == null
	 * @post | old(getEindkruispunt()).getAankomendeWegen().equals(LogicalSet.minus(old(getEindkruispunt().getAankomendeWegen()), this))
	 */
	public void ontkoppelEindkruispunt() {
		eindkruispunt.aankomendeWegen.remove(this);
		eindkruispunt = null;
	}
	
	public Set<Weg> getTweedeOrdeWegen() {
		return getEindkruispunt().getVertrekkendeWegen()
								.stream()
								.map(w -> w.eindkruispunt)
								.flatMap(k -> k.vertrekkendeWegen.stream())
								.collect(Collectors.toSet());
	}
}
