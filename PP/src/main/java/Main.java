public class Main {
    public static void main(String[] args) {
    Pobdane pobdane=new Pobdane();
    for(int i=0;i<23;i++){
            System.out.println(pobdane.getElementContent(".weather-index-item", i));
        }
    }
}
