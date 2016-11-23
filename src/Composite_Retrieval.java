/**
 * Created by yuantian on 11/22/16.
 */

import java.util.ArrayList;
import Data.Items;
import Data.Topic;

public class Composite_Retrieval {
    private ArrayList<Items> allItems;
    private Topic topic;

    public Composite_Retrieval(ArrayList<Items> allItems, Topic topic){
        this.allItems=allItems;
        this.topic = topic;
    }

    /*Composite_Retrieval*/
    public ArrayList<ArrayList<Items>> Composite_Retrieval(ArrayList<Items> allItems, int c, double beta, double mu, int k, double gamma){
        //Cand <--
        ArrayList<ArrayList<Items>> Cand = Produce_Bundles(allItems,beta,mu,c);
        return Cand;
        //Given the number of required bundles, k, a set Cand of candidate bundles, and a similarity function between items;
         //return Choose_Bundles(k,Cand);


    }

    /*Algorithm 1 - BOBO*/
    public ArrayList<ArrayList<Items>> Produce_Bundles(ArrayList<Items> I, double beta, double mu, int c){
        //Cand = empty collection
        ArrayList<ArrayList<Items>> Cand = new ArrayList<ArrayList<Items>>();

        // Pivots = I
        ArrayList<Items> Pivots = new ArrayList<Items>(I);

        //while Pivots != ∅ && |Cand| < c
        while(!Pivots.isEmpty() && Cand.size() < c) {
            // w: pick one from Pivots(item with the highest relevance estimation)
            ArrayList<Items> Temp_allItems = new ArrayList<Items>(allItems);

            Temp_allItems.removeAll(new ArrayList<Items>(Pivots));

            Items w = topic.getHighestRel(Temp_allItems);
            //I = I \ w
            I.remove(w);
            // S = Pick_Bundle
            ArrayList<Items> S = Pick_Bundle(w, I, beta); // included a f function for check vertical diversity
            //if score(S) >= mu
            if (score(S) >= mu) {
                //I = I \ S
                I.removeAll(S);
                //Pivots = Pivots \ S
                Pivots.removeAll(S);
                //Cand = Cand + {S}
                Cand.add(S);
            } else {
                //Pivots = Pivots \ w
                Pivots.remove(w);
            }
        }
        return Cand;

    }

    /* Algorithm 2 - Pick Bundle*/
    public ArrayList<Items> Pick_Bundle(Items w, ArrayList<Items> I, double beta ){
        boolean finish = false;
        //  s = w;
        ArrayList<Items> s = new ArrayList<Items>();
        s.add(w);
        ArrayList<String> Vertical = new ArrayList<String>();
        Vertical.add(w.getVertical());
        //active = I \ w ;
        ArrayList<Items> active = new ArrayList<Items>(I);
        active.removeAll(s);
        while(!finish && active.size() != 0)
        {
            //i = argmax{i ∈ active} s(i,w)
            Items i = topic.getClosetItem(w, active);
            // if function f:
            if(function(i.getVertical(), Vertical)){
                ArrayList<Items> Temp_s = new ArrayList<Items>(s);
                Temp_s.add(i);
                if(Treshold(Temp_s,beta)){
                    // s = s+i;
                    s = Temp_s;
                    Vertical.add(i.getVertical());
                }
                else{
                    finish = true;
                }
            }
            //active = active \ i;
            active.remove(i);
        }
        return s;
    }

    /* score */
    public double score(ArrayList<Items> s) {
        double score = topic.getHighestRel(s).getRelevance();
        return score;
    }


    /* Algorithm 2 also ensures vertical diversity, by enforcing the constraints that the bundle s is
    required to contain items from at least two different verticals. */
    public boolean function(String v, ArrayList<String> Vertical) {
        int flag = 0;
        if(Vertical.contains(v)){
            for(String Has_Ver: Vertical)
            {
                if(Has_Ver != v)
                    flag = 1;
            }
            if(flag == 0)
                return false;
            else
                return true;
        }
        else
            return true;
    }

    /*a threshold beta on the number of items in a bundle*/
    public boolean Treshold(ArrayList<Items> bundle, double beta) {
        int num = bundle.size();
        if (num > beta) {
            return false;
        }
        else {
            return true;
        }
    }

}
