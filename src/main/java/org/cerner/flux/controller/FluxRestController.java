package org.cerner.flux.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FluxRestController {

	@PostMapping("/")
	public Mono<Void> receiveFlux(@RequestBody Flux<String> textStream) {
		return textStream.doOnNext(System.out::println).then();
	}
}
