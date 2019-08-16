package boj.dfsbfs.example;




/*
	Q.바이러스
	신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 
	그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
	예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 
	1번 컴퓨터가 웜 바이러ㅊ스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어
	 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 
	 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
	 
	 1--2--3     4
	 \ /         /
	  5---6     7 
 
 	어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 
 	컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 
 	1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
 
	[입력]
	첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 
	둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 
	이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
	
	[출력]
	번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
	
	(입력예시)
	7
	6
	1 2
	2 3
	1 5
	5 2
	5 6
	4 7
	
	(출력예시)
	4
*/
import java.util.Scanner;
import java.util.ArrayList;

public class _2606_dfs {

	// N : 컴퓨터 수(정점의 수), M : 컴퓨터 쌍의 수(간선의 수)
	// A : 출발지, B : 목적지
	static int N, M, A, B;
	static int [][] MAT = new int[101][101];
	static ArrayList<Integer> alist[] = new ArrayList[101];
	static int [] visited = new int[101];
	static int cnt;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 첫 번째 바이러스 컴퓨터를 통해 바이러스에 걸린 컴퓨터의 수 
		cnt = 0;
		for (int i = 1; i <= M; i++) {
			A = sc.nextInt();
			B = sc.nextInt();
			MAT[A][B] = MAT[B][A] = 1;
		}
		
		
		dfs(1);
		System.out.println(cnt);
		
	}
    
    public static void dfs(int idx) {
		// 종료조건 - 전체순회
		
		visited[idx] = 1;
		
		// 탐색조건
		for (int i = 1; i <= N; i++) {
			// idx : 현재 정점, i : 방문하려고 하는 정점
			// MAT[idx][i] == 1 : 현재 정점에서 i번으로 간선 연결되어 있다면
			// visited[i] == 0  : 방문한 적이 없다면
			if( MAT[idx][i] == 1 && visited[i] == 0 ) {
				cnt++;
				dfs(i);
			}
		}
		
	}

}
