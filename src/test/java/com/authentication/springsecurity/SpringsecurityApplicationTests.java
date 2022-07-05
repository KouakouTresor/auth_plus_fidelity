package com.authentication.springsecurity;


import com.authentication.springsecurity.entity.entityClients.Clients;
import com.authentication.springsecurity.entity.entityClients.FidelityCard;
import com.authentication.springsecurity.repository.ClientsRepository;
import com.authentication.springsecurity.repository.FidelityRepository;
import com.authentication.springsecurity.service.clientsService.ClientsServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;



import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@ActiveProfiles("it")
@SpringBootTest(classes = SpringsecurityApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpringsecurityApplicationTests {

    @Autowired
    private ClientsServiceImpl clientsServiceImpl;

    @Autowired
    private FidelityRepository fidelityRepository;


    @Test
    @Rollback(value = false)
    public void a_saveClient(){
        Clients client = new Clients();
        client.setEmail("Chris@gmail.com");
        client.setPhone("0672763097");
        client.setVille("34000, Montpellier");
        client.setName("Chris");
        client.setActive(true);
        client.setCreationdate(new Date());
        client.setAddress("21 rue la vie");
        client.setCode("12365");


        FidelityCard fidelity = new FidelityCard();
        fidelity.setLastshop("2021-10-1");
        fidelity.setPoints(10);

        client.setFidelity(fidelity);

        clientsServiceImpl.SaveClient(client);

        assertTrue(client.getId() > 0);
    }


    @Test
    public void b_getClientTest(){

        Optional<Clients> client = clientsServiceImpl.FindByiD(1L);
        assertTrue(client.isPresent());
    }

    @Test
    public void c_getListOfClientsTest(){

        List list = clientsServiceImpl.SelectAll();
        assertTrue(list.size() > 0);

    }

    @Test
    @Rollback(value = false)
    public void d_updateClientTest(){
        Clients client = clientsServiceImpl.FindByiD(1L).get();
        client.setName("Christina");
        clientsServiceImpl.SaveClient(client);
        assertNotEquals("belli", clientsServiceImpl.FindByiD(1L).get().getName());

    }

    @Test
    @Rollback(value = false)
    public void deleteRecetteTest(){
        Clients client = new Clients();
        client.setEmail("belli@gmail.com");
        client.setPhone("097276392");
        client.setVille("34000, Montpellier");
        client.setName("johnny");
        client.setActive(true);
        client.setCreationdate(new Date());
        client.setAddress("21 rue de Marseille");


        FidelityCard fidelity = new FidelityCard();
        fidelity.setLastshop("2022-10-1");
        fidelity.setPoints(22);

        client.setFidelity(fidelity);

        Clients saved = clientsServiceImpl.SaveClient(client);


        Long id = saved.getId();



        clientsServiceImpl.DeleteClient(id);

        Optional<Clients> find = clientsServiceImpl.FindByiD(id);

        assertTrue(find.isEmpty());
    }


}
