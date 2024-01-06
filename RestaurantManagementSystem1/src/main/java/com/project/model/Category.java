package com.project.model;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

    private long id;
	
    private String name;
    
    private String description;
    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] img;
    @OneToMany(mappedBy="category", cascade = CascadeType.ALL)
    private List<Product> Product;
}

