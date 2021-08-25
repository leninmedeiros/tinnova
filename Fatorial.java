class Fatorial {
    public static void main(String[] args) {
        int number = 0;
        try {
            // The user must provid one positive integer greater or equal to zero as input.
            // Otherwise, an exception will be thrown.
            if (args.length != 1) {
                throw new Exception();
            }
            number = Integer.parseInt(args[0]);

            // In case the input is equal to 0, the result will be equal to 1.
            int result = 1;

            // The following loop goes from 2, as 1*1 = 1, until the provided input and
            // keeps multipling all the numbers.
            for (int i = 2; i <= number; i++) {
                result *= i;
            }

            System.out.println(Integer.toString(result));
        } catch (Exception exception) {
            System.out.println(
                    "Error! Try again passing as input parameter only one integer that is greater or equal to zero.");
        }
    }
}