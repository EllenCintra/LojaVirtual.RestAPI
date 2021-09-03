package com.github.ericomonteiro.smartstock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Photo {

    @Id
    @EqualsAndHashCode.Include
    private final UUID id = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(nullable = false)
    private Product product;

    private Boolean main;
    private String fileType;

    @Lob
    private byte[] data;
}
