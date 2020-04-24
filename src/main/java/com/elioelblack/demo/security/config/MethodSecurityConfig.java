/**
 * 
 */
package com.elioelblack.demo.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * @author eliezer
 *
 */
@Configuration
@EnableGlobalMethodSecurity(
		prePostEnabled=true
)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration{

}
