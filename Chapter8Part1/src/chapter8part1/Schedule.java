package chapter8part1;

import java.util.ArrayList;
import java.util.Collections;

public class Schedule {

    private ArrayList<Appointment> appointments;

    public Schedule() {
        appointments = new ArrayList<Appointment>();
    }

    public boolean addAppointment(Appointment appointment) {
        for (Appointment currentAppointment : appointments) {
            if (currentAppointment.getDay() == appointment.getDay()
                    && currentAppointment.getTime() == appointment.getTime()) {
                return false;
            }
        }

        appointments.add(appointment);
        return true;
    }
    
    public ArrayList<Appointment> getAppointments()
    {
        ArrayList<Appointment> copy = new ArrayList<Appointment>();
        for ( Appointment appointment : appointments)
        {
            copy.add(new Appointment(appointment));
        }
        return copy;
    }
}
