namespace SimpleNancy.SelfHost
{
	using Nancy;
	using System;
	using System.IO;
	using System.Net;
	using System.Text;

	public class HelloModule : NancyModule
	{
		public HelloModule()
		{
			Get["/ping"] = _ => "Hi there, you just pinged a app running .NET/C#";

			Get["/count"] = _ => {
			  try{
          WebRequest insertDataRequest = WebRequest.Create("http://nodeservice:8082/nodeInsert");
          insertDataRequest.GetResponse().Close();

          WebRequest getDataRequest = WebRequest.Create("http://nodeservice:8082/nodeGet");
          WebResponse response = getDataRequest.GetResponse ();

          Stream dataStream = response.GetResponseStream ();
          StreamReader reader = new StreamReader(dataStream);
          // Read the content.
          string responseFromServer = reader.ReadToEnd ();
          reader.Close ();
          response.Close ();
          return responseFromServer;

        } catch(Exception e){
          Console.WriteLine("An error occurred: '{0}'", e);
          return  "could not call towards http://nodeservice:8082";
        }
			};

		}

	}


}
