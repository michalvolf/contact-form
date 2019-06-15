package lund.backend.service;

import java.util.Objects;
import lund.backend.model.Request;
import lund.backend.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestService {
    
    @Autowired
    private RequestRepository repository;
    
    @Transactional
    public boolean saveRequest(Request request) {
        if(checkValidityOfRequest(request)) {
            repository.save(request);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkValidityOfRequest(Request request) {
        if (Objects.isNull(request)) {
            return false;
        }
        if (!request.getName().matches("^[A-Za-z]+ [A-Za-z]+$")) {
            return false;
        }
        if (!request.getPolicyNumber().matches("^[A-Za-z0-9]+$")) {
            return false;
        }
        if (request.getRequestText().length() > 5000) {
            return false;
        }
        return true;
    }
}
