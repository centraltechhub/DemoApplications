package session;

import java.net.InetAddress;

public class Server 
{
	public int sessionCounter = 0;
	public String ipAddress=null;
	public String hostName = null;
	
	public void getIPDetails()
	{
		try
		{
		InetAddress localhost = InetAddress.getLocalHost();
		ipAddress = localhost.getHostAddress();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public void getHostName()
	{
		try
		{
		InetAddress localhost = InetAddress.getLocalHost();
		hostName = localhost.getHostName();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public void sessionCounter()
	{
		sessionCounter=sessionCounter+1;
	}
	
}
