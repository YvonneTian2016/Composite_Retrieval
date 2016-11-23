/**
 * Created by yuantian on 11/22/16.
 */
import java.io.*;
import com.google.gson.*;
import java.util.ArrayList;
import Data.Items;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class File_Read {

    public File_Read(){}

    public ArrayList<Items> Read_File(String fileName){
            File file = new File(fileName);
            BufferedReader br = null;
            ArrayList<Items> items = new ArrayList<Items>();
        try{
            br = new BufferedReader(new FileReader(file));
            String str = null;
            int line = 1, index = 0;
            Items temp_it = new Items();
            int relevance =0, document = 0;
            while((str = br.readLine())!=null){
                 index = line % 4;
                switch(index) {
                    case 1:
                    {
                        temp_it.SetName(str);
                        break;
                    }
                    case 2:
                    {
                        temp_it.SetVertical(str);break;
                    }
                    case 3:
                    {
                         relevance = Integer.parseInt(str);
                         temp_it.SetRelevance(relevance); break;
                    }
                    case 0:
                    {
                        document = Integer.parseInt(str);
                        temp_it.SetRelevance(relevance);
                        items.add(temp_it);
                        break;
                    }
                }
                line++;
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
         return items;
    }


/*
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // read by line until end
            while ((tempString = reader.readLine()) != null) {
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
*/
}
