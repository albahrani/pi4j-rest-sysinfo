[![Release](https://jitpack.io/v/albahrani/pi4j-rest-sysinfo.svg)](https://jitpack.io/#albahrani/pi4j-rest-sysinfo)
[![Build](https://jitci.com/gh/albahrani/pi4j-rest-sysinfo/svg)](https://jitci.com/gh/albahrani/pi4j-rest-sysinfo)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.github.albahrani%3Api4j-rest-sysinfo&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.github.albahrani%3Api4j-rest-sysinfo)
[![codebeat badge](https://codebeat.co/badges/73611634-3b3a-44d2-a83a-ca19139257ca)](https://codebeat.co/projects/github-com-albahrani-pi4j-rest-sysinfo-master)
[![Known Vulnerabilities](https://snyk.io/test/github/albahrani/pi4j-rest-sysinfo/badge.svg?targetFile=pom.xml)](https://snyk.io/test/github/albahrani/pi4j-rest-sysinfo?targetFile=pom.xml)
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Falbahrani%2Fpi4j-rest-sysinfo.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2Falbahrani%2Fpi4j-rest-sysinfo?ref=badge_shield)
[![Hits-of-Code](https://hitsofcode.com/github/albahrani/pi4j-rest-sysinfo)](https://hitsofcode.com/view/github/albahrani/pi4j-rest-sysinfo)

# pi4j-rest-sysinfo | raspberry system info via rest
Make the pi4j SystemInfo implementation available via REST service using RestExpress.
This project provides a plugin mechanism to add the system info services to any existing RestExpress server instance.

## PROJECT INFORMATION

Project website: https://github.com/albahrani/pi4j-rest-sysinfo <br />
Project issues list: https://github.com/albahrani/pi4j-rest-sysinfo/issues <br />
<br />
Release builds are not yet available.

Snapshot builds are available via
```xml
  <dependency>
    <groupId>com.github.albahrani</groupId>
    <artifactId>pi4j-rest-sysinfo</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  </dependency>
  ...
  <repository>
    <id>sonatype-snapshots-repo</id>
    <url>https://oss.sonatype.org/content/repositories/snapshots</url>
    <releases><enabled>false</enabled></releases>
    <snapshots><enabled>true</enabled></snapshots>
  </repository>
```

## LICENSE
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0
  
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.


[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Falbahrani%2Fpi4j-rest-sysinfo.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Falbahrani%2Fpi4j-rest-sysinfo?ref=badge_large)

## USAGE
### Attach the SystemInfo services to a RestExpress instance.
```Java
	RestExpress server = new RestExpress();
	server.setName("Raspi System Info Server");
	RaspberrySystemInfoController controller = new RaspberrySystemInfoController();
	controller.attach(server, "/raspberry/systeminfo");
	server.bind();
```

## REST Services
 * **GET <baseUri>/clock**
 Provides information about the Raspberry Pi clock frequencies (Arm, Core, DPI, EMMC, H264, HDMI, ISP, Pixel, PWM, UART, V3D and VEC).
 * **GET <baseUri>/java**
 Provides information about Raspberry Pi Java VM (runtime, vendor name, vendor url, version and name).
 * **GET <baseUri>/memory**
 Provides information about the Raspberry Pi memory (buffers, cached, free, shared, total, used and the sdram voltages).
 * **GET <baseUri>/cpu**
 Provides information about the Raspberry Pi cpu (architecture, features, implementer, part, revision, temperature, variant and voltage).
 * **GET <baseUri>/os**
 Provides information about the Raspberry Pi OS (architecture, firmware build, firmware date, name and version).
 * **GET <baseUri>/features**
 Provides information about the Raspberry Pi enabled features (h264, mpg2, wvc1 and hard float abi).
 * **GET <baseUri>**
 Provides information about the Raspberry Pi (board type, hardware, model name, processor, revision and serial).
