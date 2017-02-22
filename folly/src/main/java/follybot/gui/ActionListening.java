package follybot.gui;

import follybot.follybot.Conversation;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Tapahtumankuuntelija, eli kun tapahtuma tapahtuu (painetaan enteriä),
 * actionPerformed päivittää tekstikentät + voi myös sulkea ikkunan Follyn
 * tekstikentän perusteella. Myös Follyn fontin värin asetus käy kätevästi
 * samalla kun se vaihtuu vasta kun käyttäjän nimi on tiedossa.
 */
public class ActionListening implements ActionListener {

    private JTextField follysfield;
    private JTextField humansfield;
    private JFrame frame;

    private Conversation convo;

    /**
     * Asetetaan parametreinä saadut frame, folly, human ja convo oliomuuttujien
     * arvoiksi, palauttaa ActionListening-olion.
     *
     * @param frame GUI-luokan JFrame-olio.
     * @param folly Follyn tekstikenttä.
     * @param human käyttäjän tekstikenttä.
     * @param convo Conversation-olio, jolta saadaan Follyn tekstikenttään
     * asetettava vastaus.
     */
    public ActionListening(JFrame frame, JTextField folly, JTextField human, Conversation convo) {

        this.follysfield = folly;
        this.humansfield = human;
        this.frame = frame;

        this.convo = convo;
    }

    /**
     * Metodi päivittää Follyn tekstikenttään vastauksen käyttäjälle ja
     * tyhjentää käyttäjän tekstikentän uutta syötettä varten, sekä myös muuttaa
     * Follyn tekstin väriä kun metodia ekan kerran kutsutaan (nimen antamisen
     * jälkeen) ja tekee Follyn tekstikentälle tarkistuksen, jonka perusteella
     * voidaan sulkea ikkuna ja lopettaa ohjelma. Metodista lähdetään vitun
     * äkkiä pois jos käyttäjä syöttää tyhjää (eikä olla hyvästelty ensin), eli
     * tyhjä syöte ei saa vastausta, eikä esim. tyhjän nimen syöttäminen
     * onnistu.
     *
     * @param ae tällainen ActionEvent generoidaan, kun enteriä painetaan. Emme
     * nyt kyllä tee sillä mitään.
     *
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (humansfield.getText().trim().equals("") && !windowDisposeCheck(follysfield.getText())) {
            return;
        }

        if (windowDisposeCheck(follysfield.getText())) {
            frame.dispose();
        }

        follysfield.setForeground(Color.decode("#FF004F"));
        follysfield.setText(convo.converse(humansfield.getText()));
        humansfield.setText("");
    }

    /**
     * Tarkistetaan, lukeeko Follyn tekstikentässä equalsin jälkeinen lause (jos
     * lukee, ikkuna suljetaan).
     *
     * @param follysline teksti Follyn tekstikentässä.
     *
     * @return true jos tekstikentän sisältö on tuo lause, muuten false.
     */
    public boolean windowDisposeCheck(String follysline) {

        return follysline.equals("Bye. Press enter to leave.");
    }
}
