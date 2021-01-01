package se.hs.ac.vo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WorkType {
	TODO("TODO", "-----------TODO--------------\n") {
		@Override
		public WorkType getNextType() {
			return DOING;
		}
	},
	DOING("DOING", "----------DOING--------------\n") {
		@Override
		public WorkType getNextType() {
			return DONE;
		}
	},
	DONE("DONE", "-----------DONE--------------\n") {
		@Override
		public WorkType getNextType() {
			return DONE;
		}
	};

	private final String type;
	private final String title;

	WorkType(String type, String title) {
		this.type = type;
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public String getTitle() {
		return this.title;
	}

	public static List<WorkType> getTodoTypes() {
		return Stream.of(values())
				.collect(Collectors.toList());
	}

	public abstract WorkType getNextType();
}
