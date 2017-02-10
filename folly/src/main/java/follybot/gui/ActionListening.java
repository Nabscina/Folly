package follybot.gui;

import follybot.follybot.Conversation;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 * Tapahtumankuuntelija, eli kun tapahtuma tapahtuu (painetaan enteriä),
 * actionPerformed päivittää tekstikentät. Myös Follyn fontin värin asetus käy
 * kätevästi samalla kun se vaihtuu vasta kun käyttäjän nimi on tiedossa.
 */
public class ActionListening implements ActionListener {

    private JTextField follysfield;
    private JTextField humansfield;

    private Conversation convo;

    public ActionListening(JTextField folly, JTextField human, Conversation convo) {

        this.follysfield = folly;
        this.humansfield = human;

        this.convo = convo;
    }

    /**
     * Metodi päivittää Follyn tekstikenttään vastauksen käyttäjälle, sekä myös
     * tyhjentää käyttäjän tekstikentän uutta kysymystä varten, sekä myös muuttaa
     * Follyn tekstin väriä kun metodia ekan kerran kutsutaan (nimen antamisen jälkeen).
     * Voisi toteuttaa boolean-tarkastuksen niin se tehtäisiin vain kerran.
     *
     * @param ae tällainen ActionEvent generoidaan, kun enteriä painetaan.
     * Emme nyt kyllä tee sillä mitään.
     *
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        this.follysfield.setForeground(Color.decode("#FF004F"));

        this.follysfield.setText(convo.converse(this.humansfield.getText()));
        this.humansfield.setText("");
    }
}
