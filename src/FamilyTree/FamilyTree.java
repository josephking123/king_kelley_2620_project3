package FamilyTree;

import java.util.ArrayList;

public class FamilyTree {

    private ArrayList<Client> clients;
    @SuppressWarnings("unused")
    private Client currentClient;

    public FamilyTree() {
        this.clients = new ArrayList<>();
        this.currentClient = null;
    }

    public void switchClient(Client client) {
        this.currentClient = client;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }
}