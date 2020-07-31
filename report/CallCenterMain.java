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
     * System.out.println("이름을 입력해 주세요"); callc.setName(sc.next()); do {
     * System.out.println("사번(ID)를 입력해 주세요"); id=sc.nextInt(); callc.setId(id);
     * }while(idCheck(id)); do { System.out.println("내선번호(pbx)를 입력해 주세요");
     * pbx=sc.nextInt(); callc.setPbx(pbx); }while(pbxCheck(pbx));
     * System.out.println("부서를 입력해 주세요"); callc.setTeam(sc.next());
     * System.out.println("ip를 입력해 주세요"); callc.setIp(sc.next()); call.add(callc);
     * System.out.println("정보등록이 완료되었습니다"); menu(); }
     */

    public void callAdd() {
	CallCenter callc = new CallCenter();
	int id = 0;
	int pbx = 0;

	System.out.println("이름을 입력해 주세요");
	callc.setName(sc.next());

	do {
	    System.out.println("사번(ID)를 입력해 주세요");
	    id = sc.nextInt();
	    callc.setId(id);
	} while (idCheck(id));

	System.out.println("내선번호(pbx)를 입력해 주세요");

	while (true) {
	    pbx = sc.nextInt();

	    if (pbx >= 2000 && pbx <= 3999 || pbx >= 5000 && pbx <= 5999)
		break;
	    System.out.println("다시 입력해주세요.");
	}
	callc.setPbx(pbx);

	System.out.println("부서를 입력해 주세요");
	callc.setTeam(sc.next());
	System.out.println("ip를 입력해 주세요");
	callc.setIp(sc.next());
	call.add(callc);
	System.out.println("정보등록이 완료되었습니다");
	menu();
    }

    public void callDelete() {
	System.out.println("삭제할 이름을 입력하세요");
	int index = callSearch(sc.next());
	call.remove(index);
	System.out.println("삭제되었습니다.");
	menu();
    }

    public void callModify() {
	int pbx = 0;
	System.out.println("이름을 입력하세요");
	String name = sc.next();
	for (int i = 0; i < call.size(); i++) {
	    if (call.get(i).getName().equals(name)) {
		System.out.println(name + "님의 수정할 내선번호를 입력하세요.");
		while (true) {
		    pbx = sc.nextInt();

		    if (pbx >= 2000 && pbx <= 3999 || pbx >= 5000 && pbx <= 5999)
			break;
		    System.out.println("다시 입력해주세요.");
		}
		call.get(i).setPbx(pbx);
		System.out.println("수정이 완료되었습니다.");
		System.out.println(call.get(i));
		menu();
	    } else {
		System.out.println("등록되어 있는 이름이 없습니다. 다시 입력해 주세요");
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
	System.out.println("조회할 이름을 입력하세요");
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
	    System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요");
	    break;

	}
    }

    public static void main(String[] args) {
	CallCenterMain c = new CallCenterMain();
	c.menu();
    }
}
