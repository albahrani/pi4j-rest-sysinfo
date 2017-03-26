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

import java.io.IOException;
import java.text.ParseException;

import org.pmw.tinylog.Logger;
import org.restexpress.Request;
import org.restexpress.Response;
import org.restexpress.RestExpress;

import com.pi4j.system.SystemInfo;
import com.pi4j.system.SystemInfoProvider;

import de.albahrani.pi4j.rest.sysinfo.json.JSONSystemClockInfo;
import de.albahrani.pi4j.rest.sysinfo.json.JSONSystemCpuInfo;
import de.albahrani.pi4j.rest.sysinfo.json.JSONSystemFeaturesEnabledInfo;
import de.albahrani.pi4j.rest.sysinfo.json.JSONSystemInfo;
import de.albahrani.pi4j.rest.sysinfo.json.JSONSystemJavaInfo;
import de.albahrani.pi4j.rest.sysinfo.json.JSONSystemMemoryInfo;
import de.albahrani.pi4j.rest.sysinfo.json.JSONSystemOsInfo;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;

/**
 * <h1>RaspberrySystemInfoController</h1>
 * <p>
 * The Raspberry SystemInfo controller registers several URIs to an
 * {@link RestExpress} instance. These REST services provide system information
 * about a Raspberry Pi. Therefore the {@link SystemInfo} from pi4j is used.
 * </p>
 * <p>
 * The URIs all are attached under the <code>baseUrl</code> you pass to
 * {@link #attach(RestExpress, String)}.
 * </p>
 * <p>
 * The Services support CORS requests including Preflight-Requests. You may
 * define the allowed origin set as <code>Access-Control-Allow-Origin</code> via
 * {@link #setAllowedCorsOrigin(String)}. By default '<code>*</code>' is
 * allowed.
 * <p>
 * The URIs attached are:
 * <ul>
 * <li><b>.../<i>{baseUri}</i>/clock</b> - Everything about the clock
 * frequencies set on the Pi.</li>
 * <li><b>.../<i>{baseUri}</i>/java</b> - Information about the used Java
 * installation.</li>
 * <li><b>.../<i>{baseUri}</i>/memory</b> - Key indicators around the system
 * memory including the voltage.</li>
 * <li><b>.../<i>{baseUri}</i>/cpu</b> - The CPU identity including temperature
 * and voltage.</li>
 * <li><b>.../<i>{baseUri}</i>/os</b> - Everything about the underlying OS.</li>
 * <li><b>.../<i>{baseUri}</i>/features</b> - Information about the codecs
 * available and hard float abi.</li>
 * <li><b>.../<i>{baseUri}</i>/</b> - Some basic raspberry board information
 * like model name, board type and revision.</li>
 * </ul>
 *
 * <h1>Example:</h1>
 * 
 * <pre>
 * <code>
 * RestExpress server = new RestExpress();
 * server.setName("Raspi System Info Server");
 * RaspberrySystemInfoController controller = new RaspberrySystemInfoController();
 * controller.attach(server, "/raspberry/systeminfo");
 * server.bind();
 * </code>
 * </pre>
 * 
 * @author Sir-Aliman
 *
 */
public class RaspberrySystemInfoController {

	private Pi4jSystemInfoFacade systemInfoProvider = new Pi4jSystemInfoFacade();

	private String allowedCorsOrigin = "*";

	protected void setSystemInfo(Pi4jSystemInfoFacade systemInfoProvider) {
		this.systemInfoProvider = systemInfoProvider;
	}

	public void setAllowedCorsOrigin(String allowedOrigin) {
		this.allowedCorsOrigin = allowedOrigin;
	}

	/**
	 * Attaches the system info services to your {@link RestExpress} instance
	 * under the <code>baseUri</code>.
	 * 
	 * @param server
	 *            The server to attach the services to
	 * @param baseUri
	 *            a common root Uri prefix for all registered system info
	 *            services. If <code>null</code>, the services are registered
	 *            directly under root (<code>/</code>).
	 */
	public void attach(RestExpress server, String baseUri) {
		Logger.info("Attached RaspberrySystemInfoController to server under: {}", baseUri);
		server.uri(baseUri + "/clock", this).action("getSystemClockInfo", HttpMethod.GET).action("getSystemClockInfo", HttpMethod.OPTIONS);
		server.uri(baseUri + "/java", this).action("getSystemJavaInfo", HttpMethod.GET).action("getSystemJavaInfo", HttpMethod.OPTIONS);
		server.uri(baseUri + "/memory", this).action("getSystemMemoryInfo", HttpMethod.GET).action("getSystemMemoryInfo", HttpMethod.OPTIONS);
		server.uri(baseUri + "/cpu", this).action("getSystemCpuInfo", HttpMethod.GET).action("getSystemCpuInfo", HttpMethod.OPTIONS);
		server.uri(baseUri + "/os", this).action("getSystemOsInfo", HttpMethod.GET).action("getSystemOsInfo", HttpMethod.OPTIONS);
		server.uri(baseUri + "/features", this).action("getSystemFeaturesEnabledInfo", HttpMethod.GET).action("getSystemFeaturesEnabledInfo",
				HttpMethod.OPTIONS);
		server.uri(baseUri, this).action("getSystemInfo", HttpMethod.GET).action("getSystemInfo", HttpMethod.OPTIONS);
	}

	/**
	 * Retrieve everything concerning clock frequencies from
	 * {@link SystemInfoProvider}.
	 * 
	 * @param request
	 *            the RestExpress request
	 * @param response
	 *            the RestExress response
	 */
	public void getSystemClockInfo(Request request, Response response) {
		if (!handleCORS(request, response)) {
			return;
		}

		try {
			JSONSystemClockInfo json = new JSONSystemClockInfo();
			json.setArm(systemInfoProvider.getClockFrequencyArm());
			json.setCore(systemInfoProvider.getClockFrequencyCore());
			json.setDpi(systemInfoProvider.getClockFrequencyDPI());
			json.setEmmc(systemInfoProvider.getClockFrequencyEMMC());
			json.setH264(systemInfoProvider.getClockFrequencyH264());
			json.setHdmi(systemInfoProvider.getClockFrequencyHDMI());
			json.setIsp(systemInfoProvider.getClockFrequencyISP());
			json.setPixel(systemInfoProvider.getClockFrequencyPixel());
			json.setPwm(systemInfoProvider.getClockFrequencyPWM());
			json.setUart(systemInfoProvider.getClockFrequencyUART());
			json.setV3d(systemInfoProvider.getClockFrequencyV3D());
			json.setVec(systemInfoProvider.getClockFrequencyVEC());
			response.setBody(json);
			response.setResponseStatus(HttpResponseStatus.OK);
		} catch (IOException | InterruptedException e) {
			Logger.error(e, "Unexpected error during getSystemClockInfo().");
			response.setException(e);
		}
	}

	/**
	 * Retrieve everything concerning installed Java Runtime from
	 * {@link SystemInfoProvider}.
	 * 
	 * @param request
	 *            the RestExpress request
	 * @param response
	 *            the RestExress response
	 */
	public void getSystemJavaInfo(Request request, Response response) {
		if (!handleCORS(request, response)) {
			return;
		}

		try {
			JSONSystemJavaInfo json = new JSONSystemJavaInfo();
			json.setRuntime(systemInfoProvider.getJavaRuntime());
			json.setVendor(systemInfoProvider.getJavaVendor());
			json.setVendorurl(systemInfoProvider.getJavaVendorUrl());
			json.setVersion(systemInfoProvider.getJavaVersion());
			json.setName(systemInfoProvider.getJavaVirtualMachine());
			response.setBody(json);
			response.setResponseStatus(HttpResponseStatus.OK);
		} catch (UnsupportedOperationException e) {
			Logger.error(e, "Unexpected error during getSystemJavaInfo().");
			response.setException(e);
		}
	}

	/**
	 * Retrieve everything concerning system memory from
	 * {@link SystemInfoProvider}.
	 * 
	 * @param request
	 *            the RestExpress request
	 * @param response
	 *            the RestExress response
	 */
	public void getSystemMemoryInfo(Request request, Response response) {
		if (!handleCORS(request, response)) {
			return;
		}

		try {
			JSONSystemMemoryInfo json = new JSONSystemMemoryInfo();
			json.setBuffers(systemInfoProvider.getMemoryBuffers());
			json.setCached(systemInfoProvider.getMemoryCached());
			json.setFree(systemInfoProvider.getMemoryFree());
			json.setShared(systemInfoProvider.getMemoryShared());
			json.setTotal(systemInfoProvider.getMemoryTotal());
			json.setUsed(systemInfoProvider.getMemoryUsed());
			json.setVoltageC(systemInfoProvider.getMemoryVoltageSDRam_C());
			json.setVoltageI(systemInfoProvider.getMemoryVoltageSDRam_I());
			json.setVoltageP(systemInfoProvider.getMemoryVoltageSDRam_P());
			response.setBody(json);
			response.setResponseStatus(HttpResponseStatus.OK);
		} catch (IOException | InterruptedException e) {
			Logger.error(e, "Unexpected error during getSystemMemoryInfo().");
			response.setException(e);
		}

	}

	/**
	 * Retrieve everything concerning CPU from {@link SystemInfoProvider}.
	 * 
	 * @param request
	 *            the RestExpress request
	 * @param response
	 *            the RestExress response
	 */
	public void getSystemCpuInfo(Request request, Response response) {
		if (!handleCORS(request, response)) {
			return;
		}

		try {
			JSONSystemCpuInfo json = new JSONSystemCpuInfo();
			json.setArchitecture(systemInfoProvider.getCpuArchitecture());
			json.setFeatures(systemInfoProvider.getCpuFeatures());
			json.setImplementer(systemInfoProvider.getCpuImplementer());
			json.setPart(systemInfoProvider.getCpuPart());
			json.setRevision(systemInfoProvider.getCpuRevision());
			json.setTemperature(systemInfoProvider.getCpuTemperature());
			json.setVariant(systemInfoProvider.getCpuVariant());
			json.setVoltage(systemInfoProvider.getCpuVoltage());
			json.setBogoMips(systemInfoProvider.getBogoMIPS());
			response.setBody(json);
			response.setResponseStatus(HttpResponseStatus.OK);
		} catch (IOException | InterruptedException e) {
			Logger.error(e, "Unexpected error during getSystemCpuInfo().");
			response.setException(e);
		}

	}

	/**
	 * Retrieve everything concerning OS from {@link SystemInfoProvider}.
	 * 
	 * @param request
	 *            the RestExpress request
	 * @param response
	 *            the RestExress response
	 */
	public void getSystemOsInfo(Request request, Response response) {
		if (!handleCORS(request, response)) {
			return;
		}

		try {
			JSONSystemOsInfo json = new JSONSystemOsInfo();
			json.setArchitecture(systemInfoProvider.getOsArch());
			json.setFirmwareBuild(systemInfoProvider.getOsFirmwareBuild());
			json.setFirmwareDate(systemInfoProvider.getOsFirmwareDate());
			json.setName(systemInfoProvider.getOsName());
			json.setVersion(systemInfoProvider.getOsVersion());
			response.setBody(json);
			response.setResponseStatus(HttpResponseStatus.OK);
		} catch (IOException | InterruptedException | UnsupportedOperationException | ParseException e) {
			Logger.error(e, "Unexpected error during getSystemOsInfo().");
			response.setException(e);
		}
	}

	/**
	 * Retrieve codec and hard float abi information from
	 * {@link SystemInfoProvider}.
	 * 
	 * @param request
	 *            the RestExpress request
	 * @param response
	 *            the RestExress response
	 */
	public void getSystemFeaturesEnabledInfo(Request request, Response response) {
		if (!handleCORS(request, response)) {
			return;
		}

		try {
			JSONSystemFeaturesEnabledInfo json = new JSONSystemFeaturesEnabledInfo();
			json.setCodecH264(systemInfoProvider.getCodecH264Enabled());
			json.setCodecMpg2(systemInfoProvider.getCodecMPG2Enabled());
			json.setCodecWvc1(systemInfoProvider.getCodecWVC1Enabled());
			json.setHardFloatAbi(systemInfoProvider.isHardFloatAbi());
			response.setBody(json);
			response.setResponseStatus(HttpResponseStatus.OK);
		} catch (IOException | InterruptedException | UnsupportedOperationException e) {
			Logger.error(e, "Unexpected error during getSystemFeaturesEnabledInfo().");
			response.setException(e);
		}
	}

	/**
	 * Retrieve some basic board information from {@link SystemInfoProvider}.
	 * 
	 * @param request
	 *            the RestExpress request
	 * @param response
	 *            the RestExress response
	 */
	public void getSystemInfo(Request request, Response response) {
		if (!handleCORS(request, response)) {
			return;
		}

		try {
			JSONSystemInfo json = new JSONSystemInfo();
			json.setBoardType(systemInfoProvider.getBoardType().toString());
			json.setHardware(systemInfoProvider.getHardware());
			json.setModelName(systemInfoProvider.getModelName());
			json.setProcessor(systemInfoProvider.getProcessor());
			json.setRevision(systemInfoProvider.getRevision());
			json.setSerial(systemInfoProvider.getSerial());
			response.setBody(json);
			response.setResponseStatus(HttpResponseStatus.OK);
		} catch (IOException | InterruptedException | UnsupportedOperationException e) {
			Logger.error(e, "Unexpected error during getSystemInfo().");
			response.setException(e);
		}
	}

	private boolean handleCORS(Request request, Response response) {
		boolean continueProcessing = true;

		response.addHeader("Access-Control-Allow-Origin", this.allowedCorsOrigin);

		if (HttpMethod.OPTIONS.equals(request.getHttpMethod())) {
			response.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
			response.setResponseStatus(HttpResponseStatus.OK);
			continueProcessing = false;
		}

		return continueProcessing;
	}
}
