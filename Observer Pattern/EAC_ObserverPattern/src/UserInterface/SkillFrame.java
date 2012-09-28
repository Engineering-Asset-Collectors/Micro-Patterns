package UserInterface;

import javax.swing.JFrame;

import ObserverPattern.Status;

public class SkillFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public SkillFrame(Status stat, int posX, int posY) {
		setSize(130, 300);
		setResizable(false);
		setLocation(posX, posY);
	}
}
