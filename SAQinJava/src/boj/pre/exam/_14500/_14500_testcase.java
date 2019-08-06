package boj.pre.exam._14500;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class _14500_testcase {
	public static void main(String[] args) throws FileNotFoundException {
		// 파일 객체 생성
		File file = new File("_14500.txt");
		// 출력 스트림 객체 생성
		PrintStream printStream
			= new PrintStream(new FileOutputStream(file));
		// 출력 스트림을 시스템에 세팅
		System.setOut(printStream);
		// 랜덤 객체 생성
		Random random = new Random();
		
		int T = random.nextInt(10) + 1;
		System.out.println(T);
		for (int test_case = 0; test_case < T; test_case++) {
			// 4 <= N, M <= 500
			// random.nextInt(500) :  0 ~ (N-1) 사이의 랜덤한 정수를 반환
			int N = random.nextInt(	) + 4;
			int M = random.nextInt(10) + 4;
			System.out.println(N + " " + M);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// input : 1000을 넘지 않는 자연수
//					System.out.print(random.nextInt(1000)+ 1 + " ");
					System.out.print(random.nextInt(20)+ 1 + " ");
				}
				System.out.println();
			}
		}
	}
}
