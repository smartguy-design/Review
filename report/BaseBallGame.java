package sist.com.report;

import java.util.Arrays;
import java.util.Scanner;

public class BaseBallGame {
	int[] gamer = new int[4];
	static int[] computer = new int[4];
	int cnt = 10;// 게임 횟수 초과
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
		int[] jumsu = { 0, 0 };// 0번째 : strike 1번쨰: ball
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
		System.out.printf("%dS %dB입니다.", jumsu[0], jumsu[1]);
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
				System.out.println("열번의 기회가 모두 지났습니다.");
				System.out.println("정답은 " + Arrays.toString(computer));
				System.out.println("게임을 다시 시작하지");
				makeRandom();
				cnt = 10;

			}

			System.out.println(cnt + "회 : 4자리 숫자를 입력하세요");
//			System.out.println("정답은 " + Arrays.toString(computer));

			String input = scan.next().trim();

			int gamer[] = new int[4];
			for (int i = 0; i < gamer.length; i++) {
				gamer[i] = input.charAt(i) - 48;
			}
			disp(gamer);

			setGamer(gamer);
			int jumsu[] = checkNumber();

			if (jumsu[0] == 4) {
				System.out.println("축하합니다. 당신이 이겼군요");
				System.out.println("다시 도전하기>>> 1 / 탈출하기>>> 0");
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

		System.out.println("지금부터 게임을 시작하지");
		System.out.println("숫자와 자리수가 맞으면 Strike 숫자만 맞으면 Ball입니다.(첫째자리는 0이 아니며, 중복되는 숫자는 없습니다.) ");
		BaseBallGame b = new BaseBallGame();
		b.gameController();

	}

}
