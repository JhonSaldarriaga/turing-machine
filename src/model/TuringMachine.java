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
		if(n=='0') {
			addNodoStart(k);
		}
		if(n=='1') {
			addNodoMiddle(k);
		}
		if(n=='2') {
			addNodoEnd(k);
		}
	}
	
	public void addNodoStart(char k) {
		if(firstNodo==null) {
			firstNodo=lastNodo=new Nodo(k);
		}else {
			firstNodo = new Nodo(k, firstNodo, null);
			firstNodo.getNextNodo().setPrevNodo(firstNodo);
		}
		
		size++;
	}

	public void addNodoMiddle(char k) {
		if(firstNodo==null) {
			firstNodo=lastNodo=new Nodo(k);
		}else {
			if(size==1) {
				Nodo newN = new Nodo(k, firstNodo, null);
				firstNodo.setPrevNodo(newN);
				firstNodo = newN;
			}else {
				Nodo aux = firstNodo;
				int cont = 1;
				if(size%2==0) {//se añade al siguiente de esa posicion
					while(cont<size/2) {
						aux = aux.getNextNodo();
						cont++;
					}
					Nodo newN = new Nodo(k, aux.getNextNodo(), aux);
					aux.getNextNodo().setPrevNodo(newN);
					aux.setNextNodo(newN);
					
				}else {//se añade al anterior de esa posicion
					int position = (size/2)+1;
					while(cont<position) {
						aux = aux.getNextNodo();
						cont++;
					}
					Nodo newN = new Nodo(k, aux, aux.getPrevNodo());
					aux.getPrevNodo().setNextNodo(newN);
					aux.setPrevNodo(newN);
				}
			}
		}
		
		size++;
	}
	
	public void addNodoEnd(char k) {
		if(firstNodo==null) {
			firstNodo=lastNodo=new Nodo(k);
		}else {
			lastNodo = new Nodo(k, null, lastNodo);
			lastNodo.getPrevNodo().setNextNodo(lastNodo);
		}
		
		size++;
	}
	
	public void deleteNodo(int n) {
		if(n=='0') {
			deleteFirstNodo();
		}
		if(n=='1') {
			deleteNodoMiddle();
		}
		if(n=='2') {
			deleteLastNodo();
		}
	}
	
	public void deleteFirstNodo() {
		if(firstNodo!=null) {
			if(firstNodo==lastNodo) {
				firstNodo=lastNodo=null;
			}else {
				firstNodo = firstNodo.getNextNodo();
				lastNodo.setPrevNodo(null);
			}
			size--;
		}
	}
	
	public void deleteNodoMiddle() {
		if(firstNodo!=null){
			if(size==1) {
				firstNodo=lastNodo=null;
			}else {
				if(size==2) {
					deleteFirstNodo();
				}else {
					Nodo aux = firstNodo;
					int cont = 1;
					if(size%2==0) {//se añade al siguiente de esa posicion
						while(cont<size/2) {
							aux = aux.getNextNodo();
							cont++;
						}
						Nodo newN = aux.getPrevNodo();
						newN.setNextNodo(aux.getNextNodo());
						aux.getNextNodo().setPrevNodo(newN);
						
					}else {//se añade al anterior de esa posicion
						int position = (size/2)+1;
						while(cont<position) {
							aux = aux.getNextNodo();
							cont++;
						}
						Nodo newN = aux.getPrevNodo();
						newN.setNextNodo(aux.getNextNodo());
						aux.getNextNodo().setPrevNodo(newN);
					}
				}
			}
		}
		
		size--;
	}
	
	public void deleteLastNodo() {
		if(firstNodo!=null) {
			if(firstNodo==lastNodo) {
				firstNodo=lastNodo=null;
			}else {
				lastNodo = lastNodo.getPrevNodo();
				lastNodo.setNextNodo(null);
			}
			
			size--;
		}
	}
	
	public char readNodo(int n) {
		if(n=='0') {
			if(firstNodo!=null) {
				return firstNodo.getLetter();
			}else
				return '#';
		}
		if(n=='1') {
			return readNodoMiddle();
		}
		if(n=='2') {
			if(lastNodo!=null) {
				return lastNodo.getLetter();
			}else
				return '#';
		}
		
		return '#';
	}
	
	private char readNodoMiddle() {
		if(firstNodo==null) {
			return '#';
		}else {
			if(size==1) {
				return firstNodo.getLetter();
			}else {
				Nodo aux = firstNodo;
				int cont = 1;
				if(size%2==0) {//se añade al siguiente de esa posicion
					while(cont<size/2) {
						aux = aux.getNextNodo();
						cont++;
					}
					return aux.getLetter();
					
				}else {//se añade al anterior de esa posicion
					int position = (size/2)+1;
					while(cont<position) {
						aux = aux.getNextNodo();
						cont++;
					}
					return aux.getLetter();
				}
			}
		}
	}
	
	public Nodo getFirst() {
		return firstNodo;
	}
	
	public Nodo getLast() {
		return lastNodo;
	}
	
	public String showList() {
		String message = "";
		if(firstNodo==null) {
			message = "No nodos";
		}else {
			message = "<==>";
			Nodo aux = firstNodo;
			while(aux!=null) {
				message = message + "[" + aux.getLetter() + "]<==>";
				aux = aux.getNextNodo();
			}
		}
		
		return message;
	}
	
	public String showListReverse() {
		String message = "";
		if(lastNodo==null) {
			message = "No nodos";
		}else {
			message = "<==>";
			Nodo aux = lastNodo;
			while(aux!=null) {
				message = message + "[" + aux.getLetter() + "]<==>";
				aux = aux.getPrevNodo();
			}
		}
		
		return message;
	}
}
