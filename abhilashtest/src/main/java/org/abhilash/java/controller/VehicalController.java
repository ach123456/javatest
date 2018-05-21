package org.abhilash.java.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.abhilash.Test.service.VehicalService;
import org.abhilash.java.bean.VehicalType;


@Path("/vehical")
public class VehicalController {
	
	VehicalService vehicalService=new VehicalService();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<VehicalType> getCountries()
	{
		
		List<VehicalType> listOfCountriesVehical=vehicalService.getAllCountriesVehical();
		return listOfCountriesVehical;
	}

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public VehicalType getCountryVehicalById(@PathParam("id") int id)
	{
		return vehicalService.getCountryVehicalById(id);
	}
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	public VehicalType addVehicalType(VehicalType vt)
	{
		return vehicalService.addVehicalType(vt);
	}

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
	public VehicalType updateVehialtype(VehicalType vt)
	{
		return vehicalService.updateVehialtype(vt);
		
	}
	
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public void deleteCountry(@PathParam("id") int id)
	{
    	vehicalService.deleteCountry(id);
		
	}
	
}
