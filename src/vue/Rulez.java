package vue;

import controlleur.Control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rulez extends FrameWindow implements ActionListener {
    Control cont;
    public Rulez(String nom, int width, int height) {
        super(nom, width, height, 3, 1, 1);
        setVisible(true);
        JLabel rules = addLabel("Les regles",SwingConstants.CENTER,48);
        JLabel instructions = addLabel("cliquer sur une des cases sur la gauche, en attendre que l'autre joueur ait terminé",SwingConstants.CENTER,12);
        JPanel panel = addPanel();
        JButton btn = addButton("Retour",500,50);
        panel.add(btn);
        btn.addActionListener(this);
        add(panel);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton btn = (JButton) actionEvent.getSource();
        btn.getText();
        if(btn.getText() == "Retour"){
            this.dispose();
            new Menu("Menu principal",600,600,cont);

        }
    }
}
