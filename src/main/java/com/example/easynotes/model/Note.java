package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotBlank;

@Entity    // It is used to mark the class as a persistent Java class.
@Table(name = "notes")     // provides the details of the table that this entity will be mapped to.
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)    //is a Jackson annotation. Spring Boot uses Jackson for Serializing and Deserializing Java objects to and from JSON
// This annotation is used because we don’t want the clients of the rest api to supply the createdAt and updatedAt values.

@Getter
@Setter
public class Note implements Serializable {
    @Id   // defines the primary key
    @GeneratedValue()    // primary key generation strategy (auto increment)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @Column(nullable = false, updatable = false)   // defines the properties of the column that will be mapped
    @Temporal(TemporalType.TIMESTAMP)    // It converts the date and time values from Java Object to compatible database type
    @CreatedDate
    private Date createAt;

    @Column(nullable = false)   // defines the properties of the column that will be mapped
    @Temporal(TemporalType.TIMESTAMP)    // It converts the date and time values from Java Object to compatible database type
    @LastModifiedDate
    private Date updatedAt;



}
