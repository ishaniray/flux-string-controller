package org.cerner.flux.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FluxRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FluxRestController.class);

	@PostMapping("/")
	public Mono<Void> receiveFlux(@RequestBody Flux<String> textStream) {
		return textStream.doOnNext(LOGGER::info).then();
	}
}
