package app;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.bankonet.Client;

import DTO.Dto;
import ihm.command.ExitCommand;
import ihm.command.IhmCommand;
import ihm.command.InsereJeuxCompteCourant;
import ihm.command.RechercheClientNom;
import ihm.command.RechercheClientPrenom;
import ihm.command.ConsulteSoldeDesComptesCommand;
import ihm.command.EffectueDepotCommand;

public class ConsoleApp {
	
	private Scanner sc = new Scanner(System.in);

	private List<IhmCommand> commands = Arrays.asList(
			new ExitCommand(), 
			new ConsulteSoldeDesComptesCommand(),
			new EffectueDepotCommand(),
			new RechercheClientNom(),
			new RechercheClientPrenom(),
			new InsereJeuxCompteCourant()
			);

	public static void main(String[] args) {
		ConsoleApp app = new ConsoleApp();
		app.afficherMenu();
	}

	public void afficherMenu() {
		Client client = Dto.GestionMenuLogIn();
		while(true) {
			System.out.println("****APPLICATION CLIENT***");
			for (IhmCommand command : commands) {
				System.out.println(command.getId() + ". " + command.getLibelleMenu());
			}	
			Integer saisie = sc.nextInt();
			for(IhmCommand command : commands) {
				if(command.getId().equals(saisie)) {
					command.execute(client);
				}
			}
		}
	}
}
