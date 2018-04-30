import java.util.Scanner;

public class SplitsApplication {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Splits splits = new Splits();

        int input = scanner.nextInt();

        splits.makeSplits(input);
        System.out.print(splits.getNumberSplits());
    }
}

class Splits {
    private int numberSplits = 0;
    public void makeSplits(int input) {
        numberSplits = input / 2 + 1;
    }

    public int getNumberSplits() {
        return numberSplits;
    }
}
