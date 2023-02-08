public class Trade { //realistically, this could probably just be a record since it doesn't rerally do anything... only thing
    //is that I don't have all the info at time of construction since sell price and time will have to be set later
    private String ticker;
    private String contractExpirationDate; // ensure xx/xx/xx format. possibly check input for string index values for correct char types
    private String callOrPut;
    private double strike; //the only thing I don't like is that primitive types default to 0 when out of constraints in my constructor
    private double purchasePremium;
    private int numberOfContracts;
    private int purchaseTime;
    private double sellPremium;

    //need a sell date
    private int sellTime; //really there should be a condition here were if purchase date and sell date are the same, then
    // sell time can't be before purchase time. Both also need conditions for being in bounds of trading hours

    //later this would be great if it would prompt me for spot price and first sell target to calculate risk:reward so I odn't have ro


    public Trade(String ticker, String contractExpirationDate, String callOrPut, Double strike, double purchasePremium, int numberOfContracts, int purchaseTime) {
        if (ticker.length() == 3 || ticker.length() == 4) { //only thing this doesn't fix is i can still input numbers in string form
            ticker = ticker.toUpperCase();
            this.ticker = ticker;
        }
        if (contractExpirationDate.length() == 8) {
            this.contractExpirationDate = contractExpirationDate;
        } //again, substring or .index variations not working to ensure format. only other idea I have is change type back
        // to int and if int is 7 digits, add a leading 0 and put in the '/' when formatting into a string
        if (callOrPut.equalsIgnoreCase("call") || callOrPut.equalsIgnoreCase("put")) {
            this.callOrPut = callOrPut;
        }
        if (strike > 1 && strike % .25 == 0) {
            this.strike = strike;
        }
        if (purchasePremium > .01) {
            this.purchasePremium = purchasePremium;
        }
        if (numberOfContracts >= 1) {
            this.numberOfContracts = numberOfContracts;
        }
        if (purchaseTime >= 930 && purchaseTime <= 1600) {
            this.purchaseTime = purchaseTime;
        }
    }

    @Override
    public String toString() {
        if (this.sellTime == 0) {
            return
                    " PURCHASED " + ticker + " " + contractExpirationDate + " " + callOrPut + " at " + strike + " strike" +
                            ", " + numberOfContracts + " contract(s) for $" + purchasePremium * 100 + "  at " +
                            purchaseTime + " oclock.";
        } else {
            return
                    " PURCHASED " + ticker + " " + contractExpirationDate + " " + callOrPut + " at " + strike + " strike" +
                            ", " + numberOfContracts + " contract(s) for $" + purchasePremium * 100 + "  at " +
                            purchaseTime + " oclock." + " Sold for $" + sellPremium * 100 + " at " + sellTime + " oclock" +
                            '}';
        }

    }

    public void setSellPrice(double sellPremium) {
        if (sellPremium > .01) {
            this.sellPremium = sellPremium;
        } else {
            System.out.println("invalid");

        }
    }

    public void setSellTime(int sellTime) {
        if (sellTime >= 930 && sellTime <= 1600) {
            this.sellTime = sellTime;
        }
    }
}







//temporary idea storage

//                    if (inputWeek.getWeeklyTrades().listIterator().next().getTradesOnDate().size() > 1) {
//                        System.out.println("more than 1 trade took place on this day");
//                    }
//                    (inputWeek.getWeeklyTrades().get(0).getTradesOnDate().size() > 1);
//this is not working


//                        if (inputWeek.getWeeklyTrades().listIterator().next().getTradesOnDate().size() > 1) {
//                            System.out.println("more than 1 trade took place on this day");
//                        } else {
//                            System.out.println("contrary output reached and printed");
//                        }
//                        System.out.println("Now displaying next trade" + listIterator.next().toString());
// this is not working either