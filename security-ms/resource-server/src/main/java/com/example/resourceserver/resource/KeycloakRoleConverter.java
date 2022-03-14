package com.example.resourceserver.resource;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    //custom converter to make sure the roles are being passed to spring the way I want it
	@Override
	public Collection<GrantedAuthority> convert(Jwt jwt) {
        //first we look for the key realm access
        Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");

        if (realmAccess == null || realmAccess.isEmpty()) {
            return new ArrayList<>();
        }

        //Then we look for key roles
        Collection<GrantedAuthority> returnValue = ((List<String>) realmAccess.get("roles"))
                //change to role_rolename with grant authority
                .stream().map(roleName -> "ROLE_" + roleName)  
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
 
        return returnValue;
	}

}