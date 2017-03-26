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

public class JSONSystemFeaturesEnabledInfo {

	private Boolean codecH264;
	private Boolean codecMpg2;
	private Boolean codecWvc1;
	private Boolean hardFloatAbi;

	public Boolean getCodecH264() {
		return this.codecH264;
	}

	public void setCodecH264(Boolean codecH264) {
		this.codecH264 = codecH264;
	}

	public Boolean getCodecMpg2() {
		return this.codecMpg2;
	}

	public void setCodecMpg2(Boolean codecMpg2) {
		this.codecMpg2 = codecMpg2;
	}

	public Boolean getCodecWvc1() {
		return this.codecWvc1;
	}

	public void setCodecWvc1(Boolean codecWvc1) {
		this.codecWvc1 = codecWvc1;
	}

	public Boolean getHardFloatAbi() {
		return this.hardFloatAbi;
	}

	public void setHardFloatAbi(Boolean hardFloatAbi) {
		this.hardFloatAbi = hardFloatAbi;
	}

}
