import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GeneratorRandomNumbers {
    int numberX = 0;
    int numberO = 0;
    final ArrayList<Integer> listOfXRandomNumbers = new ArrayList<>(Arrays.asList(1,1,1,2,2,2,3,3,3));
    final ArrayList<Integer> listOfORandomNumbers = new ArrayList<>(Arrays.asList(1,1,1,2,2,2,3,3,3));
    Random random = new Random();

    public int takeXNumber(){
        numberX = listOfXRandomNumbers.get(random.nextInt((listOfXRandomNumbers.size()-1)));
        return numberX;
    }

    public int takeONumber(){
        numberO = listOfORandomNumbers.get(random.nextInt((listOfORandomNumbers.size()-1)));
        return numberO;
    }


}
