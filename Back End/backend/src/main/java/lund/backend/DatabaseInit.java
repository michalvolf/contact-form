package lund.backend;

import lund.backend.model.KindOfRequest;
import lund.backend.repository.KindOfRequestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private KindOfRequestRepository repository;
    
    @Override
    public void run(String... args) throws Exception {
        KindOfRequest kind1 = new KindOfRequest("Contract Adjustment");
        KindOfRequest kind2 = new KindOfRequest("Damage Case");
        KindOfRequest kind3 = new KindOfRequest("Complaint");
        
        repository.save(kind1);
        repository.save(kind2);
        repository.save(kind3);
    }
    
}
