package org.algoquestion;
import java.util.ArrayList;
import java.util.List;


public class Calendar {

	static class Meeting {
		int startTime;
		int endTime;

		public Meeting(int start, int end) {
			this.startTime = start;
			this.endTime = end;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}

		public String toString() {
			return "( " + startTime + "," + endTime + " )";
		}
	}

	public static List<Meeting> freeTime(List<Meeting> list1, List<Meeting> list2) {
		List<Meeting> sortedMeetings = new ArrayList<>();

		int limit = list1.size();
		if (list1.size() <= list2.size()) {
			limit = list2.size();
		}

		for (int i = 0; i < limit; i++) {
			Meeting meeting1 = null;
			Meeting meeting2 = null;
			if (i < list1.size()) {
				meeting1 = list1.get(i);
			}

			if (i < list2.size()) {
				meeting2 = list2.get(i);
			}

			if (meeting1 != null && meeting2 != null) {
				if (meeting1.getStartTime() <= meeting2.getStartTime()) {
					sortedMeetings.add(meeting1);
					sortedMeetings.add(meeting2);
				} else {
					sortedMeetings.add(meeting2);
					sortedMeetings.add(meeting1);
				}

			} else if (meeting1 == null && meeting2 != null) {
				sortedMeetings.add(meeting2);

			} else if (meeting1 != null && meeting2 == null) {
				sortedMeetings.add(meeting1);
			}
		}

		List<Meeting> freeSlots = new ArrayList<Meeting>();
System.out.println(sortedMeetings);
		for (int i = 0; i < sortedMeetings.size(); i++) {
			Meeting duration1 = null;
			Meeting duration2 = null;
			if (i < sortedMeetings.size() - 1) {
				duration1 = sortedMeetings.get(i);
				duration2 = sortedMeetings.get(i + 1);

				if (duration1.getEndTime() < duration2.getStartTime()) {
					freeSlots.add(new Meeting(duration1.getEndTime(), duration2.getStartTime()));
				}
			}
		}

		return freeSlots;
	}

	public static void printDurationList(List<Meeting> durationList) {
		System.out.println("================================");
		for (Meeting duration : durationList) {
			System.out.println(duration);
		}
	}

	public static void main(String[] args) {
		List<Meeting> list1 = new ArrayList<Meeting>();
/*		list1.add(new Meeting(1, 5));
		list1.add(new Meeting(10, 14));
		list1.add(new Meeting(19, 20));
		list1.add(new Meeting(21, 24));
		list1.add(new Meeting(27, 30));
*/
		list1.add(new Meeting(1, 3));
		list1.add(new Meeting(5, 6));
		list1.add(new Meeting(7, 8));

		
		List<Meeting> list2 = new ArrayList<Meeting>();
		/*list2.add(new Meeting(3, 5));
		list2.add(new Meeting(5, 8));
		list2.add(new Meeting(12, 15));
		list2.add(new Meeting(18, 21));
		list2.add(new Meeting(23, 24));*/

		list2.add(new Meeting(2, 4));
		list2.add(new Meeting(7, 8));
		list2.add(new Meeting(9, 10));

		List<Meeting> freeTimes = freeTime(list1, list2);
		
		printDurationList(freeTimes);

	}

}