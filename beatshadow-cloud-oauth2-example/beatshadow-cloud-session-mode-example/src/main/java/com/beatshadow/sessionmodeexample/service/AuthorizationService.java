package com.beatshadow.sessionmodeexample.service;

import com.beatshadow.sessionmodeexample.model.AuthorizationRequest;
import com.beatshadow.sessionmodeexample.model.UserDto;

/**
 * 实现认证
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/15 14:17
 */
public interface AuthorizationService {
    public UserDto authorization(AuthorizationRequest authorizationRequest);
}
