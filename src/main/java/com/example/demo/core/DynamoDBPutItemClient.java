package com.example.demo.core;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class DynamoDBPutItemClient {

	public static void main(String[] args) {
		AmazonDynamoDBClient amazonDynamoDBClient = new AmazonDynamoDBClient()
			.withEndpoint("http://localhost:8000");

		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDBClient);

		final var tableName = "firstDynamoDBTable";
		try {
			System.out.println("putting into the table, wait...");
			dynamoDB.getTable(tableName);

			//dynamoDB.

		} catch (Exception e) {
			System.err.println("Cannot create the table: ");
			System.err.println(e.getMessage());
		}

	}
}
