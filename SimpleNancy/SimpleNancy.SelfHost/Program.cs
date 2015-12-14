using System;
using System.Threading;
using Nancy.Hosting.Self;

namespace SimpleNancy.SelfHost
{
	class Program
	{
		static readonly ManualResetEvent ResetEvent = new ManualResetEvent(false);
	
		static void Main()
		{
			try
			{
				var uri =new Uri(String.Format("http://{0}:{1}","localhost","8081")); 
				Console.WriteLine(uri.OriginalString);
				using (var host = new NancyHost(uri))
				{
					host.Start();
					Console.WriteLine("host startedon: " + uri.OriginalString);
					ResetEvent.WaitOne();
					Console.WriteLine("app closing");
				}
			}
			catch (Exception exception)
			{
				Console.WriteLine(exception.Message);
			}
		}
	}
}
