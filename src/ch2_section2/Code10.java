package ch2_section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* 입력으로 하나의 직교다각형(모든 변이 x축 혹은 y축과 평행한 다각형)과 또 하나의 점 p가 주어질 때
 * 그 점이 다각형의 내부에 있는지 외부에 있는지 판단하는 프로그램을 작성하라.
 * 입력 형식의 예: 시계방향으로 꼭지점의 좌표가 주어짐
 * 8	//꼭지점의 개수
 * 0 0    //1st 꼭지점의 x,y 좌표
 * 16 0   //2nd
 * 16 18  //3rd
 * 10 18  //4th
 * 10 6   //5th
 * 6 6    //6th
 * 6 12   //7th
 * 0 12   //8th
 * 7 7    //테스트할 점 p의 좌표
 * 점에서 시작하여 한 방향으로 무한히 뻗어가는 아무 직선을 그었을 때 그것이 다각형의 변과 짝수 번 교차하면 외부, 홀수번 교차하면 내부에 있다.
 * 가정1: p는 다격형의 경계상에 있지 않다.
 * 가정2: p와 동일한 x혹은 y좌표를 가진 꼭지점은 없다.
 * 가정3: 꼭지점의 좌표값은 모두 짝수, 검사할 점p의 좌표값은 홀수이다.
 * Bottom-up 방식의 사고.
 */
public class Code10 {
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("data.txt"));
			int n = in.nextInt();
			OrthoPolygon thePolygon = new OrthoPolygon(n);
			for(int i=0; i<n; i++) {
				thePolygon.addVertex(new Code09_MyPoint2(in.nextInt(), in.nextInt()));
			}
			Code09_MyPoint2 thePoint = new Code09_MyPoint2(in.nextInt(), in.nextInt());
			in.close();
			if(thePolygon.isInner(thePoint)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		} catch(FileNotFoundException e) {
			System.out.println("No data file exists.");
			System.exit(1);
		}
	}
}
