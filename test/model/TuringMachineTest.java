package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TuringMachineTest {

	TuringMachine tm;
	
	public void setup1() {
		tm = new TuringMachine();
		tm.addNodo(0, 'k');//quinto
		tm.addNodo(0, 'l');//cuarto
		tm.addNodo(0, 'm');//tercero
		tm.addNodo(0, 'n');//segundo
		tm.addNodo(0, 'o');//primer
	}
	
	public void setup2() {
		tm = new TuringMachine();
		tm.addNodo(2, 'k');
		tm.addNodo(2, 'l');
		tm.addNodo(2, 'm');
		tm.addNodo(2, 'n');
		tm.addNodo(2, 'o');
	}
	
	public void setup3() {
		tm = new TuringMachine();
		tm.addNodo(0, 'k');
		tm.addNodo(0, 'l');
		tm.addNodo(1, 'm');
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
		
		//setup3();
		//aux = tm.getFirst();
		//char letter1 = aux.getLetter();
		//aux = aux.getNextNodo();
		//char letter2 = aux.getLetter();
		//aux = aux.getNextNodo();
		//char letter3 = aux.getLetter();
		
		//assertEquals('l', letter1);
		//assertEquals('m', letter2);
		//assertEquals('k', letter3);
	}
}