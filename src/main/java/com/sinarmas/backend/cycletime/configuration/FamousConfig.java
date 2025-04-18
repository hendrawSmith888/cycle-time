package com.sinarmas.backend.cycletime.configuration;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: hendraw
 * Description:
 * @Date: 09/04/25
 */

@ConfigurationProperties(prefix = "famous")
@Configuration
public class FamousConfig {
	private String host;
	private String xApiKey;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getxApiKey() {
		return xApiKey;
	}

	public void setxApiKey(String xApiKey) {
		this.xApiKey = xApiKey;
	}
}
