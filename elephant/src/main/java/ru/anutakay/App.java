package ru.anutakay;

import ru.anutakay.client.Client;
import ru.anutakay.client.StrongClient;

public class App {
    public static void main(String[] args) {
        Fridge fridge = new Fridge(100, 100, 100, 200);
        Elephant elephant = new Elephant(new Size(100, 100, 50), new Weight(150));
        Giraffe giraffe = new Giraffe(new Size(50, 50, 100), new Weight(70));

        Client client = new StrongClient();
        client.putToFridge(fridge, elephant);
        client.putToFridge(fridge, giraffe);
        fridge.open();
        client.putToFridge(fridge, elephant);

        Elephant bigElephant = new Elephant(new Size(100, 100, 100), new Weight(250));
        client.putToFridge(fridge, bigElephant);

        Crocodile crocodile = new Crocodile(new Size(50, 20, 10), new Weight(50));
        client.putToFridge(fridge, crocodile);
    }
}
