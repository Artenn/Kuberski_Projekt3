import org.json.simple.JSONArray;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        nf.setGroupingUsed(false);

        CovidRepository covidRepository=CovidService.getCoviddate();
        int opcja;
        while(true) {
            System.out.println("Witam w mojej aplikacji!");
            System.out.println("1.Zapisz dane w formacie JSON");
            System.out.println("2.Średnia śmierci");
            System.out.println("3.Średnia wyzdrowień");
            System.out.println("4.Średnia zachorowalność");
            System.out.println("5.Pokaż Dane");
            System.out.println("Podaj jakąkolwiek inną liczbe żeby zamknąć program");
            opcja = scanner.nextInt();
            if (opcja == 1) {
                ArrayList<String> lista= new ArrayList<>();
                for(Covid c: CovidRepository.getCovidList()){
                    lista.add(c.toString());
                }
                try{
                    File plik= new File("dane.json");
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(plik, true), StandardCharsets.UTF_8));
                    writer.write("{\"countries\" :"+lista+"}");
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcja == 2) {
                for(Covid c: CovidRepository.getCovidList()) {
                    System.out.println(c.getName()+": "+nf.format(covidRepository.deathratio(c)*100)+"%");
                }
            } else if (opcja == 3) {
                for(Covid c: CovidRepository.getCovidList()) {
                    System.out.println(c.getName()+": "+nf.format(covidRepository.recoverratio(c)*100)+"%");
                }
            } else if (opcja == 4) {
                for(Covid c: CovidRepository.getCovidList()) {
                    System.out.println(c.getName()+": "+nf.format(covidRepository.covidratio(c)*100)+"%");
                }
            }
            else if (opcja == 5) {
                for(Covid c: CovidRepository.getCovidList()){
                    System.out.println(c.toString());

                }
            } else {
                break;
            }
        }
    }
}
