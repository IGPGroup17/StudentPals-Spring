package com.igpgroup17.studentpals.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "report-table")
public class Reports {

    @DynamoDBHashKey(attributeName = "reportId")
    @DynamoDBAutoGeneratedKey
    private String reportId;

    @DynamoDBAttribute(attributeName = "username")
    private String username;

    @DynamoDBAttribute(attributeName = "event")
    private String event;

    @DynamoDBAttribute(attributeName = "reportHead")
    private String reportHead;

    @DynamoDBAttribute(attributeName = "reportBody")
    private String reportBody;

    @DynamoDBAttribute(attributeName = "reportRating")
    private String reportRating;



}
