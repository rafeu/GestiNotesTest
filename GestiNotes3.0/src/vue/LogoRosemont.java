package vue;

// Codage de la TEXTURE des formes du LOGO du cégep
// Packages de noyau Java.
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

// Packages d'extension Java.
import javax.swing.*;

/**
 * 23/10/2016
 *
 * @author raphael
 */
public class LogoRosemont extends JFrame {

    BufferedImage imageTampon3 = new BufferedImage(250, 500, BufferedImage.TYPE_INT_RGB);

    static public BufferedImage logo = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);

    BufferedImage imageTampon2 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB), imageTampon = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
    // Définir la chaîne de la barre de titre et ses dimensions.

    public LogoRosemont()
   {
//      super( "Tracé de formes bidimensionnelles" );
//      setSize( 425, 160 );
      setVisible( true );
      getContentPane().setBackground(Color.white);
   }

    // Dessiner des formes avec l'API Java2D.
    public void paint(Graphics g) {
        // Créer la 2D par le remplacement du type de g en Graphics2D.
        //Graphics2D g2d = (Graphics2D)g;
        Graphics2D g2d = logo.createGraphics();

        Graphics2D g2dLogo = imageTampon3.createGraphics();

        g2dLogo.setColor(Color.red);
        g2dLogo.fill(new Rectangle2D.Double(0, 0, 250, 500));
        g2dLogo.setColor(Color.white);
        int i = 0;
        g2dLogo.translate(-20, -140);
        for (i = 0; i < 27; i++) {
            
            GeneralPath poly1 = new GeneralPath();
            
            poly1.moveTo(50, 200);
            poly1.lineTo(150, 100);
            poly1.lineTo(250, 200);
            poly1.lineTo(240, 200);
            poly1.lineTo(150, 110);
            poly1.lineTo(60, 200);
            poly1.closePath();
            g2dLogo.fill(poly1);

            g2dLogo.translate(0, 20);

        }

        createImageTampon(imageTampon, false);

        // public BufferedImage(int width,int height,int imageType)
        createImageTampon(imageTampon2, true);
        
        //g2d.translate(20, 20);
        
        // Peindre imageTampon sur le JFrame, en tant que  rectangles de 5x10 pixels
        g2d.setColor(Color.WHITE);
        g2d.fill(new Rectangle2D.Double(0, 0, 100, 100));
        g2d.setPaint(new TexturePaint(imageTampon3, new Rectangle(100, 100)));   // Rectangle(width, height)

        g2d.fill(new Ellipse2D.Double(20, 0, 60, 60));  // affichage du cercle contenant la texture : Ellipse2D.Double( x,  y,  width,  height)
        drawTriangleRect(g2d, 50, 50, 30, 50);
        g2d.setPaint(new TexturePaint(imageTampon3, new Rectangle(100, 100)));   // Rectangle(width, height)
        g2d.fill(new Rectangle2D.Double(20, 0, 30, 100));  // affichage du rectangle contenant la texture : Rectangle2D.Double( x,  y,  width,  height)
        setVisible(false);
    }

    protected void createImageTampon(BufferedImage image, boolean reverse) {
        Graphics2D gg = image.createGraphics();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int var = i;
                if (reverse) {
                    var = 99 - i;
                }

                if (j % 4 != var % 4) {
                    createPixel(gg, i, j, Color.RED);
                } else {
                    createPixel(gg, i, j, Color.white);
                }

            }
        }
    }

    protected void createPixel(Graphics2D gg, int i, int j, Color couleur) {
        gg.setColor(Color.red);
        gg.fillRect(i, j, 1, 1); // long rectangle rouge: fillRect(int x, int y, int width, int height)
    }

    protected void drawTriangleRect(Graphics2D g2d, int x, int y, int longueur, int hauteur) {
        // Tracer un polygone
        GeneralPath poly = new GeneralPath();
        poly.moveTo(x, y);           // coordonnees point depart du polygone
        poly.lineTo(x + longueur, y + hauteur);		// coordonnees 1er sommet du polygone
        poly.lineTo(x, y + hauteur);        // coordonnees 2eme sommet du polygone
        poly.closePath();		// polygone se ferme (retour au point depart)
        g2d.fill(poly);			// dessiner polygone plein
    }

   /* // Pour tester l'application.
   public static void main( String args[] )
   {
      LogoRosemont application = new LogoRosemont();
      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
   }*/
    
}


/*  DESSIN DE LA TEXTURE:
 public TexturePaint(BufferedImage txtr, Rectangle2D anchor)
 Constructs a TexturePaint object.
 Parameters:txtr - the BufferedImage object with the texture used for paintinganchor - the Rectangle2D in user space used to anchor and replicate the texture
 */
