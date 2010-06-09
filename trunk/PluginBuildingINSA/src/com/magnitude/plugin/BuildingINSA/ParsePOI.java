package com.magnitude.plugin.BuildingINSA;

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

	public ArrayList<PoiAttributes> lancerTraitement() {
		ArrayList<PoiAttributes> poiArray = new ArrayList<PoiAttributes>();
		JSONArray array = new JSONArray();
		int i = 0;
		try {
			if(highestJSONOBject != null) {
				array = highestJSONOBject.names();
				while (i < array.length()) {
					JSONObject jo;
					JSONObject joPoints;
					jo = highestJSONOBject.getJSONObject(array.getString(i));
					
					String name="POI Name";
					Double altitude = 0.0;
					Double latitude = 0.0;
					Double longitude = 0.0;
					
					if (jo.has("points")) {
						joPoints = jo.getJSONObject("points");
						JSONArray pointsArray = new JSONArray();
						pointsArray = joPoints.names();
						JSONObject joCoord = joPoints.getJSONObject(pointsArray.getString(0));
						if (joCoord.has("altitude")) {
							altitude = joCoord.getDouble("altitude");
						}
						if (joCoord.has("latitude")) {
							latitude = joCoord.getDouble("latitude");
						}
						if (joCoord.has("longitude")) {
							longitude = joCoord.getDouble("longitude");
						}
					}
					if (jo.has("nom")) {
						name = jo.getString("nom");
					}
					if (jo.has("id")) {
						//id = jo.getInt("id");
					}
					PoiAttributes p = new PoiAttributes(name, "com.magnitude.poi", latitude, longitude, altitude);
					p.setPopUp("http://etud.insa-toulouse.fr/~raymard/ptut/foot.json");
					poiArray.add(p);
					i++;
				}
			}	
		} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}	
		return poiArray;
		
	}
}
