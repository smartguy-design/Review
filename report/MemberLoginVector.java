package sist.com.report;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class MemberLoginVector {
    Scanner sc = new Scanner(System.in);
    Vector<Member> v = new Vector<Member>();

    public void add() {
	Member m = new Member();

	System.out.print("이름 : ");
	String name = sc.next();
	m.setName(name);

	System.out.print("ID : ");
	String id = sc.next();
	m.setId(id);

	System.out.print("비밀번호 : ");
	String pw = sc.next();
	m.setPw(pw);

	System.out.print("전화번호(하이픈 제외) : ");
	String phone = sc.next();
	if (phone.length() > 11) {
	    System.out.println("전화번호는 12자리를 넘을 수 없습니다. 다시 입력해주세요");
	    return;
	}
	m.setPhone(phone);

	System.out.print("생년월일 (주민번호 앞 6자리): ");
	String birth = sc.next();
	if (birth.length() != 6) {
	    System.out.println("형식에 맞지 않습니다. 다시 입력해주세요.");
	    return;
	}
	m.setBirth(birth);

	System.out.print("주소 : ");
	String address = sc.next();
	m.setAddress(address);

	v.add(m);
    }

    public void login() {
	while (true) {
	    System.out.print("ID : ");
	    String id = sc.next();
	    System.out.print("비밀번호 : ");
	    String pw = sc.next();
	    if (idpwCheck(id, pw)) {
		System.out.println("로그인 되었습니다.");
	    } else {
		System.out.println("다시 확인해 주세요.");
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
	System.out.println("검색할 ID를 입력하세요");
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
	System.out.println("비밀번호를 변경할 ID를 입력하세요.");
	String changeId = sc.next();
	for (int i = 0; i < v.size(); i++) {
	    if (v.get(i).getId().equals(changeId)) {
		System.out.println("비밀번호 변경해주세요.");
		String changePw = sc.next();
		v.get(i).setPw(changePw);
		System.out.println("비밀번호가 변경되었습니다.");
		System.out.println(v.get(i));
		return;
	    } 
	}
	System.out.println("존재하지 않는 ID입니다.");
	return;
    }

    public void delete() {
	System.out.println("탈퇴하고 싶은 ID를 입력하세요.");
	int index = idSearch(sc.next());
	v.remove(index);
	System.out.println("탈퇴되었습니다.");

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
