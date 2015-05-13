public class Main 
{
    public static void main(String argd[])
    {
        Receiver r=new Receiver();
        Messenger m=new Messenger();
        m.setVisible(true);
        m.setSocket();
        r.receive(m);
        //Thread t1=new Thread(r);
        //t1.start();
    }
    
}
