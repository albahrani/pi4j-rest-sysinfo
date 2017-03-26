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

public class JSONSystemMemoryInfo {

	private Long buffers;
	private Long cached;
	private Long free;
	private Long shared;
	private Long total;
	private Long used;
	private Float voltageC;
	private Float voltageI;
	private Float voltageP;

	public Long getBuffers() {
		return this.buffers;
	}

	public void setBuffers(Long buffers) {
		this.buffers = buffers;
	}

	public Long getCached() {
		return this.cached;
	}

	public void setCached(Long cached) {
		this.cached = cached;
	}

	public Long getFree() {
		return this.free;
	}

	public void setFree(Long free) {
		this.free = free;
	}

	public Long getShared() {
		return this.shared;
	}

	public void setShared(Long shared) {
		this.shared = shared;
	}

	public Long getTotal() {
		return this.total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getUsed() {
		return this.used;
	}

	public void setUsed(Long used) {
		this.used = used;
	}

	public Float getVoltageC() {
		return this.voltageC;
	}

	public void setVoltageC(Float voltageC) {
		this.voltageC = voltageC;
	}

	public Float getVoltageI() {
		return this.voltageI;
	}

	public void setVoltageI(Float voltageI) {
		this.voltageI = voltageI;
	}

	public Float getVoltageP() {
		return this.voltageP;
	}

	public void setVoltageP(Float voltageP) {
		this.voltageP = voltageP;
	}

}
