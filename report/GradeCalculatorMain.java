package sist.com.report;

import java.util.Scanner;

//Subject grade opt credit totalCredit score totalscore avg
public class GradeCalculatorMain {
	Scanner scanner = new Scanner(System.in);
	GradeCalculator[] result = new GradeCalculator[5];
	int cnt;

	public boolean isFull() {
		return cnt == result.length - 1;
	}

	public void increment() {
		GradeCalculator[] tmp = new GradeCalculator[result.length * 2];
		System.arraycopy(result, 0, tmp, 0, result.length);
	}

	public void add() {
		GradeCalculator gc = new GradeCalculator();
		// String []gradeKind = {"A+","A","B+","B","C+","C","D+","D","F"};

		// int index=0;
		System.out.println("과목명을 입력하세요.");
		gc.setSubject(scanner.next());

		do {
			System.out.println("이수학점을 입력하세요.");
			gc.setCredit(scanner.nextInt());
		} while (!(0 < gc.getCredit()));

		System.out.println("학점을 입력하세요.[ex)A+, A, B+....F]");
		gc.setGrade(scanner.next());

		/*
		 * System.out.println("변경할과목명:"); for (int i = 0; i < cnt; i++) {
		 * if(scanner.next().equals(result[i].getSubject())) {
		 * System.out.println("변경과목명"); result[i].setSubject(scanner.next());
		 * System.out.println("변경이수학점"); result[i].setCredit(scanner.nextInt());
		 */

		if (isFull()) {
			increment();
		}
		result[cnt++] = gc;
	}

	public void totalCredit() {
		int sum = 0;

		for (int i = 0; i < cnt; i++) {
			sum += result[i].getCredit();
			result[i].setTotalCredit(sum);
		}
	}

	public void score() {
		for (int i = 0; i < cnt; i++) {
			switch (result[i].getGrade()) {
			case "A+":
				result[i].setScore(4.5);
				break;
			case "A":
				result[i].setScore(4.0);
				break;
			case "B+":
				result[i].setScore(3.5);
				break;
			case "B":
				result[i].setScore(3.0);
				break;
			case "C+":
				result[i].setScore(2.5);
				break;
			case "C":
				result[i].setScore(2.0);
				break;
			case "D+":
				result[i].setScore(1.5);
				break;
			case "D":
				result[i].setScore(1.0);
				break;
			case "F":
				result[i].setScore(0.0);
				break;
			default:
				return;
			}
		}
	}

	public void totalScore() {
		double sum = 0;
		for (int i = 0; i < cnt; i++) {
			sum += result[i].getScore() * result[i].getCredit();
			result[i].setTotalScore(sum);
		}
	}

	public void avg() {
		for (int i = 0; i < cnt; i++) {
			result[i].setAvg(result[i].getTotalScore() / result[i].getTotalCredit());
		}
	}

	public void swap(int i, int j) {
		GradeCalculator tmp = null;
		tmp = result[i];
		result[i] = result[j];
		result[j] = tmp;
	}

	public void sort() {
		System.out.println("1.Asceding 2.Descending");
		switch (scanner.nextInt()) {
		case 1:
			for (int i = 0; i < cnt - 1; i++) {
				for (int j = i + 1; j < cnt; j++) {
					if (result[i].getScore() < result[j].getScore()) {
						swap(i, j);
					}
				}
			}
			break;
		case 2:
			for (int i = 0; i < cnt - 1; i++) {
				for (int j = i + 1; j < cnt; j++) {
					if (result[i].getScore() > result[j].getScore()) {
						swap(i, j);
					}
				}
			}
			break;
		default:
			break;
		}
	}

//	public void search() {
//		for (int i = 0; i < cnt; i++) { //행
//			for (int j = 0; j < m[i].length; j++) { //열
//				if(m[i][j]==data) {
//					//return i+"#"+j; //void -> String
//					return new int[] {i,j};
//				} //if
//			} //for
//		} //for
//	}
//		
//	}

	public void modify() {

		// GradeCalculator gc = new GradeCalculator();

		System.out.println("변경하고 싶은 과목명을 입력하세요.");
		String changeSubject = scanner.next();

		for (int i = 0; i < cnt; i++) {
			if (changeSubject.equals(result[i].getSubject())) {
				System.out.println("변경할 과목명을 입력하세요.");
				result[i].setSubject(scanner.next());
				System.out.println("변경할 이수학점을 입력하세요.");
				result[i].setCredit(scanner.nextInt());
				System.out.println("변경할 학점을 입력하세요.");
				result[i].setGrade(scanner.next());
			}
		}

		/*
		 * for (int i = 0; i < cnt; i++) {
		 * if(scanner.next().equals(result[i].getSubject())) {
		 * System.out.println("변경과목명"); result[i].setSubject(scanner.next());
		 * System.out.println("변경이수학점"); result[i].setCredit(scanner.nextInt());
		 * System.out.println("변경학점"); result[i].setGrade(scanner.next()); }
		 * 
		 * }
		 */

	}

	public void list() {
		totalCredit();
		score();
		totalScore();
		avg();
		for (int i = 0; i < cnt; i++) {
			System.out.println(result[i]);
		}
	}

	public void menu() {
		System.out.println("학점계산기입니다. 원하시는 기능을 선택하세요");
		while (true) {
			System.out.println("1.Add 2.List 3.Sort 4.Modify 5.Exit");
			switch (scanner.nextInt()) {
			case 1:
				add();
				break;
			case 2:
				list();
				break;
			case 3:
				sort();
				break;
			case 4:
				modify();
				break;
			case 5:
				return;

			default:
				break;
			}
		}
	}

	public static void main(String[] args) {
		new GradeCalculatorMain().menu();

	}

}
