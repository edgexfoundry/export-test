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

import org.edgexfoundry.domain.core.Event;
import org.edgexfoundry.domain.export.ExportMessage;
import org.edgexfoundry.domain.export.ExportRegistration;

public interface ExportMessageData {

	static ExportMessage newTestInstance() {
		ExportRegistration reg = RegistrationData.newTestInstance();
		Event event = EventData.newTestInstance();
		event.setDevice(RegistrationData.TEST_DEVICE_NAMES.get(0));
		ExportMessage msg = new ExportMessage(reg, event);
		return msg;
	}

}
