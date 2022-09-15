package com.agoni.security.core.service;

import lombok.AllArgsConstructor;


/**
 * 默认的 {@link PermissionService} 实现类
 *
 * @author 芋道源码
 */
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {

//    private final PermissionApi permissionApi;

    @Override
    public boolean hasPermission(String permission) {
        return hasAnyPermissions(permission);
    }

    @Override
    public boolean hasAnyPermissions(String... permissions) {
//        return permissionApi.hasAnyPermissions(getLoginUserId(), permissions);
        return false;
    }

    @Override
    public boolean hasRole(String role) {
//        return hasAnyRoles(role);
        return false;
    }

    @Override
    public boolean hasAnyRoles(String... roles) {
//        return permissionApi.hasAnyRoles(getLoginUserId(), roles);
        return false;
    }

    @Override
    public boolean hasScope(String scope) {
        return hasAnyScopes(scope);
    }

    @Override
    public boolean hasAnyScopes(String... scope) {
        return false;
//        LoginUser user = SecurityFrameworkUtils.getLoginUser();
//        if (user == null) {
//            return false;
//        }
//        return CollUtil.containsAny(user.getScopes(), Arrays.asList(scope));
    }

}
