package modele;

import java.util.ArrayList;

public class Bateaux {
	public enum TypeBateaux {

		PORTE_AVIONS, DESTROYER, SOUS_MARIN, PATROUILLE
	}

	ArrayList<Integer> arrayNumbreOfButton;

	int sizeBateau;

	public Bateaux(TypeBateaux typeBateaux) {
		arrayNumbreOfButton = new ArrayList<>();

		switch (typeBateaux) {

		case PORTE_AVIONS:
			this.sizeBateau = 4;
			break;

		case DESTROYER:
			this.sizeBateau = 3;
			break;

		case SOUS_MARIN:
			this.sizeBateau = 3;
			break;

		case PATROUILLE:
			this.sizeBateau = 2;
			break;
		}

	}

	public int getSizeBateau() {
		return this.sizeBateau;
	}

	public ArrayList<Integer> getArrayOfButtonNumber() {
		return this.arrayNumbreOfButton;
	}

	public void initCasesOftShip(int numbreOfCase, boolean vertical) {
		
		if (vertical == true) {

			for (int i = 0; i < this.sizeBateau; i++) {
				arrayNumbreOfButton.add(numbreOfCase);
				numbreOfCase+=10;
			}
			
		}

		else {
			for (int i = 0; i < this.sizeBateau; i++) {
				arrayNumbreOfButton.add(numbreOfCase + i + 1);
			}
		}

	}

}
