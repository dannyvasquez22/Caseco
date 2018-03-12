package com.admin.resource.java8;

import java.util.List;
import java.util.stream.Collectors;

/** * @author DANNY VASQUEZ RAFAEL */

public class Modulo4Streams {

    /**
     * Agrupacion de elementos sobre los que podemos especificar operaciones
     * Semejantes con las collections
     */
    
    private List<String> convertStreamVersion(List<Modulo3Persona_ForLambdaAndOptional> personas) {
        return personas.stream()
                .map(it -> it.getNombre())
                .collect(Collectors.toList());
    }
}
