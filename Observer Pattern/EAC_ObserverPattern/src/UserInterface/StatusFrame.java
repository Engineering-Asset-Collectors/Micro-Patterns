package UserInterface;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ObserverPattern.Status;
import ObserverPattern.WeponData;

public class StatusFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private Status stat;
	private JPanel jp;
	private JLabel level;
	private JLabel hp;
	private JLabel atk;
	private JLabel def;
	private JLabel statLevel;
	private JLabel statHP;
	private JLabel statATK;
	private JLabel statDEF;

	public StatusFrame(Status stat, int posX, int posY) {
		this.stat = stat;
		jp = new JPanel();
		level = new JLabel("Level : ");
		hp = new JLabel("HP : ");
		atk = new JLabel("ATK : ");
		def = new JLabel("DEF : ");
		statLevel = new JLabel();
		statHP = new JLabel();
		statATK = new JLabel();
		statDEF = new JLabel();

		jp.setLayout(new GridLayout(4, 1));
		jp.add(level);
		jp.add(statLevel);
		jp.add(hp);
		jp.add(statHP);
		jp.add(atk);
		jp.add(statATK);
		jp.add(def);
		jp.add(statDEF);
		
		
		setLocation(posX, posY);
		setSize(250, 150);
		setResizable(false);
		setVisible(true);
		setFrame();
		
		this.add(jp);
	}
	
	public void refreshStatus() {
		setFrame();
	}
	
	private void setFrame() {
		if(stat.getWeponData() == null) {
			stat.setWeponData(new WeponData(WeponData.RIGHT_HAND, 0, null));
		}
		statLevel.setText(Integer.toString(stat.getLevel()));
		statHP.setText(Integer.toString(stat.getHp()));
		statATK.setText(Integer.toString(stat.getAtk() + stat.getWeponData().getDamage()));
		statDEF.setText(Integer.toString(stat.getDef()));
	}
}
