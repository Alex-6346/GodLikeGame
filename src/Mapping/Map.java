package Mapping;

import Objects.Block;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Map {

    private String path;
    private int width,height;

    private Block[][] blocks;

    public Map(String loadpath){
        path=loadpath;

        blocks = new Block[height][width];

       loadMap();


    }


    public void draw(Graphics g){
        for(int i=0;i<blocks.length;i++){
            for(int j=0;j<blocks[0].length;j++){
                blocks[i][j].draw(g);
            }
        }
    }

    public void loadMap(){
        InputStream is = this.getClass().getResourceAsStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        try {
            width = Integer.parseInt(br.readLine()); //перша стрічка файлу - широта сітки
            height = Integer.parseInt(br.readLine()); // друга стрічка файлу - довгота сітки

            blocks = new Block[height][width];



            for (int i = 0; i < height; i++) {
                String line = br.readLine(); //читаємо першу лінію зверху
                String[] tokens = line.split("\\s+"); //розбиваємо цю лінію за токенами (токен - до пробілу)
                for(int j = 0; j < width; j++){

                    blocks[i][j] = new Block(j*Block.BLOCK_SIZE, i*Block.BLOCK_SIZE, Integer.parseInt(tokens[j]));
                }
            }



        }
        catch(NumberFormatException | IOException e){
            e.printStackTrace();
        }

        }

    public Block[][] getBlocks(){
        return blocks;
    }




}
