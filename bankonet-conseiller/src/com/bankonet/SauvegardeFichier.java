package com.bankonet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SauvegardeFichier {
	
	public SauvegardeFichier(String fichierDeSauvegarde) {
		File file = new File(fichierDeSauvegarde); 
		    try {
		    	ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (file));
				oos.writeObject (this);
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
