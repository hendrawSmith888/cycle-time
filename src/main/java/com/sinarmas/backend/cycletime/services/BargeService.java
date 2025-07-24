package com.sinarmas.backend.cycletime.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinarmas.backend.cycletime.model.BargeEntitiy;
import com.sinarmas.backend.cycletime.model.BargeRequestDTO;
import com.sinarmas.backend.cycletime.model.BargeResponseDTO;
import com.sinarmas.backend.cycletime.model.CrushingTonnageResponseDTO;
import com.sinarmas.backend.cycletime.repository.BargeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hendraw
 * Description:
 * @Date: 20/07/25
 */

@Service
public class BargeService {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private BargeRepository bargeRepository;

	private final String URL = "https://ccm.borneo-indobara.com/services/actual-port/v1/public/loading/barge-list?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYXRhIjoiY2NtLmJvcm5lby1pbmRvYmFyYS5jb20ifQ.zUCUD2JIOUAqVfr930HKrZ8FcHLUxqBD4huxFGqze70";

	public void fetchAndSaveBargeList(BargeRequestDTO request) throws JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Cookie", "cookiesession1=678A3EBEA40DB868865FA27A1E6F644C");

		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("startDate", request.getStartDate());
		requestBody.put("endDate", request.getEndDate());
		requestBody.put("portList", new ArrayList<>()); // Empty port list

		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(requestBody, headers);

		// Gunakan String dulu untuk debug dan parsing manual
		ResponseEntity<String> response = restTemplate.exchange(
			URL,
			HttpMethod.POST,
			httpEntity,
			String.class
		);

		if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
			String json = response.getBody();

			ObjectMapper mapper = new ObjectMapper();
			BargeResponseDTO[] dtoArray = mapper.readValue(json, BargeResponseDTO[].class);
			System.out.println("hasil nya = " + dtoArray);

			for (BargeResponseDTO dto : dtoArray) {
				BargeEntitiy entity = new BargeEntitiy();
				BeanUtils.copyProperties(dto, entity);
				bargeRepository.save(entity);
			}
		} else {
			throw new RuntimeException("Failed to fetch barge data: " + response.getStatusCode());
		}
	}
}
