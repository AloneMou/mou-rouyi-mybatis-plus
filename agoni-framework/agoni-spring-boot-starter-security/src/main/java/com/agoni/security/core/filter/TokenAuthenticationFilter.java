package com.agoni.security.core.filter;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.agoni.exception.ServiceException;
import com.agoni.pojo.CommonResult;
import com.agoni.security.config.SecurityProperties;
import com.agoni.security.core.LoginUser;
import com.agoni.security.core.util.SecurityUserUtils;
import com.agoni.util.servlet.ServletUtils;
import com.agoni.web.core.handler.GlobalExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Token 过滤器，验证 token 的有效性
 * 验证通过后，获得 {@link LoginUser} 信息，并加入到 Spring Security 上下文
 *
 * @author 芋道源码
 */
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final SecurityProperties securityProperties;

    private final GlobalExceptionHandler globalExceptionHandler;

//    private final OAuth2TokenApi oauth2TokenApi;

    @Override
    @SuppressWarnings("NullableProblems")
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String token = SecurityUserUtils.obtainAuthorization(request, securityProperties.getTokenHeader());
        if (StrUtil.isNotEmpty(token)) {
//            Integer userType = WebFrameworkUtils.getLoginUserType(request);
            try {
                // 1.1 基于 token 构建登录用户
                LoginUser loginUser = buildLoginUserByToken(token, 1);
//                // 1.2 模拟 Login 功能，方便日常开发调试
//                if (loginUser == null) {
//                    loginUser = mockLoginUser(request, token, userType);
//                }

                // 2. 设置当前用户
                if (loginUser != null) {
//                    SecurityFrameworkUtils.setLoginUser(loginUser, request);
                }
            } catch (Throwable ex) {
                CommonResult<?> result = globalExceptionHandler.allExceptionHandler(request, ex);
                ServletUtils.writeJSON(response, result);
                return;
            }
        }

        // 继续过滤链
        chain.doFilter(request, response);
    }

    private LoginUser buildLoginUserByToken(String token, Integer userType) {
        try {
//            OAuth2AccessTokenCheckRespDTO accessToken = oauth2TokenApi.checkAccessToken(token);
//            if (accessToken == null) {
//                return null;
//            }
//            // 用户类型不匹配，无权限
//            if (ObjectUtil.notEqual(accessToken.getUserType(), userType)) {
//                throw new AccessDeniedException("错误的用户类型");
//            }
//            // 构建登录用户
//            return new LoginUser().setId(accessToken.getUserId()).setUserType(accessToken.getUserType())
//                    .setTenantId(accessToken.getTenantId()).setScopes(accessToken.getScopes());
            return null;
        } catch (ServiceException serviceException) {
            // 校验 Token 不通过时，考虑到一些接口是无需登录的，所以直接返回 null 即可
            return null;
        }
    }


}
