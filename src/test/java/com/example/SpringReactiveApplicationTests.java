package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class SpringReactiveApplicationTests {

	@Test
	public void monoTest(){
		Mono<String> mono= Mono.just("abc");
		mono.then(Mono.error(new RuntimeException("exception occured"))).log()
				.subscribe(System.out::println,e->e.getMessage());
	}

	@Test
	public void fluxTest(){
		Flux<String> flux = Flux.just("cde","fgi","www");
		flux.concatWith(Flux.error(new RuntimeException("Exception occured"))).log()
				.subscribe();
	}

}
