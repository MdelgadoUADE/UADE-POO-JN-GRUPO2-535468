package org.example.project.constants;

import org.example.project.models.others.Difficulty;

public class DifficultyConstants {

    public static final Difficulty DIFICULTAD_CADETE = new Difficulty(
            2,
            1000,
            50,
            "Cadete"
    );

    public static final Difficulty DIFICULTAD_GUERRERO  = new Difficulty(
            3,
            800,
            40,
            "Guerrero"
    );

    public static final Difficulty DIFICULTAD_MAESTRO  = new Difficulty(
            4,
            600,
            30,
            "Maestro"
    );

}
