package com.binaryheap.testing.controllers;

import com.binaryheap.testing.dtos.BagDto;
import com.binaryheap.testing.services.BagService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.Matchers.*;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BagController.class)
public class BagControllerTests {
    @Autowired
    private MockMvc mvcMock;

    @MockBean
    private BagService bagService;

    @Test
    public void get_all_bags() throws Exception {
        // arrange
        BagDto bag = new BagDto();
        bag.setName("My Bag");
        bag.setId(1);
        List<BagDto> bags = Arrays.asList(bag);
        Page<BagDto> pagesOfBag = new PageImpl<>(bags);
        Pageable pageable = PageRequest.of(0, 20);

        // act
        given(bagService.getBags(pageable)).willReturn(pagesOfBag);

        // assert
        mvcMock.perform(get("/bags")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(1)))
                .andExpect(jsonPath("$.content[0].name", is(bag.getName())));
    }
}
