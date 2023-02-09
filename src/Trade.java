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



    public static Trade createTrade(String ticker, String contractExpirationDate, String callOrPut, Double strike, double purchasePremium, int numberOfContracts, int purchaseTime) {
//        if (ticker.length() == 3 || ticker.length() == 4) {
//            ticker = ticker.toUpperCase();
//        }
//        if ((contractExpirationDate.length() == 8) && (callOrPut.equalsIgnoreCase("call") || callOrPut.equalsIgnoreCase("put"))
//                && (strike > 1 && strike % .25 == 0) && (purchasePremium > .01) && (numberOfContracts >= 1) && (purchaseTime >= 930 && purchaseTime <= 1600)){
        return new Trade(ticker,contractExpirationDate,callOrPut,strike,purchasePremium,numberOfContracts,purchaseTime);
//        return null;
    }
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




//accept array as parameter? reverse array with temp variable? boolean flag. autoboxing. Iterator/List Iterator, LinkedList.
// varargs, random class, multidimensional array.

//Trader class. has arrayList of trades. comprised of multiple lists for ticker type. each ticker type has list of trades
//by date and time stamp. This works better since building a playlist can really pull from any artists or genre. just
// doing artist --> album --> song doesn't work either since these shouldn't change with adding and subtracting. We can
// only reorganize theme. but trading can either be an list of tickers --> dates --> trrade. but more realistically for
//my trade tracking I want a List of week which has a list of days which has a list of trades organized by time stamp
//and has fields of all my content. Should then be able to navigate the forwarrd and backwards trhough just like I do
// with my photos in my folders. Later this might be good if I create Objects such as SPY or QQQ to search all trades and
// create statistics


//video 117: ArrayIntro: individual generation of indexes, generation of all index values at once,
// for loop generation of index values and for loop output of index values. Method accepting array
// as parameter
// video 117: ArrayScanner: Array generation through scanner input in for loop. computation method involving
//              indexes of array.
// exercise 42: scanner and for loop generation of array. inbuilt java function Arrays.copyOf. reordering of
//              array contents using boolean flag in while loop with nested for loop and stored variable
//video 120: ReferenceVsValueType reference vs value type using int and int[] examples
//exercise 43: MinimumElementChallenge: scanner for loop array generation. Inter.MAX_VALUE for stored minimum variable
//exercise 44: ReverseArray: stored max index. For loop at 1/2 length of array. temp variable for swapping.
//video 123: ResizingArray: resize array via temporary variable and reassigning array length using 'new', use of
//              for loops to transfer temporary info and print contents.\
// video 123-125: GroceryList: ArrayList scanner generation, modification of ArrayList with methods, class
//              contents and ArrayList indexes hidden from user. Arraylist functions: .get, .size, .add,
//              .remove, .contains, .indexOf. Use of for loop to print ArrayList. Demonstrates 2 mechanisms of
//              copying an arrayList to new object. Conversion of ArrayList into new Array.
// 126-129/ex 45:MobilePhone: lots of stuff... Factory methods, hiding classes and methods from user, static methods, use of
//                  new Class as variable type in ArrayList generation, etc...
//video 130: IntroToAutoboxing: Autoboxing: Regarding ArrayList, demonstrate manual class creation for primitive
//              type, manual autoboxing/unboxing using inbuilt classes with ex: .intValue() and .valueOf()
//              methods. Demonstration of automatic autoboxing and unboxing at compile time
// 131-133/ex 52:Banking: 3 classes with Arraylist fields from component classes. Use of autoboxing, and many other previously covered items.
//introToLinkedLists: forgot to summarize. come back to.
//***Playlist: call to private method in if condition for setting of class field. Simplified for loop formatting.
//calling private methods to test for existence of parameter before removal/adding. Use of both Linkedlist and ArrayList.
// user menu for navigating ArrayList forward/backward. Use of iterator and listIterator with 'hasNext' and '.next' methods.
// '.next', '.previous/, '.remove'
// new section 9: ForVsForEachLoop: for loop, for each loop. Arrays.toString. Object class. 'instanceof
//keyword. nested Array.
// new section 9: RandomObjectAndArrayMethods: Random Class type. Random class inbuilt method '.nextInt', Array class '.binarySearch'
// method + '.sort' method + ''.copyOf' + '.equals' methods. Linear/sequential vs binary search
//***new section 9: ArrayChallenge: manually sort an array in descending order with use of boolean flag and temp variable
//new section 9: VarArgs: use of varargs method parameter format and '.split' String method
//new section 9: MinimumElementVersion2: scanner input string of numbers, '.split' into String array. Parsed ints
// to convert to int[] with use of '.trim' java method
//nwe section 9: reverse array: MutatingMethod: mutating vs non-mutating method. Post decrement variable
//new section 9: MultipleArrays: 2-dimensional array intro with both traditional and enhanced for loop access of nested array elements. '.deepToString' method
//somewhere in here it would be really good to use a static field for incrementing count of say patient ID number. Reference WorkerInheritance
//video and for some reason have to search static in the repository to find it