package prob.datastructure;


/*
 [배열]
 - 배열이란 번호(index)와 그 번호에 대응하는 데이터들로 이루어진 자료구조를 말한다.
 */
public class d1Array {
	// static 배열선언
	static int arr[];
	public static void main(String[] args) {
		// 배열 초기화
		arr = new int[7];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		arr[5] = 6;
		arr[6] = 7;
		System.out.println("arr[7] : 배열의 크기 = " + arr.length);
		System.out.print(arr[0] + " ");
		System.out.print(arr[1] + " ");
		System.out.print(arr[2] + " ");
		System.out.print(arr[3] + " ");
		System.out.print(arr[4] + " ");
		System.out.print(arr[5] + " ");
		System.out.print(arr[6] + " ");
		System.out.printf("\n\n");
		
		// 배열선언
		int arr2[] = new int[10];
		System.out.println("arr2[10] : 배열의 크기 = " + arr2.length);
		
		// 배열초기화 - 반복문이용
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = 0;
			System.out.print(arr2[i] + " ");
		}
		System.out.printf("\n\n");
		
		
		// 배열 복제
		int arr3[] = arr2.clone();
		System.out.println("arr2[] -> arr3[] 으로 clone");
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
			
		}
		
	}
}
