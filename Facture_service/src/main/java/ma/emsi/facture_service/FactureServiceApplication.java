package ma.emsi.facture_service;

import ma.emsi.facture_service.Entite.Facture;
import ma.emsi.facture_service.Entite.ProduitArticle;
import ma.emsi.facture_service.Models.Client;
import ma.emsi.facture_service.Models.Produit;
import ma.emsi.facture_service.Repository.FactureRepo;
import ma.emsi.facture_service.Repository.ProduitArticlRepo;
import ma.emsi.facture_service.service.ClientRestClient;
import ma.emsi.facture_service.service.ProduitRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.PagedModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication

@EnableFeignClients
public class FactureServiceApplication implements CommandLineRunner {


    ClientRestClient clientRestClient;

    ProduitRestClient produitRestClient;

    FactureRepo factureRepo;

    ProduitArticlRepo produitArticlRepo;

    public FactureServiceApplication(ClientRestClient clientRestClient,
                                     ProduitRestClient produitRestClient,
                                     FactureRepo factureRepo,
                                     ProduitArticlRepo produitArticlRepo){
        this.clientRestClient = clientRestClient;
        this.produitRestClient = produitRestClient;
        this.factureRepo = factureRepo;
        this.produitArticlRepo = produitArticlRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(FactureServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Client client = clientRestClient.getClientById(1L);
        Facture f = factureRepo.save(new Facture(null,
                new Date(), null,
                client.getId(), client));

        PagedModel<Produit> listeProduitsDB = produitRestClient.pageProduit(0, 3);
        listeProduitsDB.forEach(p -> {
            ProduitArticle produitArticle = new ProduitArticle();
            produitArticle.setReference(p.getId());
            produitArticle.setProduit(p);
            produitArticle.setQuantite(1 + new Random().nextInt(10));
            produitArticle.setFacture(f);
            produitArticle.setPrix(produitArticle.getQuantite() * p.getPrix());

            produitArticlRepo.save(produitArticle);
        });

    }
}
