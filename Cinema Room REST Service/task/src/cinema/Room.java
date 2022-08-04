package cinema;

import java.util.ArrayList;

public class Room {

    private int total_rows;
    private int total_columns;
    private ArrayList<Seats> available_seats = new ArrayList<>();

    public Room( int total_rows, int total_columns ) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        initAllSeats( total_rows, total_columns );
    }

    private void initAllSeats( int total_rows, int total_columns ) {
        for ( int i = 1; i <= total_rows; i++ ) {
            for ( int j = 1; j <= total_columns; j++ ) {
                Seats seat = new Seats( i, j );
                available_seats.add( seat );
            }
        }
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows( int total_rows ) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns( int total_columns ) {
        this.total_columns = total_columns;
    }

    public ArrayList<Seats> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats( ArrayList<Seats> available_seats ) {
        this.available_seats = available_seats;
    }
}