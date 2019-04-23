
package homework3swing;

public class Oval {

    private int row;
    private int column;
    private int width;
    private int height;

    public Oval() {
        this.row = 0;
        this.column = 0;
        this.width = 0;
        this.height = 0;
    }

    public void setRow(int fila) {
        row = fila;
    }

    public void setColumn(int columna) {
        column = columna;
    }

    public void setWidth(int ancho) {
        width = ancho;
    }

    public void setHeight(int alto) {
        height = alto;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
