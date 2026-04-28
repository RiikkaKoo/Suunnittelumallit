package assignment;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONExtractor {

    // Works for JSONs that do not contain arrays (based on the two different APIs and OpenWeatherMap API)
    public static String extractJokeFromJson(String json, String attribute) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);

        String[] levels = attribute.split("\\.");
        Object found = jsonObject;
        for (String s : levels) {
            JSONObject o = (JSONObject) found;
            found = o.get(s);
        }

        if (found instanceof String) {
            return (String) found;
        } else {
            String fixed = "" + found;
            return fixed;
        }
    }
}
