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

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
    	MongoAdapter adapter = new MongoAdapter();
    	
    	MongoCollection<Document> collection = adapter.DoStuff();
    	List<Document> cars = (List<Document>) collection.find().into(new ArrayList<Document>());
    	//long carCount = collection.count();
    	adapter.CloseClient();
        //return "Count: "+carCount;
//    	CarBit car = new CarBit();
//    	car.Caption = "jimbob";
//    	car.Location = "somePlace";
    	return Response.ok().entity(cars).header("Access-Control-Allow-Origin", "*").build();
    }
    
    
    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Document> getIt() {
//    	MongoAdapter adapter = new MongoAdapter();
//    	
//    	MongoCollection<Document> collection = adapter.DoStuff();
//    	List<Document> cars = (List<Document>) collection.find().into(new ArrayList<Document>());
//    	//long carCount = collection.count();
//    	adapter.CloseClient();
//        //return "Count: "+carCount;
////    	CarBit car = new CarBit();
////    	car.Caption = "jimbob";
////    	car.Location = "somePlace";
//    	return cars;
//    }
    
    
}


