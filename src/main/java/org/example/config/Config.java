package org.example.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/***
 * Gestor de configuracion dpara la conexion con LLM
 * Cargar propiedades desde el archivo application.properties
 **/
public class Config {
    /** Almacende propiedades cargadas desde el archivo */
    private final Properties properties;

    /** Crear constructor que carga la configuracion desde apllication.properties */
    public Config(){
        properties = new Properties();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")){
            properties.load(input);
        }catch (IOException e){
            throw new RuntimeException("Error cargando configuracion", e);
        }
    }

    /**
     * Obtiene la URL del endpoint del LLM
     * */
    public String getUrl(){
        return properties.getProperty("ollama.url");
    }

    /** Otiene el modelo de IA a utilizar */
    public String getModel(){
        return properties.getProperty("ollama.model");
    }
}
