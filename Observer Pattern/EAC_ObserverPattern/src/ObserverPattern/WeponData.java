package ObserverPattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeponData extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final int BASIC_TYPE = 0;
	public static final int LONGSWORD = 1;
	public static final int DUALSWORD = 2;
	public static final int BOW = 3;
	public static final int BATTLESCYTHE = 4;

	public static final int RIGHT_HAND = 1;
	public static final int LEFT_HAND = 2;

	private int strifeWepon; // 상극관계의 무기. 예 : 방패는 배틀사이드에 약하다.
	private int durability; // 무기 내구도
	private int weponDamage;
	private int wearingPart;
	private ImageIcon image;

	public WeponData(int wearingPart, int weponDamage, String weponImgName) {
		setStrifeWepon(BASIC_TYPE);
		setDurability(100);
		this.weponDamage = weponDamage;
		this.setWearingPart(wearingPart);
		if (weponImgName == null) {
			image = null;
		} else {
			image = new ImageIcon("Images\\" + weponImgName);
		}
	}

	public int getStrifeWepon() {
		return strifeWepon;
	}

	public void setStrifeWepon(int strifeWepon) {
		this.strifeWepon = strifeWepon;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public int getDamage() {
		return this.weponDamage;
	}

	public int getWearingPart() {
		return wearingPart;
	}

	public void setWearingPart(int wearingPart) {
		this.wearingPart = wearingPart;
	}

	public JLabel getImage() {
		JLabel img = new JLabel();
		if (image == null) {
			return null;
		}
		img.setIcon(image);
		return img;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}
}
