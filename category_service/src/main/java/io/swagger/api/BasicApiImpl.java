package io.swagger.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class BasicApiImpl implements BasicApi{

	@Override
	public ResponseEntity<Void> status() {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
