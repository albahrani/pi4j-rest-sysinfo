/**
 * Copyright © 2015 albahrani (https://github.com/albahrani)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.albahrani.pi4j.rest.sysinfo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.restexpress.Request;
import org.restexpress.Response;

import com.pi4j.system.SystemInfo.BoardType;

import de.albahrani.pi4j.rest.sysinfo.json.JSONSystemClockInfo;
import de.albahrani.pi4j.rest.sysinfo.json.JSONSystemCpuInfo;
import de.albahrani.pi4j.rest.sysinfo.json.JSONSystemFeaturesEnabledInfo;
import de.albahrani.pi4j.rest.sysinfo.json.JSONSystemInfo;
import de.albahrani.pi4j.rest.sysinfo.json.JSONSystemJavaInfo;
import de.albahrani.pi4j.rest.sysinfo.json.JSONSystemMemoryInfo;
import de.albahrani.pi4j.rest.sysinfo.json.JSONSystemOsInfo;
import io.netty.handler.codec.http.HttpMethod;

@RunWith(Parameterized.class)
public class RaspberrySystemInfoControllerTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { HttpMethod.GET, true }, { HttpMethod.OPTIONS, true }, { HttpMethod.GET, false }, { HttpMethod.OPTIONS, false } });
	}

	@Parameter // first data value (0) is default
	public HttpMethod requestMethod;

	@Parameter(1)
	public boolean throwException;

	@Test
	public void testSystemClockInfo() {
		RaspberrySystemInfoController controller = new RaspberrySystemInfoController();
		Pi4jSystemInfoFacade systemInfoProvider = this.createSystemInfoProviderMock();

		controller.setSystemInfo(systemInfoProvider);

		Request request = mock(Request.class);
		when(request.getHttpMethod()).thenReturn(this.requestMethod);
		Response response = new Response();

		controller.getSystemClockInfo(request, response);

		ResponseAssertionInterface responseAssertion = (body) -> {
			assertNotNull(body);
			assertTrue(body instanceof JSONSystemClockInfo);
			JSONSystemClockInfo clockInfo = (JSONSystemClockInfo) body;
			assertEquals(Long.valueOf(1l), clockInfo.getArm());
			assertEquals(Long.valueOf(2l), clockInfo.getCore());
			assertEquals(Long.valueOf(3l), clockInfo.getDpi());
			assertEquals(Long.valueOf(4l), clockInfo.getEmmc());
			assertEquals(Long.valueOf(5l), clockInfo.getH264());
			assertEquals(Long.valueOf(6l), clockInfo.getHdmi());
			assertEquals(Long.valueOf(7l), clockInfo.getIsp());
			assertEquals(Long.valueOf(8l), clockInfo.getPixel());
			assertEquals(Long.valueOf(9l), clockInfo.getPwm());
			assertEquals(Long.valueOf(10l), clockInfo.getUart());
			assertEquals(Long.valueOf(11l), clockInfo.getV3d());
			assertEquals(Long.valueOf(12l), clockInfo.getVec());
		};
		responseAssertion.assertResponse(response, requestMethod, throwException);
	}

	@Test
	public void testSystemCpuInfo() {
		RaspberrySystemInfoController controller = new RaspberrySystemInfoController();
		Pi4jSystemInfoFacade systemInfoProvider = this.createSystemInfoProviderMock();

		controller.setSystemInfo(systemInfoProvider);

		Request request = mock(Request.class);
		when(request.getHttpMethod()).thenReturn(this.requestMethod);
		Response response = new Response();
		controller.getSystemCpuInfo(request, response);

		ResponseAssertionInterface responseAssertion = (body) -> {
			assertNotNull(body);
			assertTrue(body instanceof JSONSystemCpuInfo);
			JSONSystemCpuInfo clockInfo = (JSONSystemCpuInfo) body;
			assertEquals("A", clockInfo.getArchitecture());
			assertArrayEquals(new String[] { "B", "C", "D" }, clockInfo.getFeatures());
			assertEquals("E", clockInfo.getImplementer());
			assertEquals("F", clockInfo.getPart());
			assertEquals("G", clockInfo.getRevision());
			assertEquals(1.1f, clockInfo.getTemperature(), 0.001f);
			assertEquals("H", clockInfo.getVariant());
			assertEquals(8.2f, clockInfo.getVoltage(), 0.001f);
			assertEquals("I", clockInfo.getBogoMips());
		};
		responseAssertion.assertResponse(response, requestMethod, throwException);
	}

	/**
	*
	*/
	@Test
	public void testSystemFeaturesEnabledInfo() {
		RaspberrySystemInfoController controller = new RaspberrySystemInfoController();
		Pi4jSystemInfoFacade systemInfoProvider = this.createSystemInfoProviderMock();

		controller.setSystemInfo(systemInfoProvider);

		Request request = mock(Request.class);
		when(request.getHttpMethod()).thenReturn(this.requestMethod);
		Response response = new Response();
		controller.getSystemFeaturesEnabledInfo(request, response);

		ResponseAssertionInterface responseAssertion = (body) -> {
			assertNotNull(body);
			assertTrue(body instanceof JSONSystemFeaturesEnabledInfo);
			JSONSystemFeaturesEnabledInfo clockInfo = (JSONSystemFeaturesEnabledInfo) body;
			assertTrue(clockInfo.getCodecH264());
			assertTrue(clockInfo.getCodecMpg2());
			assertTrue(clockInfo.getCodecWvc1());
			assertTrue(clockInfo.getHardFloatAbi());
		};
		responseAssertion.assertResponse(response, requestMethod, throwException);
	}

	/**
	*
	*/
	@Test
	public void testSystemInfo() {
		RaspberrySystemInfoController controller = new RaspberrySystemInfoController();
		Pi4jSystemInfoFacade systemInfoProvider = this.createSystemInfoProviderMock();

		controller.setSystemInfo(systemInfoProvider);

		Request request = mock(Request.class);
		when(request.getHttpMethod()).thenReturn(this.requestMethod);
		Response response = new Response();
		controller.getSystemInfo(request, response);

		ResponseAssertionInterface responseAssertion = (body) -> {
			assertNotNull(body);
			assertTrue(body instanceof JSONSystemInfo);
			JSONSystemInfo clockInfo = (JSONSystemInfo) body;
			assertEquals("RaspberryPi_B_Plus", clockInfo.getBoardType());
			assertEquals("A", clockInfo.getHardware());
			assertEquals("B", clockInfo.getModelName());
			assertEquals("C", clockInfo.getProcessor());
			assertEquals("D", clockInfo.getRevision());
			assertEquals("E", clockInfo.getSerial());
		};
		responseAssertion.assertResponse(response, requestMethod, throwException);
	}

	/**
	*
	*/
	@Test
	public void testSystemJavaInfo() {
		RaspberrySystemInfoController controller = new RaspberrySystemInfoController();
		Pi4jSystemInfoFacade systemInfoProvider = this.createSystemInfoProviderMock();

		controller.setSystemInfo(systemInfoProvider);

		Request request = mock(Request.class);
		when(request.getHttpMethod()).thenReturn(this.requestMethod);
		Response response = new Response();
		controller.getSystemJavaInfo(request, response);

		ResponseAssertionInterface responseAssertion = (body) -> {
			assertNotNull(body);
			assertTrue(body instanceof JSONSystemJavaInfo);
			JSONSystemJavaInfo clockInfo = (JSONSystemJavaInfo) body;
			assertEquals("A", clockInfo.getRuntime());
			assertEquals("B", clockInfo.getVendor());
			assertEquals("C", clockInfo.getVendorurl());
			assertEquals("D", clockInfo.getVersion());
			assertEquals("E", clockInfo.getName());
		};
		responseAssertion.assertResponse(response, requestMethod, throwException);
	}

	/**
	*
	*/
	@Test
	public void testSystemMemoryInfo() {
		RaspberrySystemInfoController controller = new RaspberrySystemInfoController();
		Pi4jSystemInfoFacade systemInfoProvider = this.createSystemInfoProviderMock();

		controller.setSystemInfo(systemInfoProvider);

		Request request = mock(Request.class);
		when(request.getHttpMethod()).thenReturn(this.requestMethod);
		Response response = new Response();
		controller.getSystemMemoryInfo(request, response);

		ResponseAssertionInterface responseAssertion = (body) -> {
			assertNotNull(body);
			assertTrue(body instanceof JSONSystemMemoryInfo);
			JSONSystemMemoryInfo clockInfo = (JSONSystemMemoryInfo) body;
			assertEquals(Long.valueOf(1l), clockInfo.getBuffers());
			assertEquals(Long.valueOf(2l), clockInfo.getCached());
			assertEquals(Long.valueOf(3l), clockInfo.getFree());
			assertEquals(Long.valueOf(4l), clockInfo.getShared());
			assertEquals(Long.valueOf(5l), clockInfo.getTotal());
			assertEquals(Long.valueOf(6l), clockInfo.getUsed());
			assertEquals(1.1f, clockInfo.getVoltageC(), 0.001f);
			assertEquals(2.2f, clockInfo.getVoltageI(), 0.001f);
			assertEquals(3.3f, clockInfo.getVoltageP(), 0.001f);
		};
		responseAssertion.assertResponse(response, requestMethod, throwException);
	}

	/**
	*
	*/
	@Test
	public void testSystemOsInfo() {
		RaspberrySystemInfoController controller = new RaspberrySystemInfoController();
		Pi4jSystemInfoFacade systemInfoProvider = this.createSystemInfoProviderMock();

		controller.setSystemInfo(systemInfoProvider);

		Request request = mock(Request.class);
		when(request.getHttpMethod()).thenReturn(this.requestMethod);
		Response response = new Response();
		controller.getSystemOsInfo(request, response);

		ResponseAssertionInterface responseAssertion = (body) -> {
			assertNotNull(body);
			assertTrue(body instanceof JSONSystemOsInfo);
			JSONSystemOsInfo clockInfo = (JSONSystemOsInfo) body;
			assertEquals("A", clockInfo.getArchitecture());
			assertEquals("B", clockInfo.getFirmwareBuild());
			assertEquals("C", clockInfo.getFirmwareDate());
			assertEquals("D", clockInfo.getName());
			assertEquals("E", clockInfo.getVersion());
		};
		responseAssertion.assertResponse(response, requestMethod, throwException);
	}

	private Pi4jSystemInfoFacade createSystemInfoProviderMock() {
		Pi4jSystemInfoFacade systemInfoProvider;
		if (!this.throwException) {
			systemInfoProvider = mock(Pi4jSystemInfoFacade.class);
			try {
				when(systemInfoProvider.getClockFrequencyArm()).thenReturn(1l);
				when(systemInfoProvider.getClockFrequencyCore()).thenReturn(2l);
				when(systemInfoProvider.getClockFrequencyDPI()).thenReturn(3l);
				when(systemInfoProvider.getClockFrequencyEMMC()).thenReturn(4l);
				when(systemInfoProvider.getClockFrequencyH264()).thenReturn(5l);
				when(systemInfoProvider.getClockFrequencyHDMI()).thenReturn(6l);
				when(systemInfoProvider.getClockFrequencyISP()).thenReturn(7l);
				when(systemInfoProvider.getClockFrequencyPixel()).thenReturn(8l);
				when(systemInfoProvider.getClockFrequencyPWM()).thenReturn(9l);
				when(systemInfoProvider.getClockFrequencyUART()).thenReturn(10l);
				when(systemInfoProvider.getClockFrequencyV3D()).thenReturn(11l);
				when(systemInfoProvider.getClockFrequencyVEC()).thenReturn(12l);
				when(systemInfoProvider.getCpuArchitecture()).thenReturn("A");
				when(systemInfoProvider.getCpuFeatures()).thenReturn(new String[] { "B", "C", "D" });
				when(systemInfoProvider.getCpuImplementer()).thenReturn("E");
				when(systemInfoProvider.getCpuPart()).thenReturn("F");
				when(systemInfoProvider.getCpuRevision()).thenReturn("G");
				when(systemInfoProvider.getCpuTemperature()).thenReturn(1.1f);
				when(systemInfoProvider.getCpuVariant()).thenReturn("H");
				when(systemInfoProvider.getCpuVoltage()).thenReturn(8.2f);
				when(systemInfoProvider.getBogoMIPS()).thenReturn("I");
				when(systemInfoProvider.getCodecH264Enabled()).thenReturn(true);
				when(systemInfoProvider.getCodecMPG2Enabled()).thenReturn(true);
				when(systemInfoProvider.getCodecWVC1Enabled()).thenReturn(true);
				when(systemInfoProvider.isHardFloatAbi()).thenReturn(true);
				when(systemInfoProvider.getBoardType()).thenReturn(BoardType.RaspberryPi_B_Plus);
				when(systemInfoProvider.getHardware()).thenReturn("A");
				when(systemInfoProvider.getModelName()).thenReturn("B");
				when(systemInfoProvider.getProcessor()).thenReturn("C");
				when(systemInfoProvider.getRevision()).thenReturn("D");
				when(systemInfoProvider.getSerial()).thenReturn("E");
				when(systemInfoProvider.getJavaRuntime()).thenReturn("A");
				when(systemInfoProvider.getJavaVendor()).thenReturn("B");
				when(systemInfoProvider.getJavaVendorUrl()).thenReturn("C");
				when(systemInfoProvider.getJavaVersion()).thenReturn("D");
				when(systemInfoProvider.getJavaVirtualMachine()).thenReturn("E");
				when(systemInfoProvider.getMemoryBuffers()).thenReturn(1l);
				when(systemInfoProvider.getMemoryCached()).thenReturn(2l);
				when(systemInfoProvider.getMemoryFree()).thenReturn(3l);
				when(systemInfoProvider.getMemoryShared()).thenReturn(4l);
				when(systemInfoProvider.getMemoryTotal()).thenReturn(5l);
				when(systemInfoProvider.getMemoryUsed()).thenReturn(6l);
				when(systemInfoProvider.getMemoryVoltageSDRam_C()).thenReturn(1.1f);
				when(systemInfoProvider.getMemoryVoltageSDRam_I()).thenReturn(2.2f);
				when(systemInfoProvider.getMemoryVoltageSDRam_P()).thenReturn(3.3f);
				when(systemInfoProvider.getOsArch()).thenReturn("A");
				when(systemInfoProvider.getOsFirmwareBuild()).thenReturn("B");
				when(systemInfoProvider.getOsFirmwareDate()).thenReturn("C");
				when(systemInfoProvider.getOsName()).thenReturn("D");
				when(systemInfoProvider.getOsVersion()).thenReturn("E");
			} catch (ParseException | UnsupportedOperationException | IOException | InterruptedException e) {
				fail("Unexpected exception during createSystemInfoProviderMock():" + e.getMessage());
			}
		} else {
			systemInfoProvider = mock(Pi4jSystemInfoFacade.class, new SystemInfoProviderExceptionAnswer());
		}

		return systemInfoProvider;
	}

	public static class SystemInfoProviderExceptionAnswer implements Answer<Object> {

		@Override
		public Object answer(InvocationOnMock invocation) throws Throwable {
			if (invocation.getMethod().getName().startsWith("getJava")) {
				throw new UnsupportedOperationException("SystemInfoProviderExceptionAnswer");
			}
			throw new IOException("SystemInfoProviderExceptionAnswer");
		}

	}

	@FunctionalInterface
	static interface ResponseAssertionInterface {
		void assertOnGetAndSuccess(Object body);

		default void assertResponse(Response response, HttpMethod requestMethod, boolean throwException) {
			Object body = response.getBody();
			if (HttpMethod.GET.equals(requestMethod) && throwException) {
				assertNull(body);
				Throwable exception = response.getException();
				assertNotNull(exception);
				assertTrue((exception instanceof IOException) || (exception instanceof UnsupportedOperationException));
			} else if (HttpMethod.GET.equals(requestMethod)) {
				this.assertOnGetAndSuccess(body);
			} else {
				assertNull(body);
			}
		}
	}
}
