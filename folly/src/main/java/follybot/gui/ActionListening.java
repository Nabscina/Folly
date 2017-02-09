package follybot.gui;

import follybot.follybot.Conversation;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class ActionListening implements ActionListener {

    private JTextField follysfield;
    private JTextField humansfield;

    private Conversation convo;

    public ActionListening(JTextField folly, JTextField human, Conversation convo) {

        this.follysfield = folly;
        this.humansfield = human;

        this.convo = convo;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        this.follysfield.setForeground(Color.decode("#FF004F"));

        this.follysfield.setText(convo.converse(this.humansfield.getText()));
        this.humansfield.setText("");
    }
}
