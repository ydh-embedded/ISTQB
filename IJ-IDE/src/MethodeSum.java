public class MethodeSum {

    public static void main(String[] args) {
        try {
            System.out.printf("HelloWorld of Intelli-Jay\n");
            int result = sum(1, 2, 3, 4, 5);
            System.out.println("The sum is: " + result);
            System.exit(5);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static int sum(int... numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
            if (sum > 10) {
                throw new IllegalArgumentException("Sum exceeds 10!");
            }
        }
        return sum;
    }
}