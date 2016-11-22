package Data; /**
 * Created by yuantian on 11/22/16.
 */
import java.util.ArrayList;


public class Items {

    private String name;
    private ArrayList<String> tags;
    private String vertical;
    private int relevance; //Topic relevance
    private double[] similarities;
    private int[] distances;

    public Items(String name,ArrayList<String> tags, String vertical, int relevance, double[] similarities) {
        this.name = name;
        this.tags = tags;
        this.vertical = vertical;
        this.relevance = relevance;
        this.similarities = similarities;
    }



    public String getName() {
        return name;
    }

    public ArrayList<String> getTags() { return tags; }

    public String getTagsString() {
        String tagsString = "";
        for (String tag : tags) {
            tagsString += (tag + ";");
        }
        return tagsString;
    }

    public String getVertical() {
        return vertical;
    }

    public int getRelevance() {
        return relevance;
    }

    public double[] getSimilarities() { return similarities; }

    public String getSimilaritiesString() {
        String similaritiesString = "";
        for (double sim : similarities ) {
            similaritiesString += (sim + "; ");
        }
        return similaritiesString;
    }

    public void setSimilarities(double[] similarities) { this.similarities = similarities; }

}