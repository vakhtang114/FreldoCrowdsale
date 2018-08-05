package backEnd.controller;

import backEnd.response.RatingResponse;
import backEnd.service.RatingService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/rating")
@Api(description = "Services for extracting rating Freldo ICO", name = "Rating controller")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @RequestMapping(value = "/icobench", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Method user to get Freldo ICO rating from https://icobench.com/ico/freldo/ratings")
    public RatingResponse getIcobenchRating() throws IOException {
        return ratingService.getIcobenchRating();
    }

    @RequestMapping(value = "/trackico", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Method user to get Freldo ICO rating from https://www.trackico.io/ico/freldo/")
    public RatingResponse getTrackicoRating() throws IOException {
        return ratingService.getTrackicoRating();
    }

    @RequestMapping(value = "/icomarks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Method user to get Freldo ICO rating from https://icomarks.com/ico/freldo")
    public RatingResponse getIcomarksRating() throws IOException {
        return ratingService.getIcomarksRating();
    }

    @RequestMapping(value = "/foundico", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Method user to get Freldo ICO rating from https://foundico.com/ru/ico/freldo.html")
    public RatingResponse getFoundicoRating() throws IOException {
        return ratingService.getFoundicoRating();
    }

    @RequestMapping(value = "/airdrops", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Method user to get Freldo ICO rating from https://airdrops.ninja/icos/detail/4327")
    public RatingResponse getAirdropsRating() throws IOException {
        return ratingService.getAirdropsRating();
    }

    @RequestMapping(value = "/cryptoprofy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Method user to get Freldo ICO rating from https://cryptoprofy.com/rating-ico/obzor-ico-freldo.html")
    public RatingResponse getCryptoprofyRating() throws IOException {
        return ratingService.getCryptoprofyRating();
    }
}

