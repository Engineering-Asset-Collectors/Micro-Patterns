package UserInterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import ObserverPattern.CharacterDataManager;
import ObserverPattern.Status;
import ObserverPattern.WeponData;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static MainFrame mainFrame;
	private CharacterDataManager character;
	private Status stat;
	private WeponData[] wepon; // �ӽ÷� ����. ���� ������ ������ ������ ���� ������ �� ���� �� ����.
	private StatusFrame statusFrame;
	private SkillFrame skillFrame;
	private JPanel[] inventory;

	public MainFrame() {
		/* ���� �������� ��� ���� */
		setSize(500, 600);
		setResizable(false);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* ������ �������� ���� */
		character = new CharacterDataManager();
		character.setStatus(1, 50, 10, 15, null);
		stat = new Status(character);

		// ���� ���� - ���� ���� : ������ �� �κ��� ������ �κ��̹Ƿ� ���������� ���� ����.
		inventory = new JPanel[8];
		for (int i = 0; i < inventory.length; i++) {
			inventory[i] = new JPanel();
			inventory[i].setVisible(true);
			inventory[i].setSize(40, 50);
			inventory[i].setLocation(45 * i, 400);
			inventory[i].setBackground(Color.LIGHT_GRAY);
		}
		
		/*���� ���� ���� - �� �κе� ������ �������� �ٷ� �� �ִ�.
		�׷��� �� ��� �κ��丮 �ý��۵� ���� �ܼ�ȭ �����ϸ� ����������.*/
		setWepons_temp();
		
		for(int i=0; i < inventory.length; i++) {
			inventory[i].add(wepon[i].getImage());
			this.add(inventory[i]);
		}

		/* ������ �� �������鿡�� ĳ������ ���� ���¸� ������. �׷��� �� ���������� ������ �������� ������ ������ �����͸� �����Ѵ�. */
		character.notifyObservers();

		/* �� ������ ǥ���ϴ� â�� �����ϰ� �⺻ ũ��� ��ġ�� �����Ѵ�. ��ġ�� ���� â�� ������ ��Ÿ����. */
		statusFrame = new StatusFrame(stat, this.getLocation().x
				+ this.getSize().width + 10, this.getLocation().y);
		skillFrame = new SkillFrame(stat, this.getLocation().x
				+ this.getSize().width + 10, this.getLocation().y
				+ statusFrame.getSize().height + 10);

		JButton statBtn = new JButton("Status");
		statBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!statusFrame.isVisible()) {
					statusFrame.setVisible(true);
					statusFrame.setLocation(mainFrame.getLocation().x
							+ mainFrame.getSize().width + 10,
							mainFrame.getLocation().y);
				}
			}
		});

		JButton skillBtn = new JButton("Skill");
		skillBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!skillFrame.isVisible()) {
					skillFrame.setVisible(true);
					skillFrame.setLocation(mainFrame.getLocation().x
							+ mainFrame.getSize().width + 10,
							mainFrame.getLocation().y
									+ statusFrame.getSize().height + 10);
				}
			}
		});

		statBtn.setSize(100, 30);
		skillBtn.setSize(100, 30);
		statBtn.setLocation(0, 0);
		skillBtn.setLocation(0, 40);

		this.add(statBtn);
		this.add(skillBtn);
	}

	private void setWepons_temp() {
		/* ������ ���� �Է�. �ӽ�����. */
		wepon = new WeponData[8];
		wepon[0] = new WeponData(WeponData.RIGHT_HAND | WeponData.LEFT_HAND,
				300, "eq_bow_s2_qualteirak.gif");
		wepon[1] = new WeponData(WeponData.RIGHT_HAND | WeponData.LEFT_HAND,
				290, "eq_bow_s2_rakiora.gif");
		wepon[2] = new WeponData(WeponData.RIGHT_HAND | WeponData.LEFT_HAND,
				900, "eq_dualsword_bastard.gif");
		wepon[3] = new WeponData(WeponData.RIGHT_HAND | WeponData.LEFT_HAND,
				950, "eq_dualsword_ekinar.gif");
		wepon[4] = new WeponData(WeponData.RIGHT_HAND, 500,
				"eq_longsword_s2_peacoak.gif");
		wepon[5] = new WeponData(WeponData.RIGHT_HAND, 600,
				"eq_longsword_s2_qualteirak.gif");
		wepon[6] = new WeponData(WeponData.RIGHT_HAND | WeponData.LEFT_HAND,
				1300, "eq_scythe_blade.gif");
		wepon[7] = new WeponData(WeponData.RIGHT_HAND | WeponData.LEFT_HAND,
				1520, "eq_scythe_dragon.gif");

		// �� �κ��� ���� ����ȭ �Ǿ��־��ٸ�, Ȥ�� �ٸ� ������ ���ߴٸ�
		// �̷��� �����ϰ� ���� �ʾƵ� ��. ���� ���·δ� �ݺ����� �� ���� �����Ƿ� 
		// �ϵ��ڵ��� �ϰ� �ǹ�����.
		inventory[0].addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {;}
			public void mousePressed(MouseEvent e) {;}
			public void mouseExited(MouseEvent e) {;}
			public void mouseEntered(MouseEvent e) {;}
			public void mouseClicked(MouseEvent e) {
				character.setWeponData(wepon[0]);
				character.notifyObservers();
				statusFrame.refreshStatus();
			}
		});
		inventory[1].addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {;}
			public void mousePressed(MouseEvent e) {;}
			public void mouseExited(MouseEvent e) {;}
			public void mouseEntered(MouseEvent e) {;}
			public void mouseClicked(MouseEvent e) {
				character.setWeponData(wepon[1]);
				character.notifyObservers();
				statusFrame.refreshStatus();
			}
		});
		inventory[2].addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {;}
			public void mousePressed(MouseEvent e) {;}
			public void mouseExited(MouseEvent e) {;}
			public void mouseEntered(MouseEvent e) {;}
			public void mouseClicked(MouseEvent e) {
				character.setWeponData(wepon[2]);
				character.notifyObservers();
				statusFrame.refreshStatus();
			}
		});
		inventory[3].addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {;}
			public void mousePressed(MouseEvent e) {;}
			public void mouseExited(MouseEvent e) {;}
			public void mouseEntered(MouseEvent e) {;}
			public void mouseClicked(MouseEvent e) {
				character.setWeponData(wepon[3]);
				character.notifyObservers();
				statusFrame.refreshStatus();
			}
		});
		inventory[4].addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {;}
			public void mousePressed(MouseEvent e) {;}
			public void mouseExited(MouseEvent e) {;}
			public void mouseEntered(MouseEvent e) {;}
			public void mouseClicked(MouseEvent e) {
				character.setWeponData(wepon[4]);
				character.notifyObservers();
				statusFrame.refreshStatus();
			}
		});
		inventory[5].addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {;}
			public void mousePressed(MouseEvent e) {;}
			public void mouseExited(MouseEvent e) {;}
			public void mouseEntered(MouseEvent e) {;}
			public void mouseClicked(MouseEvent e) {
				character.setWeponData(wepon[5]);
				character.notifyObservers();
				statusFrame.refreshStatus();
			}
		});
		inventory[6].addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {;}
			public void mousePressed(MouseEvent e) {;}
			public void mouseExited(MouseEvent e) {;}
			public void mouseEntered(MouseEvent e) {;}
			public void mouseClicked(MouseEvent e) {
				character.setWeponData(wepon[6]);
				character.notifyObservers();
				statusFrame.refreshStatus();
			}
		});
		inventory[7].addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {;}
			public void mousePressed(MouseEvent e) {;}
			public void mouseExited(MouseEvent e) {;}
			public void mouseEntered(MouseEvent e) {;}
			public void mouseClicked(MouseEvent e) {
				character.setWeponData(wepon[7]);
				character.notifyObservers();
				statusFrame.refreshStatus();
			}
		});
	}

	public static void main(String[] args) {
		mainFrame = new MainFrame();
	}

}
