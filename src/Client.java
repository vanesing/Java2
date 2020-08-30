import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMIClientSocketFactory;
import java.util.Scanner;

public class Client {


    // не хватает метода ввода (что бы в консоли отображалось поле ввода)

    public static void main(String... args) throws IOException {
        Socket socket;
        String SERVER_ADRES = "localhost";
        int SERVER_PORT = 5115;
        DataInputStream in;
        DataOutputStream out;
        Scanner scanner = new Scanner(System.in);


        try {

            Socket socket1 = new Socket(SERVER_ADRES,SERVER_PORT);
            in =new DataInputStream(socket1.getInputStream());
            out =new DataOutputStream(socket1.getOutputStream());
            new Thread(new Runnable() {


                // где то тут должен быть сканер для ввода
                @Override
                public void run() {
                    while (true) {
                        try {
                            String str = in.readUTF();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            String string =out.toString();

                        }catch (NullPointerException ex){
                            ex.printStackTrace();
                        }

                    }

                }
            });

        }catch (IOException e){
            e.printStackTrace();
        }


    }

}
