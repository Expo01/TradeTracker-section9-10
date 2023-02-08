import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Trade notRealTrade = new Trade("SPYYY", "01/26/23", "cill", -1d,
                -.00, -1, 1900);
        Trade SPXSCall012723At1539 = new Trade("SPXS", "02/03/23", "call", 19.5,
                .31, 2, 1446);
        Trade SPXLCall012723At1554 = new Trade("SPXL", "02/03/23", "call", 79d,
                .60, 1, 1454);

        Date dateOf012623 = new Date("01/26/23");
        dateOf012623.addTrade(notRealTrade);
        notRealTrade.setSellPrice(.75);
        notRealTrade.setSellTime(1500);
//        System.out.println(dateOf012623);

        Date dateOf012723 = new Date("01/27/23");
        dateOf012723.addTrade(SPXSCall012723At1539);
        dateOf012723.addTrade(SPXLCall012723At1554);
//        System.out.println(dateOf012723);

        Week weekOf012323 = new Week("01/23/23");
        weekOf012323.addDate(dateOf012623);
        weekOf012323.addDate(dateOf012723);


        //what I've got so far: Class Week which contains an Array of Dates which contain arrays of Trade objects with various
        // contract fields which I've limited input as much as I know how. I have an interator where I code in the trading week
        // and can cycle through the trades taken on that day en masse but not individually.

        //What I've gotta do: Add another dimension to the iterator to flip through individual trades once a date selected.
        // have scanner input for selecting a week of a trade
        //scanner for fatory method generation of trade details for Trade object.
        //could create one more array dimension: Year --> week --> date --> trade. Object of Trade 3 deep in arrays


        reviewTrades(weekOf012323);
    }

    private static void reviewTrades(Week inputWeek) {
        printMenu();
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
                    System.out.println(" now displaying " + listIterator.next().toString());
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
                        System.out.println("Now displaying next trade" + listIterator.next().toString());
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
                    printMenu();
                    break;

            }
        }
    }

    public static void printMenu() {
        System.out.println("enter 0 to quit, 1 to display first trade, 2 to display next trade, 3 to display previous trade, " +
                "4 to display the weekly trades, 5 to display menu");
    }


}


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