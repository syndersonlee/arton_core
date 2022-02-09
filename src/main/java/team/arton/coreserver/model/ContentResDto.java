package team.arton.coreserver.model;

import lombok.Getter;
import team.arton.coreserver.domain.Content;

@Getter
public class ContentResDto {
    private Long id;

    private String title;

    private String editorName;

    private String thumbnailUrl;

    public ContentResDto(Content content) {
        this.id = content.getId();
        this.title = content.getTitle();
        this.editorName = content.getEditor().getDescription();
        this.thumbnailUrl = content.getThumbnailUrl();
    }

    public ContentResDto()  {}
}