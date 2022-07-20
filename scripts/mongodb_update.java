import com.mongodb.*

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import org.bson.types.ObjectId;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;

try {
 String mongoUrl = "mongodb://192.168.11.91:27017,192.168.11.92:27017,192.168.11.93:27017/?replicaSet=myreplica01";
 MongoClient mongoClient = MongoClients.create(mongoUrl);
 
 MongoDatabase database = mongoClient.getDatabase("jmeter_test");
 MongoCollection<Document> collection = database.getCollection("blazemeter_tutorial");

 Document query = new Document().append("age",  37);
 Bson updates = Updates.combine(
        Updates.set("age", 99),
     );
 UpdateOptions options = new UpdateOptions().upsert(true);

 collection.updateOne(query,updates,options);
 
 return "Updated a document";
}
catch (Exception e) {
 SampleResult.setSuccessful(false);
 SampleResult.setResponseCode("500");
 SampleResult.setResponseMessage("Exception: " + e);
}