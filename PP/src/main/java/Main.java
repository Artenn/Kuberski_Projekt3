import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Aplikacja");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj login:");
        String login = scanner.next();
        System.out.println("Podaj Hasło:");
        String haslo = scanner.next();

        Logowanie logowanie = new Logowanie(login,haslo);
        if(logowanie.Zalogowanie()){
            int opcja;
            while(true){
                System.out.println("Zalogowany");
                System.out.println("1.Wprowadzenie Pogody z Miast na Dzień Dzisiejszy");
                System.out.println("2.Pokazanie pogody, która występowała podczas dni w których była pobierana do bazy");
                System.out.println("Podaj jakąkolwiek inną liczbe żeby zamknąć program");
                opcja=scanner.nextInt();
                if(opcja==1){
                    Workingstation.opcjapierwsza();
                }else if(opcja==2){
                    Workingstation.opcjadruga();
                }else{
                    break;
                }
            }
        }else{
            System.out.println("Błędne Dane");
        }

    }
}