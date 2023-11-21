package ma.emsi.facture_service.service;


import ma.emsi.facture_service.Models.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name= "CLIENT-SERVICE")
public interface ClientRestClient {

    @GetMapping(path="/clients/{id}")
    Client getClientById(@PathVariable Long id);


    @GetMapping(path="/clients")
    List<Client> getClients();

}
