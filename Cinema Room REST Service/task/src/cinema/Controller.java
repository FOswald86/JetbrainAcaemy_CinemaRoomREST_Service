package cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Room cinemaRoom = new Room( 9, 9 );

    @GetMapping("/seats")
    public Room getAvailableSeats() {
        return cinemaRoom;
    }

}