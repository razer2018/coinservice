package com.coindemo.common.role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Role {
	
	/**
	 * @Description:区分用户角色
	 *
	 */
	RoleType[] role() default RoleType.USER;
	
}
