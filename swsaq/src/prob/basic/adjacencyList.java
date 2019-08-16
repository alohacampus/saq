package prob.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 	*인접리스트
	1부터 N까지의 번호가 있는 정점들과 이 정점들을 잇는 간선들로 이루어진 방향 그래프
	(directed graph)가 있다. 이 정점들 간의 관계를 인접 리스트로 구성하여
	아래의 규칙대로 출력하는 프로그램을 작성하시오.
	
   [인접리스트]
   - 각 줄에 N개의 숫자를 공백을 두고 N줄에 걸쳐 출력한다.
   - i번째 줄에는 i번 정점과 연결된 정점의 번호를 출력한다. 
   	  단, 연결된 정점의 순서는 신경쓰지 않는다.
   
	[입력]
	첫 번째 줄에 테스트케이스의 수( 1 ≤ T ≤ 50 )가 주어진다.
	각 테스트케이스마다 첫 번째 줄에 정점의 수 N과 간선의 수 M이 공백을 두고 주어진다.
	(1 ≤ N ≤ 100, 1 ≤ M ≤ min(2,000, Nx(N-1)) 두 번째 줄부터 M줄에 걸쳐 
	간선이 연결하는 두 개의  정점을 공백을 두고 주어진다. 단, 두 정점이 같은 값으로 주어지는
	경우는 없으며, 기존에 주어진 간선이 중복해서 다시 주어지는 경우는 없다.
	
	[출력]
	각 줄마다 "#T"를 출력한 뒤, 두 번째 줄부터 N줄에 걸쳐 각 정점에 연결된 정점들의 리스트, 인접리스트를 출력한다.
	
	(입력 예시)
	1
	4 3
	1 4
	3 2
	2 1
 */
public class adjacencyList {
	// T : 테스트케이스, N : 정점, M : 간선, A :출발지(정점), B :목적지(정점)
	static int T, N, M, A, B;
	// 인접 리스트
	static ArrayList<Integer> alist[] = new ArrayList[101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 100; i++) {
			alist[i] = new ArrayList <Integer>();
		}
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			// 인접 리스트 초기화
			for (int i = 1; i <= N; i++) {
				alist[i].clear();
			}
			// 인접 리스트에 그래프 정점의 관계 입력
			for (int i = 1; i <= M; i++) {
				A = sc.nextInt();
				B = sc.nextInt();
				alist[A].add(B);
			}
			
			// 인접리스트 데이터 출력
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < alist[i].size(); j++) {
					System.out.print(alist[i].get(j) + " ");
				}
				System.out.println();
				
			}
			
		}
	}
}
















