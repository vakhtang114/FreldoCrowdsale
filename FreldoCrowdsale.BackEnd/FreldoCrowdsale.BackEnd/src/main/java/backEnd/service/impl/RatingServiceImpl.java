package backEnd.service.impl;

import backEnd.response.RatingResponse;
import backEnd.service.RatingService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Override
    public RatingResponse getIcobenchRating() {
        RatingResponse response = new RatingResponse();
        String rating = getRating("https://icobench.com/ico/freldo/ratings", ".//div[@class='rating']/div");
        response.setRating(rating);
        response.setName("icobench");
        return response;
    }

    @Override
    public RatingResponse getTrackicoRating() {
        RatingResponse response = new RatingResponse();
        String rating = getRating("https://www.trackico.io/ico/freldo/", "//div[@class='fs-60 fw-400 text-primary']");
        response.setRating(rating);
        response.setName("trackico");
        return response;
    }

    @Override
    public RatingResponse getIcomarksRating() {
        RatingResponse response = new RatingResponse();
        String rating = getRating("https://icomarks.com/ico/freldo", "//div[@class='ico-rating-overall']");
        response.setRating(rating);
        response.setName("icomarks");
        return response;
    }

    @Override
    public RatingResponse getFoundicoRating() {
        RatingResponse response = new RatingResponse();
        String rating = getRating("https://foundico.com/ru/ico/freldo.html", "//span[@class='flmf-mark']").replace("?", "");
        response.setRating(rating);
        response.setName("foundico");
        return response;
    }

    @Override
    public RatingResponse getAirdropsRating() {
        RatingResponse response = new RatingResponse();
        String rating = getRating("https://airdrops.ninja/icos/detail/4327", "//span[@class='g-font-size-40 g-color-black']");
        response.setRating(rating);
        response.setName("airdrops");
        return response;
    }

    @Override
    public RatingResponse getCryptoprofyRating() {
        RatingResponse response = new RatingResponse();
        String rating = getRating("https://cryptoprofy.com/rating-ico/obzor-ico-freldo.html", ".//div[@class='right']/div[@class='raiting']");
        response.setRating(rating);
        response.setName("cryptoprofy");
        return response;
    }

    private String getRating(String url, String className) {
        WebClient client = new WebClient();
        client.getOptions().setThrowExceptionOnFailingStatusCode(false);
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page = null;
        String rating = null;
        try {
            page = client.getPage(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (page != null) {
            List<HtmlElement> items = page.getByXPath(className);
            if (!items.isEmpty()) {
                rating = items.get(0).asText();
            }
        }
        return rating;
    }
}
