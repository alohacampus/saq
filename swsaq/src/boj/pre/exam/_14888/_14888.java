package boj.pre.exam._14888;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/*
 	[����]
 	N���� ���� �̷���� ���� A1, A2, ..., AN�� �־�����. ��, ���� �� ���̿� �������� �� �ִ� N-1���� �����ڰ� �־�����. 
 	�����ڴ� ����(+), ����(-), ����(��), ������(��)���θ� �̷���� �ִ�.
	�츮�� ���� �� ���̿� �����ڸ� �ϳ��� �־, ������ �ϳ� ���� �� �ִ�. �̶�, �־��� ���� ������ �ٲٸ� �� �ȴ�.
	���� ���, 6���� ���� �̷���� ������ 1, 2, 3, 4, 5, 6�̰�, �־��� �����ڰ� ����(+) 2��, ����(-) 1��, ����(��) 1��, ������(��) 1���� ��쿡�� �� 60������ ���� ���� �� �ִ�. ���� ���, �Ʒ��� ���� ���� ���� �� �ִ�.

	1+2+3-4��5��6
	1��2+3+4-5��6
	1+2��3��4-5+6
	1��2��3-4+5+6
	���� ����� ������ �켱 ������ �����ϰ� �տ������� �����ؾ� �Ѵ�. ��, �������� ���� ���������� �� ���Ѵ�. ������ ����� ���� ���� C++14�� ������ ������. ��, ����� �ٲ� �� ���� ���ϰ�, �� ���� ������ �ٲ� �Ͱ� ����. �̿� ����, ���� �� 4���� ����� ����غ��� �Ʒ��� ����.

	1+2+3-4��5��6 = 1
	1��2+3+4-5��6 = 12
	1+2��3��4-5+6 = 5
	1��2��3-4+5+6 = 7
	
	N���� ���� N-1���� �����ڰ� �־����� ��, ���� �� �ִ� ���� ����� �ִ��� �Ͱ� �ּ��� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	(�Է�)
	ù° �ٿ� ���� ���� N(2 �� N �� 11)�� �־�����. 
	��° �ٿ��� A1, A2, ..., AN�� �־�����. (1 �� Ai �� 100) 
	��° �ٿ��� ���� N-1�� 4���� ������ �־����µ�, 
	���ʴ�� ����(+)�� ����, ����(-)�� ����, ����(��)�� ����, ������(��)�� �����̴�. 
	
	(���)
	ù° �ٿ� ���� �� �ִ� ���� ����� �ִ���, 
	��° �ٿ��� �ּڰ��� ����Ѵ�.
	(10�ﺸ�� ũ�ų� ����, 10�ﺸ�� �۰ų� ���� ����� �������� �Է��� �־�����.)
	
 */
public class _14888 {
	
	
	static int N;  						// �Է� ������ ����
	static int [] arr;					// �Է� ���� ��
	static int [] op = new int[4];		// �������� ����
	static ArrayList<Integer> list;		// ��� ���� ��� list
	
	
	public static void dfs(int depth, int sum ) {
		
		// ������ ���� Ȯ��
		for (int i = 0; i < op.length; i++) {
			// ������ ������ ����������
			if( op[i] != 0 ) {
				// �ش� �����ڸ� �ϳ� ���Ŵϱ� ������ ���� -1����
				op[i]--;
				// ������ ���� ( + : 0 , - : 1 , * : 2 , / : 3 )
				switch (i) {
				// + 	: sum = sum + arr[depth]
				case 0:	dfs(depth+1, sum + arr[depth]);
						break;
				// - 	: sum = sum - arr[depth]
				case 1:	dfs(depth+1, sum - arr[depth]);
						break;
				// * 	: sum = sum * arr[depth]
				case 2:	dfs(depth+1, sum * arr[depth]);
						break;
				// / 	: sum = sum / arr[depth]
				case 3:	dfs(depth+1, sum / arr[depth]);
						break;

				}
				// ���� ���̽��� ���ؼ� ���갡 ���� ����
				op[i]++;
			}
		}
		
		if( depth == N ) {
			// ������� ����Ʈ�� ��´�
			list.add(sum);
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		list = new ArrayList<Integer>();
		
		// ���� �Է�
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// �������� ���� �Է�
		for (int i = 0; i < op.length; i++) {
			op[i] = sc.nextInt();
		}
		
		
		// dfs Ž���� ���� ����  
		// �������� depth == N 
		int depth = 1;
		dfs( depth, arr[0] );
		
		// ����Ʈ ����
		Collections.sort(list);
		int max = list.get(list.size() -1);	// �ִ�
		int min = list.get(0);				// �ּڰ�
		
		System.out.println(max);
		System.out.println(min);
		
	}
}
















