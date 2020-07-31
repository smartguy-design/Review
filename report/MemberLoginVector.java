package sist.com.report;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class MemberLoginVector {
    Scanner sc = new Scanner(System.in);
    Vector<Member> v = new Vector<Member>();

    public void add() {
	Member m = new Member();

	System.out.print("�̸� : ");
	String name = sc.next();
	m.setName(name);

	System.out.print("ID : ");
	String id = sc.next();
	m.setId(id);

	System.out.print("��й�ȣ : ");
	String pw = sc.next();
	m.setPw(pw);

	System.out.print("��ȭ��ȣ(������ ����) : ");
	String phone = sc.next();
	if (phone.length() > 11) {
	    System.out.println("��ȭ��ȣ�� 12�ڸ��� ���� �� �����ϴ�. �ٽ� �Է����ּ���");
	    return;
	}
	m.setPhone(phone);

	System.out.print("������� (�ֹι�ȣ �� 6�ڸ�): ");
	String birth = sc.next();
	if (birth.length() != 6) {
	    System.out.println("���Ŀ� ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
	    return;
	}
	m.setBirth(birth);

	System.out.print("�ּ� : ");
	String address = sc.next();
	m.setAddress(address);

	v.add(m);
    }

    public void login() {
	while (true) {
	    System.out.print("ID : ");
	    String id = sc.next();
	    System.out.print("��й�ȣ : ");
	    String pw = sc.next();
	    if (idpwCheck(id, pw)) {
		System.out.println("�α��� �Ǿ����ϴ�.");
	    } else {
		System.out.println("�ٽ� Ȯ���� �ּ���.");
	    }
	    break;
	}
    }

    public boolean idpwCheck(String id, String pw) {
	for (int i = 0; i < v.size(); i++) {
	    if (id.equals(v.get(i).getId()) && pw.equals(v.get(i).getPw()))
		return true;
	}
	return false;
    }

    public void list() {
	for (Member m : v) {
	    System.out.println(m);
	}
    }

    public void idFind() {
	System.out.println("�˻��� ID�� �Է��ϼ���");
	int index = idSearch(sc.next());
	System.out.println(v.get(index));
    }

    public int idSearch(String id) {
	for (int i = 0; i < v.size(); i++) {
	    if (v.get(i).getId().equals(id)) {
		return i;
	    }
	}
	return -1;
    }

    public void modify() {
	System.out.println("��й�ȣ�� ������ ID�� �Է��ϼ���.");
	String changeId = sc.next();
	for (int i = 0; i < v.size(); i++) {
	    if (v.get(i).getId().equals(changeId)) {
		System.out.println("��й�ȣ �������ּ���.");
		String changePw = sc.next();
		v.get(i).setPw(changePw);
		System.out.println("��й�ȣ�� ����Ǿ����ϴ�.");
		System.out.println(v.get(i));
		return;
	    } 
	}
	System.out.println("�������� �ʴ� ID�Դϴ�.");
	return;
    }

    public void delete() {
	System.out.println("Ż���ϰ� ���� ID�� �Է��ϼ���.");
	int index = idSearch(sc.next());
	v.remove(index);
	System.out.println("Ż��Ǿ����ϴ�.");

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
		idFind();
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
	MemberLoginVector ml = new MemberLoginVector();
	ml.menu();
    }

}
