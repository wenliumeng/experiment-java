package elasticsearch;


import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.env.Environment;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;

/**
 * elasticsearch 客户端
 * @author Seymour
 */
public class Client {

	private static Path initializeJavaTempDir() throws IOException {
		FileSystem fileSystem = FileSystems.getDefault().provider().getFileSystem(URI.create("file:///"));
		Path javaTempDir = fileSystem.getPath(System.getProperty("tempDir", System.getProperty("java.io.tmpdir"))).toRealPath();

		return javaTempDir.toRealPath().resolve("ccc");
	}

	public static void main(String[] args) throws IOException {
		Settings.Builder builder = Settings.builder()
				.put("node.name", "qa_smoke_client")
				.put("client.transport.ignore_cluster_name", true)
				.put(Environment.PATH_HOME_SETTING.getKey(), initializeJavaTempDir());
		final Collection<Class<? extends Plugin>> plugins;
		plugins = Collections.emptyList();

		URL url = new URL("http://127.0.0.1:9301");
		InetAddress inetAddress = InetAddress.getByName(url.getHost());
		TransportAddress transportAddresses = new TransportAddress(new InetSocketAddress(inetAddress, url.getPort()));

		TransportClient client = new PreBuiltTransportClient(builder.build(), plugins).addTransportAddresses(transportAddresses);

		ClusterHealthResponse health = client.admin().cluster().prepareHealth().get();
		System.out.println(health.getClusterName());
		System.out.println(health.getNumberOfNodes());

	}
}
