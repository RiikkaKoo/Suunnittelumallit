package assignment;

import java.io.IOException;

public class Facade {
    public String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalArgumentException, IOException {

        String result = "";
        try {
            result = HTTPRequest.getRequest(urlString);
        } catch (Exception e) {
            throw new IOException("Request to URL failed.");
        }

        String attribute = "";
        try {
            String extraction = JSONExtractor.extractJokeFromJson(result, attributeName);
            if (extraction == null) {
                throw new IllegalArgumentException("Attribute not found.");
            } else {
                attribute = extraction;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Attribute not found.");
        }
        return attribute;
    }
}
