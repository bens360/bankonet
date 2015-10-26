package ihm.command;

import com.bankonet.Client;

public interface IhmCommand {

	Integer getId();
	String getLibelleMenu();
	void execute(Client client);
}
