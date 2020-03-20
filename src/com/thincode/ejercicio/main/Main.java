package com.thincode.ejercicio.main;


import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.thincode.ejercicio.clases.Persona;
import com.thincode.ejercicio.implementacion.PersonaImplementacion;

public class Main {
	public static void main(String[] args) {
		boolean aux = true;
		int opcion = 0;
		Map<Integer, Persona> listaPersona = null;
		while (aux) {
			System.out.println("Elige la opcion:");
			System.out.println("1.- Cargar archivo");
			System.out.println("2.- Mostrar lista");
			System.out.println("3.- Mostrar lista/id");
			System.out.println("4.- Salir");
			System.out.println("Elige la opcion:");
			try {
				Scanner entrada = new Scanner(System.in);
				opcion = entrada.nextInt();
				switch (opcion) {
				case 1:
					PersonaImplementacion persona = new PersonaImplementacion();
					listaPersona = persona.leerArchivo();
					break;
				case 2:
					if (listaPersona == null) {
						System.out.println("Porfa primero carga el archivo, aun no tengo datos para trabajar.");
					} else {
						Iterator<Integer> it = listaPersona.keySet().iterator();
						while (it.hasNext()) {
							Integer key = (Integer) it.next();
							System.out.println(listaPersona.get(key).toString());
						}
					}
					break;
				case 3:
					if (listaPersona == null) {
						System.out.println("Porfa primero carga el archivo, aun no tengo datos para trabajar.");
					} else {
						System.out.println("Ingresa el ID para buscar en la lista");
						Integer key = entrada.nextInt();
						System.out.println(listaPersona.get(key).toString());
					}
					break;
				case 4:
					System.out.println("Adiós");
					aux = false;
					break;
				default:
					System.out.println("Solo acepto números del 1 al 4");
				}
			} catch (Exception ex) {
				System.out.println("Lo siento la información que ingresaste no es la correcta, intenta de nuevo.");
			}
		}
	}
}
