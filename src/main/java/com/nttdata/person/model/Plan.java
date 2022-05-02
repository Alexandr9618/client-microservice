package com.nttdata.person.model;

import java.util.Date;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "plans")
public class Plan {

    @Id
    private String id;

    @Field(name = "name", write = Field.Write.NON_NULL)
    private String name;

    @Field(name = "credit_quantity", write = Field.Write.NON_NULL)
    private String creditQuantity;

    @Field(name = "created_at", write = Field.Write.NON_NULL)
    private Date createdAt;

    @Field(name = "updated_at", write = Field.Write.NON_NULL)
    private Date updatedAt;

    public Plan(String name, String creditQuantity, Date createdAt, Date updatedAt) {
        this.name = name;
        this.creditQuantity = creditQuantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
