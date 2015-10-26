package ihm.command;

import com.bankonet.Client;

import DAO.CompteCourantDaoJpa;
import client.InitService;

public class InsereJeuxCompteCourant implements IhmCommand{

	@Override
	public Integer getId() {
		return 6;
	}

	@Override
	public String getLibelleMenu() {
		return "Insere un jeux de compte courant";
	}

	@Override
	public void execute(Client client) {
		InitService.init();
	}

}
