package cinema;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller implements ErrorController {

    private final int TOTAL_ROWS = 9, TOTAL_COLUMNS = 9;
    Room cinemaRoom = new Room( TOTAL_ROWS, TOTAL_COLUMNS );

    @GetMapping("/seats")
    public Room getAvailableSeats() {
        return cinemaRoom;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseSeat( @RequestBody Seat seat ) {
        return cinemaRoom.purchase( seat );
    }

    @PostMapping("/return")
    public ResponseEntity<?> purchaseSeat( @RequestBody Ticket ticket ) {
        return cinemaRoom.refund( ticket );
    }

    @PostMapping("/stats")
    public ResponseEntity<?> statistics( @RequestParam(value = "password", required = false) String password ) {
        return cinemaRoom.getStatistics( password );
    }

}