package sist.com.report;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionStringMethod {
    String[] str = { "A", "B", "C", "D", "E" };

    public void arraylistMethod() {
	ArrayList<String> a = new ArrayList<String>(Arrays.asList(str));
	System.out.println(a); 			// [A, B, C, D, E] | ���� a ���
	System.out.println(a.clone()); 		// [A, B, C, D, E] | ���� a ����
	System.out.println(a.equals("A")); 	// false | ���� a�� A �� ������ Ȯ��
	a.addAll(a); 				// ���� a�� �ִ°͵��� �� ���Ѵ�.
	System.out.println(a); 			// [A, B, C, D, E, A, B, C, D, E] | addAll�� �ϰ� �� ���� ���� a ���
	System.out.println(a.contains("A")); 	// true | ���� a�� A��� ���ڰ� ���ԵǾ��ִ��� ���� Ȯ��
	System.out.println(a.containsAll(a));	// true | ���� a�� ��� ���ԵǾ��ִ��� ���� Ȯ��
	a.ensureCapacity(70);			// ���� a�� �޸𸮸� 70���� �ø�
	a.add("F"); 				// ���� a�� ���� F�� �߰��Ѵ�.
	System.out.println(a); 			// [A, B, C, D, E, A, B, C, D, E, F] | ���� F�� �߰��ϰ� �� �� ���� a ���
	System.out.println(a.get(2)); 		// C | ���� a���� index 2���� �ش��ϴ� ���ڸ� ���
	System.out.println(a.hashCode()); 	// -349851707 | ���� a�� �ؽ��ڵ� �ּҰ��� ���
	System.out.println(a.indexOf("C")); 	// 2 | ���� a���� ���� C�� �ش��ϴ� �ε��� ���� ���
	System.out.println(a.isEmpty()); 	// false | ���� a�� ��� ����� �ִ��� Ȯ��
	a.clear(); 				// ���� a�� ��� ����
	System.out.println(a.isEmpty()); 	// true | ���� a�� ����� �� �� ��� ����� �ִ��� Ȯ��
    }

    public void stringMethod() {
	String s = new String("JAVA");
	String s2 = new String("SQL");
	
	System.out.println(s);					//JAVA | ���� s �� ���ڿ� ���
	System.out.println(s2);					//SQL | ���� s2 �� ���ڿ� ���
	System.out.println(s.charAt(0)); 			//J | ���� s �� ������ ��ġ�� �ִ� ���� ���
	System.out.println(s2.charAt(0)); 			//S | ���� s2 �� ������ ��ġ�� �ִ� ���� ���
	System.out.println(s.concat("�� ����")); 			//JAVA�� ���� | ���ڿ��� �ڿ� �����δ� 
	System.out.println(s2.concat("�� ����")); 		//SQL�� ���� | ���ڿ��� �ڿ� �����δ�
	System.out.println(Arrays.toString(s.split("V"))); 	//[JA, A] | ���ڿ��� ������ �и��ڷ� ������ �迭�� ��� ����Ѵ�.
	System.out.println(s.indexOf("JAVA"));			//0 | ���� s�� ����Ȯ�� ���θ� �˷��ش�. �����ؼ� 0
	System.out.println(s2.indexOf("JAVA"));			//-1 | ���� s�� ����Ȯ�� ���θ� �˷��ش�. �������� �ʾƼ� -1
	System.out.println(s.indexOf("SQL"));			//-1
	System.out.println(s.lastIndexOf("JAVA"));		//0 | ������ ���ڿ��� ������ ���������� ��ġ�� �˷���. ��ã���� -1
	System.out.println(s2.lastIndexOf("JAVA"));		//-1
	System.out.println(s.length()); 			//4 | ���ڿ��� ���̸� �˷���
	System.out.println(s2.length());			//3
	System.out.println(s.substring(0, 3)); 			//JAV | ���ڿ��� �Ϻθ� ���
	System.out.println(s2.substring(0, 2)); 		//SQ
	System.out.println(s.replace("JAVA", "JSP"));		//JSP | ���ڿ� �߿� ���� ���ڿ��� ���ο� ���ڿ��� �ٲ۰� ���
    }

    public void stringMethod2() {
	StringBuffer sb = new StringBuffer();
	sb.append("JAVA");
	sb.append("SQL");
	sb.append('A');
	sb.append(10.5);
	System.out.println(sb);				//JAVASQLA10.5 | ���� sb�� ���� �̾ ��µȴ�.
	System.out.println(sb.capacity()); 		//16 | �ν��Ͻ� ����ũ�⸦ �˷��ش�.
	System.out.println(sb.charAt(0)); 		//J | ���ڿ� �Ϻθ� �ε����� ���� ����Ѵ�.
	System.out.println(sb.codePointAt(8)); 		//49 | �ش� �ε����� ���ڿ��� ascii���� ����Ѵ�.
	System.out.println(sb.codePointBefore(8)); 	//65 | �ش� �ε����� ���ڿ��� �� ���ڿ��� ascii���� ����Ѵ�.
	System.out.println(sb.codePointCount(0, 2)); 	//2 | �����ε������� ���ε����� ������ ����Ʈ���� �����ϴµ� ���
	System.out.println(sb.hashCode()); 		//366712642 | �ּҰ� ���
	System.out.println(sb.indexOf("JAVA")); 	//0 | �ش� ���ڿ��� �ε����� ���
	System.out.println(sb.indexOf("SQL")); 		//4
	System.out.println(sb.indexOf("SQL", 1)); 	//4
	System.out.println(sb.lastIndexOf("JAVA")); 	//0
	System.out.println(sb.length()); 		//12 | ���ڿ� ���� ���
	System.out.println(sb.substring(2, 6)); 	//VASQ | ���ڿ��� �Ϻθ� ���
    }

    public static void main(String[] args) {
	CollectionStringMethod cm = new CollectionStringMethod();
//	cm.arraylistMethod();
//	cm.stringMethod();
	cm.stringMethod2();
    }

}
