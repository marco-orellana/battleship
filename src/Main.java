
import vue.*;
import controlleur.*;
import modele.AI;
import modele.Player;

public class Main {
	public static void main(String[] args) {

		Control cont = new Control();
		Player player = new Player();
		cont.setModele(player);
		Menu menuWindow = new Menu("Menu principal", 600, 600, cont);
		cont.setMenu(menuWindow);

	}
}
