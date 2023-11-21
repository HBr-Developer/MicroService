package ma.emsi.produit_service.Repository;

import ma.emsi.produit_service.Entite.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
