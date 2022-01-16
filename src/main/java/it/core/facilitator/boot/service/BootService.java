package it.core.facilitator.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BootService implements IBootService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${api.url}")
	private String url;

	@Override
	public ByteArrayResource getImageFromText(String content) {
		ResponseEntity<byte[]> response = restTemplate.getForEntity(url.concat(content), byte[].class);
		return new ByteArrayResource(response.getBody());
	}

}
