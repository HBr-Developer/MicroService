package ma.emsi.facture_service.Models;

import lombok.Data;

@Data
public class Produit {

    private Long id;

    private String nom;

    private Double prix;
}
