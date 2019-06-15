package lund.backend.repository;

import lund.backend.model.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Long> {
    
    Request save(Request request);
    
}
