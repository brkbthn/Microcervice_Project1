package com.brkbthn.controller;

import com.brkbthn.constant.EndPoint;
import com.brkbthn.dto.request.DoLoginRequestDto;
import com.brkbthn.dto.request.DoRegisterRequestDto;
import com.brkbthn.dto.response.DoRegisterResponseDto;
import com.brkbthn.model.Auth;
import com.brkbthn.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//    http://localhost:9090
@RestController
@RequestMapping
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

  //  @PostMapping(EndPoint.REGISTER)
  /* public ResponseEntity<Auth> doRegister1(@RequestBody DoRegisterRequestDto dto){
        System.out.println("DTO: " +  dto);
        return ResponseEntity.ok(authService.doRegister(dto));
   }
   */


    @PostMapping(EndPoint.REGISTER)
    public ResponseEntity<DoRegisterResponseDto> doRegister(@RequestBody DoRegisterRequestDto dto){
        System.out.println("DTO: " +  dto);
        return ResponseEntity.ok(authService.doRegister(dto));
    }


    @PostMapping(EndPoint.LOGIN)
    public ResponseEntity<Auth> doLogin(@RequestBody DoLoginRequestDto dto){
        System.out.println("DTO: " +  dto);
        return ResponseEntity.ok(authService.doLogin(dto));
    }

    public ResponseEntity<  List <Auth>  > findAll()   {
        return ResponseEntity.ok(authService.findAll());
    }


    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok("AuthServis mesaji");
    }

}
