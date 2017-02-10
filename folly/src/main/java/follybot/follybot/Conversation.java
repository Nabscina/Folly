package follybot.follybot;

/**
 * Tämä luokka sisältää vähän päällekkäistä toiminnallisuutta Folly-luokan kanssa, eli
 * palauttaa Follyn merkkijonovastauksen GUI-luokan käytettäväksi. Tuntuu vain
 * luonnolliselta, että käyttöliittymään liittyy keskustelu, ja keskusteluun
 * Folly.
 */
public class Conversation {

    private Folly folly;

    public Conversation() {

        folly = new Folly();
    }

    public String converse(String line) {

        return folly.respond(line);
    }
}
