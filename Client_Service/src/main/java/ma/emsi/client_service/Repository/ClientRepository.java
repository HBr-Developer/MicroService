package ma.emsi.client_service.Repository;

import ma.emsi.client_service.Entite.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
