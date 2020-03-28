package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TuringMachineTest {

	TuringMachine tm;
	
	public void setup1() {
		tm = new TuringMachine();
		tm.addNodo('0', 'k');
		tm.addNodo('0', 'l');
		tm.addNodo('0', 'm');
		tm.addNodo('0', 'n');
		tm.addNodo('0', 'o');
	}
	
	public void setup2() {
		tm = new TuringMachine();
		tm.addNodo('2', 'k');
		tm.addNodo('2', 'l');
		tm.addNodo('2', 'm');
		tm.addNodo('2', 'n');
		tm.addNodo('2', 'o');
	}
	
	public void setup3() {
		tm = new TuringMachine();
		tm.addNodo('0', 'k');
		tm.addNodo('2', 'l');
		tm.addNodo('0', 'm');
		tm.addNodo('1', 'z');
	}
	
	public void setup4() {
		tm = new TuringMachine();
		tm.addNodo('1', 'k');
		tm.addNodo('1', 'l');
		tm.addNodo('1', 'm');
		tm.addNodo('1', 'z');
	}
	
	public void setup5() {
		tm = new TuringMachine();
	}
	
	@Test
	public void addNodoTest() {
		setup1();
		Nodo aux = tm.getFirst();
		Nodo prev1 = aux.getPrevNodo();
		char next1 = aux.getNextNodo().getLetter(); 
		aux = aux.getNextNodo();
		char prev2 = aux.getPrevNodo().getLetter();
		char next2 = aux.getNextNodo().getLetter(); 
		aux = aux.getNextNodo();
		char prev3 = aux.getPrevNodo().getLetter();
		char next3 = aux.getNextNodo().getLetter(); 
		aux = aux.getNextNodo();
		char prev4 = aux.getPrevNodo().getLetter();
		char next4 = aux.getNextNodo().getLetter(); 
		aux = aux.getNextNodo();
		char prev5 = aux.getPrevNodo().getLetter();
		Nodo next5 = aux.getNextNodo(); 
		
		assertEquals(null, prev1);
		assertEquals('o', prev2);
		assertEquals('n', prev3);
		assertEquals('m', prev4);
		assertEquals('l', prev5);
		
		assertEquals('n', next1);
		assertEquals('m', next2);
		assertEquals('l', next3);
		assertEquals('k', next4);
		assertEquals(null, next5);
		
		setup2();
		aux = tm.getFirst();
		prev1 = aux.getPrevNodo();
		next1 = aux.getNextNodo().getLetter(); 
		aux = aux.getNextNodo();
		prev2 = aux.getPrevNodo().getLetter();
		next2 = aux.getNextNodo().getLetter(); 
		aux = aux.getNextNodo();
		prev3 = aux.getPrevNodo().getLetter();
		next3 = aux.getNextNodo().getLetter(); 
		aux = aux.getNextNodo();
		prev4 = aux.getPrevNodo().getLetter();
		next4 = aux.getNextNodo().getLetter(); 
		aux = aux.getNextNodo();
		prev5 = aux.getPrevNodo().getLetter();
		next5 = aux.getNextNodo(); 
				
		assertEquals(null, prev1);
		assertEquals('k', prev2);
		assertEquals('l', prev3);
		assertEquals('m', prev4);
		assertEquals('n', prev5);
		
		assertEquals('l', next1);
		assertEquals('m', next2);
		assertEquals('n', next3);
		assertEquals('o', next4);
		assertEquals(null, next5);
		
		setup3();
		aux = tm.getFirst();
		prev1 = aux.getPrevNodo();
		next1 = aux.getNextNodo().getLetter(); 
		aux = aux.getNextNodo();
		prev2 = aux.getPrevNodo().getLetter();
		next2 = aux.getNextNodo().getLetter(); 
		aux = aux.getNextNodo();
		prev3 = aux.getPrevNodo().getLetter();
		next3 = aux.getNextNodo().getLetter(); 
		aux = aux.getNextNodo();
		prev4 = aux.getPrevNodo().getLetter();
		next5 = aux.getNextNodo(); 
 
		
		assertEquals(null, prev1);
		assertEquals('m', prev2);
		assertEquals('z', prev3);
		assertEquals('k', prev4);
		
		assertEquals('z', next1);
		assertEquals('k', next2);
		assertEquals('l', next3);
		assertEquals(null, next5);
		
		setup4();
		aux = tm.getFirst();
		prev1 = aux.getPrevNodo();
		next1 = aux.getNextNodo().getLetter(); 
		aux = aux.getNextNodo();
		prev2 = aux.getPrevNodo().getLetter();
		next2 = aux.getNextNodo().getLetter(); 
		aux = aux.getNextNodo();
		prev3 = aux.getPrevNodo().getLetter();
		next3 = aux.getNextNodo().getLetter(); 
		aux = aux.getNextNodo();
		prev4 = aux.getPrevNodo().getLetter();
		next5 = aux.getNextNodo(); 
 
		
		assertEquals(null, prev1);
		assertEquals('l', prev2);
		assertEquals('z', prev3);
		assertEquals('m', prev4);
		
		assertEquals('z', next1);
		assertEquals('m', next2);
		assertEquals('k', next3);
		assertEquals(null, next5);
	}
	
	@Test
	public void deleteNodoTest() {
		setup1();

		tm.deleteNodo('2');
		assertEquals('l', tm.getLast().getLetter());

		tm.deleteNodo('0');
		assertEquals('n', tm.getFirst().getLetter());

		tm.deleteNodo('1');
		assertEquals('n', tm.getFirst().getLetter());

		tm.deleteNodo('1');
		assertEquals('l', tm.getFirst().getLetter());

		tm.deleteNodo('2');
		assertEquals(null, tm.getFirst());
		assertEquals(null, tm.getLast());
	}
	
	@Test
	public void readNodoTest() {
		setup1();
		
		char letter = tm.readNodo('1');
		assertEquals('m', letter);
		
		tm.deleteNodo('2');
		letter = tm.readNodo('1');
		assertEquals('n', letter);
		
		letter = tm.readNodo('0');
		assertEquals('o', letter);
		
		letter = tm.readNodo('2');
		assertEquals('l', letter);
		
		setup5();
		letter = tm.readNodo('0');
		assertEquals('#', letter);
		
		letter = tm.readNodo('1');
		assertEquals('#', letter);
		
		letter = tm.readNodo('2');
		assertEquals('#', letter);
		
	}
}