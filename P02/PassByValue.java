enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY,
}

class Foo {
    private DayOfWeek dayOfWeek;
    Foo(DayOfWeek day) {dayOfWeek = day;}
    public void setDayOfWeek(DayOfWeek day) {dayOfWeek = day;}
    public DayOfWeek day() {return dayOfWeek;}
}

public class PassByValue {
    public static void everyDayIsFriday(DayOfWeek dow) { // Ali | Parametric signature! | DayOfWeek
        dow = DayOfWeek.FRIDAY;
    }
    public static void everyDayIsFriday(Foo foo) { // Ali | Parametric signature! | Foo
        foo.setDayOfWeek(DayOfWeek.FRIDAY);
    }
    public static void main(String[] args) {
        DayOfWeek day = DayOfWeek.MONDAY;   // Ali | enum Mon = 1 primitive?
        everyDayIsFriday(day);
        System.out.println(day); // primitives are pass by value

        Foo foo = new Foo(DayOfWeek.MONDAY);  // Ali | Object - instance of Class Foo
        everyDayIsFriday(foo);
        System.out.println(foo.day()); // objects behave as pass by refernece
    }
}
