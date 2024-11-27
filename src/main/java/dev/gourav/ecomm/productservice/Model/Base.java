package dev.gourav.ecomm.productservice.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
public class Base {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date updatedAt;
    private Date createdAt;
    private Boolean isDeleted;
}
