package com.beatshadow.sessionmodeexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/15 14:16
 */
@Data
@AllArgsConstructor
public class AuthorizationRequest {
    private String username ;
    private String password;
}
