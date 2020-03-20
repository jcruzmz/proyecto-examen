package com.thincode.ejercicio.implementacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.thincode.ejercicio.clases.Persona;
import com.thincode.ejercicio.interfaces.PersonaInterface;

public class PersonaImplementacion implements PersonaInterface {
	private Persona persona = null;
	private JFrame frame;
    private JFileChooser fc = new JFileChooser();
	public PersonaImplementacion() {
		frame = new JFrame();

		frame.setVisible(true);
		BringToFront();
	}

	public File getFile() {
		if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(null)) {
			frame.setVisible(false);
			return fc.getSelectedFile();
		} else {
			return null;
		}
	}

	private void BringToFront() {
		frame.setExtendedState(JFrame.ICONIFIED);
		frame.setExtendedState(JFrame.NORMAL);

	}

	@Override
	public Map<Integer,Persona> leerArchivo() {
		Map<Integer,Persona> map = new HashMap<Integer,Persona>();
		String cadena;
		File archivo = getFile();
		if (archivo== null) {
			return null;
		}
		else {
			String ruta = archivo.getPath();
			FileReader f = null;
			try {
				f = new FileReader(ruta);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedReader b = new BufferedReader(f);
			try {
				while ((cadena = b.readLine()) != null) {
					Pattern pat = Pattern.compile("(\\d+)\\s(([a-zA-Z]+\\s?){4})\\s(\\d+)\\s(([0-9]+\\/?){3})\\s(.*\\@(.*\\..*){1,2})");
				    Matcher mat = pat.matcher(cadena);
				    if(mat.matches()) {
				    	persona = new Persona();
				    	persona.setId(Integer.parseInt(mat.group(1)));
				    	persona.setNombre(mat.group(2));
				    	persona.setEdad(Integer.parseInt(mat.group(4)));
				    	persona.setFechaNacimiento(mat.group(5));
				    	persona.setCorreo(mat.group(7));
						map.put(Integer.parseInt(mat.group(1)),persona);
				    }
				}
				return map;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				b.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
