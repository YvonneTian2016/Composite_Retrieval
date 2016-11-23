import Data.Items;
import Data.Topic;
import java.util.ArrayList;

public class Main {

    private Composite_Retrieval  C_R;
    private ArrayList<Items> allItems;
    private Topic relevance;

    public static void main(String args[]){

        // C_R = new Composite_Retrieval(allItems,relevance);

        System.out.println("line ");

        File_Read file = new File_Read();



        System.out.println("line ");

        String fileName = "src/Temp.txt";
        file.readFileByLines(fileName);



    }



}
