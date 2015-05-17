package exam2011;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * Created by Kristian on 17/05/15.
 */
public class DayPlan {

    protected List<TimeSlot> dayPlan;

    public DayPlan(List<TimeSlot> dayPlan) {
        this.dayPlan = new ArrayList<>();
        if (dayPlan != null) {
            this.dayPlan.addAll(dayPlan);
            Collections.sort(dayPlan);
        }
    }

    public void addTimeSlot(TimeSlot timeSlot) {
        if (!dayPlan.contains(timeSlot)) {
            dayPlan.add(timeSlot);
            Collections.sort(dayPlan);
        } else {
            throw new IllegalArgumentException("The timeslot is already in the dayplan");
        }
    }

    public void removeTimeSlot(TimeSlot timeSlot){
        if (dayPlan.contains(timeSlot)){
            dayPlan.remove(timeSlot);
        }
    }

    public TimeSlot getTimeSlotAt(int hours, int minutes){
        for (int i = 0; i<dayPlan.size();i++){
            if (dayPlan.get(i).contains(hours, minutes)){
                return dayPlan.get(i);
            }
        }
        return null;
    }

    public boolean containsOverlapping(){
        for (int i = 0; i<dayPlan.size()-1;i++){
            if (dayPlan.get(i).contains(dayPlan.get(i+1).start.hours, dayPlan.get(i+1).start.minutes)){
                return true;
            }
        }
        return false;
    }

    public Collection<TimeSlot> getFreeTime(){
        Collection<TimeSlot> freeTime = new ArrayList<>();
        freeTime.add(new TimeSlot("", 0,0, calculateDuration(0,0,dayPlan.get(0).start.hours, dayPlan.get(0).start.minutes)));
        for (int i = 0; i<dayPlan.size()-1;i++){
            TimeSlot t1 = dayPlan.get(i);
            TimeSlot t2 = dayPlan.get(i+1);
            freeTime.add(new TimeSlot("", t1.start.hours, t1.start.minutes, calculateDuration(t1.end.hours, t1.end.minutes, t2.start.hours, t2.start.minutes)));
        }
        freeTime.add(new TimeSlot("", dayPlan.get(dayPlan.size()-1).end.hours, dayPlan.get(dayPlan.size()-1).end.minutes, calculateDuration(dayPlan.get(dayPlan.size()-1).end.hours, dayPlan.get(dayPlan.size()-1).end.minutes, 0, 59)));
        return freeTime;
    }

    protected int calculateDuration(int fromHour, int fromMinutes, int toHour, int toMinutes){
        return (toHour-fromHour)*60+toMinutes-fromMinutes;
    }



}
