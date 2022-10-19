package ee.bcs.java.controller;

import ee.bcs.java.tasks.Lesson1;
import ee.bcs.java.tasks.Lesson2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    private List<Client> clients = new ArrayList<>();

    @GetMapping("client")
    public List<Client> getClients() {
        // TODO tagasta kogu clients list
        return clients;
    }

    @PostMapping("client")
    public void saveClient(@RequestBody Client client) {
        // TODO lisa requestBodys olev klient listi
        clients.add(client);
        System.out.println(clients);
    }

    @GetMapping("client/{index}")
    public Client getClient(@PathVariable("index") Integer index) {
        // TODO tagasta klient indexil
        return clients.get(index);
    }

    @DeleteMapping("client{index}")
    public void deleteClient(@PathVariable("index") int index) {
        // TODO kustuta klient vastaval indeksil
        clients.remove(index);
    }

    @PutMapping("client/{index}")
    public void updateClient(@PathVariable("index") int i, @RequestBody Client client) {
        // TODO uuenda kliendi andmed, vastavalt indexile
        // TODO uued andmed loe sisse request bodyst
        clients.set(i, client);
    }

    //  @GetMapping("client")
    //  public Client hello() {
    //     Client client = new Client ();
    //   client.setFirstName("Viljar");
    // client.setLastName("Vahemae");
    // client.setAddress("Tallinn");
    // return client;
    // }

    //  @PostMapping("client")
    //  public Client saveClient(@RequestBody Client client) {
    //    client.setFirstName(client.getFirstName() + "2");
    //  return client;
    // }


    @GetMapping("lesson1/min/{a}/{b}")
    public Integer min(@PathVariable("a") int x, @PathVariable("b") int y) {
        return Lesson1.min(x, y);
    }

    @GetMapping("lesson1/max/{a}/{b}")
    public Integer max(@PathVariable("a") int x, @PathVariable("b") int y) {
        return Lesson1.max(x, y);
    }

    @GetMapping("lesson1/abs/{a}")
    public Integer abs(@PathVariable("a") int x) {
        return Lesson1.abs(x);
    }

    @GetMapping("lesson1/isEven/{a}")
    public boolean isEven(@PathVariable("a") int x) {
        return Lesson1.isEven(x);
    }

    @GetMapping("lesson1/min3/{a}/{b}/{c}")
    public Integer min3(@PathVariable("a") int x, @PathVariable("b") int y, @PathVariable("c") int z) {
        return Lesson1.min3(x, y, z);
    }

    @GetMapping("lesson1/max3/{a}/{b}/{c}")
    public Integer max3(@PathVariable("a") int x, @PathVariable("b") int y, @PathVariable("c") int z) {
        return Lesson1.max3(x, y, z);
    }

    @GetMapping("lesson1/someString")
    public String someString(String a) {
        return Lesson1.someString();
    }

    @GetMapping("lesson2/generateArray")
    public int[] generateArray(@PathVariable("n") int x) {
        return Lesson2.generateArray(x);
    }

    @GetMapping("lesson2/decreasingArray")
    public int[] decreasingArray(@RequestParam("n") int x) {
        return Lesson2.decreasingArray(x);
    }


}
