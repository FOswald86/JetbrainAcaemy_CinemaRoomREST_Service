package cinema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

public class Room {

    private int total_rows;
    private int total_columns;
    private ArrayList<Seat> available_seats = new ArrayList<>();

    @JsonIgnoreProperties(value = {"price_SWITCH", "higher_PRICE", "lower_PRICE"})
    private final int PRICE_SWITCH = 4, LOWER_PRICE = 8, HIGHER_PRICE = 10;

    public Room( int total_rows, int total_columns ) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        initAllSeats();
    }

    private void initAllSeats() {
        for ( int i = 1; i <= this.total_rows; i++ ) {
            for ( int j = 1; j <= this.total_columns; j++ ) {
                available_seats.add( new Seat( i, j, i <= PRICE_SWITCH ? HIGHER_PRICE : LOWER_PRICE ) );
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

    public ArrayList<Seat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats( ArrayList<Seat> available_seats ) {
        this.available_seats = available_seats;
    }
}