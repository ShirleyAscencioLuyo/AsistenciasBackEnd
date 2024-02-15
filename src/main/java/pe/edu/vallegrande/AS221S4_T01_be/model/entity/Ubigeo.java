package pe.edu.vallegrande.AS221S4_T01_be.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "UBIGEO")
public class Ubigeo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ubigeo_code")
    private String ubigeoCode;

    @Column(name = "department")
    private String department;

    @Column(name = "province")
    private String province;

    @Column(name = "district")
    private String district;

    // Constructor que acepta un valor numérico para el campo `id`- Flutter
    public Ubigeo(Long id) {
        this.id = id;
    }

}
