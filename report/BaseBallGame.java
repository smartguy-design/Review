package sist.com.report;

import java.util.Arrays;
import java.util.Scanner;

public class BaseBallGame {
	int[] gamer = new int[4];
	static int[] computer = new int[4];
	int cnt = 10;// ���� Ƚ�� �ʰ�
	Scanner scan = new Scanner(System.in);

	static {
		makeRandom();
		System.out.println();
	}

	public void setGamer(int[] gamer) {

		this.gamer = gamer;
	}

	public static void makeRandom() {
		for (int i = 0; i < computer.length; i++) {
			computer[i] = (int) (Math.random() * 10);
			if (computer[0] == 0)
				i--;

			for (int j = 0; j < i; j++) {
				if (computer[i] == computer[j]) {
					i--;
					break;
				}
			}
		}
	}

	public int[] checkNumber() {
		cnt--;
		int[] jumsu = { 0, 0 };// 0��° : strike 1����: ball
		for (int i = 0; i < computer.length; i++) {
			for (int j = 0; j < computer.length; j++) {
				if (gamer[i] == computer[j]) {
					if (i == j) {
						jumsu[0]++;
					} else {
						jumsu[1]++;
					}
				}
			}
		}
		System.out.printf("%dS %dB�Դϴ�.", jumsu[0], jumsu[1]);
		return jumsu;
	}

	public void disp(int c[]) {
		for (int i : c) {
			System.out.printf("%3d", i);
		}
		System.out.println();
	}

	public void gameController() {
		while (true) {
			if (cnt == 0) {
				System.out.println("������ ��ȸ�� ��� �������ϴ�.");
				System.out.println("������ " + Arrays.toString(computer));
				System.out.println("������ �ٽ� ��������");
				makeRandom();
				cnt = 10;

			}

			System.out.println(cnt + "ȸ : 4�ڸ� ���ڸ� �Է��ϼ���");
//			System.out.println("������ " + Arrays.toString(computer));

			String input = scan.next().trim();

			int gamer[] = new int[4];
			for (int i = 0; i < gamer.length; i++) {
				gamer[i] = input.charAt(i) - 48;
			}
			disp(gamer);

			setGamer(gamer);
			int jumsu[] = checkNumber();

			if (jumsu[0] == 4) {
				System.out.println("�����մϴ�. ����� �̰屺��");
				System.out.println("�ٽ� �����ϱ�>>> 1 / Ż���ϱ�>>> 0");
				int n = scan.nextInt();
				if (n == 0) {
					break;
				} else {
					makeRandom();
				}

			}

		}
	}

	public static void main(String[] args) {

		System.out.println("���ݺ��� ������ ��������");
		System.out.println("���ڿ� �ڸ����� ������ Strike ���ڸ� ������ Ball�Դϴ�.(ù°�ڸ��� 0�� �ƴϸ�, �ߺ��Ǵ� ���ڴ� �����ϴ�.) ");
		BaseBallGame b = new BaseBallGame();
		b.gameController();

	}

}
