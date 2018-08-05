package backEnd.service;

import backEnd.response.RatingResponse;

public interface RatingService {

    RatingResponse getIcobenchRating();

    RatingResponse getTrackicoRating();

    RatingResponse getIcomarksRating();

    RatingResponse getFoundicoRating();

    RatingResponse getAirdropsRating();

    RatingResponse getCryptoprofyRating();
}
