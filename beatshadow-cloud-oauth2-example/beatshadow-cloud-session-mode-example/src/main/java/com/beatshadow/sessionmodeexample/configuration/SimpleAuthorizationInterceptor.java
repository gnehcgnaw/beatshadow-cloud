package com.beatshadow.sessionmodeexample.configuration;

import com.beatshadow.sessionmodeexample.model.UserDto;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/15 15:17
 */
public class SimpleAuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object object = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if (object==null){
            writerContext(response ,"please login");
        }
        UserDto userDto = (UserDto)object;
        if (userDto.getAuthorities().contains("p1")&& request.getRequestURL().equals("r1")) {
            return true ;
        }
        if (userDto.getAuthorities().contains("p2")&& request.getRequestURL().equals("r2")){
            return true ;
        }
        writerContext(response,"permission denied");
        return false ;
    }

    private void writerContext(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/plain; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(msg);
        printWriter.close();
        response.resetBuffer();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
