package containers;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class ConsommateurContainer {
    public static void main(String[] args) {
        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl(false);
        profile.setParameter(ProfileImpl.MAIN_HOST, "localhost");
        AgentContainer container = runtime.createAgentContainer(profile);
        AgentController controller = null;
        try {
            controller = container.createNewAgent("Consommateur", "agents.ConsommateurAgent", new Object[]{});
            controller.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }
}
