package lund.backend.service;

import lund.backend.model.KindOfRequest;
import lund.backend.model.Request;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RequestServiceTest {
    
    @Autowired
    private RequestService service;
    
    @Ignore
    @Test
    public void testCheckValidityOnValidInput() {
        Request request = new Request();
        request.setId(Long.MIN_VALUE);
        request.setKind(new KindOfRequest("Complaint"));
        request.setName("John Doe");
        request.setPolicyNumber("abc123");
        request.setRequestText("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nullam at arcu a est sollicitudin euismod. Suspendisse sagittis ultrices augue.");

        assertTrue(service.checkValidityOfRequest(request));
    }
    
    @Ignore
    @Test
    public void testCheckValidityOnNullInput() {
        assertFalse(service.checkValidityOfRequest(null));
    }
    
    @Test
    public void testCheckValidityOnInvalidName() {
        
    }
    
    @Test
    public void testCheckValidityOnInvalidPolicyNumber() {
        
    }
    
    @Test
    public void testCheckValidityOnInvalidRequestText() {
        
    }
    
    @Test
    public void testSaveRequestValidRequest() {
        
    }
    
    @Test
    public void testSaveRequestInvalidRequest() {
        
    }
}
