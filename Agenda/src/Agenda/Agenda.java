package Agenda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Agenda extends TreeMap<String, String>{	
		
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) throws IOException {			
			
		escribir("agenda.dat", leerConScanner("Agenda.txt", "utf-8"));
		
		
		
		/*do {
			System.out.print("> ");
			Scanner s = new Scanner(in.readLine());
			int estado = 0;
			String token;
			String nombre = null;
			while (estado != 5) {
				switch (estado) {
				case 0:
					try {
						token = s.skip("fin|buscar|[a-zA-ZáéíóúÁÉÍÓÚ]+\\s+([a-zA-ZáéíóúÁÉÍÓÚ]+\\s+)*[a-zA-ZáéíóúÁÉÍÓÚ]+|[a-zA-ZáéíóúÁÉÍÓÚ]+").match().group();
						if (token.equals("fin"))
							estado = 5;
						else if (token.equals("buscar"))
							estado = 2;
						else {
							nombre = token;
							estado = 1;
						}
					} catch (NoSuchElementException e) {
						System.out.println("Se esperaba 'buscar' o 'fin' o un nombre");
						estado = 5;
					}
					break;
				case 1:
					try {
						s.skip("-");
						estado = 3;
					}catch (NoSuchElementException e) {
						System.out.println("Se esperaba '-'");
						estado = 5;
					}
					break;
				case 2:
					try {
						s.skip(":");
						estado = 4;
					}catch (NoSuchElementException e) {
						System.out.println("Se esperaba ':'");
						estado = 5;
					}
					break;
				case 3:
					try {
						token = s.skip("\\d{9}").match().group();
						agenda.put(nombre, token);
						estado = 5;
					}catch (NoSuchElementException e) {
						System.out.println("Se esperaba un teléfono");
						estado = 5;
					}
					break;
				case 4:
					try {
						token = s.skip("[a-zA-ZáéíóúÁÉÍÓÚ]+\\s+([a-zA-ZáéíóúÁÉÍÓÚ]+\\s+)*[a-zA-ZáéíóúÁÉÍÓÚ]+|[a-zA-ZáéíóúÁÉÍÓÚ]+").match().group();
						String telefono = agenda.get(token);
						if (telefono != null)
							System.out.println(token + " -> " + telefono);
						else
							System.out.println(token + " no se encuentra en la agenda");
						estado = 5;
					} catch (NoSuchElementException e) {
						System.out.println("Se esperaba un nombre");
						estado = 5;
					}
					break;
				}
			}
		} while (!fin);*/
	}
	
	static Map<String, Integer> leerConScanner(String fichero, String codigo) throws IOException{
		Map<String, String> agenda = new HashMap<>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //Con esto es para las líneas de texto de texto
		String linea;
		Map<String, Integer> map = new TreeMap<>();
		boolean fin = false;
		do {
			System.out.print("> ");
			Scanner s = new Scanner(in.readLine());
			int estado = 0;
			String token;
			String nombre = null;
			while (estado != 5) {
				switch (estado) {
				case 0:
					try {
						token = s.skip("fin|buscar|[a-zA-ZáéíóúÁÉÍÓÚ]+\\s+([a-zA-ZáéíóúÁÉÍÓÚ]+\\s+)*[a-zA-ZáéíóúÁÉÍÓÚ]+|[a-zA-ZáéíóúÁÉÍÓÚ]+").match().group();
						if (token.equals("fin"))
							estado = 5;
						else if (token.equals("buscar"))
							estado = 2;
						else {
							nombre = token;
							estado = 1;
						}
					} catch (NoSuchElementException e) {
						System.out.println("Se esperaba 'buscar' o 'fin' o un nombre");
						estado = 5;
					}
					break;
				case 1:
					try {
						s.skip("-");
						estado = 3;
					}catch (NoSuchElementException e) {
						System.out.println("Se esperaba '-'");
						estado = 5;
					}
					break;
				case 2:
					try {
						s.skip(":");
						estado = 4;
					}catch (NoSuchElementException e) {
						System.out.println("Se esperaba ':'");
						estado = 5;
					}
					break;
				case 3:
					try {
						token = s.skip("\\d{9}").match().group();
						agenda.put(nombre, token);
						estado = 5;
					}catch (NoSuchElementException e) {
						System.out.println("Se esperaba un teléfono");
						estado = 5;
					}
					break;
				case 4:
					try {
						token = s.skip("[a-zA-ZáéíóúÁÉÍÓÚ]+\\s+([a-zA-ZáéíóúÁÉÍÓÚ]+\\s+)*[a-zA-ZáéíóúÁÉÍÓÚ]+|[a-zA-ZáéíóúÁÉÍÓÚ]+").match().group();
						String telefono = agenda.get(token);
						if (telefono != null)
							System.out.println(token + " -> " + telefono);
						else
							System.out.println(token + " no se encuentra en la agenda");
						estado = 5;
					} catch (NoSuchElementException e) {
						System.out.println("Se esperaba un nombre");
						estado = 5;
					}
					break;
				}
			}
		} while (!fin);
		return map;	
	
}
	static  void escribir(String fichero, Map<String, Integer> map) throws FileNotFoundException, IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichero))) {
			out.writeObject(map);
}
	}

}	
		
	/* public class Agenda extends TreeMap<String, String>{
	 	public String Ejecutar(String comando){....}
	 	
	 }*/
