//package com.vibecart.gateway.controller;
//
//import com.vibecart.gateway.model.AuthRequest;
//import com.vibecart.gateway.model.Response;
//import com.vibecart.gateway.service.APIGatewayService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.Instant;
//
//@RestController
//@RequestMapping("/api/v1/vibe-cart/offers")
//public class APIGatewayController {
//    private AuthenticationManager authenticationManager;
//    private APIGatewayService apiGatewayService;
//
//    public APIGatewayController(AuthenticationManager authenticationManager, APIGatewayService apiGatewayService) {
//        this.authenticationManager = authenticationManager;
//        this.apiGatewayService = apiGatewayService;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<Response> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//        if (authentication.isAuthenticated()) {
//            Response response = new Response(apiGatewayService.generateToken(authRequest.getUsername()), HttpStatus.ACCEPTED.getReasonPhrase(), Instant.now());
//            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
//        } else {
//            throw new UsernameNotFoundException("Invalid user request !");
//        }
//
//    }
//
//
//}
