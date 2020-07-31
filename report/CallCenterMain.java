package sist.com.report;

import java.util.ArrayList;
import java.util.Scanner;

public class CallCenterMain {
    ArrayList<CallCenter> call = new ArrayList<CallCenter>();
    Scanner sc = new Scanner(System.in);

    /*
     * public void callAdd() { CallCenter callc=new CallCenter(); int id=0; int
     * pbx=0;
     * 
     * System.out.println("�̸��� �Է��� �ּ���"); callc.setName(sc.next()); do {
     * System.out.println("���(ID)�� �Է��� �ּ���"); id=sc.nextInt(); callc.setId(id);
     * }while(idCheck(id)); do { System.out.println("������ȣ(pbx)�� �Է��� �ּ���");
     * pbx=sc.nextInt(); callc.setPbx(pbx); }while(pbxCheck(pbx));
     * System.out.println("�μ��� �Է��� �ּ���"); callc.setTeam(sc.next());
     * System.out.println("ip�� �Է��� �ּ���"); callc.setIp(sc.next()); call.add(callc);
     * System.out.println("��������� �Ϸ�Ǿ����ϴ�"); menu(); }
     */

    public void callAdd() {
	CallCenter callc = new CallCenter();
	int id = 0;
	int pbx = 0;

	System.out.println("�̸��� �Է��� �ּ���");
	callc.setName(sc.next());

	do {
	    System.out.println("���(ID)�� �Է��� �ּ���");
	    id = sc.nextInt();
	    callc.setId(id);
	} while (idCheck(id));

	System.out.println("������ȣ(pbx)�� �Է��� �ּ���");

	while (true) {
	    pbx = sc.nextInt();

	    if (pbx >= 2000 && pbx <= 3999 || pbx >= 5000 && pbx <= 5999)
		break;
	    System.out.println("�ٽ� �Է����ּ���.");
	}
	callc.setPbx(pbx);

	System.out.println("�μ��� �Է��� �ּ���");
	callc.setTeam(sc.next());
	System.out.println("ip�� �Է��� �ּ���");
	callc.setIp(sc.next());
	call.add(callc);
	System.out.println("��������� �Ϸ�Ǿ����ϴ�");
	menu();
    }

    public void callDelete() {
	System.out.println("������ �̸��� �Է��ϼ���");
	int index = callSearch(sc.next());
	call.remove(index);
	System.out.println("�����Ǿ����ϴ�.");
	menu();
    }

    public void callModify() {
	int pbx = 0;
	System.out.println("�̸��� �Է��ϼ���");
	String name = sc.next();
	for (int i = 0; i < call.size(); i++) {
	    if (call.get(i).getName().equals(name)) {
		System.out.println(name + "���� ������ ������ȣ�� �Է��ϼ���.");
		while (true) {
		    pbx = sc.nextInt();

		    if (pbx >= 2000 && pbx <= 3999 || pbx >= 5000 && pbx <= 5999)
			break;
		    System.out.println("�ٽ� �Է����ּ���.");
		}
		call.get(i).setPbx(pbx);
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		System.out.println(call.get(i));
		menu();
	    } else {
		System.out.println("��ϵǾ� �ִ� �̸��� �����ϴ�. �ٽ� �Է��� �ּ���");
		callModify();
	    }
	}
	return;
    }

    public void callList() {
	for (CallCenter callc : call) {
	    System.out.println(callc);
	}
	menu();
    }

    public int callSearch(String name) {
	for (int i = 0; i < call.size(); i++) {
	    if (call.get(i).getName().equals(name)) {
		return i;
	    }
	}
	return -1;
    }

    public boolean idCheck(int id) {
	for (int i = 0; i < call.size(); i++) {
	    if (call.get(i).getId() == id)
		return true;
	}
	return false;
    }

    public boolean pbxCheck(int pbx) {
	for (int i = 0; i < call.size(); i++) {
	    if (call.get(i).getPbx() == pbx)
		return true;
	}
	return false;
    }

    public boolean ipCheck(String ip) {
	for (int i = 0; i < call.size(); i++) {
	    if (call.get(i).getIp().equals(ip))
		return true;
	}
	return false;
    }

    public void callInfo() {
	System.out.println("��ȸ�� �̸��� �Է��ϼ���");
	int index = callSearch(sc.next());
	System.out.println(call.get(index));
	menu();

    }

    public void menu() {
	System.out.println("1.Add 2.List 3.Delete 4.Modify 5.Search 6.Exit");
	switch (sc.nextInt()) {
	case 1:
	    callAdd();
	    break;
	case 2:
	    callList();
	    break;
	case 3:
	    callDelete();
	    break;
	case 4:
	    callModify();
	    break;
	case 5:
	    callInfo();
	    break;
	case 6:
	    return;
	default:
	    System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���");
	    break;

	}
    }

    public static void main(String[] args) {
	CallCenterMain c = new CallCenterMain();
	c.menu();
    }
}
