package eu.fiveminutes.android.weatherapp.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JSONUtil {

    public static JSONObject createJsonFromString(String data) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JSONObject getSubNode(String name, JSONObject node) {
        JSONObject subNode = null;

        if (node == null || node.isNull(name)) {
            return subNode;
        }
        try {
            subNode = node.getJSONObject(name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return subNode;
    }

    public static String getString(String key, JSONObject jsonObject) {
        String value = null;

        if (jsonObject == null || jsonObject.isNull(key)) {
            return value;
        }
        try {
            value = jsonObject.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static int getInt(String key, JSONObject jsonObject) {
        int value = 0;

        if (jsonObject == null || jsonObject.isNull(key)) {
            return value;
        }
        try {
            double valueDouble = jsonObject.getDouble(key);
            value = (int) Math.round(valueDouble);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static JSONArray getJSONArray(String name, JSONObject jsonObject) {
        JSONArray jsonArray = null;

        if (jsonObject == null || jsonObject.isNull(name)) {
            return jsonArray;
        }
        try {
            jsonArray = jsonObject.getJSONArray(name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    public static JSONObject getJsonObjectFromJsonArray(int index, JSONArray jsonArray) {
        JSONObject jsonObject = null;

        if (jsonArray == null) {
            return jsonObject;
        }
        if (jsonArray.isNull(index)) {
            return jsonObject;
        }

        try {
            jsonObject = jsonArray.getJSONObject(index);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}

