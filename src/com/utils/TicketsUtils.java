package com.utils;

import com.constants.PropertiesCache;

public class TicketsUtils {
	
	static final double endToEndJourneyCost=Double.parseDouble(PropertiesCache.getInstance().getProperty("endtoendjourneycost"));
	static final double minStationsForDefaultCost=Double.parseDouble(PropertiesCache.getInstance().getProperty("minstationsfordefaultcost"));
	static final double minDefaultCost=Double.parseDouble(PropertiesCache.getInstance().getProperty("mindefaultcost"));
	static final double incrementalCost=Double.parseDouble(PropertiesCache.getInstance().getProperty("incrementalcost"));
	
	public static Double calculateFare(int from, int to) {
		if(from==0 && to==17) return endToEndJourneyCost;
		else if(to>from && to-from<=minStationsForDefaultCost) return minDefaultCost;
		else if(to<from && from-to<=minStationsForDefaultCost) return minDefaultCost;
		else if(to>from && to-from>minStationsForDefaultCost) return minDefaultCost+(to/(int)minStationsForDefaultCost * incrementalCost);
		else if(to<from && from-to>minStationsForDefaultCost) return minDefaultCost+(from/(int)minStationsForDefaultCost * incrementalCost);
		return 0.0;
	}
}
