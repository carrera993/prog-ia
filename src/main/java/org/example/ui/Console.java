package org.example.ui;

import org.example.agents.IAgent;
import org.example.agents.desarrollo.GeneratorCodeAgent;
import org.example.agents.texto.TranslatorTextAgent;
import org.example.client.LlmClient;
import org.example.factory.AgentFactory;

import java.util.Scanner;

public class Console {

    private Scanner scanner = new Scanner(System.in);
    private String prompt;
    private int option = 0;

    public Console() {
    }

    public void menu() throws Exception {
        while (option != 3) {
            System.out.println("\nSeleccione una opcion:");
            System.out.println("1. Generador de codigo");
            System.out.println("2. Traductor al espanol");
            System.out.println("3. Salir");

            try {
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character from the buffer
                } else {
                    System.out.println("Error: Debe ingresar un numero valido.");
                    scanner.next(); // Consume invalid token
                    continue;
                }

                switch (option) {
                    case 1: {
                        System.out.println("Ingrese las especificaciones de codigo que desea generar:");
                        prompt = scanner.nextLine();
                        IAgent agent = AgentFactory.create(option);
                        System.out.println("\nResultado:\n" + agent.execute(prompt));
                        break;
                    }

                    case 2: {
                        System.out.println("Ingrese el texto a traducir:");
                        prompt = scanner.nextLine();
                        IAgent agent = AgentFactory.create(option);
                        System.out.println("\nResultado:\n" + agent.execute(prompt));
                        break; // Added missing break
                    }

                    case 3: {
                        System.out.println("Saliendo...");
                        break;
                    }

                    default:
                        System.out.println("Opcion invalida, intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
        }

        // Close the scanner only when the program loop ends completely
        scanner.close();
    }
}