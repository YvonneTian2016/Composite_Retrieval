package Data;

/**
 * Created by yuantian on 11/22/16.
 */
import java.util.ArrayList;

public class Topic {

    private ArrayList<Items> allItems;
    private int entities; //subTopic of Topic identified by integer(mimic data)

    public Topic(){}
    public Topic(int entities, ArrayList<Items> allItems){
        this.allItems = allItems;
        this.entities = entities;
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

    public ArrayList<Items> getAboutnessBundle(ArrayList<ArrayList<Items>> Cand){
        int aboutness = 0, document = 0, max_about = 0;
        ArrayList<Items> Cur_Bundle = new ArrayList<Items>();
        ArrayList<ArrayList<Items>> Cur_C = new ArrayList<ArrayList<Items>>(Cand);
        ArrayList<Items> MaxAboutB = new ArrayList<Items>();

            for(ArrayList<Items> B: Cur_C){
                for(Items I: B)
                {
                      int[] freq = I.getDocument();
                     aboutness+=freq[entities];
                }
                if(aboutness >= max_about){
                     max_about = aboutness;
                     MaxAboutB = B;
                }
            }

        return MaxAboutB;
    }



}
