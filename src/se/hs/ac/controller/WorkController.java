package se.hs.ac.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import se.hs.ac.module.WorkModule;
import se.hs.ac.view.WorkView;
import se.hs.ac.vo.WorkType;
import se.hs.ac.vo.Work;

import static se.hs.ac.util.WorkConstants.Menu.*;

public class WorkController {
	private final WorkModule workService;
	private final WorkView view;

	public WorkController() {
		this.workService = new WorkModule();
		this.view = new WorkView();
		this.workService.init();
	}

	public void run() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				view.showMenu();
				view.showInput("메뉴 선택");
				String select = br.readLine();
				switch (select) {
					case ADD:
						addWork(br);
						break;
					case REMOVE:
						removeWork(br);
						break;
					case UPDATE:
						updateWork(br);
						break;
					case SHOW:
						showWork();
					case EXIT:
						return;
				}
			}
		} catch (Exception e) {
			view.showError();
		}
	}

	private void addWork(BufferedReader br) throws IOException {
		view.showInput("할일");
		String work = br.readLine();
		workService.addWork(work);
	}


	private void showWork() {
		WorkType.getTodoTypes().forEach(
				todoType -> {
					String title = workService.selectWorkByTitle(todoType);
					List<Work> works = Optional
							.ofNullable(workService.selectWorksAllByTodoType(todoType))
							.orElse(new ArrayList<>());
					view.showTitle(title);
					view.showWorks(works);
				}
		);
	}

	private void removeWork(BufferedReader br) throws IOException {
		showWork();
		view.showInput("제거할 할일 번호");
		String number = br.readLine();

		boolean isRemoved = workService.removeWork(Integer.parseInt(number));
		if (isRemoved) {
			view.showSuccess("상태 ");
			return;
		}

		view.showInvalidParam();
	}

	private void updateWork(BufferedReader br) throws IOException {
		showWork();
		view.showInput("상태를 변경할 번호");
		String number = br.readLine();

		boolean isUpdated = workService.updateWork(Integer.parseInt(number));
		if (isUpdated) {
			view.showSuccess("상태 ");
			return;
		}

		view.showInvalidParam();
	}
}
