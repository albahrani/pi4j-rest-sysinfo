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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.restexpress.Request;
import org.restexpress.Response;
import org.restexpress.RestExpress;
import org.restexpress.route.parameterized.ParameterizedRouteBuilder;

import com.pi4j.system.SystemInfo.BoardType;

import io.netty.handler.codec.http.HttpMethod;

public class RaspberrySystemInfoControllerTestRest {

	@Test
	public void testSystemClockInfo() {
		RestExpress server = mock(RestExpress.class);
		RaspberrySystemInfoController controller = new RaspberrySystemInfoController();

		Map<String, ParameterizedRouteBuilder> routeBuilders = new HashMap<>();

		String[] expectedRouteNames = new String[] { "test/clock", "test/java", "test/memory", "test/cpu", "test/os", "test/features", "test" };
		for (int i = 0; i < expectedRouteNames.length; i++) {
			String expectedRouteName = expectedRouteNames[i];
			ParameterizedRouteBuilder routeBuilder = mock(ParameterizedRouteBuilder.class);
			when(server.uri(eq(expectedRouteName), eq(controller))).thenReturn(routeBuilder);
			when(routeBuilder.action(anyString(), any())).thenReturn(routeBuilder);
			routeBuilders.put(expectedRouteName, routeBuilder);
		}
		controller.attach(server, "test");

		Set<Entry<String, ParameterizedRouteBuilder>> entrySet = routeBuilders.entrySet();
		for (Entry<String, ParameterizedRouteBuilder> entry : entrySet) {
			verify(server).uri(entry.getKey(), controller);
			ParameterizedRouteBuilder routeBuilder = entry.getValue();
			verify(routeBuilder).action(anyString(), eq(HttpMethod.GET));
			verify(routeBuilder).action(anyString(), eq(HttpMethod.OPTIONS));
			verifyNoMoreInteractions(routeBuilder);
		}
		verifyNoMoreInteractions(server);
	}

	@Test
	public void testCorsSetting() {
		RaspberrySystemInfoController controller = new RaspberrySystemInfoController();
		Pi4jSystemInfoFacade systemInfoProvider = createSystemInfoProviderMock();
		controller.setSystemInfo(systemInfoProvider);

		Request request = mock(Request.class);
		when(request.getHttpMethod()).thenReturn(HttpMethod.GET, HttpMethod.OPTIONS);
		Response response = new Response();

		controller.setAllowedCorsOrigin("http://abc.def.com");
		controller.getSystemClockInfo(request, response);

		String origin = response.getHeader("Access-Control-Allow-Origin");
		assertEquals("http://abc.def.com", origin);

		Response responseOptions = new Response();
		controller.getSystemClockInfo(request, responseOptions);
		String originOptions = responseOptions.getHeader("Access-Control-Allow-Origin");
		assertEquals("http://abc.def.com", originOptions);

	}

	private static Pi4jSystemInfoFacade createSystemInfoProviderMock() {
		Pi4jSystemInfoFacade systemInfoProvider;
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

		return systemInfoProvider;
	}
}
