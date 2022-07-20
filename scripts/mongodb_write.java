import com.mongodb.*

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import org.bson.types.ObjectId;
import com.mongodb.MongoClientSettings;
import java.lang.Math;
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

 for(int i=0;i<510;++i){
    Document newDoc = new Document()
                        .append("_id", new ObjectId())
                        .append("rand",Math.random())
                        .append("first_name", "Test frist name")
                        .append("last_name","Test last name")
                        .append("skills", Arrays.asList("java", "dart","js","react","IoT","Robotics","MongoDB"));
    collection.insertOne(newDoc);
 }
 
 return "Inserted 10 sample documents ";
}
catch (Exception e) {
 SampleResult.setSuccessful(false);
 SampleResult.setResponseCode("500");
 SampleResult.setResponseMessage("Exception: " + e);
}