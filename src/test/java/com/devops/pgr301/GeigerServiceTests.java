package com.devops.pgr301;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeigerServiceTests {

    @Autowired
    private GeigerCounterService geigerCounterService;

    @Test
    public void createGeigerAndGetGeiger(){
        GeigerCounter geigerCounter = geigerCounterService.createGeigerCounter();
        assertThat(geigerCounter).isNotNull();
        assertThat(geigerCounterService.getGeigerCounters()).isNotNull();
    }

}
