
package homework3swing;

public class MainClass {

    static final int X_Frame = 10;
    static final int Y_Frame = 10;
    static final int ANCHO_frame = 400;
    static final int ALTO_frame = 400;
    static final int TIEMPO_ESPERA = 500;

    public static void main(String[] args) throws InterruptedException {
        Display myFrame = new Display(X_Frame, Y_Frame, ANCHO_frame, ALTO_frame);
        Test mytest = new Test(myFrame);

        myFrame.setVisible(true);
        mytest.startSimulation(TIEMPO_ESPERA);
    }
}
