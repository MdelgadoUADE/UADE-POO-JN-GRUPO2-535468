package org.example.project.constants;

import org.example.project.models.others.Difficulty;

public class DifficultyConstants {

    public static final Difficulty DIFICULTAD_CADETE = new Difficulty(
            1,
            1000,
            5,
            "Cadete"
    );

    public static final Difficulty DIFICULTAD_GUERRERO  = new Difficulty(
            2,
            800,
            4,
            "Guerrero"
    );

    public static final Difficulty DIFICULTAD_MAESTRO  = new Difficulty(
            3,
            600,
            3,
            "Maestro"
    );

}
