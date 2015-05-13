import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ricky
 */
class Receiver //implements Runnable
{
    int port;
    InetAddress ip;
    int flag=0;
    int choice;
    int group;
    public void receive(Messenger m)
    {
        
        flag=m.getFlag();
        
        byte[] receiveData = new byte[1024];
        //int gr=0;
        Statement st=null;
        DatagramSocket socket=m.getSocket();//new DatagramSocket(4000); 
        try{
        
        }
        
        catch(Exception e)
        {}
              
        while(true){
            int change=0;
        if(flag==0)
        { 
            try
            {    
                //System.out.println("Invoked");
                DatagramPacket receivePacket = 
                new DatagramPacket(receiveData, receiveData.length);
                    socket.receive(receivePacket); 
                    String sentence = new String(receivePacket.getData());
                    String str[]=sentence.split("x");
                     m.disp(str[0]);
                    flag=m.getFlag();
            }
            catch(Exception e)
            {
                
                System.out.println(e.getMessage());
            }
        }
        else
        {
            //m.disp("in multi");
            group=m.getgroup();
            String g=group+"";
            setPort(g.charAt(0));
            try
            {
                InetAddress address =ip;// InetAddress.getByName("224.2.2.3"); // Multicast address
                if (!address.isMulticastAddress()) // Test if multicast address
                throw new IllegalArgumentException("Not a multicast address");
                MulticastSocket sock = new MulticastSocket(port); // Multicast receiving socket
                sock.joinGroup(address); // Join the multicast group
                byte[] data = new byte[1024];   
                while(change==0) 
                {    
                    DatagramPacket receivePacket = new DatagramPacket(data, data.length); 
                    sock.receive(receivePacket); 
                    String sentence = new String(receivePacket.getData());
                    String str[]=sentence.split("x");
                    System.out.println(str[0]);
                    m.disp(str[0]);
                    
                    if(group==m.getgroup())
                         change=0;
                    else
                    {
                         change=1;
                         //flag=0;
                    }
                }
            }
            catch(Exception e)
            {
             System.out.println("Exception");
            }
        }}
       
    }
    void setPort(char c)
        {
            try
            {
            switch(c)
            {
                case '1':
                    port=5001;
                    ip=InetAddress.getByName("224.2.2.3");
                    break;
                case '2':
                    port=5002;
                    ip=InetAddress.getByName("224.2.2.4");
                    break;
                case '3':
                    port=5003;
                    ip=InetAddress.getByName("224.2.2.5");
                    break;
                case '4':
                    port=5004;
                    ip=InetAddress.getByName("224.2.2.7");
                    break;  
            }
            }
            catch(Exception e)
            {}
        }
}
