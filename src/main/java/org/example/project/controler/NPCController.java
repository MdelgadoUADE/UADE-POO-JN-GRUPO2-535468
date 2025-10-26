package org.example.project.controler;

import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.objects.Proyectile;


import java.util.List;

public class NPCController {

    private static NPCController instancia;
    private AreaDeJuego area;
    private List<Proyectile> proyectilesJugador;
    private List<Proyectile> proyectilesEnemigos;


    private NPCController(){
        area = new AreaDeJuego(400, 400);
    }

    public static NPCController getInstancia(){
        if (instancia == null) instancia = new NPCController();
        return instancia;
    }



}
