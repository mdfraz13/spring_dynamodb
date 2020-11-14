package com.example.demo.core;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import java.util.Arrays;

public class DynamoDBTableCreationClient {

	public static void main(String[] args) {
		AmazonDynamoDBClient amazonDynamoDBClient = new AmazonDynamoDBClient()
			.withEndpoint("http://localhost:8000");

		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDBClient);

		final var tableName = "firstDynamoDBTable";
		try {
			System.out.println("Creating the table, wait...");
			Table table = dynamoDB.createTable (tableName,
				Arrays.asList (
					new KeySchemaElement("ID", KeyType.HASH), // the partition key
					// the sort key
					new KeySchemaElement("Nomenclature", KeyType.RANGE)
				),
				Arrays.asList (
					new AttributeDefinition("ID", ScalarAttributeType.N),
					new AttributeDefinition("Nomenclature", ScalarAttributeType.S)
				),
				new ProvisionedThroughput(10L, 10L)
			);
			table.waitForActive();
			System.out.println("Table created successfully.  Status: " +
							   table.getDescription().getTableStatus());

		} catch (Exception e) {
			System.err.println("Cannot create the table: ");
			System.err.println(e.getMessage());
		}

	}
}
