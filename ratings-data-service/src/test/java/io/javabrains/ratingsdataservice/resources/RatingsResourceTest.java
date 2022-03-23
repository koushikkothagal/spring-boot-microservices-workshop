package io.javabrains.ratingsdataservice.resources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {RatingsResource.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RatingsResourceTest {
    @Autowired
    private RatingsResource ratingsResource;
    
    @Test
    public void testGetMovieRating() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ratingsdata/movies/{movieId}", "42");
        MockMvcBuilders.standaloneSetup(this.ratingsResource)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("{\"movieId\":\"42\",\"rating\":4}"));
    }
    
    @Test
    public void testGetMovieRating2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ratingsdata/movies/{movieId}",
                "Uri Vars", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.ratingsResource)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("{\"movieId\":\"Uri Vars\",\"rating\":4}"));
    }
    
    @Test
    public void testGetUserRatings() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ratingsdata/user/{userId}", "42");
        MockMvcBuilders.standaloneSetup(this.ratingsResource)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"userId\":\"42\",\"ratings\":[{\"movieId\":\"100\",\"rating\":3},{\"movieId\":\"200\",\"rating\":4}]}"));
    }
    
    @Test
    public void testGetUserRatings2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/ratingsdata/user/{userId}", "42");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.ratingsResource)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"userId\":\"42\",\"ratings\":[{\"movieId\":\"100\",\"rating\":3},{\"movieId\":\"200\",\"rating\":4}]}"));
    }
}

