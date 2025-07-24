package com.sinarmas.backend.cycletime.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinarmas.backend.cycletime.model.BargeRequestDTO;
import com.sinarmas.backend.cycletime.model.CrushingRequestDTO;
import com.sinarmas.backend.cycletime.services.BargeService;
import com.sinarmas.backend.cycletime.services.CrushingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hendraw
 * Description:
 * @Date: 19/07/25
 */

@RestController
@RequestMapping("/ccm")
public class CrushingPlantCtr {

	@Autowired
	private CrushingService crushingService;

	@Autowired
	private BargeService bargeService;

	@PostMapping("/crushing/fetch")
	public ResponseEntity<String> fetchAndSave(@RequestBody CrushingRequestDTO request) throws JsonProcessingException {
		String result = crushingService.getTonnageProductivity(request);
		return ResponseEntity.ok(result);
	}

	@PostMapping("/barge/fetch")
	public ResponseEntity<String> fetchBargeData(@RequestBody BargeRequestDTO request) throws JsonProcessingException {
		bargeService.fetchAndSaveBargeList(request);
		return ResponseEntity.ok("Data successfully fetched and saved.");
	}
}
