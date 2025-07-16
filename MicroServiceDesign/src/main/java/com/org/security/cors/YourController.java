package com.org.security.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://your-frontend-domain.com")
@RestController
public class YourController {
	// your endpoints
}
