package team.arton.coreserver.api;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.arton.coreserver.model.ContentResDto;
import team.arton.coreserver.model.DefaultResponse;
import team.arton.coreserver.model.StatusType;
import team.arton.coreserver.service.ContentService;

import java.util.List;

@RestController
@Slf4j
public class HomeController {
    private ContentService contentService;

    public HomeController(ContentService contentService) {
        this.contentService = contentService;
    }

    @ApiOperation("홈 화면 조회")
    @GetMapping("/api/v1/home")
    public DefaultResponse getHome(@RequestParam(required = false, defaultValue = "0") Long lastContentId,
                                   @RequestParam int contentNum) {
        log.info(lastContentId.toString());
        List<ContentResDto> contentResDtoList = contentService.infiniteContentView(lastContentId, contentNum);
        return DefaultResponse.res(StatusType.OK, contentResDtoList);
    }
}
































