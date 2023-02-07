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
        System.out.println(weekOf012323);

        //what I've got so far: Class Week which contains an Array of Dates which contain arrays of Trade objects with various
        // contract fields which I've limited input as much as I know how.

        //What I've gotta do: Create an iterator to flip through and display individual trade information with a chart...
        //will likely want to do scanner and factory method for this later

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