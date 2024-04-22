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
        
    }

    public static void main (String[] args) {
        //System.out.println(add(1,2));
        System.out.println(reverse("chungus"));
    }
}

