package Frontend.Paginas;

import javax.swing.*;

import Backend.Social.Clases.Usuario;
import Backend.Social.Clases.Chat;
import Frontend.Componentes.JChat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class JPaginaChats extends JPanel {
    @SuppressWarnings("unused")
    private Usuario emisor;
    private HashMap<String, Chat> chats;

    public JPaginaChats(Usuario emisor) {
        this.emisor = emisor;
        chats = emisor.getChats();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for(Chat chatito : chats.values()) {
            String receptor = chatito.getReceptor();
            JButton chatButton = new JButton("Chat con " + receptor);
            chatButton.setFocusPainted(false);
            chatButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JChat chatWindow = new JChat(emisor.getUsername(), receptor);
                    chatWindow.inicializar();
                }
            });
            add(chatButton);
        }
    }

    public void inicializar() {
        JFrame frame = new JFrame("Página de Chats");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 600);
        frame.add(this);
        frame.setVisible(true);
    }
}