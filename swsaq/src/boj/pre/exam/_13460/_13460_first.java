package boj.pre.exam._13460;
/*
	Q.���� Ż��2
	��ŸƮ��ũ���� �Ǹ��ϴ� ��̿� �峭�� �߿��� ���� �αⰡ ���� ��ǰ�� ���� Ż���̴�. 
	���� Ż���� ���簢�� ���忡 ���� ������ �Ķ� ������ �ϳ��� ���� ����, ���� ������ ������ ���� ������ �����̴�.
	
	������ ���� ũ��� N, ���� ũ��� M�̰�, ���ǻ� 1��1ũ���� ĭ���� �������� �ִ�. 
	���� �ٱ� ��� ���� ��� ������ �ְ�, ���忡�� ������ �ϳ� �ִ�. 
	���� ������ �Ķ� ������ ũ��� ���忡�� 1��1ũ���� ĭ�� ���� ä��� �������̰�, ���� �ϳ��� �� �ִ�. 
	������ ��ǥ�� ���� ������ ������ ���ؼ� ������ ���̴�. �̶�, �Ķ� ������ ���ۿ� ���� �� �ȴ�.
	
	�̶�, ������ ������ �ǵ帱 ���� ����, �߷��� �̿��ؼ� �̸� ���� ������ �Ѵ�.
	�������� ����̱�, ���������� ����̱�, �������� ����̱�, �Ʒ������� ����̱�� ���� �� ���� ������ �����ϴ�.
	
	������ ���ۿ��� ���� ���ÿ� �����δ�. ���� ������ ���ۿ� ������ ����������, �Ķ� ������ ���ۿ� ������ �����̴�. 
	���� ������ �Ķ� ������ ���ÿ� ���ۿ� ������ �����̴�. ���� ������ �Ķ� ������ ���ÿ� ���� ĭ�� ���� �� ����. 
	��, ���� ������ �Ķ� ������ ũ��� �� ĭ�� ��� �����Ѵ�. ����̴� ������ �׸��ϴ� ���� �� �̻� ������ �������� ���� �� �����̴�.
	
	������ ���°� �־����� ��, �ּ� �� �� ���� ���� ������ ������ ���� ���� �� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	[�Է�]
	ù ��° �ٿ��� ������ ����, ���� ũ�⸦ �ǹ��ϴ� �� ���� N, M (3 �� N, M �� 10)�� �־�����. 
	���� N���� �ٿ� ������ ����� ��Ÿ���� ���� M�� ���ڿ��� �־�����. �� ���ڿ��� '.', '#', 'O', 'R', 'B' �� �̷���� �ִ�. 
	'.'�� �� ĭ�� �ǹ��ϰ�, '#'�� ���� �̵��� �� ���� ��ֹ� �Ǵ� ���� �ǹ��ϸ�, 'O'�� ������ ��ġ�� �ǹ��Ѵ�. 'R'�� ���� ������ ��ġ, 'B'�� �Ķ� ������ ��ġ�̴�.
	�ԷµǴ� ��� ������ �����ڸ����� ��� '#'�� �ִ�. ������ ������ �� �� �̸�, ���� ������ �Ķ� ������ �׻� 1���� �־�����.
	
	[���]
	�ּ� �� �� ���� ���� ������ ������ ���� ���� �� �ִ��� ����Ѵ�. 
	����, 10�� ���Ϸ� �������� ���� ������ ������ ���� ���� �� ������ -1�� ����Ѵ�.
	
	(���� �Է�1)
	5 5
	#####
	#..B#
	#.#.#
	#RO.#
	#####
	
	(���� ���1)
	1
	
	(���� �Է�2)
	7 7
	#######
	#...RB#
	#.#####
	#.....#
	#####.#
	#O....#
	#######
	
	(���� ���2)
	5
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _13460_first {
	// ��������
	public static int N, M;
	public static int rx, ry, bx, by;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	public static char[] d = {'��','��','��','��'};
	public static char[] dp = {'��','��','��','��'};
	public static int [][] MAT;
	public static int [][][][] visited;
	public static Queue<Pair> que = new LinkedList<>();
	
	
	// class : �Ӽ�(����), ���(�޼ҵ�)
	public static class Pair {
		int rx, ry, bx, by, cnt;

		// alt + shift + S  --> O
		public Pair(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}
	
	
	// bfs()
	public static int bfs() {
		// 1. ������ Pair �� ť�� �ִ´�.
		que.add(new Pair(rx, ry, bx, by, 0));
		visited[rx][ry][bx][by] = 1;
		
		// 5. ť�� ������� �ʴٸ� �ݺ�
		while(!que.isEmpty()) {
			// 2. ť���� ������ġ(R,B)�� ������.
			Pair p = que.poll();
			
			// 3. (��������)	
			// - ����� 10�� �ʰ��� ����(-1)
			// - �Ķ��� ������ ���ۿ� ������ continue
			// - ������ ������ ���ۿ� ������ cnt
			if( p.cnt > 10 ) return -1;
			if( MAT[p.bx][p.by] == 4 ) continue;
			if( MAT[p.rx][p.ry] == 4 ) return p.cnt; 
			
			// 4. (Ž������)
			// ������ ���� �̵� 
			for (int i = 0; i < 4; i++) {
				int nxt_rx = p.rx;
				int nxt_ry = p.ry;
				while(true) {
					// ���� ������ ��(1)�̶� ����(4)�� �ƴϸ�
					if( MAT[nxt_rx][nxt_ry] != 1 && MAT[nxt_rx][nxt_ry] != 4 ) {
						nxt_rx += dx[i];
						nxt_ry += dy[i];
					} else {
						// ���� ������ ��(1)�̸�
						if( MAT[nxt_rx][nxt_ry] == 1) {
							nxt_rx -= dx[i];
							nxt_ry -= dy[i];
						}
						break;
					}
				}
				System.out.println(d[i] + " �����η��̵� : " + "(rx,ry) : " +  "( " + nxt_rx + ", " + nxt_ry + " )" + " <��������> -- " + dp[i] );
				
				// �Ķ��� ���� �̵�
				int nxt_bx = p.bx;
				int nxt_by = p.by;
				while(true) {
					// ���� ������ ��(1)�̶� ����(4)�� �ƴϸ�
					if( MAT[nxt_bx][nxt_by] != 1 && MAT[nxt_bx][nxt_by] != 4 ) {
						nxt_bx += dx[i];
						nxt_by += dy[i];
					} else {
						// ���� ������ ��(1)�̸�
						if( MAT[nxt_bx][nxt_by] == 1 ) {
							nxt_bx -= dx[i];
							nxt_by -= dy[i];
						}
						break;
					}
				}
				System.out.println(d[i] + " �����η��̵� : " + "(bx,by) : " +  "( " + nxt_bx + ", " + nxt_by + " )" + " <�Ķ�����> -- " + dp[i] );
				System.out.println();
				// ������ ������ �Ķ��� ���� ��ġ���� Ȯ��
				if( nxt_rx == nxt_bx && nxt_ry == nxt_by ) {
					if( MAT[nxt_rx][nxt_ry] != 4) {
						int red_cost = Math.abs(nxt_rx - p.rx) + Math.abs(nxt_ry - p.ry);
						int blue_cost = Math.abs(nxt_bx - p.bx) + Math.abs(nxt_by - p.by);
						if(red_cost > blue_cost) {
							nxt_rx -= dx[i];
							nxt_ry -= dy[i];
						} else {
							nxt_bx -= dx[i];
							nxt_by -= dy[i];
						}
					}
				}
				
				// �̵� ��ġ, �̵� Ƚ���� Pair�� ť�� ��´�.
				// ���� ť���� ���� ��, 
				// �Ķ� �������� ���ۿ� �������� Ȯ�� (�������� ���� Ž��) 
				// ���� ������ ���ۿ� �������� Ȯ�� 
				if( visited[nxt_rx][nxt_ry][nxt_bx][nxt_by] == 0 ) {
					visited[nxt_rx][nxt_ry][nxt_bx][nxt_by] = 1;
					que.add( new Pair(nxt_rx, nxt_ry, nxt_bx, nxt_by, p.cnt +1) );
				}
				
			}
			
		}
		
		return -1;
	}
	
	
	
	
	
	
	// main()
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		
		MAT = new int[N+1][M+1];
		visited = new int[N+1][M+1][N+1][M+1];
		
		// ���ڸ� �ѹ���, R�� B�� �Է���ǥ�� ����.
		for (int i = 1; i <= N ; i++) {
			String str = sc.nextLine();
			for (int j = 1; j <= str.length(); j++) {
				int num = 0;
				switch (str.charAt(j-1)) {
				case '.':  	num = 0;
							break;
				case '#':  	num = 1;
							break;
				case 'R':  	num = 2;
							rx = i;
							ry = j;
							break;
				case 'B':  	num = 3;
							bx = i;
							by = j;
							break;
				case 'O':  	num = 4;
							break;
				}
				MAT[i][j] = num;
			}
		}
		
		System.out.println(bfs());
	}

}




















