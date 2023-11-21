package ma.emsi.client_service;

import ma.emsi.client_service.Entite.Client;
import ma.emsi.client_service.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientServiceApplication implements CommandLineRunner {

    @Autowired
    ClientRepository clientRepository;


    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        clientRepository.save(new Client(null, "hanane", "hanane@emsi.ma"));
        clientRepository.save(new Client(null, "hanane", "hanane@emsi.ma"));
        clientRepository.save(new Client(null, "hanane", "hanane@emsi.ma"));
        clientRepository.save(new Client(null, "hanane", "hanane@emsi.ma"));
        clientRepository.save(new Client(null, "hanane", "hanane@emsi.ma"));
    }

}
