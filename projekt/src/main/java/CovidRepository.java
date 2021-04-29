import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CovidRepository {
    private static final List<Covid> covidList = new ArrayList<>();

    public static List<Covid> getCovidList() {
        return covidList;
    }
    public void save(Covid covid){
        covidList.add(covid);
    }
    public double deathratio(Covid covid){
        return (double)covid.getDeaths()/(double)covid.getTotal_cases();
    }
    public double recoverratio(Covid covid){
        return (double)covid.getRecovered()/(double)covid.getTotal_cases();
    }
    public double covidratio(Covid covid){
        if(covid.getTested()==0){
            return 0;
        }else {
            return (double) covid.getTotal_cases() / (double) covid.getTested();
        }
    }



}
