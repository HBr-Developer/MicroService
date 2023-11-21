package ma.emsi.facture_service.Controller;

import ma.emsi.facture_service.Entite.Facture;
import ma.emsi.facture_service.Models.Produit;
import ma.emsi.facture_service.Repository.FactureRepo;
import ma.emsi.facture_service.Repository.ProduitArticlRepo;
import ma.emsi.facture_service.service.ClientRestClient;
import ma.emsi.facture_service.service.ProduitRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FactureRestController {

    FactureRepo factureRepo;

    ClientRestClient clientRestClient;

    ProduitRestClient produitRestClient;

    ProduitArticlRepo produitArticlRepo;

    public FactureRestController(FactureRepo factureRepo,
                                 ClientRestClient clientRestClient,
                                 ProduitRestClient produitRestClient,
                                 ProduitArticlRepo produitArticlRepo){
        this.factureRepo = factureRepo;
        this.clientRestClient = clientRestClient;
        this.produitRestClient = produitRestClient;
        this.produitArticlRepo = produitArticlRepo;
    }


    @GetMapping("/factures/{id}")
    public Facture getFacture(@PathVariable Long id){
        Facture facture = factureRepo.findById(id).get();
        facture.setClient(clientRestClient.getClientById(facture.getIdClient()));
        facture.getListeProduits().forEach(produitArticle -> {
            Produit p = produitRestClient.getProduitById(produitArticle.getReference());
            produitArticle.setProduit(p);
        });
        return facture;

    }

    @GetMapping("/factures")
    public List<Facture> getAll(){
        System.out.println("Liste factures");
        return factureRepo.findAll();
    }


}
