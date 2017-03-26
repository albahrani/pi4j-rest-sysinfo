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
package de.albahrani.pi4j.rest.sysinfo.json;

public class JSONSystemClockInfo {

	private Long arm;
	private Long core;
	private Long dpi;
	private Long emmc;
	private Long h264;
	private Long hdmi;
	private Long isp;
	private Long pixel;
	private Long pwm;
	private Long uart;
	private Long v3d;
	private Long vec;

	public Long getArm() {
		return this.arm;
	}

	public void setArm(Long arm) {
		this.arm = arm;
	}

	public Long getCore() {
		return this.core;
	}

	public void setCore(Long core) {
		this.core = core;
	}

	public Long getDpi() {
		return this.dpi;
	}

	public void setDpi(Long dpi) {
		this.dpi = dpi;
	}

	public Long getEmmc() {
		return this.emmc;
	}

	public void setEmmc(Long emmc) {
		this.emmc = emmc;
	}

	public Long getH264() {
		return this.h264;
	}

	public void setH264(Long h264) {
		this.h264 = h264;
	}

	public Long getHdmi() {
		return this.hdmi;
	}

	public void setHdmi(Long hdmi) {
		this.hdmi = hdmi;
	}

	public Long getIsp() {
		return this.isp;
	}

	public void setIsp(Long isp) {
		this.isp = isp;
	}

	public Long getPixel() {
		return this.pixel;
	}

	public void setPixel(Long pixel) {
		this.pixel = pixel;
	}

	public Long getPwm() {
		return this.pwm;
	}

	public void setPwm(Long pwm) {
		this.pwm = pwm;
	}

	public Long getUart() {
		return this.uart;
	}

	public void setUart(Long uart) {
		this.uart = uart;
	}

	public Long getV3d() {
		return this.v3d;
	}

	public void setV3d(Long v3d) {
		this.v3d = v3d;
	}

	public Long getVec() {
		return this.vec;
	}

	public void setVec(Long vec) {
		this.vec = vec;
	}

}
