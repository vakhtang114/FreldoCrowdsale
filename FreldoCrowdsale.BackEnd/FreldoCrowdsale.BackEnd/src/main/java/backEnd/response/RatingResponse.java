package backEnd.response;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject(name = "RatingResponse")
public class RatingResponse {

    @ApiObjectField(name = "name")
    private String name;

    @ApiObjectField(name = "rating")
    private String rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
