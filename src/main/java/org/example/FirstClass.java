package org.example;

import javax.swing.*;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class FirstClass extends JFrame {
    private int[][] maze = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,1,1,1,1,1,0,0,0,0,0,1},
            {1,0,0,1,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,}
    };
    public List<Integer> path = new ArrayList<>();
    public FirstClass(){
        setTitle("Maze solver");
        setSize(640,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DFS.searchPath(maze,1,1,path);
        System.out.println(path);
    }
    @Override
    public void paint(Graphics g){
        g.translate(50,50);
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                Color color;
                switch(maze[i][j]){
                    case 1:
                        color = Color.black;
                        break;
                    case 9:
                        color = Color.red;
                        break;
                    default:
                        color = Color.white;
                        break;
                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.red);
                g.drawRect(30*j,30*i,30,30);
            }
        }
        for(int i=0; i<path.size(); i+=2){
            int pathx = path.get(i);
            int pathy = path.get(i+1);
            System.out.println("X Co=ordinates " + pathx);
            System.out.println("Y Co=ordinates " + pathy);
            g.setColor(Color.green);
            g.fillRect(30*pathx,30*pathy,25,25);
        }
    }
}
