package prob.datastructure.sort;


/*
 	[1차원 배열 정렬]
 	- Arrays.sort(배열이름, 시작index, 마지막index+1); 을 사용하여 정렬하면, 오름차순으로 정렬된다.
 	
 	(오름차순 정렬)
 	Arrays.sort(배열이름, 시작index, 마지막index+1);
 	
 	(내림차순 정렬)
 	- 방법1 : 오름차순 정려하고 index를 마지막에서부터 거꾸로 출력한다.
 	- 방법2 : 모든 요소에 (-1)을 곱하고 오름차순 정렬 후 다시 (-1)을 곱한다.
 	
 */

import java.util.Arrays;
public class d1ArraySort {
	public static void main(String[] args) {
		int arr[] = new int[5];
		arr[0] = 3;
		arr[1] = 2;
		arr[2] = 1;
		
		// 초기값 출력
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		// 범위를 정하지 않고 sort(정렬)를 수행한 경우
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		// 배열 초기화
		arr = new int[]{3,2,1,0,0};
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// 의도한 결과 : 1, 2, 3
		// 배열의 크기가 10이기 때문에 별도의 범위 지정없이 sort하게 되면
		// { 0,0,1,2,3 } 으로 정렬되기 때문에 sort를 할 범위를 지정해주어야한다.
		
		
		// Arrays.sort(배열이름, 시작index, 마지막index+1);
		Arrays.sort(arr, 0, 3);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		// 배열 초기화
		arr = new int[]{3,5,2,4,1};
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// 내림차순 정렬 
		// (방법1)
		// - 오름차순 정렬 후 뒤에서 부터 출력한다.
		Arrays.sort(arr, 0, arr.length);
		// #방법1-출력방법1
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[arr.length-1 -i] +" "); 
		}
		System.out.println();
		
		// #방법1-출력방법2
		for (int i = arr.length-1; i >= 0; i--) {
			System.out.print(arr[i] +" "); 
		}
		System.out.println();
		
		
		// 배열 초기화
		arr = new int[]{3,5,2,4,1};
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		// 내림차순 정렬
		// (방법2) - 모두 같음 부호일 때 가능
		// 기존 배열에 모두 (-1)을 곱한다.
		for (int i = 0; i < arr.length; i++) 
			arr[i] = (-1)*arr[i];
		// (-1)이 곱해진 배열을 오름차순 정렬한다.
		Arrays.sort(arr, 0, arr.length);
		// 다시 (-1)을 곱해 원래 값으로 바꾼다.
		for (int i = 0; i < arr.length; i++) 
			arr[i] = (-1)*arr[i];
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
}

