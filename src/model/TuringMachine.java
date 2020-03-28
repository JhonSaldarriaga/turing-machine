package model;

public class TuringMachine {

	private Nodo firstNodo;
	private Nodo lastNodo;
	private int size;
	
	public TuringMachine() {
		firstNodo = null;
		lastNodo = null;
		size = 0;
	}
	
	public void addNodo(int n, char k) {
		if(firstNodo == null) {
			firstNodo = new Nodo(k);
			size++;
		}else {
			if(n==0) {
				Nodo aux = new Nodo(k);
				aux.setNextNodo(firstNodo);
				firstNodo = aux;
				aux.getNextNodo().setPrevNodo(aux);
				size++;
			}else {
				if(n==1){
					if((size%2) == 0) {
						int position = (size/2) + 1;
						putNodo(position, new Nodo(k));
					}else {
						int position = (size+1)/2;
						putNodo(position, new Nodo(k));
					}
				}else {
					if(n==2) {
						Nodo aux = firstNodo;
						while(aux.getNextNodo()!=null) {
							aux=aux.getNextNodo();
						}
						aux.setNextNodo(new Nodo(k));
						aux.getNextNodo().setPrevNodo(aux);
						size++;
					}
				}
			}
		}
	}
	
	public void addNodoEnd(char k) {
		if(firstNodo==null) {
			firstNodo=lastNodo=new Nodo(k);
		}else {
			lastNodo = new Nodo(k, null, lastNodo);
			lastNodo.getPrevNodo().setNextNodo(lastNodo);
		}
	}
	
	public void addNodoStart(char k) {
		if(firstNodo==null) {
			firstNodo=lastNodo=new Nodo(k);
		}else {
			firstNodo = new Nodo(k, firstNodo, null);
			firstNodo.getNextNodo().setPrevNodo(firstNodo);
		}
	}
	
	public void putNodo(int position, Nodo k) {
		
		Nodo aux = firstNodo;
		int cont = 1;
		while(cont<position) {
			aux = aux.getNextNodo();
			cont++;
		}
		if(aux.getPrevNodo()!=null) {
			k.setPrevNodo(aux.getPrevNodo());
			k.setNextNodo(aux);
			k.getNextNodo().setPrevNodo(k);
			size++;
		}else {
			k.setNextNodo(aux);
			k.getNextNodo().setPrevNodo(k);
			size++;
		}
		
	}
	
	public Nodo getFirst() {
		return firstNodo;
	}
}
