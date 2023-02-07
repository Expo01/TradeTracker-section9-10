import java.util.ArrayList;
import java.util.Arrays;

public class Week {
    private ArrayList<Date> weeklyTrades; // did have this as a basic Array with set value of 5 so couldn't create more than 5 trading
    // days in a week but then ran into trouble when printing it out it kept printing all the null values too...
    private String tradingWeek; //limit format f
    private static int counter = 0;

    public Week(String inputWeekExpiration) {
        this.tradingWeek = inputWeekExpiration;
        this.weeklyTrades = new ArrayList<>();
    }

    @Override
    public String toString() { //overriding the toString method is getting impractical because the output gets crazy long.
        // seems better to just have a method call to a private displayTrades method. but need to return a String per the over-rided
        //method signiture
        displayTrades(); // no content can exist after return statement unfortunately. So
        String repeatCharacter = "=";
        return repeatCharacter.repeat(30);


    }

    private void displayTrades(){
        System.out.println("Trades for week of " + this.tradingWeek + " : ");
        for (Date date: weeklyTrades){
            System.out.println("    " + date); // this doesn't work with text block either. Gotta do it the dirty way
//            System.out.printf("%n%d",date); can't use %d or %s with Objects I created
        }
    }

    public void addDate(Date addDate) {
        counter++;
        if (counter > 0 && counter <= 5) {
            weeklyTrades.add(addDate);

        }
        else System.out.println("can only have 5 trading days in a week");
    }

}
