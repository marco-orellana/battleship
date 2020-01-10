package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlleur.Control;

@SuppressWarnings("serial")
public class Menu extends FrameWindow implements ActionListener {
	Control cont;

	public Menu(String nom, int width, int height, Control unControleur) {
		super(nom, width, height, 2, 1, 1);
		this.cont = unControleur;
		String[] noms = { "Vs CPU", "Rules", "Vs another player" };
		addLabel("Sploosh Kaboom", SwingConstants.CENTER, 32);
		JPanel panel = this.addPanel();
		panel.setLayout(new GridLayout(3, 1));
		for (int i = 0; i < noms.length; i++) {
			JPanel panel2 = this.addPanel();
			JButton btn = this.addButton(noms[i], 500, 75);
			btn.addActionListener(this);
			panel2.add(btn);
			panel.add(panel2);

		}

		this.validate();
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		JButton btn = (JButton) actionEvent.getSource();

		btn.getText();

		if (btn.getText() == "Vs CPU") {
			this.dispose();
			PlateauJeu plat = new PlateauJeu("Jouseur 1", 1000, 800,cont);

			plat.initPlacementShip(cont.passArrayToview());
			cont.lancerPartieOffline();

		} else if (btn.getText() == "Rules") {
			this.dispose();
			Rulez rules = new Rulez("rules", 600, 600);

		} else if (btn.getText() == "Vs another player") {
			this.dispose();
			PlateauJeu plat = new PlateauJeu("Jouseur 1", 1000, 800,cont);
			plat.initPlacementShip(cont.passArrayToview());
			cont.lancerPartieOffline();
		}

	}
}
