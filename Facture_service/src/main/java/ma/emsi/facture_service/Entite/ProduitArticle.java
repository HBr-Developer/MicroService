package ma.emsi.facture_service.Entite;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.facture_service.Models.Client;
import ma.emsi.facture_service.Models.Produit;

import java.util.Collection;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProduitArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Long reference;

    private int quantite;

    private double prix;


    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Facture facture;

    @Transient
    private Produit produit;

}
