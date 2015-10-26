package ihm.command;

import com.bankonet.Client;

public class ExitCommand implements IhmCommand{
	
	@Override
	public Integer getId() {
		return 0;
	}

	@Override
	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "Arrêter le programme";
	}

	@Override
	public void execute(Client client) {
		System.exit(0);
	}
	
}


