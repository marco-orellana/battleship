package controlleur;

import vue.*;
import modele.*;
import modele.AI.StatutBateauAI;
import modele.Player.StatutBateauPlayer;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Control {
	public static boolean tourAI = false;
	Menu leMenu;
	PlateauJeu lePlateauJeu;
	Player leModele;
	AI ai;
	int casePeformed = -1;

	public void bateauStatut() {
		leModele.getStatut(lePlateauJeu.getIndice());
	}

	public void setMenu(Menu menu) {
		this.leMenu = menu;
	}

	public void setPlateau(PlateauJeu lePlateauJeu) {
		this.lePlateauJeu = lePlateauJeu;
	}

	public void setModele(Player leModele) {
		this.leModele = leModele;
	}

	public ArrayList<Bateaux> passArrayToview() {
		return this.leModele.getArrayBateau();
	}

	public StatutBateauAI statutEnemy(int casePerformed) {
		return this.ai.getStatut(casePerformed);
	}

	public StatutBateauPlayer statutPlayer(int casePerformed) {
		return this.leModele.getStatut(casePerformed);
	}

	public void setCase(int casePerformed) {

		this.casePeformed = casePerformed;

	}

	public boolean setTour() {
		tourAI = true;
		return tourAI;

	}
	public void lancerPartieOffline() {
		this.ai = new AI();
				
		boolean gameOver = false;

		int cptPlayer = 0, cptAi = 0;

		while (gameOver) {

			if (Control.tourAI == false) {

				if (tourAI == false) {

					StatutBateauAI statutAi = ai.getStatut(casePeformed);
					tourAI = true;

					if (statutAi == StatutBateauAI.TOUCHE || statutAi == StatutBateauAI.COULE) {
						cptPlayer++;
					}
				} else if (tourAI == true) {
					int caseAi = new Random().nextInt(100);
					StatutBateauPlayer statutPlayer = this.leModele.getStatut(caseAi);
					if (statutPlayer == StatutBateauPlayer.TOUCHE || statutPlayer == StatutBateauPlayer.COULE) {
						cptAi++;
						this.lePlateauJeu.setIndice(caseAi);
					} else {
						this.lePlateauJeu.setIndice(caseAi);
					}
				}
				if (cptPlayer == 12 || cptAi == 12) {
					gameOver = true;
				}
			}

		}

	}
}
