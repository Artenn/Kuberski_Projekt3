import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CovidService {
    public static CovidRepository getCoviddate(){
        CovidRepository repository= new CovidRepository();
        String requestUrl = "https://api.quarantine.country/api/v1/summary/latest";
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            StringBuilder inline= new StringBuilder();
            Scanner scanner=new Scanner(url.openStream());
            while(scanner.hasNext()){
                inline.append(scanner.nextLine());
            }
            scanner.close();
            JSONParser parser= new JSONParser();
            JSONObject data_obj = (JSONObject) parser.parse(inline.toString());
            List <String> panstwa= List.of("usa","india","brazil","france","russia","turkey","uk","italy","spain","germany","argentina","colombia","poland","iran","mexico","ukraine","peru","indonesia","czechia","south_africa","netherlands","canada","chile","iraq","romania","philippines","belgium","sweden","israel","portugal","pakistan","hungary","bangladesh","jordan","serbia","switzerland","austria","japan","united_arab_emirates","morocco","saudi_arabia","malaysia","bulgaria","slovakia","ecuador","kazakhstan","panama","belarus","greece","croatia","azerbaijan","nepal","tunisia","bolivia","palestine","paraguay","kuwait","dominican_republic","ethiopia","denmark","moldova","ireland","lithuania","costa_rica","slovenia","guatemala","egypt","armenia","honduras","qatar","bosnia_and_herzegovina","venezuela","oman","uruguay","libya","bahrain","nigeria","kenya","north_macedonia","myanmar","albania","algeria","estonia","south_korea","latvia","norway","sri_lanka","cuba","montenegro","kyrgyzstan","ghana","zambia","uzbekistan","finland","mozambique","el_salvador","luxembourg","cameroon","cyprus","thailand","singapore","afghanistan","namibia","botswana","ivory_coast","jamaica","uganda","senegal","zimbabwe","madagascar","malawi","sudan","mongolia","malta","australia","maldives","angola","rwanda","cabo_verde","gabon","syria","guinea","reunion","mayotte","french_guiana","french_polynesia","eswatini","mauritania","somalia","mali","guadeloupe","tajikistan","burkina_faso","andorra","haiti","togo","guyana","belize","curacao","cambodia","hong_kong","martinique","djibouti","papua_new_guinea","lesotho","congo","aruba","south_sudan","bahamas","trinidad_and_tobago","suriname","benin","equatorial_guinea","nicaragua","iceland","central_african_republic","yemen","gambia","seychelles","niger","san_marino","chad","saint_lucia","gibraltar","channel_islands","sierra_leone","burundi","guinea_bissau","eritrea","liechtenstein","vietnam","new_zealand","monaco","turks_and_caicos","bermuda","sao_tome_and_principe","sint_maarten","timor_leste","liberia","st_vincent_grenadines","saint_martin","isle_of_man","caribbean_netherlands","antigua_and_barbuda","mauritius","taiwan","bhutan","st_barth","diamond_princess","faeroe_islands","laos","cayman_islands","tanzania","wallis_and_futuna","brunei","british_virgin_islands","dominica","grenada","new_caledonia","fiji","anguilla","falkland_islands","macao","saint_kitts_and_nevis","greenland","vatican_city","saint_pierre_miquelon","solomon_islands","montserrat","western_sahara","ms_zaandam","marshall_islands","vanuatu","samoa"
            );
            JSONObject data = (JSONObject) parser.parse(String.valueOf(data_obj.get("data")));
            JSONObject tablica = (JSONObject) parser.parse(String.valueOf(data.get("regions")));
            for (String o: panstwa) {
                try {
                    JSONObject newObject = (JSONObject) parser.parse(String.valueOf(tablica.get(o)));
                    Covid dane = new Covid(newObject.get("name").toString(), Integer.parseInt(newObject.get("total_cases").toString()), Integer.parseInt(newObject.get("active_cases").toString()), Integer.parseInt(newObject.get("recovered").toString()), Integer.parseInt(newObject.get("deaths").toString()), Integer.parseInt(newObject.get("tested").toString()));
                    repository.save(dane);
                } catch (ParseException | NumberFormatException | NullPointerException ignored) {
                }

            }
            return repository;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
