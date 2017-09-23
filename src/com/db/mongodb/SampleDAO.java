/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.mongodb;

import com.mongodb.client.MongoCollection;

/**
 *
 * @author admin1
 */
public class SampleDAO {
    
    private static MongoCollection sampleCollection = null; 
    private static final String  CollectionStr = "Sample";
    private static DBConnection DBConn;

    public SampleDAO() {
        SampleDAO.DBConn.dbConnection();
        SampleDAO.setSampleCollection();
    }
    
    public static MongoCollection getSampleCollection() {
        return sampleCollection;
    }

    public static void setSampleCollection() {
        if(null != DBConn.getDb())
        {
             sampleCollection = DBConn.getDb().getCollection(CollectionStr);
        }
        else
        {
            System.out.println("DB connection is not availbale ");
            System.out.println("reconnecting...");
            SampleDAO.DBConn.dbConnection();
        }
    }
    
}
