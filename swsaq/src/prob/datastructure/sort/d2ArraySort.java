package prob.datastructure.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
	[2차원 배열 정렬]
	
	(오름차순 정렬)
	
	(내림차순 정렬)
	
*/

public class d2ArraySort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [][] arr = new int[5][5];
		int start = 0;
		int end = arr.length;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		
		Arrays.sort(arr, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				Integer a1 = o1[0];
				Integer a2 = o2[0];
				return  a2.compareTo(a1);			}
		});
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
	}
}
