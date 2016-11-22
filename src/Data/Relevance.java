package Data;

/**
 * Created by yuantian on 11/22/16.
 */
import java.util.ArrayList;

public class Relevance {

    private ArrayList<Items> allItems;

    public Relevance(){}
    public Relevance(ArrayList<Items> allItems){
        this.allItems = allItems;
    }

    public Items getHighestRel(ArrayList<Items> allItems){
        int max = 0, idx= 0, i = 0;
           for(Items I: allItems)
           {
                 if(I.getRelevance() > max)
                 {
                     idx = i;
                     max = I.getRelevance();
                 }
               i++;
           }
     return allItems.get(idx);
    }

    public Items getClosetItem(Items w, ArrayList<Items> active){
        int min = 10000, dis= 0,idx = 0,i = 0;
        for(Items I: active){
            dis = Math.abs(I.getRelevance()-w.getRelevance());
             if(dis<min){
                 min = dis;
                 idx = i;
             }
             i++;
        }
      return active.get(idx);
    }


}
