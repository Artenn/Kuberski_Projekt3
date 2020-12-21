import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
    Pobdane pobdane=new Pobdane();
        PrintWriter output = null;
        try {
            output = new PrintWriter("dane.txt");
            for(int i=0;i<16;i++){
                output.println(pobdane.getElementContent(".weather-index-item", i));
            }
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
