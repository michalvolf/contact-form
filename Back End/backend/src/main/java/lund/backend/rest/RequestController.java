package lund.backend.rest;

import java.util.Objects;
import lund.backend.dto.RequestDTO;
import lund.backend.model.KindOfRequest;
import lund.backend.model.Request;
import lund.backend.service.KindOfRequestService;
import lund.backend.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/request")
public class RequestController {
    
    @Autowired
    private RequestService requestService;
    private KindOfRequestService kindService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendRequest(@RequestBody RequestDTO requestDto) {
        Request request = new Request();
        KindOfRequest kind = kindService.getKindOfRequest(requestDto.kindOfRequest);
        if (Objects.isNull(kind)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        request.setKind(kind);
        request.setName(requestDto.firstName + " " + requestDto.lastName);
        request.setPolicyNumber(requestDto.policyNumber);
        request.setRequestText(requestDto.requestText);
        boolean result = requestService.saveRequest(request);
        if(result) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    @ResponseBody
    public String testMessage() {
        return "Connection successful";
    }
}
