package tile;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import main.GamePanel;

public class TileManager {
    private GamePanel gP;
    private int maxTiles = 10;
    Tile[] arregloTiles;

    public TileManager(GamePanel gP){
        this.gP = gP;
        this.arregloTiles = new Tile[maxTiles];
        getImagenesTile();
    }

    void getImagenesTile(){
        try{
            arregloTiles[0] = new Tile();
            arregloTiles[0].setImage(ImageIO.read(getClass().getResourceAsStream("/tiles/agua.png")));
            arregloTiles[1] = new Tile();
            arregloTiles[1].setImage(ImageIO.read(getClass().getResourceAsStream("/tiles/arbol.png")));
            arregloTiles[2] = new Tile();
            arregloTiles[2].setImage(ImageIO.read(getClass().getResourceAsStream("/tiles/arena.png")));
            arregloTiles[3] = new Tile();
            arregloTiles[3].setImage(ImageIO.read(getClass().getResourceAsStream("/tiles/muro.png")));
            arregloTiles[4] = new Tile();
            arregloTiles[4].setImage(ImageIO.read(getClass().getResourceAsStream("/tiles/pasto.png")));
            arregloTiles[5] = new Tile();
            arregloTiles[5].setImage(ImageIO.read(getClass().getResourceAsStream("/tiles/suelo.png")));
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2){
//        g2.drawImage(arregloTiles[0].getImage(), gP.getTileSize() * 0, 0, gP.getTileSize(), gP.getTileSize(), null);
//        g2.drawImage(arregloTiles[1].getImage(), gP.getTileSize() * 1, 0, gP.getTileSize(), gP.getTileSize(), null);
//        g2.drawImage(arregloTiles[2].getImage(), gP.getTileSize() * 2, 0, gP.getTileSize(), gP.getTileSize(), null);
//        g2.drawImage(arregloTiles[3].getImage(), gP.getTileSize() * 3, 0, gP.getTileSize(), gP.getTileSize(), null);
//        g2.drawImage(arregloTiles[4].getImage(), gP.getTileSize() * 4, 0, gP.getTileSize(), gP.getTileSize(), null);
//        g2.drawImage(arregloTiles[5].getImage(), gP.getTileSize() * 5, 0, gP.getTileSize(), gP.getTileSize(), null);
        for(int i = 0; i <= gP.getMaxCols(); i++){
            for(int j = 0; j <= gP.getMaxRows(); j++){
                g2.drawImage(arregloTiles[4].getImage(), gP.getTileSize() * i, gP.getTileSize() * j, gP.getTileSize(), gP.getTileSize(), null);
            }
        }
    }
}