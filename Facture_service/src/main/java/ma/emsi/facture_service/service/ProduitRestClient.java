package ma.emsi.facture_service.service;

import ma.emsi.facture_service.Models.Client;
import ma.emsi.facture_service.Models.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name= "PRODUIT-SERVICE")
public interface ProduitRestClient {

    @GetMapping(path="/produits/{id}")
    Produit getProduitById(@PathVariable Long id);


    @GetMapping(path="/produits")
    PagedModel<Produit> pageProduit(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "taille") int taille);

}
