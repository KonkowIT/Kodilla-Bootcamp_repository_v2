package com.crud.tasks.controller;

import com.crud.tasks.domain.*;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoard();

        trelloBoards.stream()
                .filter(Objects::nonNull)
                .filter(a -> a.getName().contains("Kodilla"))
                .filter(b -> !(b.getName().isEmpty()))
                .filter(c -> !(c.getId().isEmpty()))
                .forEach(c -> System.out.println(c.getId() + " " + c.getName()));

        return trelloClient.getTrelloBoard();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {

        return trelloClient.createNewCard(trelloCardDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createExtraTrello")
    public ExtraTrelloCard extraTrelloCard(@RequestBody ExtraTrelloDto extraTrelloDto) {

        return trelloClient.createExtraTrelloCard(extraTrelloDto);
    }
}
