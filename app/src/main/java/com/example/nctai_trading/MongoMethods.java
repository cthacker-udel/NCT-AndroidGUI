package com.example.nctai_trading;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;

import org.bson.BSONObject;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MongoMethods {

    public DBObject findDocumentById(String id, MongoCollection<Document> collection){

        ObjectId objId = new ObjectId("id");
        BasicDBObject obj = new BasicDBObject();
        obj.append("_id", objId);
        BasicDBObject query = new BasicDBObject();
        query.putAll((BSONObject)obj);
        return query;

    }


}
