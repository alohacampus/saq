package boj.pre.exam._14890;

import java.util.Scanner;  

public class _14890 {
	/**
	 *  *** boj[14890] ���� - (index 0) ***
	 *  *** [����] 
	 *  *** MAT[][] 	: ���� ����				- �Է�
	 *  *** height[] 	: ���ӵ� ���� ī��Ʈ
	 *  *** N			: ���� ũ�� (NxN)		- �Է�
	 *  *** L			: ������ ����			- �Է�
	 *  ***
	 *  *** ��� �� 2*N ��ŭ ���亯���� �־�ΰ�, ���� �ȵǴ� ��츦 �߰��� �� ���� 1�� ���� ���ҽ�Ű�� ������� �ذ�
	 */
	static int[][] MAT;
	static int[] height;
	static int N, L;
	
	public static void main(String[] args) {
		// (�Է�)
		Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    L = sc.nextInt();
	    MAT = new int[N * 2][N];					// �迭�� ���� N*2 (2��)�� �����ؼ�, (���α�)/(���α�)�� �ϳ��� �迭�� ó���ϱ� ����
	    int ans = N * 2;							// ��� ����� ���� ������ �־�ΰ�, ������ �� ���� ���� ã�� ������ -1 ����
	 
	    for (int i = 0; i < N; i++) {
			for (int j = 0; j < N ; j++) {
				MAT[i][j] = sc.nextInt();
			}
		}
	    
	    // (0~n-1)���� ����(���α�), (n~2n-1)���� ������ ȸ����Ų ��(���α�)
	    for (int i = N ; i < N * 2 ; i++) {
	        for (int j = 0 ; j < N ; j++) {
	            MAT[i][j] = MAT[j][i - N];
	        }
	    }

	    // (���θ� ���ƾ� �ϴ� ���?)
	    // * now(������ġ)�� nxt(������ġ)�� ���� ���� 1�� ��
	    //  - (case1) : �� -> ��, ���� ĭ�� ���� ���
	    // 			        ������ ���� ���ӵǾ����� �Ǵ�
	    //  - (case2) : �� -> ��, ���� ĭ�� ���� ���
	    // 				���� ĭ�� ���ӵǴ��� �Ǵ�
	 
	    for (int i = 0; i < N * 2; i++) {
	        int now = MAT[i][0];
	        height = new int[11];
	        height[now] = 1;
	        int j = 1;
	        while (j < N) {
	            int nxt = MAT[i][j];
	            if (!checkRamp(now, nxt)) {
	                // ���� ���� 1���� ũ�� ���� ��ġ �Ұ���
	                --ans;
	                break;
	            }
	            // <���̰� �ٸ� ���>
	            if (now != nxt) {
	                if (now < nxt) {
	                    // (case1) : (��->��)
	                    if (!upHill(now, nxt)) {
	                    	// ���θ� ���� �� ���, ������ ��(ans) -1
	                        --ans;
	                        break;
	                    }
	                } else {
	                    // (case2) : (��->��)
	                    if (!downHill(i, j, now, nxt)) {
	                    	// ���θ� ���� �� ���, ������ ��(ans) -1
	                        --ans;
	                        break;
	                    }
	                    // ���θ� ���� �� �־, ���θ� ���� ����(L) ���� ĭ���� �Ǵ�
	                    j += L - 1;
	                }
	                // ���� ĭ�� �Ǵ��ϱ� ����, ���� ĭ�� ���̷� 
	                now = nxt;
	            }
	            // <���̰� ���� ���>
	            else {
	                // ���� ���̰� ���ӵ� ���ϱ�, (��->��) ��츦 ������ �� �̸� ���ӵ� ������ ���� ĭ ���� ī��Ʈ 
	                height[now]++;
	            }
	            // ���� ĭ���� �̵�
	            j++;
	        }
	    }
	    System.out.println(ans);
	}
	 
	// downHill() : (��->��) ���� ĭ�� ���ӵǴ��� �Ǵ�
	public static boolean downHill(int i, int j, int now, int nxt) {
	    // L���� ��ŭ ���ӵǴ��� �Ǵ�
	    for (int k = 0; k < L; k++) {
	        if (j + k == N) {				// ���ڸ� ����� �н�
	            break;
	        }
	        if (MAT[i][j + k] == nxt) {		// L���� ��ŭ ���ӵǸ� ī��Ʈ
	            height[nxt]++;
	        }
	    }
	    if (height[nxt] < L) {				// ���̰� L���� ������ ���θ� ���� �� ����
	        return false;
	    }
	    height[nxt] -= L;					// ���ӵǾ��ٸ�, L���� ������ ĭ�� ī��Ʈ���ֱ� ���� ���θ� ���� ��ŭ(L) ���ش�
	    return true;
	}
	 
	// upHill()  : (��->��) ���� ĭ�� ������ ���, ������ ���� L�̻����� �Ǵ�
	public static boolean upHill(int now, int nxt) {
	    if (height[now] < L) {
	        return false;
	    }
	    // �����±�~����ĭ ���� L�̻� ���ӵǾ�����, ����ĭ ������ ����Ƚ���� �������ְ�, ����ĭ�� 1ȸ ���ӵ� ������ ����
	    height[now] = 0;
	    height[nxt] = 1;
	    return true;
	}
	 
	// checkRamp() : ���θ� ���ƾ� �ϴ� ��� ���� �Ǵ� (now�� nxt�� �������� 1���� Ȯ��)
	public static boolean checkRamp(int a, int b) {
	    int gap = Math.abs(a - b);
	    if (gap > 1) {
	        return false;
	    }
	    return true;
	}    
}
