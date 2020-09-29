package cn.org.nf404.slide.web.controller;

import cn.org.nf404.slide.api.facade.UserFacade;
import cn.org.nf404.slide.api.response.user.UserMetaData;
import cn.org.nf404.slide.common.utils.FacadeInvoker;
import cn.org.nf404.slide.web.bean.converter.DtoConverter;
import cn.org.nf404.slide.web.bean.dto.user.UserLoginRequestDTO;
import cn.org.nf404.slide.web.bean.dto.user.UserRegisterRequestDTO;
import cn.org.nf404.slide.web.component.login.UserLoginComponent;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dx DingXing
 * @date 2020-09-28
 */
@RestController
@AllArgsConstructor
public class UserRestEndpoint {
    private UserLoginComponent loginComponent;
    private UserFacade userFacade;
    private DtoConverter dtoConverter;

    @PostMapping("/api/user/login")
    public UserMetaData login(HttpServletRequest request, @RequestBody UserLoginRequestDTO dto) {
        return this.loginComponent.login(request, dto);
    }

    @PostMapping("/api/user/register")
    public void register(@RequestBody UserRegisterRequestDTO dto) {
        FacadeInvoker.invoke(userFacade::register, dtoConverter.toRequest(dto));
    }
}
