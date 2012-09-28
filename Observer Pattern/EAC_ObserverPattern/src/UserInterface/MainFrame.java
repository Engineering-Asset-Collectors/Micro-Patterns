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
	private WeponData[] wepon; // 임시로 만듦. 무기 정보도 옵저버 패턴을 통해 관리할 수 있을 것 같다.
	private StatusFrame statusFrame;
	private SkillFrame skillFrame;
	private JPanel[] inventory;

	public MainFrame() {
		/* 메인 프레임의 골격 세팅 */
		setSize(500, 600);
		setResizable(false);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* 주제와 옵저버를 생성 */
		character = new CharacterDataManager();
		character.setStatus(1, 50, 10, 15, null);
		stat = new Status(character);

		// 무기 설정 - 임의 설정 : 본래는 이 부분은 동적인 부분이므로 예제용으로 만든 것임.
		inventory = new JPanel[8];
		for (int i = 0; i < inventory.length; i++) {
			inventory[i] = new JPanel();
			inventory[i].setVisible(true);
			inventory[i].setSize(40, 50);
			inventory[i].setLocation(45 * i, 400);
			inventory[i].setBackground(Color.LIGHT_GRAY);
		}
		
		/*무기 정보 설정 - 이 부분도 옵저버 패턴으로 다룰 수 있다.
		그렇게 할 경우 인벤토리 시스템도 더욱 단순화 가능하며 유용해진다.*/
		setWepons_temp();
		
		for(int i=0; i < inventory.length; i++) {
			inventory[i].add(wepon[i].getImage());
			this.add(inventory[i]);
		}

		/* 주제가 각 옵저버들에게 캐릭터의 현재 상태를 보낸다. 그러면 각 옵저버들은 주제가 전달해준 정보를 가지고 데이터를 세팅한다. */
		character.notifyObservers();

		/* 각 정보를 표기하는 창을 생성하고 기본 크기와 위치를 지정한다. 위치는 메인 창의 우측에 나타난다. */
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
		/* 무기의 정보 입력. 임시형성. */
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

		// 이 부분이 만약 패턴화 되어있었다면, 혹은 다른 구조를 취했다면
		// 이렇게 불편하게 하지 않아도 됨. 지금 상태로는 반복문을 쓸 수가 없으므로 
		// 하드코딩을 하게 되버린다.
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
