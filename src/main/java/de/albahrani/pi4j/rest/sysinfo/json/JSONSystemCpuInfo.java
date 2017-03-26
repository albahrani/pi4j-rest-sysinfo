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

public class JSONSystemCpuInfo {

	private String architecture;
	private String[] features;
	private String implementer;
	private String part;
	private String revision;
	private Float temperature;
	private String variant;
	private Float voltage;
	private String bogoMips;

	public String getArchitecture() {
		return this.architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public String[] getFeatures() {
		return this.features;
	}

	public void setFeatures(String[] features) {
		this.features = features;
	}

	public String getImplementer() {
		return this.implementer;
	}

	public void setImplementer(String implementer) {
		this.implementer = implementer;
	}

	public String getPart() {
		return this.part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getRevision() {
		return this.revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public Float getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public String getVariant() {
		return this.variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public Float getVoltage() {
		return this.voltage;
	}

	public void setVoltage(Float voltage) {
		this.voltage = voltage;
	}

	public String getBogoMips() {
		return this.bogoMips;
	}

	public void setBogoMips(String bogoMips) {
		this.bogoMips = bogoMips;
	}
}
