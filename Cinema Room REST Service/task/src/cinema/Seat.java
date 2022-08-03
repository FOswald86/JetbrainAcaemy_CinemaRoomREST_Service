package cinema;

public class Seat {
    private Integer row;
    private Integer column;
    private Integer price;

    public Seat( Integer row, Integer column, Integer price ) {
        this.row = row;
        this.column = column;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice( int price ) {
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public void setRow( int row ) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn( int column ) {
        this.column = column;
    }
}