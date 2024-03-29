package com.isatimur.questom;

import com.isatimur.questom.model.AbstractEntityId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
public class QuestOnMapBackendApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(QuestOnMapBackendApplication.class);


    @Autowired
    AccountRepository usersRepository;
    @Autowired
    BoxRepository boxesRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(QuestOnMapBackendApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE box IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE box(id SERIAL, username VARCHAR(255), title VARCHAR(255),body VARCHAR(255),boxtype VARCHAR(255))");

        Arrays.asList("adam1,adam2,adam3,adam4,adam5".split(",")).forEach((u) -> {
            int i = 0;
            usersRepository.save(new Account(u + "@gmail.com", u, "password", "/mock-data/images" + (++i) + ".jpg"));
            boxesRepository.save(new Box(u,"Title","Body","fgdfg"));
        });

        //(usersRepository.findAll()).forEach(u -> System.out.println(u.toString()));
//        (boxesRepository.findAll()).forEach(b -> System.out.println(b.toString()));

    }
}


@Entity
class Account extends AbstractEntityId {

    public Account(){}
    private String login;

    private String username;

    private String password;

    private String avatar;

    public String getLogin() {
        return login;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAvatar() {
        return avatar;
    }

    public Account(String login, String username, String password, String avatar) {
        this.login = login;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
    }
}

@Entity
class Box extends AbstractEntityId {

    public Box(){}
    private String username;

    private String title;

    private String body;

    private String boxtype;

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getBoxType() {
        return boxtype;
    }

    public Box(String username, String title, String body, String boxtype) {
        this.username = username;
        this.title = title;
        this.body = body;
        this.boxtype = boxtype;
    }
}

interface AccountRepository extends JpaRepository<Account, Long> {
    public Collection<Account> findAllUsersByLogin(String title);
}

interface BoxRepository extends JpaRepository<Box, Long> {
    public Collection<Box> findAllBoxesByUsername(String username);
}

@RestController
class UserController {

    @Autowired
    AccountRepository usersRepository;

    @RequestMapping("/users")
    public ResponseEntity findUsers(){
        return ResponseEntity.ok().body(usersRepository.findAll());
    }
}
@RestController
class BoxController {

    @Autowired
    BoxRepository boxRepository;

    @RequestMapping("/boxes")
    public ResponseEntity findUsers(){
        return ResponseEntity.ok().body(boxRepository.findAll());
    }
}



