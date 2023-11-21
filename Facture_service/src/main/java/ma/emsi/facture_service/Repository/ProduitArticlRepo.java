package ma.emsi.facture_service.Repository;

import ma.emsi.facture_service.Entite.ProduitArticle;
import ma.emsi.facture_service.Models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProduitArticlRepo extends JpaRepository<ProduitArticle, Integer> {
    //List<Produit> findByFactureId(Long id);
}
