package prob.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 	����Ʈ(List)
 	- ����Ʈ�� �����Ϳ� ���� ���Ҹ� ����Ű�� ������ ������ ���� �ִ� �ڷᱸ���̴�.
 	- ���� ����Ʈ�� �迭 ����Ʈ�� ��� �������� ũ�⸦ �ø� �� �ִ� ������ �ִ�.
 	
 	*�迭 ����Ʈ(ArrayList)
 	- ���������� �����͸� �迭���� ����, ������ ����/���� �� �ӽù迭�� ������ �����Ѵ�.
 	- �� �����Ͱ� index�� ������ �־� �� ���� ������ ����.
 	- �˻��� ����, ����/������ ����
 	
 	*���� ����Ʈ(LikedList)
 	- �� ��尡 �����Ϳ� �����͸� ������ �� �ٷ� ����Ǿ� �ִ� ������� �����͸� �����ϴ� �ڷᱸ��.
 	- �� �����Ͱ� index�� ������ ���� �ʾ� ù��°���� ���������� �����͸� ȣ���ؾ���.
 	- �˻��� ����, ����/������ ����
 	
 	
 	*SAQ SW Test�� �غ��� �� ���� ����Ʈ���� �迭����Ʈ�� �ַ� ���.
 */
public class dsList {
	static ArrayList<Integer> v;
	static LinkedList<Integer> u;
	public static void main(String[] args) {
		v = new ArrayList<Integer>();
		u = new LinkedList<Integer>();
		// arrayList �ʱ�ȭ
		v.clear();
		// arrayList�� ������ 1 ����
		v.add(1);
		// arrayList�� ������ 10 ����
		v.add(10);
		System.out.println("[ArrayList]");
		// ù ��° ���� ���
		System.out.println("v[0] = " + v.get(0));
		// �� ��° ���� ���
		System.out.println("v[1] = " + v.get(1));
		// arrayList�� ���� ���� ���
		System.out.println("v.size = " + v.size());
		
		// likedList �ʱ�ȭ
		u.clear();
		// likedList�� ������ 1 ����
		u.add(1);
		// likedList�� ������ 10 ����
		u.add(10);
		System.out.println("[LikedList]");
		// ù ��° ���� ���
		System.out.println("u[0] = " + v.get(0));
		// �� ��° ���� ���
		System.out.println("u[1] = " + v.get(1));
		// likedList�� ���� ���� ���
		System.out.println("u.size = " + u.size());
		
		
	}
	
}


















