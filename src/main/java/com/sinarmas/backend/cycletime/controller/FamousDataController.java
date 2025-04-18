package com.sinarmas.backend.cycletime.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinarmas.backend.cycletime.external.FamousExternal;
import com.sinarmas.backend.cycletime.model.FamousDataRequest;
import com.sinarmas.backend.cycletime.model.FamousDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hendraw
 * Description:
 * @Date: 09/04/25
 */

@RestController
@RequestMapping("/famous")
public class FamousDataController {

	@Autowired
	private FamousExternal famousService;

	@PostMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
	public FamousDataResponse getRitase(FamousDataRequest req) throws JsonProcessingException {
		return famousService.fetchData(req);
	}
}
