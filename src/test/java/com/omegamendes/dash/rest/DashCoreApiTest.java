package com.omegamendes.dash.rest;

import com.omegamendes.dash.api.DashCoreApi;
import com.omegamendes.dash.model.repository.HeroRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

/**
 * Created by omegamendes on 03/01/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class DashCoreApiTest {
    
    @Mock
    private HeroRepository heroRepository;
    
    
    @InjectMocks
    private DashCoreApi api = new DashCoreApi();
    
    @Test
    public void testFindPlayerStats() {
        Mockito.when(heroRepository.findAll()).thenReturn(new ArrayList<>());
        
        api.getPlayerStats("omegamendes");
    }
}
