package it.core.facilitator.boot.service;

import org.springframework.core.io.ByteArrayResource;

public interface IBootService {

	ByteArrayResource getImageFromText(String content);

}
