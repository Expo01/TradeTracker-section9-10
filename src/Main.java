import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    //what I've got so far: Class Week which contains an Array of Dates which contain arrays of Trade objects with various
    // contract fields. I have an Iterator that traverses forward and back through ArrayList of Dates of a given Week object
    // and displays all trades of the date at once

    // scanner input for selecting a week of a trade
    //scanner for factory method generation of trade details for Trade object.

public static Scanner masterScanner = new Scanner(System.in);
    public static void main(String[] args) {
        masterMenu();
        int selection = masterScanner.nextInt();
        boolean masterQuit = false;
        Scanner contractScanner = new Scanner(System.in);

        while (!masterQuit) {
            switch (selection) {
                case 1:
                    System.out.println("enter ticker");
                    String ticker = contractScanner.next();
                    System.out.println("enter contract expiration date in format XX/XX/XX");
                    String contractExpirationDate = contractScanner.next();
                    System.out.println("enter 'call' or 'put'");
                    String callOrPut = contractScanner.next();
                    System.out.println("enter strike in decimal format");
                    double strike = contractScanner.nextDouble();
                    System.out.println("input purchase premium in decimal format");
                    double purchasePremium = contractScanner.nextDouble();
                    System.out.println("input number of contracts");
                    int numberOfContracts = contractScanner.nextInt();
                    System.out.println("input 3 or 4 digit purchase time using 930 to 1600 time bounds");
                    int purchaseTime = contractScanner.nextInt();
                    Trade.createTrade(ticker,contractExpirationDate,callOrPut,strike,purchasePremium,numberOfContracts,purchaseTime);
                    break;
                    //  PROBLEM: USER MUST KNOW VARIABLE NAMES TO ADD TRADE --> DATE AND DATE --> WEEK. Doeesn't appear that I can
            }
        }



//        Trade notRealTrade = new Trade("SPYYY", "01/26/23", "cill", -1d,
//                -.00, -1, 1900);
//        Trade SPXSCall012723At1539 = new Trade("SPXS", "02/03/23", "call", 19.5,
//                .31, 2, 1446);
//        Trade SPXLCall012723At1554 = new Trade("SPXL", "02/03/23", "call", 79d,
//                .60, 1, 1454);
//
//        Date dateOf012623 = new Date("01/26/23");
//        dateOf012623.addTrade(notRealTrade);
//        notRealTrade.setSellPrice(.75);
//        notRealTrade.setSellTime(1500);
//
//        Date dateOf012723 = new Date("01/27/23");
//        dateOf012723.addTrade(SPXSCall012723At1539);
//        dateOf012723.addTrade(SPXLCall012723At1554);
//
//        Week weekOf012323 = new Week("01/23/23");
//        weekOf012323.addDate(dateOf012623);
//        weekOf012323.addDate(dateOf012723);

//        reviewTrades(weekOf012323);
    }

    private static void reviewTrades(Week inputWeek) {
        printIterationMenu();
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ArrayList<Date> localList = inputWeek.getWeeklyTrades();
        ListIterator<Date> listIterator = localList.listIterator();
        if (localList.size() == 0) {
            System.out.println("No trades in list");
            return;
        }
//        else {
//            System.out.printf("Now displaying trades from first trading date of the week: \n\t" + );
//        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Quitting trade review");
                    quit = true;
                    break;
                case 1:
                    if (!listIterator.hasPrevious()) {
                        System.out.println("now displaying trade(s) from first trading day of the week : " + listIterator.next().toString());
                        forward = true;
                    } else {
                        System.out.println("cannot call argument option '1' when not at beginning of list");}
                    // for some reason, if I don't include a print statement with this, it ignores the .toString content
                    // but if I try to print the listIterator.next.tostring, it errors.
                    break;
                case 2:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now displaying next trade: " + listIterator.next().toString());
                    } else {
                        System.out.println("No other trades in list");
                    }
                    break;

                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now displaying previous trade " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                    }
                    break;
                case 4:
                    System.out.println(inputWeek);
                    break;
                case 5:
                    printIterationMenu();
                    break;

            }
        }
    }

    public static void printIterationMenu() {
        System.out.println("enter 0 to quit, 1 to begin viewing of trade list, 2 to display next trade, 3 to display previous trade, " +
                "4 to display the weekly trades, 5 to display menu");
    }

    public static void masterMenu(){
        System.out.println("""
                enter 1 to add a new trade
                enter 2 to enter the week date of the trades you wish to review
                enter 3 to quit the program
                """);
    }

}


