package pe.edu.vallegrande.AS221S4_T01_be.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "DOCUMENT_TYPE")
public class DocumentType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_document")
    private String nameDocument;

    @Column(name = "descriptions")
    private String description;

}
