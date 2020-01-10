package modele;

import java.util.ArrayList;
import java.util.Random;


public class AI {
	public enum StatutBateauAI {
		TOUCHE, COULE, RATE
	}
	private ArrayList<Bateaux> arrayBateauAI;

	public AI() {
		arrayBateauAI = new ArrayList<>();

		Bateaux porteAvions = new Bateaux(Bateaux.TypeBateaux.PORTE_AVIONS);
		Bateaux destroyer = new Bateaux(Bateaux.TypeBateaux.DESTROYER);
		Bateaux sousMarin = new Bateaux(Bateaux.TypeBateaux.SOUS_MARIN);
		Bateaux patrouille = new Bateaux(Bateaux.TypeBateaux.PATROUILLE);

		arrayBateauAI.add(porteAvions);
		arrayBateauAI.add(destroyer);
		arrayBateauAI.add(sousMarin);
		arrayBateauAI.add(patrouille);

		initPlacementOfShip();

	
	}

	public void initPlacementOfShip() {
		int x;
		int y;
		int valueCase;
		boolean goodCheckUp = false;
		ArrayList<Boolean> gridBool = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			gridBool.add(true);

		}

		for (int i = 0; i < this.arrayBateauAI.size(); i++) {
			Bateaux bateauCourant = this.arrayBateauAI.get(i);

			do {

				boolean vertical = new Random().nextBoolean();

				if (vertical == true) {
					x = new Random().nextInt(10 - bateauCourant.sizeBateau);
					y = new Random().nextInt(10);
				}

				else {
					x = new Random().nextInt(10);
					y = new Random().nextInt(10 - bateauCourant.sizeBateau);
				}

				valueCase = (x * 10) + y;

				bateauCourant.initCasesOftShip(valueCase, vertical);

				// tant que c vrai je regarde lautre
				int cpt = 1;
				while (gridBool.get(bateauCourant.getArrayOfButtonNumber().get(cpt-1)) == true
						&& cpt < bateauCourant.sizeBateau) {

					cpt++;
				}

				if (cpt == bateauCourant.sizeBateau) {
					goodCheckUp = true;
				} else {
					goodCheckUp = false;
					bateauCourant.getArrayOfButtonNumber().clear();
				}

			} while (goodCheckUp == false);

			for (int j = 0; j < bateauCourant.getArrayOfButtonNumber().size(); j++) {
				gridBool.add(bateauCourant.getArrayOfButtonNumber().get(j), false);
			}

		}

	}

	public StatutBateauAI getStatut(int valueCase) {
		StatutBateauAI statutBateau = StatutBateauAI.RATE;

		for (int i = 0; i < this.arrayBateauAI.size(); i++) {
			for (int j = 0; j < this.arrayBateauAI.get(i).getArrayOfButtonNumber().size(); j++)

				if (valueCase == this.arrayBateauAI.get(i).getArrayOfButtonNumber().get(j)) {
					statutBateau = StatutBateauAI.TOUCHE;
					this.arrayBateauAI.get(i).getArrayOfButtonNumber().remove(j);
					if (this.arrayBateauAI.get(i).getArrayOfButtonNumber().isEmpty()) {
						statutBateau = StatutBateauAI.COULE;
					}
				}
		}

		return statutBateau;
	}

}
