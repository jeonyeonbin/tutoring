package se.hs.ac.view;

import java.util.List;

import se.hs.ac.vo.Work;

public class WorkView {


	public void showMenu() {
		System.out.println("---------------------------------");
		System.out.println("|\t\t\tmenu\t\t\t|");
		System.out.println("|\t\t\t1. 할일 추가\t\t\t|");
		System.out.println("|\t\t\t2. 할일 삭제\t\t\t|");
		System.out.println("|\t\t\t3. 할일 수정\t\t\t|");
		System.out.println("|\t\t\t4. 조회\t\t\t|");
		System.out.println("|\t\t\t5. 나가기\t\t\t|");
		System.out.println("---------------------------------");
	}

	public void showInput(String input) {
		System.out.println(" >>   " + input);
	}

	public void showError() {
		System.out.println("비정상적인 프로그램상 에러로 프로그램이 종료됩니다.");
	}

	public void showTitle(String title) {
		System.out.println(title);
	}

	public void showWorks(List<Work> works) {
		works.forEach(System.out::println);
	}

	public void showInvalidParam() {
		System.out.println("잘못 입력하였거나, 변경을 할 수 없습니다.");
	}

	public void showSuccess(String status) {
		System.out.println(status + " 변경에 성공하였습니다.");
	}


}
