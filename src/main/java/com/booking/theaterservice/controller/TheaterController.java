package com.example.theaterservice.controller;


import com.example.theaterservice.dto.v1.AuditoriumDetailDto;
import com.example.theaterservice.dto.v1.AuditoriumDto;
import com.example.theaterservice.dto.v1.TheatreDto;
import com.example.theaterservice.service.v1.AuditoriumService;
import com.example.theaterservice.service.v1.TheatreService;
import io.swagger.annotations.Api;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
public class TheaterController {

    private final TheatreService theatreService;

    private final AuditoriumService auditoriumService;



    public TheaterController(TheatreService theatreService, AuditoriumService auditoriumService) {
        this.theatreService = theatreService;
        this.auditoriumService = auditoriumService;
    }

    @PostMapping( path = "/api/theatre" )
    public ResponseEntity<TheatreDto> register(@RequestBody @Valid TheatreDto theatreDto) {
        return ResponseEntity.ok( theatreService.save( theatreDto ) );
    }


    @PostMapping( path = "/api/theatre/{id}/auditorium" )
    public ResponseEntity<AuditoriumDto> addAuditorium( @PathVariable(name = "id") Long id,
        @RequestBody @Valid AuditoriumDto auditoriumDto) {
        auditoriumDto.setTheaterId( id );
        return ResponseEntity.ok( auditoriumService.save( auditoriumDto ) );
    }

    @GetMapping( path = "/api/theatre/{id}/auditorium" )
    public ResponseEntity<List<AuditoriumDetailDto>> theatreDetail(@PathVariable(name = "id") Long id ) {
        return ResponseEntity.ok( auditoriumService.findByTheaterId( id ) );
    }
}
