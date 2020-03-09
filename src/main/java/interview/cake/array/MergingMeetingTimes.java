package interview.cake.array;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Meeting {
    public int start;
    public int finish;

    public Meeting(final int start,
                   final int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "start=" + start +
                ", finish=" + finish +
                '}';
    }
}


public class MergingMeetingTimes {
    public static List<Meeting> mergeMeetings(final List<Meeting> meetings) {
        // sort by start time
        meetings.sort(Comparator.comparingInt(m -> m.start));

        final List<Meeting> mergedMeeting = new ArrayList<>();
        mergedMeeting.add(meetings.get(0));

        for (Meeting currentMeeting : meetings) {
            Meeting currentRange = mergedMeeting.get(mergedMeeting.size() - 1);
            // if the current meeting starts before the current range ends
            // update the range and the current meeting
            if (currentRange.finish >= currentMeeting.start) {
                mergedMeeting.set(
                        mergedMeeting.size() - 1,
                        new Meeting(currentRange.start, Math.max(currentRange.finish, currentMeeting.finish))
                );
            } else { // current meeting is not merge-able
                mergedMeeting.add(currentMeeting);
            }
        }

        return mergedMeeting;
    }

    public static void main(String args[]) {
        List<Meeting> meetings = new ArrayList<Meeting>() {
            {
                add(new Meeting(2, 3));
                add(new Meeting(6, 9));
            }
        };

        List<Meeting> meetings2 = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 3));
                add(new Meeting(2, 4));
            }
        };

        List<Meeting> meetings3 = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 10));
                add(new Meeting(2, 6));
                add(new Meeting(3, 5));
                add(new Meeting(7, 9));
            }
        };

        System.out.println(mergeMeetings(meetings)); // [2-3, 6-9]
        System.out.println(mergeMeetings(meetings2)); // [1-4]
        System.out.println(mergeMeetings(meetings3)); // [1-10]
    }

}
