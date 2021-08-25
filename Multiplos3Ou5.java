class Multiplos3Ou5 {
    public static void main(String[] args) {
        try {
            // The following guarantees that the user informes only one input.
            if (args.length != 1) {
                throw new Exception();
            }

            // In case the user does not provide one valid integer as input, an exception
            // will be thrown.
            int number = Integer.parseInt(args[0]);

            // The following goes from 0 to the provided input and sums the numbers that are
            // divisible by either 3 or 5.
            // Note that j%k returns the remainder of j/k. When the remainder is 0, j is a
            // multiple of k.
            int result = 0;
            for (int i = 0; i < number; i++) {
                if (i % 3 == 0 || i % 5 == 0) {
                    result += i;
                }
            }
            System.out.println(Integer.toString(result));
        } catch (Exception e) {
            // Catching an exception in case no valid input is provided by the user.
            System.out.println(
                    "Error! Try again passing as input parameter only one integer that is greater or equal to zero.");
        }
    }
}
