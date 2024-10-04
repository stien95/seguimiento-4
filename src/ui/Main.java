package ui;

import java.util.Scanner;

import model.ShelterController;

/**
 * Main
 */
public class Main {
    // Attributes
    Scanner scanner;
    ShelterController controller;
    /**
     * Name: Main
     * <br> Constructor method of Main, used to initialize the scanner
     */
    public Main() {
        scanner = new Scanner(System.in);
    }
    /**
     * Name: main
     * <br> Method used to run the program and interact with the user
     * <br> @param args
     */
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Bienvenido al sistema de refugio de animales");
        System.out.println("Por favor, ingrese el nombre del refugio");
        String name = main.scanner.nextLine();
        System.out.println("Ingrese la dirección del refugio");
        String address = main.scanner.nextLine();
        System.out.println("Ingrese la capacidad del refugio");
        int capacity = main.scanner.nextInt();
        System.out.println("Ingrese el presupuesto del refugio");
        double budget = main.scanner.nextDouble();
        main.scanner.nextLine();
        main.controller = new ShelterController(capacity, name, address, budget);
        int option = 0;
        while (option != 4) {
            main.showMenu();
            option = main.scanner.nextInt();
            main.scanner.nextLine();
            System.out.println("--------------------");
            switch (option) {
                case 1:
                    main.addAnimal();
                    break;
                case 2:
                    main.searchAnimal();
                    break;
                case 3:
                    main.getSpecieAmount();
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
    /**
     * Name: showMenu
     * <br> Method used to show the menu
     */
    public void showMenu() {
        System.out.println("--------------------");
        System.out.println("Menú de opciones");
        System.out.println("1. Añadir animal");
        System.out.println("2. Buscar animal");
        System.out.println("3. Obtener cantidad de animales de una especie");
        System.out.println("4. Salir");
        System.out.println("Por favor, seleccione una opción");
    }
    /**
     * Name: addAnimal
     * <br> Method used to add an animal
     */
    public void addAnimal() {
        System.out.println("Ingrese el id del animal");
        String id = scanner.nextLine();
        System.out.println("Ingrese el nombre del animal");
        String name = scanner.nextLine();
        System.out.println("Ingrese la especie del animal (perro, gato, pajaro, conejo, hamster, tortuga, pez, otro)");
        String specie = scanner.nextLine();
        System.out.println("¿Está esterilizado?");
        boolean isSterilized = scanner.nextLine().equalsIgnoreCase("si");
        System.out.println("¿Está vacunado?");
        boolean isVaccinated = scanner.nextLine().equalsIgnoreCase("si");
        String message = controller.addAnimal(id, name, specie, isSterilized, isVaccinated);
        System.out.println(message);
    }
    /**
     * Name: searchAnimal
     * <br> Method used to search an animal
     */
    public void searchAnimal() {
        System.out.println("1. Buscar por id");
        System.out.println("2. Buscar por nombre");
        System.out.println("3. Buscar por especie");
        System.out.println("4. Buscar por esterilización");
        System.out.println("5. Buscar por vacunación");
        System.out.println("Por favor, seleccione una opción");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                System.out.println("Ingrese el id del animal");
                String id = scanner.nextLine();
                System.out.println(controller.searchAnimalById(id));
                break;
            case 2:
                System.out.println("Ingrese el nombre del animal");
                String name = scanner.nextLine();
                System.out.println(controller.searchAnimalByName(name));
                break;
            case 3:
                System.out.println("Ingrese la especie del animal");
                String specie = scanner.nextLine();
                System.out.println(controller.searchAnimalsBySpecie(specie));
                break;
            case 4:
                System.out.println("¿Está esterilizado?");
                boolean isSterilized = scanner.nextLine().equalsIgnoreCase("si");
                System.out.println(controller.searchAnimalsBySterilization(isSterilized));
                break;
            case 5:
                System.out.println("¿Está vacunado?");
                boolean isVaccinated = scanner.nextLine().equalsIgnoreCase("si");
                System.out.println(controller.searchAnimalsByVaccination(isVaccinated));
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }
    /**
     * Name: getSpecieAmount
     * <br> Method used to get the amount of animals of a specie
     */
    public void getSpecieAmount() {
        System.out.println("Ingrese la especie del animal");
        String specie = scanner.nextLine();
        System.out.println(controller.getSpecieAmount(specie));
    }

}