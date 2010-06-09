package com.magnitude.plugin.sample;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.magnitude.libs.PoiAttributes;


public class ParsePOI {
	private JSONObject highestJSONOBject;

	public ParsePOI(JSONObject jo) {
		this.highestJSONOBject = jo;
	}

	public ArrayList<PoiAttributes> parseObjects() {
		ArrayList<PoiAttributes> poiArray = new ArrayList<PoiAttributes>();
		try {	
			JSONArray array = new JSONArray(highestJSONOBject.getString("pois"));
			int i = 0;
			
			while (i < array.length()) {
				JSONObject jo = array.getJSONObject(i);
				String name="POI Name";
				Double altitude = 0.0;
				Double latitude = 0.0;
				Double longitude = 0.0;
				
				if (jo.has("name")) {
					name = jo.getString("name");
				}
				if (jo.has("altitude")) {
					altitude = jo.getDouble("altitude");
				}
				if (jo.has("latitude")) {
					latitude = jo.getDouble("latitude");
				}
				if (jo.has("longitude")) {
					longitude = jo.getDouble("longitude");
				}
				
				PoiAttributes p = new PoiAttributes(name, "com.magnitude.poi", latitude, longitude, altitude);
				
				poiArray.add(p);
				i++;
			}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return poiArray;
		
	}
}
