package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.Location;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ConsommateurAgent extends Agent {
    private String receivedMessage = null;

    @Override
    protected void setup() {
        super.setup();

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                //sendMsg("Apple");
                ACLMessage message = receive();
                if (message != null) {
                    System.out.println(message.getContent());
                    receivedMessage = message.getContent();
                }
            }
        });
    }

    @Override
    protected void takeDown() {
        super.takeDown();
    }

    @Override
    public void doMove(Location destination) {
        super.doMove(destination);
    }

    public void sendMsg(String msg) {
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.addReceiver(new AID("Trader", AID.ISLOCALNAME));
        message.setContent(msg);
        send(message);
    }

    public String getReceivedMessage() {
        return receivedMessage;
    }
}
