package com.sinarmas.backend.cycletime.external;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinarmas.backend.cycletime.configuration.FamousConfig;
import com.sinarmas.backend.cycletime.constant.BeanConstant;
import com.sinarmas.backend.cycletime.model.FamousDataRequest;
import com.sinarmas.backend.cycletime.model.FamousDataResponse;
import com.sinarmas.backend.cycletime.model.RitaseData;
import com.sinarmas.backend.cycletime.repository.RitaseDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: hendraw
 * Description:
 * @Date: 09/04/25
 */

@Service
public class FamousExternal {

	@Autowired
	@Qualifier(BeanConstant.FAMOUS_BEAN)
	private RestTemplate restTemplateExternal;

	@Autowired
	private FamousConfig famousConfig;

	@Autowired
	private RitaseDataRepository ritaseDataRepository;

	public FamousDataResponse fetchData(FamousDataRequest req) throws JsonProcessingException {
		FamousDataResponse resp = new FamousDataResponse();

		Map<String, Object> body = new HashMap<>();
		body.put("hull_code", req.getHullCode());
		body.put("start_date", req.getStartDate());
		body.put("end_date", req.getEndDate());

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(body);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.ALL));
		headers.set("x-api-key", famousConfig.getxApiKey());

		HttpEntity<String> requestData = new HttpEntity<>(json, headers);


		String urlBuilder = famousConfig.getHost() + "api/v2/integration/getRitaseTime";
		resp = restTemplateExternal.exchange(
			urlBuilder,
			HttpMethod.POST,
			requestData,
			FamousDataResponse.class
		).getBody();
		if (resp.getData() != null) {
			List<RitaseData> entities = resp.getData().stream()
				.map(this::mapToEntity)
				.collect(Collectors.toList());

			ritaseDataRepository.saveAll(entities);
		}
		return resp;
	}

	private RitaseData mapToEntity(FamousDataResponse.RitaseData data) {
		RitaseData entity = new RitaseData();
		entity.setHullCode(data.getHullCode());
		entity.setRomGeofence(data.getRomGeofence());
		entity.setPortGeofence(data.getPortGeofence());
		entity.setDeviceId(data.getDeviceId());
		entity.setTaskDate(data.getTaskDate());
		entity.setRitase(data.getRitase());
		entity.setShift(data.getShift());
		entity.setRomEnterTime(data.getRomEnterTime());
		entity.setRomExitTime(data.getRomExitTime());
		entity.setWimCreated(data.getWimCreated());
		entity.setHaulingEnterTime(data.getHaulingEnterTime());
		entity.setHaulingExitTime(data.getHaulingExitTime());
		entity.setPortEnterTime(data.getPortEnterTime());
		entity.setPortExitTime(data.getPortExitTime());
		entity.setNoSk(data.getNoSk());
		entity.setPayloadTon(data.getPayloadTon());
		return entity;
	}

}
