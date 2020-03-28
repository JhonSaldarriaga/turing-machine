package model;

public class Nodo {

	private Nodo nextNodo;
	private Nodo prevNodo;
	private char letter;

	public Nodo(char letter, Nodo next, Nodo prev) {
		nextNodo = next;
		prevNodo = prev;
	}
	
	public Nodo(char letter) {
		this.letter = letter;
		nextNodo = null;
		prevNodo = null;
	}

	public Nodo getNextNodo() {
		return nextNodo;
	}

	public void setNextNodo(Nodo nextNodo) {
		this.nextNodo = nextNodo;
	}

	public Nodo getPrevNodo() {
		return prevNodo;
	}

	public void setPrevNodo(Nodo prevNodo) {
		this.prevNodo = prevNodo;
	}

	public char getLetter() {
		return letter;
	}
}
