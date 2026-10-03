package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Data transfer Object para respuesta de la API LLM
 * */

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseDto(String response) {
}
