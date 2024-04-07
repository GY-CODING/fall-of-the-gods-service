package com.gycoding.fallofthegods.model.database;

import com.gycoding.fallofthegods.model.entities.accounts.GYToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenService {
    public TokenRepository tokenRepository;

    @Autowired
    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public Boolean checkToken(GYToken token) {
        for(GYToken gyToken : listTokens()) {
            if(token.equals(gyToken)) {
                return true;
            } else {
                continue;
            }
        }

        return false;
    }

    private List<GYToken> listTokens() {
        return tokenRepository.findAllTokens().orElse(null);
    }
}
