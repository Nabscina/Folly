package follybot.follybot;

/**
 * Tämä luokka sisältää vähän päällekkäistä toiminnallisuutta Folly-luokan
 * kanssa, eli palauttaa Follyn merkkijonovastauksen GUI-luokan käytettäväksi.
 * Tuntuu vain luonnolliselta, että käyttöliittymään liittyy keskustelu, ja
 * keskusteluun Folly.
 */
public class Conversation {

    private Folly folly;

    /**
     * Alustetaan folly-oliomuuttuja, palauttaa Conversation-olion.
     */
    public Conversation() {

        folly = new Folly();
    }

    /**
     * Kutsuu follyn metodia respond(line) ja palauttaa vastauksen
     * ActionListening-luokalle.
     *
     * @param line käyttäjän syöte.
     *
     * @return Follyn vastaus syötteeseen.
     */
    public String converse(String line) {

        return folly.respond(line);
    }
}
