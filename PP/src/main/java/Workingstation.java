import java.sql.*;

public class Workingstation {
    private static final Connection conn= Connector.connect();
    public Workingstation(){};
    public static void opcjapierwsza(){
        String state = "Insert INTO pogoda(Miasto,Temperatura,Data) Values (?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement((state));
            Weather[] weathers = GetWeather.Weathers();
            for(Weather d: weathers){
                statement.setString(1, d.getMiasto());
                statement.setString(2, d.getTemp());
                statement.setString(3, d.getData().toString());
                statement.execute();
            }
            System.out.println("Obiekty zostały wysłane do bazy");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void opcjadruga(){
        ResultSet wyniki;
        String state="Select * From pogoda";
        try{
            Statement statement = conn.prepareStatement(state);
            wyniki=statement.executeQuery(state);
            wyniki.next();
            while(wyniki.next()){
                System.out.println(
                        "Miasto: "+wyniki.getString("Miasto") +
                        "\nTemperatura: "+wyniki.getString("Temperatura")+
                        "\nData: "+wyniki.getString("Data")+
                        "\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Wyświetlono obiekty z bazy");
    }
}
