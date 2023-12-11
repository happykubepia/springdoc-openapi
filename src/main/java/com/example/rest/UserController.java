package com.example.rest;

/*
 * Presentation Layer: UserController
 */

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.HelloVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/*
 * springdoc-openapi
 * https://springdoc.org/#migrating-from-springfox
 */

@Tag(name="Springboot sample API", description="Spring boot sample API 입니다.")
@RestController
@RequiredArgsConstructor
public class UserController {
	private String msgTemplate = "%s 님 반갑습니다.";
	private final AtomicLong vistorCounter = new AtomicLong();
	
	@Operation(summary="Hello API", description="Hello API 입니다.")
	@Parameters({
		@Parameter(name="name", in=ParameterIn.QUERY, description="", required=true, allowEmptyValue=true) 
	})
	
	@GetMapping("/hello")
	public HelloVO getHelloMsg(@RequestParam(value = "name") String name) {
		return new HelloVO(vistorCounter.incrementAndGet(), String.format(msgTemplate, name));
	}
	
}