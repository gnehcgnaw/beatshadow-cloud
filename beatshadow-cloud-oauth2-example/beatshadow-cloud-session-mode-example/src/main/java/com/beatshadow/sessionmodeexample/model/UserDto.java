package com.beatshadow.sessionmodeexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/15 14:13
 */
@Data
@AllArgsConstructor
public class UserDto {
    /**
     *   实现会话
     */
    public static final String SESSION_USER_KEY="_user" ;
    private String username ;
    private String password ;
    private String fullName ;
    /**
     * 授权
     */
    private Set<String> authorities ;


    public UserDto(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }
}
