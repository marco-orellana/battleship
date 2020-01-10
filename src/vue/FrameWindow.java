package vue;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class FrameWindow extends JFrame {



	public FrameWindow(String nom, int width, int height, int row, int cols, int layout) {
		super(nom);
		switch (layout){
			case 1:
				this.setLayout(new GridLayout(row,cols));
			break;
			case 2:
				this.setLayout(new FlowLayout());
				break;
			case 3:
				this.setLayout(new BoxLayout(getContentPane(),BoxLayout.LINE_AXIS));
				break;
			default:

		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}
	
	
	public JLabel addLabel(String labelName, int alignement, int size) {
		JLabel lbl = new JLabel(labelName);
		lbl.setHorizontalAlignment(alignement);
		lbl.setFont(new Font("Arial",Font.BOLD, size));
		this.add(lbl);
		return lbl;
	}

	public JButton addButton(String buttonName, int width, int height) {
		JButton btn = new JButton(buttonName);
		btn.setPreferredSize(new Dimension(width,height));
		//this.add(btn);
		return btn;
	}
	
	public JPanel addPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(panel);
		return panel;
	}
public JTextArea addArea(int height,int width){
	    JTextArea Area = new JTextArea();
	    Area.setPreferredSize(new Dimension(height,width));
	   // this.add(Area);
	    return Area;
}

}
