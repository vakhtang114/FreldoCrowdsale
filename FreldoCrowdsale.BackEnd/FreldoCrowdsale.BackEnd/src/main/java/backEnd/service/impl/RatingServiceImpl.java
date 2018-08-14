package backEnd.service.impl;

import backEnd.response.RatingResponse;
import backEnd.service.RatingService;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
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

    @Override
    public RatingResponse getCryptonextRating() throws IOException, InterruptedException {
        RatingResponse response = new RatingResponse();
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.setCssErrorHandler(new SilentCssErrorHandler());
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        WebRequest request = new WebRequest(new URL("https://cryptonext.com/ico/freldo"));
        HtmlPage page = webClient.getPage(request);

        int i = webClient.waitForBackgroundJavaScript(1000);
        while (i > 0) {
            i = webClient.waitForBackgroundJavaScript(1000);

            if (i == 0) {
                break;
            }
            synchronized (page) {
                System.out.println("wait");
                page.wait(500);
            }
        }

        webClient.getAjaxController().processSynchron(page, request, false);

        String rating = null;
        if (page != null) {
            List<HtmlElement> items = page.getByXPath("//div[@class='data-v-2f2c9bb3']");
            if (!items.isEmpty()) {
                rating = items.get(0).asText();
            }
        }

        response.setRating(rating);
        response.setName("cryptonext");
        return response;
    }

    @Override
    public RatingResponse getBetaicoRating() {
        RatingResponse response = new RatingResponse();
        String rating = getRating("http://betaico.com/freldo#tab-analysis", "//div[@class='c100 p75 big center rate4']");
        response.setRating(rating);
        response.setName("betaico");
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
