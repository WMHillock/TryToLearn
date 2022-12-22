public enum Weekday {
    //Расширение монимания ENUMs
    MONDAY("MON", false),
    TUESDAY("TUE", false),
    WEDNESDAY("WED", false),
    THURSDAY("THU", false),
    FRIDAY("FRI", false),
    SATURDAY("SAT", true),
    SYNDAY("SUN", true);

    private final String shortName;
    private final boolean weekend;

    Weekday (String shortName, boolean weekend) {
        this.shortName = shortName;
        this.weekend = weekend;
    }

    public String getShortName() {return shortName;}

    public boolean isWeekend() {return weekend;}

    /*Есть встроенный обходчик, работает если что
    еще есть:
    .valuesOf(String), - имя
    .name() - toString,
    .ordinal() - номер
     */
//    for (Weekday weekday : Weekday.values()) {
//                System.out.println(weekday + "[" +
//                weekday.getShortName()
//                + (weekday.isWeekend() ?
//                "relax and enjoy" : "arbaiten") );
//    }
}
