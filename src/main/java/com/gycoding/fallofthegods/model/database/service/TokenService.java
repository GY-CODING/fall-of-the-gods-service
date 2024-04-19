package com.gycoding.fallofthegods.model.database.service;

import com.gycoding.fallofthegods.model.database.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TokenService {
    public TokenRepository tokenRepository;

    @Autowired
    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public Boolean checkToken(UUID token) {
        for(UUID singleToken : listTokens()) {
            if(token.equals(singleToken)) {
                return true;
            } else {
                continue;
            }
        }

        return false;
    }

    private List<UUID> listTokens() {
        return tokenRepository.findAllTokens().orElse(null);
    }
}
