package javaio;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.entity.ContentType;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

import java.io.*;
import java.nio.charset.Charset;

/**
 * ½Ó¿Ú
 *
 * @author bfei
 * @date 2018/6/21
 */
public class InputStreamTwoMethod {

	public static String toString(HttpEntity entity) throws IOException, ParseException {
		if (entity == null) {
			throw new IllegalArgumentException("HTTP entity may not be null");
		} else {
			InputStream instream = entity.getContent();
			if (instream == null) {
				return null;
			} else {
				String var10;
				try {
					if (entity.getContentLength() > 2147483647L) {
						throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
					}

					int i = (int)entity.getContentLength();
					if (i < 0) {
						i = 4096*3;
					}

					ContentType contentType = ContentType.getOrDefault(entity);
					Charset charset = contentType.getCharset();

					if (charset == null) {
						charset = HTTP.DEF_CONTENT_CHARSET;
					}

					Reader reader = new InputStreamReader(instream, charset);
//					String buffer = IOUtils.toString(reader);
					CharArrayBuffer buffer = new CharArrayBuffer(i);
					char[] tmp = new char[1024];

					int l;
					while((l = reader.read(tmp)) != -1) {
						System.out.println("bflog tmp " + String.valueOf(tmp));
						buffer.append(tmp, 0, l);
					}

					System.out.println("bflog " + buffer.length());
					System.out.println("bflog " + buffer);
					System.out.println("bflog ");
					var10 = buffer.toString();
				} finally {
					instream.close();
				}

				return var10;
			}
		}
	}

	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
