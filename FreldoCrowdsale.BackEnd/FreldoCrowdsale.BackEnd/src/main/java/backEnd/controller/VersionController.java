package backEnd.controller;

import backEnd.exception.BadRequestException;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(name = "Version controller", description = "")
public class VersionController {

    @RequestMapping(value = "/version", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Method returns current version of FRELDO ICO")
    public String getVersion() throws BadRequestException {
        return Version.getVersion();
    }
}
