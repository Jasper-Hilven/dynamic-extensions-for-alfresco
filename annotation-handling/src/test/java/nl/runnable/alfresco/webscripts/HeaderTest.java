package nl.runnable.alfresco.webscripts;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import nl.runnable.alfresco.webscripts.annotations.Header;

import org.junit.Test;
import org.kubek2k.springockito.annotations.ReplaceWithMock;
import org.kubek2k.springockito.annotations.SpringockitoContextLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * Integration test for {@link Header} handling.
 * 
 * @author Laurens Fridael
 * 
 */
@ContextConfiguration(locations = "webscript-integration-test-context.xml", loader = SpringockitoContextLoader.class)
@DirtiesContext
public class HeaderTest extends AbstractWebScriptAnnotationsTest {

	/* Dependencies */

	@ReplaceWithMock
	@Autowired
	private HeaderHandler handler;

	/* Main operations */

	@Test
	public void testHandle() {
		handleGetRequest(handler, "handleHeader", new MockWebScriptRequest().header("Content-Type", "application/json"));
		verify(handler).handleHeader(eq("application/json"));
	}

}
