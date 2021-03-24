import java.sql.*;
public class Logowanie{
    private String login;
    private String haslo;
    private boolean zalogowany = false;
    public Logowanie(String login, String pass){
        setLogin(login);
        setHaslo(pass);
    }
    public boolean Zalogowanie(){
        Connection conn= Connector.connect();

        String select="Select pass FROM uzytkownicy where login = ?";
        try{
            PreparedStatement statement = conn.prepareStatement(select);
            statement.setString(1,this.login);
            try{
                ResultSet wyniki= statement.executeQuery();
                wyniki.next();
                String pass = wyniki.getString("pass");
            if(pass.equals(this.haslo)){
                this.zalogowany=true;
                return true;
            }
            }
            catch (SQLException throwables){

            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public void setLogin(String login){this.login=login;}
    public void setHaslo(String haslo){this.haslo = haslo;}

    public boolean Zalogowany(){return zalogowany;}

}
