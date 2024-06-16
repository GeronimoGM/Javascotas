package Frontend.Componentes;


import javax.swing.*;
import Backend.Social.Clases.Mensaje;
import Backend.Gestor.Clases.Gestor;
import Backend.Gestor.Excepciones.UsuarioNoExistenteException;
import Backend.Social.Clases.Chat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class JChat extends JFrame {
    
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private Chat chat;

    public JChat(String emisor, String receptor) {
        try {
            this.chat = Gestor.sesionIniciada.abrirChat(Gestor.getUsuario(receptor));
        } catch (UsuarioNoExistenteException e) {
            // TODO: handle exception
        }
        
        setTitle("Chat con " + receptor);
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        sendButton = new JButton("Enviar");
        sendButton.setFocusPainted(false);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                if (!message.trim().isEmpty()) {
                    chat.enviarMensaje(message);
                    chatArea.append(Gestor.sesionIniciada.getUsername() + ": " + message + "\n");
                    inputField.setText("");
                }
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    public void inicializar() {
        setVisible(true);
        cargarMensajes();
    }

    private void cargarMensajes() {
        LinkedList<Mensaje> mensajes = chat.getMensajes();
        for (Mensaje mensaje : mensajes) {
            chatArea.append(mensaje.getUsername() + ": " + mensaje.getTexto() + "\n");
        }
    }
}
