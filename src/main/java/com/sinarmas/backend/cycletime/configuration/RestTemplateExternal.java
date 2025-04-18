package com.sinarmas.backend.cycletime.configuration;

import com.sinarmas.backend.cycletime.constant.BeanConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: hendraw
 * Description:
 * @Date: 09/04/25
 */

@Configuration
public class RestTemplateExternal {

	@Autowired
	private FamousConfig famousConfig;

	@Bean(BeanConstant.FAMOUS_BEAN)
	public RestTemplate famousRestTemplate() {
		return new RestTemplateBuilder()
			.rootUri(famousConfig.getHost())
			.build();
	}
}
