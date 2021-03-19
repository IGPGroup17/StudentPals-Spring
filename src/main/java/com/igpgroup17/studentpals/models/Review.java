package com.igpgroup17.studentpals.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;
import org.joda.time.DateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "reviews")
public class Review {

    @DynamoDBHashKey(attributeName = "review_id")
    @DynamoDBAutoGeneratedKey
    private String reviewId;

    @DynamoDBAttribute(attributeName = "eventId")
    private String eventId;

    @DynamoDBAttribute(attributeName = "rating")
    private int rating;

    @DynamoDBAttribute(attributeName = "description")
    private String description;

    @DynamoDBAttribute(attributeName = "creationDate")
    private String creationDate;

    @DynamoDBAttribute(attributeName = "lastModificationDate")
    private String lastModificationDate;

}
