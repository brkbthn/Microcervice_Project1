package com.brkbthn.service;

import com.brkbthn.dto.request.DoLoginRequestDto;
import com.brkbthn.dto.request.DoRegisterRequestDto;
import com.brkbthn.dto.response.DoRegisterResponseDto;
import com.brkbthn.model.Auth;
import com.brkbthn.repository.IAuthRepository;
import com.brkbthn.utils.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, Long> {

  // @Autowired
    private final IAuthRepository repository;

    public AuthService(IAuthRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Auth doRegister1(DoRegisterRequestDto dto) {

        System.out.println("DoRegisterRequestDto: " +  dto);

        // TODO  Exception
        //if (repository.existsByUsername(dto.getUsername()))
        //    throw new Exception()

        Auth auth = new Auth();
        auth.setUsername(dto.getUsername());

        // TODO password rePassword
        auth.setPassword(dto.getPassword());
        auth.setEmail(dto.getEmail());
        auth.setCreateAt(System.currentTimeMillis());
        auth.setState(true);

        save(auth);
        System.out.println("auth: " +  auth);

        return auth;
    }


    public DoRegisterResponseDto doRegister(DoRegisterRequestDto dto) {

        System.out.println("DoRegisterRequestDto: " +  dto);

        // TODO  Exception
        //if (repository.existsByUsername(dto.getUsername()))
        //    throw new Exception()



        Auth auth = new Auth();
        auth.setUsername(dto.getUsername());

        // TODO password rePassword
        auth.setPassword(dto.getPassword());
        auth.setEmail(dto.getEmail());
        auth.setCreateAt(System.currentTimeMillis());
        auth.setState(true);

        save(auth); // KAYIT

        System.out.println("auth: " +  auth);


        DoRegisterResponseDto responseDto = new DoRegisterResponseDto();
        responseDto.setUsername(dto.getUsername());
        responseDto.setEmail(dto.getEmail());
        return responseDto;
    }


    public String doLogin1(DoLoginRequestDto dto) {

        Optional<Auth> auth = repository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());

      //  if (auth.isEmpty())
            // TODO execption


        return auth.get().getId().toString();
    }


    public Auth doLogin(DoLoginRequestDto dto) {

        Optional<Auth> auth = repository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());

        //  if (auth.isEmpty())
        // TODO execption


        return auth.get();
    }


}
