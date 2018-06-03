package com.carapp.CarAppApi;

import org.bson.Document;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoAdapter {
	private MongoClient client;
	private MongoDatabase db;
	
	public MongoAdapter()
	{
		client = new MongoClient("localhost", 27017);
						
	}
	
	public MongoCollection<Document> GetCars()
	{
		db = client.getDatabase("carimageapp");	
		
		MongoCollection<Document> collection = db.getCollection("images");
		
		return collection;
	}
	
	public void CloseClient()
	{
		client.close();
		
	}

}
