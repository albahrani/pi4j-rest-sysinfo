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

import com.pi4j.system.SystemInfo.BoardType;
import com.pi4j.system.SystemInfoFactory;
import com.pi4j.system.SystemInfoProvider;

/**
 * <h1>Pi4jSystemInfoFacade</h1>
 * 
 * <p>
 * This class is a wrapper for pi4j's {@link SystemInfoFactory}. It just
 * delegates all method calls. The main reason for this class is to allow easy
 * mocking for unit tests.
 * </p>
 * 
 * @author Sir-Aliman
 *
 */
public class Pi4jSystemInfoFacade {
	private SystemInfoProvider systemInfoProvider = SystemInfoFactory.getProvider();

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getProcessor()
	 */
	String getProcessor() throws IOException, InterruptedException {
		return this.systemInfoProvider.getProcessor();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getModelName()
	 */
	String getModelName() throws IOException, InterruptedException {
		return this.systemInfoProvider.getModelName();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getBogoMIPS()
	 */
	String getBogoMIPS() throws IOException, InterruptedException {
		return this.systemInfoProvider.getBogoMIPS();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getCpuFeatures()
	 */
	String[] getCpuFeatures() throws IOException, InterruptedException {
		return this.systemInfoProvider.getCpuFeatures();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getCpuImplementer()
	 */
	String getCpuImplementer() throws IOException, InterruptedException {
		return this.systemInfoProvider.getCpuImplementer();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getCpuArchitecture()
	 */
	String getCpuArchitecture() throws IOException, InterruptedException {
		return this.systemInfoProvider.getCpuArchitecture();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getCpuVariant()
	 */
	String getCpuVariant() throws IOException, InterruptedException {
		return this.systemInfoProvider.getCpuVariant();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getCpuPart()
	 */
	String getCpuPart() throws IOException, InterruptedException {
		return this.systemInfoProvider.getCpuPart();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getCpuRevision()
	 */
	String getCpuRevision() throws IOException, InterruptedException {
		return this.systemInfoProvider.getCpuRevision();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getHardware()
	 */
	String getHardware() throws IOException, InterruptedException {
		return this.systemInfoProvider.getHardware();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getRevision()
	 */
	String getRevision() throws IOException, InterruptedException {
		return this.systemInfoProvider.getRevision();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getSerial()
	 */
	String getSerial() throws IOException, InterruptedException {
		return this.systemInfoProvider.getSerial();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getOsName()
	 */
	String getOsName() {
		return this.systemInfoProvider.getOsName();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getOsVersion()
	 */
	String getOsVersion() {
		return this.systemInfoProvider.getOsVersion();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getOsArch()
	 */
	String getOsArch() {
		return this.systemInfoProvider.getOsArch();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getOsFirmwareBuild()
	 */
	String getOsFirmwareBuild() throws IOException, InterruptedException {
		return this.systemInfoProvider.getOsFirmwareBuild();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getOsFirmwareDate()
	 */
	String getOsFirmwareDate() throws IOException, InterruptedException, ParseException {
		return this.systemInfoProvider.getOsFirmwareDate();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getJavaVendor()
	 */
	String getJavaVendor() {
		return this.systemInfoProvider.getJavaVendor();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getJavaVendorUrl()
	 */
	String getJavaVendorUrl() {
		return this.systemInfoProvider.getJavaVendorUrl();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getJavaVersion()
	 */
	String getJavaVersion() {
		return this.systemInfoProvider.getJavaVersion();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getJavaVirtualMachine()
	 */
	String getJavaVirtualMachine() {
		return this.systemInfoProvider.getJavaVirtualMachine();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getJavaRuntime()
	 */
	String getJavaRuntime() {
		return this.systemInfoProvider.getJavaRuntime();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#isHardFloatAbi()
	 */
	boolean isHardFloatAbi() {
		return this.systemInfoProvider.isHardFloatAbi();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getMemoryTotal()
	 */
	long getMemoryTotal() throws IOException, InterruptedException {
		return this.systemInfoProvider.getMemoryTotal();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getMemoryUsed()
	 */
	long getMemoryUsed() throws IOException, InterruptedException {
		return this.systemInfoProvider.getMemoryUsed();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getMemoryFree()
	 */
	long getMemoryFree() throws IOException, InterruptedException {
		return this.systemInfoProvider.getMemoryFree();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getMemoryShared()
	 */
	long getMemoryShared() throws IOException, InterruptedException {
		return this.systemInfoProvider.getMemoryShared();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getMemoryBuffers()
	 */
	long getMemoryBuffers() throws IOException, InterruptedException {
		return this.systemInfoProvider.getMemoryBuffers();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getMemoryCached()
	 */
	long getMemoryCached() throws IOException, InterruptedException {
		return this.systemInfoProvider.getMemoryCached();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getBoardType()
	 */
	BoardType getBoardType() throws IOException, InterruptedException {
		return this.systemInfoProvider.getBoardType();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getCpuTemperature()
	 */
	float getCpuTemperature() throws IOException, InterruptedException {
		return this.systemInfoProvider.getCpuTemperature();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getCpuVoltage()
	 */
	float getCpuVoltage() throws IOException, InterruptedException {
		return this.systemInfoProvider.getCpuVoltage();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getMemoryVoltageSDRam_C()
	 */
	float getMemoryVoltageSDRam_C() throws IOException, InterruptedException {
		return this.systemInfoProvider.getMemoryVoltageSDRam_C();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getMemoryVoltageSDRam_I()
	 */
	float getMemoryVoltageSDRam_I() throws IOException, InterruptedException {
		return this.systemInfoProvider.getMemoryVoltageSDRam_I();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getMemoryVoltageSDRam_P()
	 */
	float getMemoryVoltageSDRam_P() throws IOException, InterruptedException {
		return this.systemInfoProvider.getMemoryVoltageSDRam_P();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getCodecH264Enabled()
	 */
	boolean getCodecH264Enabled() throws IOException, InterruptedException {
		return this.systemInfoProvider.getCodecH264Enabled();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getCodecMPG2Enabled()
	 */
	boolean getCodecMPG2Enabled() throws IOException, InterruptedException {
		return this.systemInfoProvider.getCodecMPG2Enabled();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getCodecWVC1Enabled()
	 */
	boolean getCodecWVC1Enabled() throws IOException, InterruptedException {
		return this.systemInfoProvider.getCodecWVC1Enabled();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getClockFrequencyArm()
	 */
	long getClockFrequencyArm() throws IOException, InterruptedException {
		return this.systemInfoProvider.getClockFrequencyArm();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getClockFrequencyCore()
	 */
	long getClockFrequencyCore() throws IOException, InterruptedException {
		return this.systemInfoProvider.getClockFrequencyCore();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getClockFrequencyH264()
	 */
	long getClockFrequencyH264() throws IOException, InterruptedException {
		return this.systemInfoProvider.getClockFrequencyH264();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getClockFrequencyISP()
	 */
	long getClockFrequencyISP() throws IOException, InterruptedException {
		return this.systemInfoProvider.getClockFrequencyISP();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getClockFrequencyV3D()
	 */
	long getClockFrequencyV3D() throws IOException, InterruptedException {
		return this.systemInfoProvider.getClockFrequencyV3D();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getClockFrequencyUART()
	 */
	long getClockFrequencyUART() throws IOException, InterruptedException {
		return this.systemInfoProvider.getClockFrequencyUART();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getClockFrequencyPWM()
	 */
	long getClockFrequencyPWM() throws IOException, InterruptedException {
		return this.systemInfoProvider.getClockFrequencyPWM();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getClockFrequencyEMMC()
	 */
	long getClockFrequencyEMMC() throws IOException, InterruptedException {
		return this.systemInfoProvider.getClockFrequencyEMMC();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getClockFrequencyPixel()
	 */
	long getClockFrequencyPixel() throws IOException, InterruptedException {
		return this.systemInfoProvider.getClockFrequencyPixel();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getClockFrequencyVEC()
	 */
	long getClockFrequencyVEC() throws IOException, InterruptedException {
		return this.systemInfoProvider.getClockFrequencyVEC();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getClockFrequencyHDMI()
	 */
	long getClockFrequencyHDMI() throws IOException, InterruptedException {
		return this.systemInfoProvider.getClockFrequencyHDMI();
	}

	/**
	 * @see com.pi4j.system.SystemInfoProvider#getClockFrequencyDPI()
	 */
	long getClockFrequencyDPI() throws IOException, InterruptedException {
		return this.systemInfoProvider.getClockFrequencyDPI();
	}
}
