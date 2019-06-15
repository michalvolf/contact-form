package lund.backend.service;

import java.util.List;
import java.util.Optional;
import lund.backend.model.KindOfRequest;
import lund.backend.repository.KindOfRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KindOfRequestService {
    
    @Autowired
    private KindOfRequestRepository repository;
    
    @Transactional
    public List<KindOfRequest> getAllKinds() {
        List<KindOfRequest> kinds = repository.findAll();
        return kinds;
    }
    
    @Transactional
    public KindOfRequest getKindOfRequest(String name) {
        Optional<KindOfRequest> kind = repository.findById(name);
        if (kind.isPresent()) {
            return kind.get();
        } else {
            return null;
        }
    }
}
