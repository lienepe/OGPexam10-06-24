package wegennetwerk.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import wegennetwerk.Kruispunt;
import wegennetwerk.Weg;

class WegennetwerkTest {

	@Test
	void test() {
		// op examen nog meer testen schrijven, maar dit is even goed voor het principe
		Kruispunt k1 = new Kruispunt();
		Kruispunt k2 = new Kruispunt();
		Kruispunt k3 = new Kruispunt();
		
		assertTrue(k1.getAankomendeWegen().isEmpty());
		assertTrue(k1.getVertrekkendeWegen().isEmpty());
		
		Weg w1 = new Weg();
		
		assertNull(w1.getStartkruispunt());
		assertNull(w1.getEindkruispunt());
		
		w1.setEindkruispunt(k1);
		assertSame(w1.getEindkruispunt(), k1);
		assertTrue(k1.getAankomendeWegen().contains(w1));
		
		Weg w2 = new Weg();
		Weg w3 = new Weg();
		Weg w4 = new Weg();
		Weg w5 = new Weg();
		Weg w6 = new Weg();

		w2.setStartkruispunt(k1);
		assertThrows(IllegalArgumentException.class, () -> w2.setStartkruispunt(k2));
		assertSame(w2.getStartkruispunt(), k1);
		assertTrue(k1.getVertrekkendeWegen().contains(w2));
		
		w2.setEindkruispunt(k2);
		w3.setStartkruispunt(k2);
		w4.setStartkruispunt(k2);
		w5.setStartkruispunt(k1);
		w5.setEindkruispunt(k3);
		w6.setStartkruispunt(k3);
		
		HashSet<Weg> wegen = new HashSet<Weg>(List.of(w3, w4,w6));
		assertEquals(wegen, w1.getTweedeOrdeWegen());
	}

}
