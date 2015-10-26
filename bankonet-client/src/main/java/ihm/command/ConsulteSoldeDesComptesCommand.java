package ihm.command;

import com.bankonet.Client;

import DAO.ClientDao;

public class ConsulteSoldeDesComptesCommand implements IhmCommand{

	
	@Override
	public Integer getId() {
		return 1;
	}

	@Override
	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "Consulter les soldes des comptes";
	}

	@Override
	public void execute(Client client) {
		ClientDao.SoldeDesComptes(client);
	}

}
