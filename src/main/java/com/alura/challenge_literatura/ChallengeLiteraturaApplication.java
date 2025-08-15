package com.alura.challenge_literatura;

import com.alura.challenge_literatura.main.MainLiteratura;
import com.alura.challenge_literatura.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeLiteraturaApplication implements CommandLineRunner{

    public static void main(String[] args) {SpringApplication.run(ChallengeLiteraturaApplication.class, args);}

    @Autowired
    private MenuService menuService;


    @Override
    public void run(String... args) throws Exception {
        MainLiteratura principal = new MainLiteratura(menuService);
        principal.EjecutarAplicacion();
    }
}
