package containers;

import jade.wrapper.AgentContainer;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;

public class TraderContainer {
    public static void main(String[] args) {
        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl(false);
        profile.setParameter(ProfileImpl.MAIN_HOST, "localhost");
        AgentContainer container = runtime.createAgentContainer(profile);
        AgentController controller = null;
        try {
            controller = container.createNewAgent("Trader", "agents.TraderAgent", new Object[]{});
            controller.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }
}
