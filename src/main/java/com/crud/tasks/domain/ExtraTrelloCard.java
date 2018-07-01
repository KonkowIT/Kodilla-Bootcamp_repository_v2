package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtraTrelloCard {

    @JsonProperty("id")
    private String id;

    @JsonProperty("badges")
    private Badges badges;

    @JsonProperty("votes")
    private int votes;

    @JsonProperty("attachments")
    private AttachmentByType attachments;

    @JsonProperty("trello")
    private Trello trello;

    @JsonProperty("board")
    private int board;

    @JsonProperty("card")
    private int card;

}
