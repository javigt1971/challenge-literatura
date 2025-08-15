package com.alura.challenge_literatura.main;

import com.alura.challenge_literatura.service.MenuService;
import com.alura.challenge_literatura.user_interface.MenuPrincipal;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainLiteratura {

    private final MenuService menuService;

    @Autowired
    public MainLiteratura(MenuService menuService) {
        this.menuService = menuService;
    }


    public void EjecutarAplicacion() {
        MenuPrincipal menu = new MenuPrincipal();
        Scanner teclado = new Scanner(System.in);
        System.out.println(menu.getBienvenida());
        int opcion;
        do {
            try {
                System.out.print(menu.getMenu() + " ");
                opcion = teclado.nextInt();
                teclado.nextLine();
                switch (opcion) {
                    case 1:
                        menuService.guardarLibro();
                        break;
                    case 2:
                        menuService.listarLibrosRegistrados();
                        break;
                    case 3:
                        menuService.listarAutoresRegistrados();
                        break;
                    case 4:
                        menuService.listarAutoresVivosEnAnio();
                        break;
                    case 5:
                        menuService.listarLibrosPorIdioma();
                        break;
                    case 0:
                        System.out.println("Cerrando la Aplicacion...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese un número");
                opcion = -1;
                teclado.nextLine();
            }
        } while (opcion != 0);
        teclado.close();
    }
}

