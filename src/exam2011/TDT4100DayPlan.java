package exam2011;

/**
 * Created by Kristian on 17/05/15.
 */
public class TDT4100DayPlan extends DayPlan {


    public TDT4100DayPlan() {
        super(null);
        dayPlan.add(new TDT4100Lecture());
    }

    @Override
    public void addTimeSlot(TimeSlot timeSlot) {
        if (timeSlot.overlaps(getTimeSlotAt(10, 15))) {
            throw new IllegalArgumentException("Can't interupt TDT4100 lecutre");
        }
        super.addTimeSlot(timeSlot);
    }

    @Override
    public void removeTimeSlot(TimeSlot timeSlot) {
        if (timeSlot instanceof TDT4100Lecture) {
            throw new IllegalArgumentException("Can't remove TDT4100 lecture");
        }
        super.removeTimeSlot(timeSlot);
    }


}