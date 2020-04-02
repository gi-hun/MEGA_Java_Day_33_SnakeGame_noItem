package day_37;

import java.util.Scanner;

/*
 * # 스네이크 게임
 * 1. 10x10 배열을 0으로 채운다.
 * 2. 스네이크는 1234로 표시한다.
 * 3. 상하좌우로 이동이 가능하며, 꼬리가 따라온다.
 * 4. 자기몸하고 부딪히면, 사망한다.
 * 5. 랜덤으로 아이템을 생성해
 *    아이템을 먹으면 꼬리 1개가 자란다.
 * 6. 꼬리는 최대 8개까지 증가할 수 있다.
 */

public class snake_answer_noItem {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 10;
		int[][] map = new int[SIZE][SIZE];
		
		int[] y = new int[4];	// 0 0 0 0
		int[] x = new int[4];	// 0 1 2 3

		int[] snake = new int[4];
		
		for(int i=0; i<4; i++) {
			x[i] = i;			
			map[y[i]][x[i]] = i+1;
			snake[i] = map[y[i]][x[i]];
		}	
		
		while(true) {
			
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			
			System.out.print("1)left 2)right 3)up 4)down : ");
			int move = scan.nextInt();
		
			int yy = 0;
			int xx = 0;
			
			if(move == 1) {
				yy = y[0];
				xx = x[0] - 1;
			}
			else if(move == 2) {
				yy = y[0];
				xx = x[0] + 1;
			}
			else if(move == 3) {
				yy = y[0] - 1;
				xx = x[0];
			}
			else if(move == 4) {
				yy = y[0] + 1;
				xx = x[0];
			}

			if(yy < 0 || xx < 0) { continue; }
			if(yy >= SIZE || xx >= SIZE) { continue; }

			if(map[yy][xx] != 0) { continue; } 
			
			// 화면 초기화
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					map[i][j] = 0;
				}
			}
			
			// 이동하기
			for(int i=snake.length-1; i>0; i--) {
				y[i] = y[i - 1];
				x[i] = x[i - 1];
			}

			x[0] = xx;
			y[0] = yy;
			
			// 뱀 표시
			for(int i=0; i<snake.length; i++) {
				map[y[i]][x[i]] = i + 1;
			}
			
			
		}
		
	}
}