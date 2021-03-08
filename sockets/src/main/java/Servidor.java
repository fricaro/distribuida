import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Servidor {

    private static String HOME = System.getProperty("user.home");

    public static void main(String[] args) throws IOException {
        System.out.println("== Servidor ==");

        // Configurando o socket
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        while (true) {
            System.out.println("Cliente: " + socket.getInetAddress());

            String mensagem = dis.readUTF();
            System.out.println(mensagem);

            switch (mensagem) {
                case "readdir":
                    Set<String> filesName = readdir();
                    dos.writeUTF("File names: " + String.join(",", filesName));
                    break;
                case "rename":
                    dos.writeUTF("Digite o nome do arquivo para renomear:");
                    String qualArquivoRenomear = dis.readUTF();
                    dos.writeUTF("Digite o novo nome do arquivo:");
                    String novoNome = dis.readUTF();
                    String newName = rename(qualArquivoRenomear, novoNome);
                    dos.writeUTF("Arquivo renomeado com sucesso: " + newName);
                    break;
                case "create":
                    String arquivo = create();
                    dos.writeUTF("Arquivo criado com successo. Nome do arquivo: " + arquivo);
                    break;
                case "remove":
                    dos.writeUTF("Digite o arquivo que será deletado:");
                    String fileToDelete = dis.readUTF();
                    String filename = remove(fileToDelete);
                    dos.writeUTF("Arquivo deletado com successo. Nome do arquivo: " + filename);
                    break;
                default:
                    dos.writeUTF("Li sua mensagem: " + mensagem);
                    break;
            }
        }
    }

    static private Set<String> readdir() throws IOException {
        Set<String> fileList = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(HOME))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.getFileName()
                            .toString());
                }
            }
        }
        return fileList;
    }

    static private String rename(String arquivo, String novoNome) throws IOException {
        Path fileToRename = Paths.get(HOME + "/" + arquivo);
        Path newNome = Paths.get(HOME + "/" + novoNome);
        Files.move(fileToRename, newNome, StandardCopyOption.REPLACE_EXISTING);
        return newNome.toString();
    }

    static private String create() throws IOException {
        String fileName = "myfile_" + UUID.randomUUID().toString() + ".txt";
        Path p = Paths.get(HOME + "/" + fileName);
        Files.createFile(p);
        return fileName;
    }

    static private String remove(String filename) throws IOException {
        Path p = Paths.get(HOME + "/" + filename);
        Files.delete(p);
        return filename;
    }
}