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
		System.out.print("�̸� : ");
		m.setName(sc.next());
		if (m.getName().length() >= 7) {
			System.out.println("�̸��� 7���ڸ� ���� �� �����ϴ�. �ٽ� �Է����ּ���");
			return;
		}

		System.out.print("ID : ");
		m.setId(sc.next());

		System.out.print("��й�ȣ : ");
		m.setPw(sc.next());

		System.out.print("��ȭ��ȣ(������ ����) : ");
		m.setPhone(sc.next());
		if (m.getPhone().length() > 11) {
			System.out.println("��ȭ��ȣ�� 12�ڸ��� ���� �� �����ϴ�. �ٽ� �Է����ּ���");
			return;
		}

		System.out.print("������� (�ֹι�ȣ �� 6�ڸ�): ");
		m.setBirth(sc.next());
		if (m.getBirth().length() != 6) {
			System.out.println("���Ŀ� ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
			return;
		}

		System.out.print("�ּ� : ");
		m.setAddress(sc.next());

		this.m[cnt++] = m;
	}

	public void login() {
		String id;
		String pw;
		while (true) {
			System.out.print("ID : ");
			id = sc.next();
			System.out.print("��й�ȣ : ");
			pw = sc.next();
			if (idpwCheck(id, pw)) {
				System.out.println("�α��� �Ǿ����ϴ�.");
			} else {
				System.out.println("�ٽ� Ȯ���� �ּ���.");
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

	public int idsearch() {// ���̵� �˻�
		String id = null;
		while (true) {
			System.out.print("ID : ");
			id = sc.next();
			for (int i = 0; i < cnt; i++) {
				if (m[i].getId().equals(id)) {
					System.out.println(m[i].getId().concat("ID Ȯ�εǾ����ϴ�."));
					break;
				} else {
					System.out.println(m[i].getId().concat("Ȯ�ξȵ�"));
					break;
				}
			}
			return -1;
		}
	}

	public void modify() {

		System.out.println("��й�ȣ�� ������ ID�� �Է��ϼ���.");
		String changeId = sc.next();

		for (int i = 0; i < cnt; i++) {
			if (changeId.equals(m[i].getId())) {
				System.out.println("������ ��й�ȣ�� �Է��ϼ���.");
				m[i].setPw(sc.next());

			}
		}
		System.out.println("��й�ȣ�� ����Ǿ����ϴ�.");
	}

	public void delete() {
		System.out.println("Ż���ϰ� ���� ID�� �Է��ϼ���.");
		String delId = sc.next();
		Member delete;
		for (int i = 0; i < cnt - 1; i++) {
			if (delId.equals(m[i].getId())) {
				delete = m[i];
				m[i] = m[i + 1];
				m[i + 1] = delete;
			}
		}
		System.out.println("Ż��Ǿ����ϴ�.");
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
