package com.sinarmas.backend.cycletime.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinarmas.backend.cycletime.model.CrushingRequestDTO;
import com.sinarmas.backend.cycletime.model.CrushingTonase;
import com.sinarmas.backend.cycletime.model.CrushingTonnageResponseDTO;
import com.sinarmas.backend.cycletime.repository.CrushingTonaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hendraw
 * Description:
 * @Date: 19/07/25
 */

@Service
public class CrushingService {
	private final RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private CrushingTonaseRepository crushingTonaseRepository;

	public String getTonnageProductivity(CrushingRequestDTO request) throws JsonProcessingException {
		String url = "https://ccm.borneo-indobara.com/services/actual-port/v1/public/crushing/tonnages-productivity?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYXRhIjoiY2NtLmJvcm5lby1pbmRvYmFyYS5jb20ifQ.zUCUD2JIOUAqVfr930HKrZ8FcHLUxqBD4huxFGqze70";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Cookie", "cookiesession1=678A3E22F70C23101196D49C2BAA9AA8");

		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("crushingPlantList", List.of(
			"CP 1", "CP 2", "CP 2A", "CP 2B", "CP 3", "CP 4", "CP 5",
			"CP 6", "CP 7", "CP 8", "CP 9", "CP 10"
		));
		requestBody.put("startDate", request.getStartDate());
		requestBody.put("endDate", request.getEndDate());
		requestBody.put("shift", "All");

		HttpEntity<Map<String, Object>> requests = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> response = restTemplate.exchange(
			url,
			HttpMethod.POST,
			requests,
			String.class
		);

		String fixedJson = response.getBody().replace("\"NaN\"", "null");
		ObjectMapper mapper = new ObjectMapper();
		CrushingTonnageResponseDTO[] dtoArray = mapper.readValue(fixedJson, CrushingTonnageResponseDTO[].class);
		System.out.println("response nya => " + dtoArray);
		if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
			for (CrushingTonnageResponseDTO dto : dtoArray) {
				CrushingTonase entity = new CrushingTonase();
				BeanUtils.copyProperties(dto, entity);
				crushingTonaseRepository.save(entity);
			}
			return "Data successfully saved.";
		} else {
			throw new RuntimeException("Failed to fetch data. Status: " + response.getStatusCode());
		}
	}
}
