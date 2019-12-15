package com.beatshadow.sessionmodeexample.service.impl;

import com.beatshadow.sessionmodeexample.model.AuthorizationRequest;
import com.beatshadow.sessionmodeexample.model.UserDto;
import com.beatshadow.sessionmodeexample.service.AuthorizationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/15 14:18
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private static Map<String,UserDto> userDtoMap = new HashMap<>();
    private static Set<String>  authorities1 = new HashSet<>();
    private static Set<String>  authorities2 = new HashSet<>();
    {
        userDtoMap.put("root",new UserDto("root","123456","张三"));
        userDtoMap.put("admin",new UserDto("admin","123456","李四"));
        authorities1.add("p1");
        authorities2.add("p2");
    }

    @Override
    public UserDto authorization(AuthorizationRequest authorizationRequest) {
        if (authorizationRequest == null|| StringUtils.isEmpty(authorizationRequest.getUsername())||StringUtils.isEmpty(authorizationRequest.getPassword())) {
            throw  new RuntimeException("username or password  is not null ");
        }
        UserDto userDto = getUserDto(authorizationRequest.getUsername());
        if (userDto==null){
            throw  new RuntimeException("user is not exist ");
        }
        if (!authorizationRequest.getPassword().equals(userDto.getPassword())){
            throw  new RuntimeException("password is error ");
        }
        //授权
        if (("root".equals(userDto.getUsername()) == true)) {
            userDto.setAuthorities(authorities1);
        } else {
            userDto.setAuthorities(authorities2);
        }
        return userDto;
    }



    private UserDto getUserDto(String username){
        return userDtoMap.get(username);
    }

}
