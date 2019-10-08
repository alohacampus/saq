package boj.pre.exam._14890;

import java.util.Scanner;  

public class _14890 {
	/**
	 *  *** boj[14890] 경사로 - (index 0) ***
	 *  *** [변수] 
	 *  *** MAT[][] 	: 길의 높이				- 입력
	 *  *** height[] 	: 연속된 높이 카운트
	 *  *** N			: 지도 크기 (NxN)		- 입력
	 *  *** L			: 경사로의 길이			- 입력
	 *  ***
	 *  *** 모든 길 2*N 만큼 정답변수에 넣어두고, 길이 안되는 경우를 발견할 때 마다 1씩 답을 감소시키는 방식으로 해결
	 */
	static int[][] MAT;
	static int[] height;
	static int N, L;
	
	public static void main(String[] args) {
		// (입력)
		Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    L = sc.nextInt();
	    MAT = new int[N * 2][N];					// 배열의 행을 N*2 (2배)로 생성해서, (가로길)/(세로길)을 하나의 배열로 처리하기 위함
	    int ans = N * 2;							// 모든 경우의 길을 답으로 넣어두고, 지나갈 수 없는 길을 찾을 때마다 -1 감소
	 
	    for (int i = 0; i < N; i++) {
			for (int j = 0; j < N ; j++) {
				MAT[i][j] = sc.nextInt();
			}
		}
	    
	    // (0~n-1)행은 원본(가로길), (n~2n-1)행은 왼쪽을 회전시킨 길(세로길)
	    for (int i = N ; i < N * 2 ; i++) {
	        for (int j = 0 ; j < N ; j++) {
	            MAT[i][j] = MAT[j][i - N];
	        }
	    }

	    // (경사로를 놓아야 하는 경우?)
	    // * now(현재위치)와 nxt(다음위치)의 높이 차가 1일 때
	    //  - (case1) : 낮 -> 높, 높은 칸을 만난 경우
	    // 			        지나온 길이 연속되었는지 판단
	    //  - (case2) : 높 -> 낮, 낮은 칸을 만난 경우
	    // 				낮은 칸이 연속되는지 판단
	 
	    for (int i = 0; i < N * 2; i++) {
	        int now = MAT[i][0];
	        height = new int[11];
	        height[now] = 1;
	        int j = 1;
	        while (j < N) {
	            int nxt = MAT[i][j];
	            if (!checkRamp(now, nxt)) {
	                // 높이 차가 1보다 크면 경사로 배치 불가능
	                --ans;
	                break;
	            }
	            // <높이가 다를 경우>
	            if (now != nxt) {
	                if (now < nxt) {
	                    // (case1) : (낮->높)
	                    if (!upHill(now, nxt)) {
	                    	// 경사로를 놓을 수 없어서, 가능한 길(ans) -1
	                        --ans;
	                        break;
	                    }
	                } else {
	                    // (case2) : (높->낮)
	                    if (!downHill(i, j, now, nxt)) {
	                    	// 경사로를 놓을 수 없어서, 가능한 길(ans) -1
	                        --ans;
	                        break;
	                    }
	                    // 경사로를 놓을 수 있어서, 경사로를 놓은 길이(L) 다음 칸부터 판단
	                    j += L - 1;
	                }
	                // 다음 칸을 판단하기 위해, 다음 칸의 높이로 
	                now = nxt;
	            }
	            // <높이가 같을 경우>
	            else {
	                // 같은 높이가 연속된 경우니까, (낮->높) 경우를 만나기 전 미리 연속된 높이의 낮은 칸 수를 카운트 
	                height[now]++;
	            }
	            // 다음 칸으로 이동
	            j++;
	        }
	    }
	    System.out.println(ans);
	}
	 
	// downHill() : (높->낮) 낮은 칸이 연속되는지 판단
	public static boolean downHill(int i, int j, int now, int nxt) {
	    // L길이 만큼 연속되는지 판단
	    for (int k = 0; k < L; k++) {
	        if (j + k == N) {				// 격자를 벗어나면 패스
	            break;
	        }
	        if (MAT[i][j + k] == nxt) {		// L길이 만큼 연속되면 카운트
	            height[nxt]++;
	        }
	    }
	    if (height[nxt] < L) {				// 길이가 L보다 작으면 경사로를 놓을 수 없다
	        return false;
	    }
	    height[nxt] -= L;					// 연속되었다면, L길이 이후의 칸만 카운트해주기 위해 경사로를 놓은 만큼(L) 빼준다
	    return true;
	}
	 
	// upHill()  : (낮->높) 높은 칸을 만났을 경우, 지나온 길이 L이상인지 판단
	public static boolean upHill(int now, int nxt) {
	    if (height[now] < L) {
	        return false;
	    }
	    // 지나온길~현재칸 까지 L이상 연속되었으니, 현재칸 높이의 연속횟수는 리셋해주고, 다음칸은 1회 연속된 것으로 지정
	    height[now] = 0;
	    height[nxt] = 1;
	    return true;
	}
	 
	// checkRamp() : 경사로를 놓아야 하는 경우 인지 판단 (now와 nxt의 높이차가 1인지 확인)
	public static boolean checkRamp(int a, int b) {
	    int gap = Math.abs(a - b);
	    if (gap > 1) {
	        return false;
	    }
	    return true;
	}    
}
