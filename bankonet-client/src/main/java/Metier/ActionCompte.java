package Metier;

import com.bankonet.Compte;

public class ActionCompte {

	public static void EffectueDepot(Compte compte) {
		System.out.println("on est dans EffectueDepot");
		/*System.out.println("Montant à crediter?");
		Scanner sc = new Scanner(System.in);
		double montantCrediter = Double.parseDouble(sc.nextLine());
		try {
		compte.crediter(montantCrediter);
		} catch (Exception e) {
			System.out.println("Erreur dans la réalisation du dépot");
		}
		*/
		
	}

	public static void EffectueRetrait(Compte compte) {
		// TODO Auto-generated method stub
		System.out.println("on est dans EffectueRetrait");
		
		
		
	}

	public static void EffectueVirementEntreCompte() {
		// TODO Auto-generated method stub
		System.out.println("on est dans EffectueVirementEntreCompte");
	}

	public static void EffectueVirementExterne() {
		System.out.println("on est dans EffectueVirementExterne");
		
		
	}

}
