import Data.Items;
import Data.Topic;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {

    public static void main(String args[]){

        Scanner s = new Scanner(System.in); //read from console
        System.out.println("Please Type the No. of Topic you want to search:");
        //receive integer
        int T = s.nextInt();
        Topic Cur_T = new Topic(T);   //Topic
        ArrayList<ArrayList<Items>> Search_R = new ArrayList<ArrayList<Items>>();


        File_Read file = new File_Read();
        String fileName = "src/"+T+".txt";
        ArrayList<Items> items = file.Read_File(fileName);
        System.out.println(items);

        Composite_Retrieval C_R = new Composite_Retrieval(items,Cur_T);
        System.out.println("Please define the threshold on number of items in a bundle *beta*:");
        int beta = s.nextInt();
        System.out.println("Please define minimum bundle score *mu*:");
        int mu = s.nextInt();
        System.out.println("Please define number of bundles in ProduceBundles *c*:");
        int c = s.nextInt();
        System.out.println("Please define number of bundles in ChooseBundles *k*:");
        int k = s.nextInt();

        System.out.println("Searching Topic "+T+"... ...\n");

        Search_R = C_R.Composite_Retrieval(items,c,beta,mu,k);



    }



}


