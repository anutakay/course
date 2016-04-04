package ru.anutakay.app;

import ru.anutakay.fridge.BoxFridge;
import ru.anutakay.animals.size.Size;
import ru.anutakay.animals.size.Weight;
import ru.anutakay.animals.Crocodile;
import ru.anutakay.animals.Elephant;
import ru.anutakay.animals.Giraffe;
import ru.anutakay.client.Client;
import ru.anutakay.client.StrongClient;
import ru.anutakay.exception.*;

public class App {
    public static void main(String[] args) {

        doByStrongClient();
    }

    private static void doByStrongClient()  {
        Size frigeSize = new Size(100, 100, 100, new Weight(200));
        BoxFridge fridge = new BoxFridge(frigeSize);
        Elephant elephant = new Elephant(new Size(100, 100, 50, new Weight(150)));
        Giraffe giraffe = new Giraffe(new Size(50, 50, 100, new Weight(70)));

        Client client = new StrongClient();

        try {
            client.putToFridge(fridge, elephant);
            client.putToFridge(fridge, giraffe);
            fridge.open();
            client.putToFridge(fridge, elephant);

            Elephant bigElephant = new Elephant(new Size(100, 100, 100, new Weight(250)));
            client.putToFridge(fridge, bigElephant);

            Crocodile crocodile = new Crocodile(new Size(50, 20, 10, new Weight(50)));
            client.putToFridge(fridge, crocodile);
        } catch (BasicException e) {
            e.printStackTrace();
        }
    }
}
