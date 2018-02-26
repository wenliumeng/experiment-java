package elasticsearch;

import com.carrotsearch.hppc.cursors.ObjectObjectCursor;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.metadata.IndexMetaData;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NodeClient {

	public static void main(String[] args) {
		NodeClient nodeClient = new NodeClient();
		TransportClient test = nodeClient.test();

//		Map<String,Object> infoMap = new HashMap<>(1);
//		infoMap.put("name", "cd1");
//		infoMap.put("age", 11);
//		IndexResponse indexResponse = test.prepareIndex("test1", "type1","1").setSource(infoMap).execute().actionGet();
//		System.out.println("id:"+indexResponse.getId());

//		Map<String,Object> infoMap = new HashMap<>(1);
//		infoMap.put("name", "cd1");
//		infoMap.put("name", "cd1");
//		infoMap.put("name", "cd1");
//		infoMap.put("age", 11);
//		IndexResponse indexResponse = test.prepareIndex("test", "tab","1").setSource(infoMap).execute().actionGet();
//		System.out.println("id:"+indexResponse.getId());

//		GetResponse response = test.prepareGet("test", "tab", "1")
//				.execute().actionGet();
//		System.out.println(response.getSourceAsMap().toString());

		ImmutableOpenMap<String, IndexMetaData> indices = test.admin().cluster().prepareState().execute().actionGet().getState().getMetaData().getIndices();

		PrintKeyValue<String, IndexMetaData> p1 = (s, indexMetaData) -> s + indexMetaData.getIndex().getName();
//		indices.forEach(s -> System.out.print(String.format("key:[%s] value[%s]%n",s.key,s.value.getIndex().getName())));
//		indices.forEach(Sysout.out::println);
		indices.forEach(new consum());

//		ImmutableOpenMap<String, MappingMetaData> type = test.admin().cluster().prepareState().execute().actionGet().getState().getMetaData().getIndices().get("test").getMappings();
//		System.out.println(type);
	}

	public TransportClient test() {
		TransportClient client = null;
		try {
			Settings esSettings = Settings.builder()
//					.put("cluster.name", "see")
					.put("client.transport.sniff", true)
					.build();
			client = new PreBuiltTransportClient(esSettings);
			client.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return client;
	}

	public interface PrintKeyValue<T, R> {
		String print(T t, R r);

		default void prin(T t, R r) {
			System.out.println(t.toString() + r.toString());
		}
	}

	public static class consum implements Consumer<ObjectObjectCursor<String,IndexMetaData>>{

		@Override
		public void accept(ObjectObjectCursor<String, IndexMetaData> object) {
			System.out.print(String.format("key:[%s] value[%s]%n",object.key,object.value.getIndex().getName()));
		}

		@Override
		public Consumer<ObjectObjectCursor<String, IndexMetaData>> andThen(Consumer<? super ObjectObjectCursor<String, IndexMetaData>> after) {
			return null;
		}
	}
}
