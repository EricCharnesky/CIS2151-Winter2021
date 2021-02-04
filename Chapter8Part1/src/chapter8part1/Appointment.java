package chapter8part1;

public class Appointment {

    enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    };

    enum TimeOfDay {
        MORNING, AFTERNOON, EVENING
    };

    private DayOfWeek day;
    private TimeOfDay time;
    private String details;

    public Appointment(DayOfWeek day, TimeOfDay time, String details) {
        this.day = day;
        this.time = time;
        this.details = details;
    }
    
    public Appointment(Appointment other)
    {
        this.day = other.day;
        this.time = other.time;
        this.details = other.details;
    }

    public TimeOfDay getTime() {
        return time;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public String getDetails() {
        return details;
    }
    
    

}
