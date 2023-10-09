package APIMethods;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class GetIPAdress  {
    public static void main(String[] args) {
        String domain = "monets-garden.se"; // Den domän vars IP-adress du vill hämta

        try {
            InetAddress ipAddress = InetAddress.getByName(domain);
            String ipAddressStr = ipAddress.getHostAddress();

            System.out.println("IP-adressen för " + domain + " är: " + ipAddressStr);
        } catch (UnknownHostException e) {
            System.err.println("Kunde inte hämta IP-adressen: " + e.getMessage());
        }
    
        
    
    }
    }