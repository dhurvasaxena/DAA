import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
class Activity {
    int start;
    int end;
    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public String toString() {
        return "(" + start + ", " + end + ")";
    }
}
public class ActivitySelection {
    public static List<Activity> maxActivities(List<Activity> activities) {
        activities.sort((a, b) -> Integer.compare(a.end, b.end));
        List<Activity> selectedActivities = new ArrayList<>();
        int lastEndTime = 0;
        for (Activity activity : activities) {
            if (activity.start >= lastEndTime) {
                selectedActivities.add(activity);
                lastEndTime = activity.end;
            }
        }
        return selectedActivities;
    }
    public static void main(String[] args) {
        List<Activity> activities = Arrays.asList(
                new Activity(1, 3),
                new Activity(2, 5),
                new Activity(3, 9),
                new Activity(6, 8),
                new Activity(5, 7),
                new Activity(8, 9)
        );
        List<Activity> selected = maxActivities(activities);
        System.out.println("Selected activities: " + selected);
    }
}

