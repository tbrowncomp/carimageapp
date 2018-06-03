package com.carapp.CarAppApi;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Document> GetCars()
	{
		db = client.getDatabase("carimageapp");	
		
		MongoCollection<Document> collection = db.getCollection("images");
		
		List<Document> cars = (List<Document>) collection.find().into(new ArrayList<Document>());
		
		client.close();
		
		return cars;
	}
}
