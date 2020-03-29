package ui;

import java.io.*;

import model.*;

public class Main {

	private TuringMachine tm;
	private final String DATABASE_NAME = "data/in_turing.txt";
	private final String REPORT = "data/report.txt";
	
	public static void main (String [] args) throws IOException {
		Main main = new Main();
		main.program();
	}
	
	public Main() {
		tm = new TuringMachine();
	}
	
	public void program() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(REPORT));
		File file = new File(DATABASE_NAME);
		char[] data;
		if(file.exists()) {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			boolean empty = false;
			String line = "";
			while(!empty) {
				line = br.readLine();
				if(line==null){
					empty = true;
				}else {
					data = line.toCharArray();
					resolve(line, bw, data);
					resetTuringMachine();
				}
			}
			
			br.close();
			bw.close();
		}
	}
	
	public void resolve(String line, BufferedWriter bw, char[] data) throws IOException {	
		int position = 0;
		int size = data.length;
		while(position<size) {
			if(data[position+1] == '0') {
				bw.write(tm.readNodo(data[position]) + "\n");
				position+=2;
			}else {
				if(data[position+1] == '1'){
					tm.addNodo(data[position], data[position+2]);
					position+=3;
				}else {
					if(data[position+1] == '2'){
						tm.deleteNodo(data[position]);
						position+=2;
					}
				}
			}
			
			bw.flush();
		}
	}
	
	public void resetTuringMachine() {
		tm.resetTuringMachine();
	}
}
