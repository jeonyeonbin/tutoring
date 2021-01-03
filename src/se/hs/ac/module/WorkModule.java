package se.hs.ac.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import se.hs.ac.vo.WorkType;
import se.hs.ac.vo.Work;

public class WorkModule {
	private final List<Work> works = new ArrayList<>();
	private int id = 0;

	public void init() {
		works.add(new Work(id++, "해야할일"));
		works.add(new Work(id++, "해야할일 2"));
		works.add(new Work(id++, "해야할일 3"));
	}

	private Map<WorkType, List<Work>> getTodoByType() {
		return works.stream()
				.collect(Collectors.groupingBy(Work::getWorkType));
	}

	public List<Work> selectWorksAllByTodoType(WorkType todoType) {
		return getTodoByType().get(todoType);
	}

	public String selectWorkByTitle(WorkType todoType) {
		return todoType.getTitle();
	}

	public void addWork(String contents) {
		this.works.add(new Work(id++, contents));
	}

	public boolean updateWork(int id) {

		for (Work work : this.works) {
			if (work.getId() == id && work.getWorkType() != WorkType.DONE) {
				work.setWorkType(work.getWorkType().getNextType());
				return true;
			}
		}
		return false;
	}

	public boolean removeWork(int id) {
		Work remove = works
				.stream()
				.filter(work -> work.getId() == id)
				.findFirst()
				.orElse(null);
		if (remove == null) {
			return false;
		}

		this.works.remove(remove);
		return true;
	}

}
