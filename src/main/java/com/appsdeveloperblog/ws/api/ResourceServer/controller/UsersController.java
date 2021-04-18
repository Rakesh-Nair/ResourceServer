package com.appsdeveloperblog.ws.api.ResourceServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.ws.api.ResourceServer.response.UserRest;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private Environment env;

	@GetMapping("/status/check")
	public String getStatus() {
		return "Response returned from PORT " + env.getProperty("local.server.port");
	}

	// @Secured("ROLE_developer")
	@PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
	@DeleteMapping(path = "/{id}")
	public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return "Deleted User with Id " + id + " and Jwt Subject " + jwt.getSubject();
	}

	@PostAuthorize("returnObject.userId == #jwt.subject")
	@GetMapping(path = "/{id}")
	public UserRest getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return new UserRest("Rakesh", "Nair", "6e5099ca-8223-4ef0-bfce-0e820c35a259");
	}
}
