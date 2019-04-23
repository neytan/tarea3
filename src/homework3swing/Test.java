package homework3swing;

import java.awt.*;

public class Test 
{

    private Display myDisplayer;  //JFrame
    private Oval myOval;
    private Rectangle myRectangle;


    //constructor
    public Test(Display myDisplayer_)
    {
        this.setMyDisplayer(myDisplayer_);
        this.setMyOval(new Oval());
        this.setMyRectangle(new Rectangle());

        //valores de las figuras
        myOval.setHeight(70);
        myOval.setWidth(50);
        myRectangle.setHeight(50);
        myRectangle.setWidth(50);
    }

    
    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException 
    {
        //ciclo infinito
        while (true)
        {
            this.moveShapes();
            this.createImages();

            //pone en espera el flujo del programa
            Thread.sleep(waitingTime);
        }
    }//end method


    //cambio los valores de las variables de las figuras que tengo
    public void moveShapes() {
        int x = (int) (Math.random() * (myDisplayer.getWidth() - 100)+1);
        int y = (int) (Math.random() * (myDisplayer.getHeight() -100)+1);
        getMyOval().setRow(y);
        getMyOval().setColumn(x);

        x = (int) (Math.random() * (myDisplayer.getWidth()-10)+1);
        y = (int) (Math.random() * (myDisplayer.getWidth()-10)+1);
        getMyRectangle().setRow(y);
        getMyRectangle().setColumn(x);
    }

    //coloca nuevos valores aleatorios en las figuras
    public void createImages()
    {
        myDisplayer.initializeImage();
        Graphics graphic = myDisplayer.getGraphicsImage();

        graphic.setColor(Color.green);
        graphic.fillOval(getMyOval().getColumn(), getMyOval().getRow(),
                getMyOval().getWidth(),getMyOval().getHeight());

        graphic.setColor(Color.BLACK);
        graphic.fillRect(getMyRectangle().getColumn(),getMyRectangle().getRow(),
                getMyRectangle().getWidth(),getMyRectangle().getHeight());

        myDisplayer.paintAgain();
    }


    public Oval getMyOval() {
        return myOval;
    }

    public void setMyOval(Oval myOval) {
        this.myOval = myOval;
    }

    public Display getMyDisplayer() {
        return myDisplayer;
    }

    public void setMyDisplayer(Display myDisplayer) {
        this.myDisplayer = myDisplayer;
    }

    public homework3swing.Rectangle getMyRectangle() {
        return myRectangle;
    }

    public void setMyRectangle(homework3swing.Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }
    

}
