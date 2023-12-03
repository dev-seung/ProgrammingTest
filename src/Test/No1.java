package Test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

interface Bread {
    void displayRecipe();
}

class CreamBread implements Bread {
    JSONObject recipe;
    CreamBread(JSONObject recipe) { this.recipe = recipe; }
    public void displayRecipe() {
        System.out.println("breadType: cream\nrecipe");
        System.out.println("flour: " + recipe.get("flour"));
        System.out.println("water: " + recipe.get("water"));
        System.out.println("cream: " + recipe.get("cream"));
    }
}

class SugarBread implements Bread {
    JSONObject recipe;
    SugarBread(JSONObject recipe) { this.recipe = recipe; }
    public void displayRecipe() {
        System.out.println("breadType: sugar\nrecipe");
        System.out.println("flour: " + recipe.get("flour"));
        System.out.println("water: " + recipe.get("water"));
        System.out.println("sugar: " + recipe.get("sugar"));
    }
}

class ButterBread implements Bread {
    JSONObject recipe;
    ButterBread(JSONObject recipe) { this.recipe = recipe; }
    public void displayRecipe() {
        System.out.println("breadType: butter\nrecipe");
        System.out.println("flour: " + recipe.get("flour"));
        System.out.println("water: " + recipe.get("water"));
        System.out.println("butter: " + recipe.get("butter"));
    }
}

class BreadFactory {
    static Bread createBread(String breadType, JSONObject recipe) {
        switch (breadType) {
            case "cream": return new CreamBread(recipe);
            case "sugar": return new SugarBread(recipe);
            case "butter": return new ButterBread(recipe);
            default: throw new IllegalArgumentException("잘못된 입력: " + breadType);
        }
    }
}

public class No1 {
    public static void main(String[] args) throws ParseException {
        String jsonData = "[{\"breadType\": \"cream\", \"recipe\": {\"flour\": 100, \"water\": 100, \"cream\": 200}}, {\"breadType\": \"sugar\", \"recipe\": {\"flour\": 100, \"water\": 50, \"sugar\": 200}}, {\"breadType\": \"butter\", \"recipe\": {\"flour\": 100, \"water\": 100, \"butter\": 50}}]";
        
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(jsonData);
        JSONArray breadsArray = (JSONArray)obj;
       
        List<Bread> breads = new ArrayList<>();

        for (int i = 0; i < breadsArray.size(); i++) {
            JSONObject breadObject = (JSONObject)breadsArray.get(i);
            String breadType = breadObject.get("breadType").toString();
            JSONObject recipe = (JSONObject)breadObject.get("recipe");
            Bread bread = BreadFactory.createBread(breadType, recipe);
            breads.add(bread);
        }

        for (Bread bread : breads) {
            bread.displayRecipe();
            System.out.println();
        }
    }
}
