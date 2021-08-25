import java.util.ArrayList;
import java.util.List;

class BubbleSort {
    public static void main(String[] args) {
        // Default array to be sorted in case the user does not provide any valid input.
        final int[] DEFAULT_ARRAY = { 5, 3, 2, 4, 7, 1, 0, 6 };

        String[] inputList;
        List<Integer> formattedList = new ArrayList<>();

        try {
            // The following guarantees that the user informes only one input.
            if (args.length != 1) {
                throw new Exception();
            }

            // The following parses the input to a list of integers. In case the user does
            // not send a n-size list of integers in the form of 'int_1,int_2, ... ,int_n',
            // an excepetion will be thrown. Note that lists are dynamic, therefore a good
            // option here as we don't know the size of the list the user will provide.
            inputList = args[0].split(",");
            for (int i = 0; i < inputList.length; i++) {
                formattedList.add(Integer.parseInt(inputList[i]));
            }
        } catch (Exception exception) {
            // Catching an execption in case the program did not manage to convert the
            // input to a list of integers.
            System.out.println("Oops! The input must be 'x_1,x_2, ... ,x_n'.");
            System.out.println(
                    "As I haven't understood your input, I will be using the following array: 5,3,2,4,7,1,0,6.");

            // The following makes sure the program will sort the default arrat provided
            // earlier in case there is no valid input from the user.
            formattedList.clear();
            for (int i = 0; i < DEFAULT_ARRAY.length; i++) {
                formattedList.add(i, DEFAULT_ARRAY[i]);
            }
        }

        // The following loop goes all over the n-size list A (n - 1) times and checks
        // adjacents pairs to decide if A[i] > A[i+1].
        // If that's the case, they will have their positions swapped.
        // Note that Java starts indices from 0.
        int aux = 0;
        for (int i = 0; i < formattedList.size() - 1; i++) {
            for (int j = 0; j < formattedList.size() - 1; j++) {
                if (formattedList.get(j + 1) < formattedList.get(j)) {
                    aux = formattedList.get(j + 1);
                    formattedList.set(j + 1, formattedList.get(j));
                    formattedList.set(j, aux);
                }
            }
        }

        System.out.println(formattedList.toString());

    }
}