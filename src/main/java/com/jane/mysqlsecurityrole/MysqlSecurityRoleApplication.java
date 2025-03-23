package com.jane.mysqlsecurityrole;

import com.jane.mysqlsecurityrole.auth.AuthenticationService;
import com.jane.mysqlsecurityrole.auth.RegistrationRequest;
import com.jane.mysqlsecurityrole.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableJpaAuditing
public class MysqlSecurityRoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlSecurityRoleApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthenticationService service) {
        return args -> {
            var admin = RegistrationRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@admin.com")
                    .password("password")
                    .role(Role.ADMIN)
                    .build();
            System.out.println("Admin accesstoken: " + service.register(admin).getAccessToken());


            var manager = RegistrationRequest.builder()
                    .firstname("Manager")
                    .lastname("Manager")
                    .email("manager@admin.com")
                    .password("password")
                    .role(Role.MANAGER)
                    .build();
            System.out.println("Manager accesstoken: " + service.register(manager).getAccessToken());
        };
    }

}
