package cinema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Controller implements ErrorController {

    @JsonIgnoreProperties(value = {"room_ROWS", "room_COLUMNS"})
    private final int ROOM_ROWS = 9, ROOM_COLUMNS = 9;

    Room cinemaRoom = new Room( ROOM_ROWS, ROOM_COLUMNS );

    @GetMapping("/seats")
    public Room getAvailableSeats() {
        return cinemaRoom;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseSeat( @RequestBody Seat seat ) {

        int column = seat.getColumn();
        int row = seat.getRow();

        // check for indexOutOfBoundException
        if ( column > cinemaRoom.getTotal_columns() || row > cinemaRoom.getTotal_rows() || row < 1 || column < 1 ) {
            return new ResponseEntity<>( Map.of( "error", "The number of a row or a column is out of bounds!" )
                    , HttpStatus.BAD_REQUEST );
        }

        // check seat available + purchase
        for ( int i = 0; i < cinemaRoom.getAvailable_seats().size(); i++ ) {
            seat = cinemaRoom.getAvailable_seats().get( i );
            if ( seat.getRow() == row && seat.getColumn() == column ) {
                cinemaRoom.getAvailable_seats().remove( i );
                return new ResponseEntity<>( seat, HttpStatus.OK );
            }
        }

        // else = already purchased
        return new ResponseEntity<>( Map.of( "error", "The ticket has been already purchased!" )
                , HttpStatus.BAD_REQUEST );

    }

}