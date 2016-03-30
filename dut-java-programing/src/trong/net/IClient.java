package trong.net;

import java.io.IOException;

public interface IClient {
	String request(String s) throws IOException;
	void stop() throws IOException;
}
