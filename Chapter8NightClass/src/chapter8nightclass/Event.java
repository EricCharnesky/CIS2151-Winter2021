package chapter8nightclass;

public class Event {

    enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    enum TimeOfDay {
        MORNING, AFTERNOON, EVENING
    };

    private DayOfWeek dayOfWeek;
    private TimeOfDay timeOfDay;
    private String name;

    public Event(DayOfWeek dayOfWeek, TimeOfDay timeOfDay, String name) {
        this.dayOfWeek = dayOfWeek;
        this.timeOfDay = timeOfDay;
        this.name = name;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
    }

    public String getName() {
        return name;
    }
    
    
}
