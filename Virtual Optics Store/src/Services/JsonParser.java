package Services;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import Model.Glasses;

public class JsonParser {
	public static JSONObject prepareGlassesJSON(ArrayList<Glasses> glasses) throws JSONException{
		ArrayList<String> brands = new ArrayList<String>();
		ArrayList<String> modelNames = new ArrayList<String>();
		ArrayList<String> paths = new ArrayList<String>();
		ArrayList<Double> prices = new ArrayList<Double>();
		for(Glasses g : glasses){
			brands.add(g.getBrand().getName());
			modelNames.add(g.getModelName());
			paths.add(g.getModel());
			prices.add(g.getPrice());
		}
		JSONObject obj = new JSONObject();
		obj.put("brands", brands);
		obj.put("modelNames", modelNames);
		obj.put("paths", paths);
		obj.put("prices", prices);
		
		return obj;
	}
}
