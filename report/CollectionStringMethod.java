package sist.com.report;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionStringMethod {
    String[] str = { "A", "B", "C", "D", "E" };

    public void arraylistMethod() {
	ArrayList<String> a = new ArrayList<String>(Arrays.asList(str));
	System.out.println(a); 			// [A, B, C, D, E] | 변수 a 출력
	System.out.println(a.clone()); 		// [A, B, C, D, E] | 변수 a 복제
	System.out.println(a.equals("A")); 	// false | 변수 a가 A 랑 같은지 확인
	a.addAll(a); 				// 변수 a에 있는것들을 다 더한다.
	System.out.println(a); 			// [A, B, C, D, E, A, B, C, D, E] | addAll을 하고 난 후의 변수 a 출력
	System.out.println(a.contains("A")); 	// true | 변수 a에 A라는 문자가 포함되어있는지 여부 확인
	System.out.println(a.containsAll(a));	// true | 변수 a가 모두 포함되어있는지 여부 확인
	a.ensureCapacity(70);			// 변수 a의 메모리를 70으로 늘림
	a.add("F"); 				// 변수 a에 문자 F를 추가한다.
	System.out.println(a); 			// [A, B, C, D, E, A, B, C, D, E, F] | 문자 F를 추가하고 난 후 변수 a 출력
	System.out.println(a.get(2)); 		// C | 변수 a에서 index 2번에 해당하는 문자를 출력
	System.out.println(a.hashCode()); 	// -349851707 | 변수 a의 해시코드 주소값을 출력
	System.out.println(a.indexOf("C")); 	// 2 | 변수 a에서 문자 C에 해당하는 인덱스 값을 출력
	System.out.println(a.isEmpty()); 	// false | 변수 a가 모두 비워져 있는지 확인
	a.clear(); 				// 변수 a를 모두 지움
	System.out.println(a.isEmpty()); 	// true | 변수 a를 지우고 난 후 모두 비워져 있는지 확인
    }

    public void stringMethod() {
	String s = new String("JAVA");
	String s2 = new String("SQL");
	
	System.out.println(s);					//JAVA | 변수 s 의 문자열 출력
	System.out.println(s2);					//SQL | 변수 s2 의 문자열 출력
	System.out.println(s.charAt(0)); 			//J | 변수 s 의 지정된 위치에 있는 문자 출력
	System.out.println(s2.charAt(0)); 			//S | 변수 s2 의 지정된 위치에 있는 문자 출력
	System.out.println(s.concat("의 정석")); 			//JAVA의 정석 | 문자열을 뒤에 덧붙인다 
	System.out.println(s2.concat("의 정석")); 		//SQL의 정석 | 문자열을 뒤에 덧붙인다
	System.out.println(Arrays.toString(s.split("V"))); 	//[JA, A] | 문자열을 지정된 분리자로 나누어 배열에 담아 출력한다.
	System.out.println(s.indexOf("JAVA"));			//0 | 변수 s의 존재확인 여부를 알려준다. 존재해서 0
	System.out.println(s2.indexOf("JAVA"));			//-1 | 변수 s의 존재확인 여부를 알려준다. 존재하지 않아서 -1
	System.out.println(s.indexOf("SQL"));			//-1
	System.out.println(s.lastIndexOf("JAVA"));		//0 | 지정된 문자열의 오른쪽 끝에서부터 위치를 알려줌. 못찾으면 -1
	System.out.println(s2.lastIndexOf("JAVA"));		//-1
	System.out.println(s.length()); 			//4 | 문자열의 길이를 알려줌
	System.out.println(s2.length());			//3
	System.out.println(s.substring(0, 3)); 			//JAV | 문자열의 일부를 출력
	System.out.println(s2.substring(0, 2)); 		//SQ
	System.out.println(s.replace("JAVA", "JSP"));		//JSP | 문자열 중에 기존 문자열을 새로운 문자열로 바꾼걸 출력
    }

    public void stringMethod2() {
	StringBuffer sb = new StringBuffer();
	sb.append("JAVA");
	sb.append("SQL");
	sb.append('A');
	sb.append(10.5);
	System.out.println(sb);				//JAVASQLA10.5 | 변수 sb의 값이 이어서 출력된다.
	System.out.println(sb.capacity()); 		//16 | 인스턴스 버퍼크기를 알려준다.
	System.out.println(sb.charAt(0)); 		//J | 문자열 일부를 인덱스를 통해 출력한다.
	System.out.println(sb.codePointAt(8)); 		//49 | 해당 인덱스의 문자열의 ascii값을 출력한다.
	System.out.println(sb.codePointBefore(8)); 	//65 | 해당 인덱스의 문자열의 전 문자열의 ascii값을 출력한다.
	System.out.println(sb.codePointCount(0, 2)); 	//2 | 시작인덱스에서 끝인덱스로 지정된 포인트수를 리턴하는데 사용
	System.out.println(sb.hashCode()); 		//366712642 | 주소값 출력
	System.out.println(sb.indexOf("JAVA")); 	//0 | 해당 문자열의 인덱스값 출력
	System.out.println(sb.indexOf("SQL")); 		//4
	System.out.println(sb.indexOf("SQL", 1)); 	//4
	System.out.println(sb.lastIndexOf("JAVA")); 	//0
	System.out.println(sb.length()); 		//12 | 문자열 길이 출력
	System.out.println(sb.substring(2, 6)); 	//VASQ | 문자열의 일부를 출력
    }

    public static void main(String[] args) {
	CollectionStringMethod cm = new CollectionStringMethod();
//	cm.arraylistMethod();
//	cm.stringMethod();
	cm.stringMethod2();
    }

}
