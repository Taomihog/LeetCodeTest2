public class Main {
    public static void main(String[] args) {

        StockPrice2 obj = new StockPrice2();
        //[[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
        obj.update(1,10);
        obj.update(2,5);
        System.out.println(obj.current());
        System.out.println(obj.maximum());
        obj.update(1,3);
        System.out.println(obj.maximum());
        obj.update(4,2);
        System.out.println(obj.minimum());
//        obj.printAll();

    }
}