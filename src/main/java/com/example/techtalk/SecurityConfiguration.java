//package com.example.techtalk;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.ldap.core.support.BaseLdapPathContextSource;
//import org.springframework.ldap.core.support.LdapContextSource;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.httpBasic().disable();
//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.NEVER);
//
//		/*http.csrf().disable().authorizeRequests().anyRequest().authenticated()
//		.and().exceptionHandling().authenticationEntryPoint(new AjaxAwareAuthenticationEntryPoint("/login"));
//		http.formLogin().failureUrl("/login?error").defaultSuccessUrl("/").loginPage("/login").permitAll().and()
//				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
//				.permitAll();
//		http.exceptionHandling().accessDeniedPage("/login");*/
//    }
//
//    // @Autowired
//    // public void configureGlobal(AuthenticationManagerBuilder auth) throws
//    // Exception {
//    // auth.ldapAuthentication().userDnPatterns("uid={0},ou=people").groupSearchBase("ou=groups").contextSource()
//    // .ldif("classpath:test-server.ldif");
//    // }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.ldapAuthentication().userSearchFilter("(&(objectClass=user)(sAMAccountName={0}))")
//                .contextSource(ldapContextSource());
//    }
//
//    @Bean
//    public BaseLdapPathContextSource ldapContextSource() {
//        LdapContextSource bean = new LdapContextSource();
//        String[] urls = new String[2];
//        urls[0] = "ldap://ma1c-dc01.1aauto.inc:3268";
//        urls[1] = "ldap://ma1c-dc02.1aauto.inc:3268";
//        bean.setUrls(urls);
//        bean.setBase("DC=1AAUTO,DC=INC");
//        bean.setUserDn("bindldap@1aauto.inc");
//        bean.setPassword("4GxnMTGcPFuLWQsv");
//        bean.setPooled(true);
//        bean.setReferral("follow");
//        return bean;
//    }
//    //
//    // @Configuration
//    // protected static class AuthenticationConfiguration extends
//    // GlobalAuthenticationConfigurerAdapter {
//    //
//    // @Override
//    // public void init(AuthenticationManagerBuilder auth) throws Exception {
//    // DefaultSpringSecurityContextSource contextSource = new
//    // DefaultSpringSecurityContextSource("ldap://ma1c-dc01.1aauto.inc");
//    // contextSource.setUserDn("bindldap@1aauto.inc");
//    // contextSource.setBase("");
//    // contextSource.setPassword("4GxnMTGcPFuLWQsv");
//    // contextSource.setReferral("follow");
//    // contextSource.afterPropertiesSet();
//    //
//    // LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder>
//    // ldapAuthenticationProviderConfigurer = auth.ldapAuthentication();
//    //
//    // ldapAuthenticationProviderConfigurer
//    // .userSearchFilter("(&(objectClass=user)(sAMAccountName={0}))")
//    // .userSearchBase("DC=1AAUTO,DC=INC")
//    // .groupSearchBase("CN=(.*),OU=")
//    // .contextSource(contextSource);
//    // }
//    // }
//
//}
