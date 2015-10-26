package ihm.command;

import com.bankonet.Client;

public class RechercheClientNom implements IhmCommand{

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "Rechercher un client par son nom";
	}

	@Override
	public void execute(Client client) {
		// TODO Auto-generated method stub
		
	}

}
