import java.util.Random;
import java.util.Scanner;

class QuickStart {

    public static int add(int num1, int num2) {
        return num1 + num2;
    }


    public static String reverse(String word) {
        String result = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            result = result + c;
        }
        return result;
    }

    public static void guessingGame() {
        Scanner s = new Scanner(System.in);
        boolean gameOver = false;
        Random r = new Random(100);
        int target = r.nextInt();
        int turns = 10;
        while (!gameOver || turns == 0) {
            System.out.println("Enter a number");
            int num = Integer.parseInt( s.nextLine());
            if (num == target) gameOver = true;
            else if (num < target) System.out.println("Too low, try again!");
            else System.out.println("Too high, try again");
            turns--;
        }
        

        
    }

    public static void main (String[] args) {
        //System.out.println(add(1,2));
        //System.out.println(reverse("chungus"));
        guessingGame();
    }
}

