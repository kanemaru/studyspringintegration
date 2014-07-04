package jp.biglobe.springintegration.util;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sane on 2014/07/02.
 */
public class JsonUtils {

    public static Map<String, String> parseJson(String jsonStr) {

        JsonParser parser =
                Json.createParser(new ByteArrayInputStream(jsonStr.getBytes()));

        HashMap<String, String> parseResult = new HashMap<String, String>();
        String lastKey = "";
        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            switch (event) {
                case KEY_NAME:
                    lastKey = parser.getString();
                    break;
                case VALUE_STRING:
                    parseResult.put(lastKey, parser.getString());
                    break;
                default:
                    break;
            }
        }

        return parseResult;
    }

    public static String buildJsonMessage(Map data) {

        StringBuilder builder = new StringBuilder();
        builder.append("{ ");

        boolean isFirst = true;
        for (Object key : data.keySet()) {
            if (!isFirst) {
                builder.append(", ");
            }
            builder.append("\"");
            builder.append(key);
            builder.append("\" : \"");
            builder.append(data.get(key));
            builder.append("\"");
            isFirst = false;
        }

        builder.append(" }");
        return builder.toString();
    }
}
