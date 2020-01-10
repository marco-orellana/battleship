package vue;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GagnerPerdre extends JFrame {

	public void gagner() {
		JLabel label = new JLabel("Gagner!!");
		label.setFont(new Font("", Font.BOLD, 32));
		add(label);
	}
	public void perdre() {
		JLabel label = new JLabel("Perdu!!");
		label.setFont(new Font("", Font.BOLD, 32));
		add(label);
	}
}
