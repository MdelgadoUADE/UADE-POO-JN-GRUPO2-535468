package org.example.project.constants;

import org.example.project.models.others.Difficulty;

public class DifficultyConstants {

    public static final Difficulty DIFICULTAD_CADETE = new Difficulty(
            10,
            10,
            5,
            50,
            "Cadete"
    );

    public static final Difficulty DIFICULTAD_GUERRERO  = new Difficulty(
            15,
            20,
            8,
            40,
            "Guerrero"
    );

    public static final Difficulty DIFICULTAD_MAESTRO  = new Difficulty(
            20,
            30,
            10,
            30,
            "Maestro"
    );

}
