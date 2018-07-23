package com.crud.tasks.domain;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MapperTestSuite {

    @Autowired
    private TrelloMapper mapper;

    @Test
    public void testMapToBoards() {
        //given
        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloBoardDto.add(new TrelloBoardDto("test_board_id", "test_board_name", trelloListDto));
        trelloListDto.add(new TrelloListDto("test_list_id", "test_list_name", false));

        //when
        List<TrelloBoard> result = mapper.mapToBoards(trelloBoardDto);

        //then
        assertEquals("test_board_id", result.get(0).getId());
        assertEquals("test_board_name", result.get(0).getName());
        assertEquals(1, result.get(0).getLists().size());
    }

    @Test
    public void testMapToBoardsDto() {
        //given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        List<TrelloList> trelloList = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("test_board_id", "test_board_name", trelloList));
        trelloList.add(new TrelloList("test_list_id", "test_list_name", false));

        //when
        List<TrelloBoardDto> result = mapper.mapToBoardsDto(trelloBoards);

        //then
        assertEquals("test_board_id", result.get(0).getId());
        assertEquals("test_board_name", result.get(0).getName());
        assertEquals(1, result.get(0).getLists().size());
    }

    @Test
    public void testMapToList() {
        //given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("test_list_id", "test_list_name", false));

        //when
        List<TrelloList> result = mapper.mapToList(trelloListDto);

        //then
        assertEquals("test_list_id", result.get(0).getId());
        assertEquals("test_list_name", result.get(0).getName());
        assertFalse(result.get(0).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("test_list_id", "test_list_name", false));

        //when
        List<TrelloListDto> result = mapper.mapToListDto(trelloList);

        //then
        assertEquals("test_list_id", result.get(0).getId());
        assertEquals("test_list_name", result.get(0).getName());
        assertFalse(result.get(0).getIsClosed());
    }

    @Test
    public void testMapToCardDto() {
        //given
        TrelloCard trelloCard = new TrelloCard("trello_card_name", "trello_card_description",
                "trello_card_pos", "trello_card_listId");

        //when
        TrelloCardDto result = mapper.mapToCardDto(trelloCard);

        //then
        assertEquals("trello_card_name", result.getName());
        assertEquals("trello_card_description", result.getDescription());
        assertEquals("trello_card_pos", result.getPos());
        assertEquals("trello_card_listId", result.getListId());
    }

    @Test
    public void testMapToCard() {
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("trello_card_name", "trello_card_description",
                "trello_card_pos", "trello_card_listId");

        //when
        TrelloCard result = mapper.mapToCard(trelloCardDto);

        //then
        assertEquals("trello_card_name", result.getName());
        assertEquals("trello_card_description", result.getDescription());
        assertEquals("trello_card_pos", result.getPos());
        assertEquals("trello_card_listId", result.getListId());
    }
}
