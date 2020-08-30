import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[]args) {
        Socket socket = null;



        try {
            ServerSocket serverSocket = new ServerSocket(5115);
            System.out.println("Сервер запущен");
            socket =serverSocket.accept();
            System.out.println("Подключился клиент");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos =new DataOutputStream(socket.getOutputStream());


            while (true){
                String str = dis.readUTF();

                if (str.equals("exit")){
                    dos.writeUTF("Завершение");
                    break;
                }
                dos.writeUTF("Client" + str);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}