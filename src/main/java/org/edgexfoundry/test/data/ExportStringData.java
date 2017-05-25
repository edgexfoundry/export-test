/*******************************************************************************
 * Copyright 2017 Dell Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @microservice:  export-test library
 * @author: Jim White, Dell
 * @version: 1.0.0
 *******************************************************************************/
package org.edgexfoundry.test.data;

import org.edgexfoundry.domain.export.ExportString;

public interface ExportStringData {
	
	static ExportString newTestInstance(){
		ExportString string = new ExportString();
		string.setEventId("12345");
		string.setEventString("{\"origin\":1471806386919,\"device\":\"livingroomthermostat\",\"readings\":[{\"origin\":1471806386919,\"name\":\"temperature\",\"value\":\"38\"}]}");
		string.setRegistration(RegistrationData.newTestInstance(), "12345");
		return string;
	}
}
