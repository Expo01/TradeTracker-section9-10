import java.util.LinkedList;

public class Date {
    private LinkedList<Trade> tradesOnDate = new LinkedList<>(); // must instantiate the LinkedList in the field or code breaks
    private String date; // limit format

    public Date(String date) {
        this.date = date;
    }

    @Override
    public String toString() { // tried to get the Trade objects printed on different lines. Can't make it work.
        return date + " : " + tradesOnDate;
    }

    public LinkedList<Trade> getTradesOnDate() {
        return tradesOnDate;
    }

    public void addTrade(Trade addTrade) {
        this.tradesOnDate.add(addTrade);
    }



}
