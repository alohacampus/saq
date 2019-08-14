package boj.dfsbfs.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 	Q.DFS와 BFS
	 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
	 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
	 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
	 
	[입력]
	첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 
	간선의 개수 M(1 ≤ M ≤ 10,000), 
	탐색을 시작할 정점의 번호 V가 주어진다. 
	다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
	어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
	
	[출력]
	첫째 줄에 DFS를 수행한 결과를, 
	그 다음 줄에는 BFS를 수행한 결과를 출력한다. 
	V부터 방문된 점을 순서대로 출력하면 된다.
	
	(입력예시)
	4 5 1
	1 2
	1 3
	1 4
	2 4
	3 4
	
	(출력예시)
	1 2 4 3
	1 2 3 4
	
 */
public class _1260 {
	
	static int[][] MAT;
	static int[] visited;
	static int N, M, V, A, B;
	
	
	public static void ResetVisit() {
		for (int i = 1; i <= N; i++) {
			visited[i]= 0;
		}
		System.out.println();
	}
	
	// 깊이 우선 탐색(Depth First Search) - 재귀함수
	public static void dfs(int idx) {
		// 방문한 정점 체크
		visited[idx] = 1;
		System.out.print(idx + " ");
		
		for (int i = 1; i <= N; i++) {
			if(MAT[idx][i] == 1 && visited[i] == 0) {
				dfs(i);
			}
		}
	}
	
	// 깊이 우선 탐색(Depth First Search) - 스택
	public static void dfs2(int idx) {
		Stack<Integer> stack = new Stack<>();
		stack.push(idx);
		// 탐색중인 정점
		int p;
		boolean flag;
		
		visited[idx] = 1;
		System.out.print(idx + " ");
		
		while(!stack.isEmpty()) {
			p = stack.peek();
			flag = false;
			
			for (int i = 1; i <= N; i++) {
				if(MAT[p][i] == 1 && visited[i] == 0) {
					stack.push(i);
					visited[i] = 1;
					System.out.print(i + " ");
					flag = true;
					break;
					
				}
			}
			
			// 조건을 만족하지 않을 경우 정점에서 제거
			if(!flag)
				stack.pop();
			
		}
	}
	
	
	// 너비 우선 탐색(Breadth First Search) - 큐
	public static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(idx);
		// 방문한 정점 체크
		visited[idx] = 1;
		
		while(!queue.isEmpty()) {
			idx = queue.poll();
			System.out.print(idx + " ");
			
			for (int i = 1; i <= N; i++) {
				if(MAT[idx][i] == 1 && visited[i] == 0) {
					queue.offer(i);
					visited[i] = 1;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		MAT = new int[N+1][N+1];
		visited = new int[N+1];
		
		for (int i = 1; i <= M; i++) {
			A = sc.nextInt();
			B = sc.nextInt();
			MAT[A][B] = MAT[B][A] = 1;
		}
		
		dfs2(V);
		ResetVisit();
		bfs(V);
	}
	

	
}















