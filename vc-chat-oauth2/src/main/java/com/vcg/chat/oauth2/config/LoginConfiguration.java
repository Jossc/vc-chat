package com.vcg.chat.oauth2.config;

import com.vcg.chat.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import javax.sql.DataSource;

/**
 * Created by wuyu on 2016/8/29.
 */
@Configuration
public class LoginConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
//                .authorizeRequests()
//                .antMatchers("/admin/**")
//                .hasRole("ADMIN")
//                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                //开启记住我, 默认 两个星期!
                .rememberMe()
                //由于采用的是http basic 验证 ,故 无法接收 _spring_security_remember_me 参数
                .alwaysRemember(true)
                .and()
                .csrf()
                .disable();


        //启用请求头携带用户名密码登录
        http.httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/user/company","/user/findNicknameAndAvatarAndIdById/**", "/css/**", "/style/**", "/images/**", "/js/**", "/favicon.ico", "/webjars/**", "/user/company", "/index.html", "/login", "/login.html", "/me");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(new Md5PasswordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public UserDetailsService userDetailsService(@Autowired DataSource dataSource) {
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource);
        return jdbcDao;
    }
}
