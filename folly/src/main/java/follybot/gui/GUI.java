package follybot.gui;

import follybot.follybot.Conversation;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Täällä luodaan ikkuna, jossa keskustelu käydään, ja liitetään ikkunan
 * tekstikentät ActionListening-luokkaan, jotta uudet jutut päivittyvät
 * ikkunaan.
 */
public class GUI implements Runnable {

    private JFrame frame;
    private Conversation convo;

    /**
     * Alustetaan uusi Conversatioin-olio, palauttaa GUI-olion.
     */
    public GUI() {

        convo = new Conversation();
    }

    @Override
    public void run() {

        this.frame = new JFrame("Folly");
        frame.setPreferredSize(new Dimension(1000, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        components(frame.getContentPane());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Metodissa lisätään containeriin komponentteja, kuten ikkunan
     * tekstikentät. Samalla muokataan komponenttien ominaisuuksia ja lisätään
     * tapahtumankuuntelijat.
     *
     * @param container Container-olio, johon komponentit lisätään ja jotka
     * frame saa käyttöönsä kun tätä metodia kutsutaan.
     */
    private void components(Container container) {

        GridLayout layout = new GridLayout(3, 0);
        container.setLayout(layout);

        JTextField follysfield = new JTextField("Enter your name to talk to Folly");
        JTextField humansfield = new JTextField("");

        follysfield.setBackground(Color.decode("#DCDCDC"));
        follysfield.setFont(new Font("Helvetica", Font.BOLD, 15));

        follysfield.setHorizontalAlignment(JTextField.CENTER);
        follysfield.setEditable(false);

        humansfield.setFont(new Font("Helvetica", Font.BOLD, 14));
        humansfield.setHorizontalAlignment(JTextField.CENTER);

        container.add(follysfield);
        container.add(humansfield);

        addActionListeners(follysfield, humansfield);
    }

    /**
     * Luo ActionListening-olion ja lisää sen kummallekin tekstikentälle, mikä
     * mahdollistaa niiden päivittymisen enteriä painettaessa.
     *
     * @param follysfield Follyn tekstikenttä.
     * @param humansfield Käyttäjän "ihmisen" tekstikenttä.
     */
    private void addActionListeners(JTextField follysfield, JTextField humansfield) {

        ActionListening al = new ActionListening(frame, follysfield, humansfield, convo);

        follysfield.addActionListener(al);
        humansfield.addActionListener(al);
    }
}
