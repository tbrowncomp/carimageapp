package com.carapp.CarAppApi;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
    	MongoAdapter adapter = new MongoAdapter();    	
    	MongoCollection<Document> collection = adapter.GetCars();
    	List<Document> cars = (List<Document>) collection.find().into(new ArrayList<Document>());
    	adapter.CloseClient();
    	return Response.ok().entity(cars).header("Access-Control-Allow-Origin", "*").build();
    }   
}


