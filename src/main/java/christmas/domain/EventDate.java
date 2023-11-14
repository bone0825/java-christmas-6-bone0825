package christmas.domain;

public enum EventDate {
    YEAR(2023),
    MONTH(12),
    DDAY(25);

    private int date;
    private EventDate(int date){
        this.date=date;
    }

    public int getDate() {return date;}
}
