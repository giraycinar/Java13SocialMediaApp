package com.giray.service;
import com.giray.dto.request.RegisterRequestDto;
import com.giray.entity.Auth;
import com.giray.repository.AuthRepository;
import com.giray.utility.enums.ERole;
import com.giray.utility.enums.EStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public boolean register(RegisterRequestDto dto){
        Auth auth = Auth.builder()
                .password(dto.getPassword())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .role(ERole.ADMIN)
                .createDate(System.currentTimeMillis())
                .updateDate(System.currentTimeMillis())
                .status(EStatus.PENDING)
                .build();
        authRepository.save(auth);

        return true;

    }
}
