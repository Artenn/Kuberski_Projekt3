import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Pobdane {
    private Document stron=null;
    public Pobdane(){
        try
        {
            this.stron= Jsoup.connect("https://pogoda.interia.pl").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getElementContent(String cQ, int ktr){
        return elementToText(getAllElements().select(cQ).get(ktr));
    }
    public String getIdContent(String id){
        return elementToText(getAllElements().getElementById(id));
    }
    public Element getAllElements(){
        return this.stron.getAllElements().first();
    }
    public String elementToText(Element el){
        return el.text();
    }
    @Override
    public String toString() {
        return "Scrapper{" +  super.toString()+ '}';
    }
}
