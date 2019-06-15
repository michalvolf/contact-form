package lund.backend.rest;

import java.util.List;
import lund.backend.model.KindOfRequest;
import lund.backend.service.KindOfRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/kindofrequest")
public class KindOfRequestController {
    
    @Autowired
    private KindOfRequestService kindService;
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<KindOfRequest>> getKinds() {
        List<KindOfRequest> kinds = kindService.getAllKinds();
        if(kinds.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(kinds, HttpStatus.OK);
        }
    }
    
}
