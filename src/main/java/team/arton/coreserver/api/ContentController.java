package team.arton.coreserver.api;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.arton.coreserver.common.auth.Auth;
import team.arton.coreserver.common.auth.AuthContext;
import team.arton.coreserver.model.ContentResDto;
import team.arton.coreserver.model.DefaultResponse;
import team.arton.coreserver.model.StatusType;
import team.arton.coreserver.service.ContentService;

import java.util.List;

@RestController
public class ContentController {

    private ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @ApiOperation("New Content")
    @GetMapping("/api/v1/newcontent")
    @Auth
    public DefaultResponse getNewContentList(@RequestParam(required = false, defaultValue = "0") Long lastContentId,
                                             @RequestParam(required = false, defaultValue = "6") int contentNum) {
        Long userId = AuthContext.getUserId();
        List<ContentResDto> contentResDtoList = contentService.infiniteNewContentView(lastContentId, contentNum, userId);
        return DefaultResponse.res(StatusType.OK, contentResDtoList);
    }


    public DefaultResponse getWatchedContentList(@RequestParam(required = false, defaultValue = "0") Long lastContentId,
                                                 @RequestParam(required = false, defaultValue = "6") int contentNum) {
        return DefaultResponse.res(StatusType.OK);

    }
}