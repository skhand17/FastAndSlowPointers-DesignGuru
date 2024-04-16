public class HappyNumber {

    public static void main(String[] args) {

        int num = 12;
        boolean isHappy = find(num);
        System.out.println(isHappy);
    }

    public static boolean find(int num) {

        int slow = num;
        int fast = num;

        do {
            slow = findSquares(slow);
            fast = findSquares(findSquares(fast));
        } while(slow != fast);

        return slow == 1;

    }

    private static int findSquares(int num){

        int sum = 0;
        int digit;

        while(num > 0){
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }
}
