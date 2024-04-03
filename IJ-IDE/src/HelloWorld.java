public class HelloWorld {
    public static void main(String[] args) {        // snipped= main + TAB
        System.out.printf("HelloWorld of Intelli-Jay\n");          // souf + TAB
        System.exit(5);
        System.out.println(sum(1, 2, 3, 4, 5));
    }


    public static int sum(int... numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }
}
//
