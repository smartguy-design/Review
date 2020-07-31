package sist.com.report;

import java.util.Scanner;
import java.util.Vector;

public class VectorTest {
    Scanner scan = new Scanner(System.in);
    Vector<String> blist = new Vector<String>();

    public void test() {

	while (true) {
	    System.out.println("1.�޴��߰� 2.�޴�����  3.�޴�����  4.�޴��˻�  5. �޴����� 6.������");

	    switch (scan.nextInt()) {
	    case 1:
		add();
		break;
	    case 2:
		System.out.println(blist);

		break;
	    case 3:
		System.out.println("������ �޴��� �����ϼ���");
		String name1 = scan.next().trim();
		blist.remove(name1);
		System.out.println(name1 + "�ش� �޴��� ������.");

		break;
	    case 4:
		System.out.println("�˻��� �޴��� �Է����ּ���.");
		String mName = scan.next().trim();
		if (blist.contains(mName)) {
		    System.out.println("�����ϴ� �޴��Դϴ�.");
		} else {
		    System.out.println(mName + "�����ϴ�.");
		}
		break;
	    case 5:
		System.out.println("������ �޴��� �����ϼ���.");
		String mName2 = scan.next().trim();
		int index = blist.indexOf(mName2);
		System.out.println("�̸��� �������ּ���.");
		String upName = scan.next().trim();
		blist.set(index, upName);
		System.out.println("�̸��� ����Ǿ����ϴ�.");
		break;
	    case 6:
		return;
	    default:
		break;
	    }

	}
    }

    public void add() {
	System.out.println("�߰��� �޴��� �Է��ϼ���");
	String name = scan.next().trim();
	blist.add(name);
	System.out.println(name + "�޴��� �߰��߽��ϴ�.");
    }

    public void delete() {
	System.out.println("������ �޴��� �����ϼ���");
	String name1 = scan.next().trim();
	blist.remove(name1);
	System.out.println(name1 + "�ش� �޴��� ������.");
    }

    public void search() {
	System.out.println("�˻��� �޴��� �Է����ּ���.");
	String mName = scan.next().trim();
	if (blist.contains(mName)) {
	    System.out.println("�����ϴ� �޴��Դϴ�.");
	}
    }

    public void modify() {
	System.out.println("������ �޴��� �����ϼ���.");
	String mName2 = scan.next().trim();
	int index = blist.indexOf(mName2);
	System.out.println("�̸��� �������ּ���.");
	String upName = scan.next().trim();
	blist.set(index, upName);
	System.out.println("�̸��� ����Ǿ����ϴ�.");
    }

    public static void main(String[] args) {
	VectorTest v = new VectorTest();
	v.test();
    }
}