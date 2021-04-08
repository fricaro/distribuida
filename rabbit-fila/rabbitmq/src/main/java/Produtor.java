import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.nio.charset.StandardCharsets;

public class Produtor {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (
            Connection connection = connectionFactory.newConnection();
            Channel canal = connection.createChannel();
        ) {
            String mensagem = String.join("", args);
            mensagem += "\nFRANCISCO ICARO CIPRIANO SILVA";
            String NOME_FILA = "Francisco";

            //(queue, passive, durable, exclusive, autoDelete, arguments)
            canal.queueDeclare(NOME_FILA, false, false, false, null);

            // ​(exchange, routingKey, mandatory, immediate, props, byte[] body)
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, "PRIMEIRA".getBytes());
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, "SEGUNDA".getBytes());
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, "TERCEIRA".getBytes());
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, "PROF QUERIA FAZER TAREFA NAO".getBytes());
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, "O 10 VEM, REIZINHO DO JAVA".getBytes());
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, "MENTIRA, APENAS COPIEI O CODIGO".getBytes());
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, "QAURTA".getBytes());
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, "QUINTA".getBytes());
            System.out.println ("[x] Enviado '" + mensagem + "'");
        }
    }
}