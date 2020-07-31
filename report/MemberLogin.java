package sist.com.report;

import java.util.Scanner;

public class MemberLogin {
	Scanner sc = new Scanner(System.in);
	Member[] m = new Member[6];
	int cnt = 0;

	public boolean isFull() {
		return cnt == m.length - 1;
	}

	public void add() {
		Member m = new Member();
		System.out.print("이름 : ");
		m.setName(sc.next());
		if (m.getName().length() >= 7) {
			System.out.println("이름은 7글자를 넘을 수 없습니다. 다시 입력해주세요");
			return;
		}

		System.out.print("ID : ");
		m.setId(sc.next());

		System.out.print("비밀번호 : ");
		m.setPw(sc.next());

		System.out.print("전화번호(하이픈 제외) : ");
		m.setPhone(sc.next());
		if (m.getPhone().length() > 11) {
			System.out.println("전화번호는 12자리를 넘을 수 없습니다. 다시 입력해주세요");
			return;
		}

		System.out.print("생년월일 (주민번호 앞 6자리): ");
		m.setBirth(sc.next());
		if (m.getBirth().length() != 6) {
			System.out.println("형식에 맞지 않습니다. 다시 입력해주세요.");
			return;
		}

		System.out.print("주소 : ");
		m.setAddress(sc.next());

		this.m[cnt++] = m;
	}

	public void login() {
		String id;
		String pw;
		while (true) {
			System.out.print("ID : ");
			id = sc.next();
			System.out.print("비밀번호 : ");
			pw = sc.next();
			if (idpwCheck(id, pw)) {
				System.out.println("로그인 되었습니다.");
			} else {
				System.out.println("다시 확인해 주세요.");
			}
			break;
		}
	}

	public boolean idpwCheck(String id, String pw) {
		for (int i = 0; i < cnt; i++) {
			if (id.equals(m[i].getId()) && pw.equals(m[i].getPw()))
				return true;
		}
		return false;
	}

	public void list() {
		toString();
		for (int i = 0; i < cnt; i++) {
			System.out.println(m[i]);
		}
	}

	public int idsearch() {// 아이디 검색
		String id = null;
		while (true) {
			System.out.print("ID : ");
			id = sc.next();
			for (int i = 0; i < cnt; i++) {
				if (m[i].getId().equals(id)) {
					System.out.println(m[i].getId().concat("ID 확인되었습니다."));
					break;
				} else {
					System.out.println(m[i].getId().concat("확인안됨"));
					break;
				}
			}
			return -1;
		}
	}

	public void modify() {

		System.out.println("비밀번호를 변경할 ID를 입력하세요.");
		String changeId = sc.next();

		for (int i = 0; i < cnt; i++) {
			if (changeId.equals(m[i].getId())) {
				System.out.println("변경할 비밀번호를 입력하세요.");
				m[i].setPw(sc.next());

			}
		}
		System.out.println("비밀번호가 변경되었습니다.");
	}

	public void delete() {
		System.out.println("탈퇴하고 싶은 ID를 입력하세요.");
		String delId = sc.next();
		Member delete;
		for (int i = 0; i < cnt - 1; i++) {
			if (delId.equals(m[i].getId())) {
				delete = m[i];
				m[i] = m[i + 1];
				m[i + 1] = delete;
			}
		}
		System.out.println("탈퇴되었습니다.");
		cnt--;
	}

	public void menu() {
		while (true) {
			System.out.println("1.Add  2.Login  3.List  4.ID Search  5.Modify  6.Delete  0.Exit");
			switch (sc.nextInt()) {
			case 1:
				add();
				break;
			case 2:
				login();
				break;
			case 3:
				list();
				break;
			case 4:
				idsearch();
				break;
			case 5:
				modify();
				break;
			case 6:
				delete();
				break;
			case 0:
				return;

			}
		}
	}

	public static void main(String[] args) {
		MemberLogin ml = new MemberLogin();
		ml.menu();
	}

}
