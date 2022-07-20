import com.mongodb.*

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.Arrays;

try {
 String mongoUrl = "mongodb://192.168.11.91:27017,192.168.11.92:27017,192.168.11.93:27017/?replicaSet=myreplica01";
 MongoClient mongoClient = MongoClients.create(mongoUrl);
 
 MongoDatabase database = mongoClient.getDatabase("jmeter_test");
 MongoCollection<Document> collection = database.getCollection("blazemeter_tutorial");

 List<Document> cursor = collection.find().iterator().toArray();
  
 return "Connected to Got documents from collection";
}
catch (Exception e) {
 SampleResult.setSuccessful(false);
 SampleResult.setResponseCode("500");
 SampleResult.setResponseMessage("Exception: " + e);
}