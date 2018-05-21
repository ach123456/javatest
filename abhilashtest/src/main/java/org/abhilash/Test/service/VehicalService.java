package org.abhilash.Test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.abhilash.java.bean.VehicalType;

/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
public class VehicalService {

	static HashMap<Integer,VehicalType> vehicalIdMap=getvehicalIdMap();


	public VehicalService() {
		super();

		if(vehicalIdMap==null)
		{
			vehicalIdMap=new HashMap<Integer,VehicalType>();
		
			VehicalType indiavehical = new VehicalType(1,"bike1","bike2","bike3");
			VehicalType americanvehical = new VehicalType(2,"bike1","bike4","bike5");
			
			
			

			vehicalIdMap.put(1,indiavehical);
			vehicalIdMap.put(2,americanvehical);
			
		}
	}

	public List<VehicalType> getAllCountriesVehical()
	{
		List<VehicalType> vehicalsType = new ArrayList<VehicalType>(vehicalIdMap.values());
		return vehicalsType;
	}

	public VehicalType getCountryVehicalById(int id)
	{
		VehicalType vehicalsType= vehicalIdMap.get(id);
		return vehicalsType;
	}
	public VehicalType addVehicalType(VehicalType vehicalType)
	{
		vehicalType.setId(vehicalIdMap.size()+1);
		vehicalIdMap.put(vehicalType.getId(), vehicalType);
		return vehicalType;
	}
	
	public VehicalType updateVehialtype(VehicalType vt)
	{
		if(vt.getId()<=0)
			return null;
		vehicalIdMap.put(vt.getId(), vt);
		return vt;

	}
	public void deleteCountry(int id)
	{
		vehicalIdMap.remove(id);
	}

	public static HashMap<Integer, VehicalType> getvehicalIdMap() {
		return vehicalIdMap;
	}


}
