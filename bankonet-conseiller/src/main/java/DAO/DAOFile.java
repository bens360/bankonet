package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DAOFile {

	/**
	* M�thode permettant r�cup�rer les infos d'un fichier s�rialis� 
	* @param nomFichier (String) le nom du fichier � r�cup�rer
	* @return listObjet (ArrayList): l'objet qui est renvoy�
	*/
	public static ArrayList<Object> RecupereInfoFichier (String nomFichier){
		ArrayList<Object> listObjet= new ArrayList<Object>();
		try
		{
		    ObjectInputStream ois = new ObjectInputStream (new FileInputStream (nomFichier)); 
	        byte[] buf = new byte[8];
	        @SuppressWarnings("unused")
			int n = 0;
	        while ((n = ois.read(buf)) != -1) {
	    	listObjet.add(ois.readObject());
		    }
		    ois.close();
		}
		catch (ClassNotFoundException exception)
		{
		    System.out.println ("Impossible de lire l'objet : " + exception.getMessage());
		}
		catch (IOException exception)
		{
		    System.out.println ("Erreur lors de l'�criture : " + exception.getMessage());
		}
		return listObjet;
	}

	/**
	 * M�thode permettant de sauvegarder un objet dans un fichier
	 * @param fichierDeSauvegarde
	 * @param objetASauvegarder
	 */
	
	public static void SauvegardeFichier(String fichierDeSauvegarde, Object objetASauvegarder) {
		File file = new File(fichierDeSauvegarde); 
		    try {
		    	ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (file));
				oos.writeObject (objetASauvegarder);
				//System.out.println("Objet: " + objetASauvegarder.toString() + "sauvegrader dans :" + fichierDeSauvegarde);
				oos.close();
			} catch (IOException e) {
				System.out.println("Erreur lors de l'�criture de l'objet :" + objetASauvegarder.toString() + "dans le fichier " + fichierDeSauvegarde);
				e.printStackTrace();
			}
	}

	/**
	 * M�thode affichant le listing des clients
	 */
	public static void ListeClients() {
		ArrayList<Object> listClient = RecupereInfoFichier("clients.properties");
		int compteurObjet=0;
		for (Object object : listClient) {
			compteurObjet++;
			System.out.println(object);
		}
		System.out.println(compteurObjet);
	}
}
