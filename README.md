[![Build Status](https://travis-ci.org/albahrani/pi4j-rest-sysinfo.svg?branch=master)](https://travis-ci.org/albahrani/pi4j-rest-sysinfo)
[![Quality Gate](https://sonarqube.com/api/badges/gate?key=com.github.albahrani:pi4j-rest-sysinfo)](https://sonarqube.com/dashboard/index/com.github.albahrani:pi4j-rest-sysinfo)
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

## USAGE
### Attach the system info services to a RestExpress instance.
```Java
	RestExpress server = new RestExpress();
	server.setName("Raspi System Info Server");
	RaspberrySystemInfoController controller = new RaspberrySystemInfoController();
	controller.attach(server, "/raspberry/systeminfo");
	server.bind();
```
