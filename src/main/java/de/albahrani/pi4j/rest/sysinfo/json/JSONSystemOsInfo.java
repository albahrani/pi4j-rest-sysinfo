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

public class JSONSystemOsInfo {

	private String architecture;
	private String firmwareBuild;
	private String firmwareDate;
	private String name;
	private String version;

	public String getArchitecture() {
		return this.architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public String getFirmwareBuild() {
		return this.firmwareBuild;
	}

	public void setFirmwareBuild(String firmwareBuild) {
		this.firmwareBuild = firmwareBuild;
	}

	public String getFirmwareDate() {
		return this.firmwareDate;
	}

	public void setFirmwareDate(String firmwareDate) {
		this.firmwareDate = firmwareDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
