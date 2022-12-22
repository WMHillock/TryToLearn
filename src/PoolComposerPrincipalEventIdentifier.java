import java.util.logging.Level;
import java.util.logging.Logger;

public class PoolComposerPrincipalEventIdentifier {
    private static final Logger LOG = Logger.getLogger(
            PoolComposerPrincipalEventIdentifier.class.getName());
    public void identifyPrincipalEvent() {
        try {
            doIdentifyPrincipalEventUsingPoolComposer();
        }
        catch(Exception ex) {
            LOG.log(Level.SEVERE, "SMT gona wrong!", ex);
        }
    }

    private void doIdentifyPrincipalEventUsingPoolComposer() {
    }
}
