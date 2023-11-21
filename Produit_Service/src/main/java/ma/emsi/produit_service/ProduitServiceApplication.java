package ma.emsi.produit_service;

import ma.emsi.produit_service.Entite.Produit;
import ma.emsi.produit_service.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProduitServiceApplication implements CommandLineRunner{

    @Autowired
    ProduitRepository produitRepository;


    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }


    public void run(String... args) throws Exception{
        produitRepository.save(new Produit(null, "banane", 12.90));
        produitRepository.save(new Produit(null, "banane", 12.90));
        produitRepository.save(new Produit(null, "banane", 12.90));
        produitRepository.save(new Produit(null, "banane", 12.90));
        produitRepository.save(new Produit(null, "banane", 12.90));
    }
}
