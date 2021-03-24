public class GetWeather {
    private static final Pobdane scrapper= new Pobdane();
    public static Weather[] Weathers(){
        Weather[] weathers= new Weather[17];
        for(int i=0;i<16;i++){
            weathers[i]=new Weather(
                    scrapper.getElementContent(".weather-index-item-name",i),
                    scrapper.getElementContent(".weather-index-item-temp",i));
        }
        return weathers;
    }
}
