package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.Location;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.HashMap;
import java.util.Map;

public class TraderAgent extends Agent {
    static Map<String, Double> actions;
    static {
        actions = new HashMap<>();
        actions.put("Google", 125.15);
        actions.put("Facebook", 173.0);
        actions.put("IBM", 94.2);
        actions.put("Apple", 207.59);
        actions.put("Xiaomi", 117.0);
        actions.put("Twitter", 90.14);
    }
    String msg = null;

    @Override
    protected void setup() {
        super.setup();
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage message = receive();
                if (message != null) {
                    msg = message.getContent();
                    System.out.println("Message received by the trader : " + msg);
                    ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
                    aclMessage.addReceiver(new AID("Consommateur", AID.ISLOCALNAME));
                    if (actions.containsKey(msg)) {
                        aclMessage.setContent(Double.toString(actions.get(msg)));
                        send(aclMessage);
                    }
                }else {
                    msg = "NOT FOUND";
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

    public String receivedMsg() {
        return msg;
    }
}
