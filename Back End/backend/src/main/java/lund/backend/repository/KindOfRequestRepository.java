package lund.backend.repository;

import java.util.List;
import lund.backend.model.KindOfRequest;
import org.springframework.data.repository.CrudRepository;

public interface KindOfRequestRepository extends CrudRepository<KindOfRequest, String> {
    
    List<KindOfRequest> findAll();
    
    KindOfRequest save(KindOfRequest kind);

}
