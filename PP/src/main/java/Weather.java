import java.time.LocalDate;

public class Weather {
    private String miasto;
    private String temp;
    private LocalDate data;
    public Weather(String miasto, String temp){
        setMiasto(miasto);
        setTemp(temp);
        setData(LocalDate.now());
    }
    public void setData(LocalDate data){this.data=data;}
    public LocalDate getData(){return data;}
    public void setMiasto(String miasto){this.miasto=miasto;}
    public String getMiasto(){return miasto;}
    public void setTemp(String temp){this.temp = temp;}
    public String getTemp(){return temp;}
}
