package sist.com.report;

import java.util.Scanner;
import java.util.Vector;

public class VectorTest {
    Scanner scan = new Scanner(System.in);
    Vector<String> blist = new Vector<String>();

    public void test() {

	while (true) {
	    System.out.println("1.메뉴추가 2.메뉴보기  3.메뉴삭제  4.메뉴검색  5. 메뉴수정 6.나가기");

	    switch (scan.nextInt()) {
	    case 1:
		add();
		break;
	    case 2:
		System.out.println(blist);

		break;
	    case 3:
		System.out.println("삭제할 메뉴를 말씀하세요");
		String name1 = scan.next().trim();
		blist.remove(name1);
		System.out.println(name1 + "해당 메뉴가 삭제함.");

		break;
	    case 4:
		System.out.println("검색함 메뉴를 입력해주세요.");
		String mName = scan.next().trim();
		if (blist.contains(mName)) {
		    System.out.println("존재하는 메뉴입니다.");
		} else {
		    System.out.println(mName + "없습니다.");
		}
		break;
	    case 5:
		System.out.println("수정할 메뉴를 선택하세요.");
		String mName2 = scan.next().trim();
		int index = blist.indexOf(mName2);
		System.out.println("이름을 수정해주세요.");
		String upName = scan.next().trim();
		blist.set(index, upName);
		System.out.println("이름이 변경되었습니다.");
		break;
	    case 6:
		return;
	    default:
		break;
	    }

	}
    }

    public void add() {
	System.out.println("추가할 메뉴를 입력하세요");
	String name = scan.next().trim();
	blist.add(name);
	System.out.println(name + "메뉴를 추가했습니다.");
    }

    public void delete() {
	System.out.println("삭제할 메뉴를 말씀하세요");
	String name1 = scan.next().trim();
	blist.remove(name1);
	System.out.println(name1 + "해당 메뉴가 삭제함.");
    }

    public void search() {
	System.out.println("검색함 메뉴를 입력해주세요.");
	String mName = scan.next().trim();
	if (blist.contains(mName)) {
	    System.out.println("존재하는 메뉴입니다.");
	}
    }

    public void modify() {
	System.out.println("수정할 메뉴를 선택하세요.");
	String mName2 = scan.next().trim();
	int index = blist.indexOf(mName2);
	System.out.println("이름을 수정해주세요.");
	String upName = scan.next().trim();
	blist.set(index, upName);
	System.out.println("이름이 변경되었습니다.");
    }

    public static void main(String[] args) {
	VectorTest v = new VectorTest();
	v.test();
    }
}