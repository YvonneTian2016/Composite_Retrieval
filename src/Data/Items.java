package Data; /**
 * Created by yuantian on 11/22/16.
 */
import java.util.ArrayList;


public class Items {

    private String name;
    private String vertical;
    private int relevance; //Topic relevance  1-10
    private int document; //frequency in document

    public Items(){}
    public Items(String name,ArrayList<String> tags, String vertical, int relevance, int document) {
        this.name = name;
        this.vertical = vertical;
        this.relevance = relevance;
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public String getVertical() {
        return vertical;
    }

    public int getRelevance() {
        return relevance;
    }

    public int getDocument(){return document;}


    public void SetName(String name) {
        this.name = name;
    }

    public void SetVertical(String vertical) {
        this.vertical = vertical;
    }

    public void SetRelevance(int relevance) {
        this.relevance = relevance;
    }

    public void SetDocument(int document){
        this.document=document;
    }

}