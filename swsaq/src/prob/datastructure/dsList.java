package prob.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 	리스트(List)
 	- 리스트는 데이터와 다음 원소를 가리키는 일종의 방향을 갖고 있는 자료구조이다.
 	- 연결 리스트와 배열 리스트는 모두 동적으로 크기를 늘릴 수 있는 장점이 있다.
 	
 	*배열 리스트(ArrayList)
 	- 내부적으로 데이터를 배열에서 관리, 데이터 삽입/삭제 시 임시배열을 생성해 복사한다.
 	- 각 데이터가 index를 가지고 있어 한 번에 참조가 가능.
 	- 검색은 빠름, 삽입/삭제는 느림
 	
 	*연결 리스트(LikedList)
 	- 각 노드가 데이터와 포인터를 가지고 한 줄로 연결되어 있는 방식으로 데이터를 저장하는 자료구조.
 	- 각 데이터가 index를 가지고 있지 않아 첫번째부터 순차적으로 데이터를 호출해야함.
 	- 검색은 느림, 삽입/삭제는 빠름
 	
 	
 	*SAQ SW Test를 준비할 땐 연결 리스트보다 배열리스트를 주로 사용.
 */
public class dsList {
	static ArrayList<Integer> v;
	static LinkedList<Integer> u;
	public static void main(String[] args) {
		v = new ArrayList<Integer>();
		u = new LinkedList<Integer>();
		// arrayList 초기화
		v.clear();
		// arrayList에 데이터 1 삽입
		v.add(1);
		// arrayList에 데이터 10 삽입
		v.add(10);
		System.out.println("[ArrayList]");
		// 첫 번째 원소 출력
		System.out.println("v[0] = " + v.get(0));
		// 두 번째 원소 출력
		System.out.println("v[1] = " + v.get(1));
		// arrayList의 원소 개수 출력
		System.out.println("v.size = " + v.size());
		
		// likedList 초기화
		u.clear();
		// likedList에 데이터 1 삽입
		u.add(1);
		// likedList에 데이터 10 삽입
		u.add(10);
		System.out.println("[LikedList]");
		// 첫 번째 원소 출력
		System.out.println("u[0] = " + v.get(0));
		// 두 번째 원소 출력
		System.out.println("u[1] = " + v.get(1));
		// likedList의 원소 개수 출력
		System.out.println("u.size = " + u.size());
		
		
	}
	
}


















