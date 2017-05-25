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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.edgexfoundry.domain.export.EncryptionDetails;
import org.edgexfoundry.domain.export.ExportCompression;
import org.edgexfoundry.domain.export.ExportDestination;
import org.edgexfoundry.domain.export.ExportEncryption;
import org.edgexfoundry.domain.export.ExportFilter;
import org.edgexfoundry.domain.export.ExportFormat;
import org.edgexfoundry.domain.export.ExportRegistration;
import org.edgexfoundry.domain.meta.Addressable;
import org.edgexfoundry.domain.meta.Protocol;

public interface RegistrationData {

	static final String TEST_NAME = "NORTH_CLIENT.NAME";
	// for embedded addressable
	static final String TEST_ADDR_NAME = "MQTT_PIPE";
	static final Protocol TEST_PROTOCOL = Protocol.TCP;
	static final String TEST_ADDRESS = "tcp://m10.cloudmqtt.com";
	static final int TEST_PORT = 15421;
	static final String TEST_PATH = "";
	static final String TEST_PUBLISHER = "EdgeXExportPublisher";
	static final String TEST_USER = "hukfgtoh";
	static final String TEST_PASSWORD = "uP6hJLYW6Ji4";
	static final String TEST_TOPIC = "EdgeXDataTopic";
	static final ExportFormat TEST_FORMAT = ExportFormat.JSON;
	static final ExportEncryption TEST_ENCRYPT = ExportEncryption.AES;
	static final String TEST_KEY = "abc";
	static final String TEST_VECTOR = "123";
	static final String[] TEST_DEVICES = { "livingroomthermosat", "hallwaythermostat" };
	static final String[] TEST_DESCRIPTORS = { "temperature", "humidity" };
	static final List<String> TEST_DEVICE_NAMES = Arrays.asList(TEST_DEVICES);
	static final List<String> TEST_VALUE_DESCRIPTOR_NAMES = Arrays.asList(TEST_DESCRIPTORS);
	static final ExportCompression TEST_COMPRESSION = ExportCompression.GZIP;
	static final boolean TEST_ENABLED = true;
	static final int TEST_ORIGIN = 123;
	static final ExportDestination TEST_DESTINATION = ExportDestination.REST_ENDPOINT;

	static ExportRegistration newTestInstance() {
		ExportRegistration registration = new ExportRegistration();
		Addressable addressable = new Addressable(TEST_ADDR_NAME, TEST_PROTOCOL, TEST_ADDRESS, TEST_PORT,
				TEST_PUBLISHER, TEST_USER, TEST_PASSWORD, TEST_TOPIC);
		addressable.setPath(TEST_PATH);
		registration.setAddressable(addressable);
		registration.setCompression(TEST_COMPRESSION);
		registration.setEnable(TEST_ENABLED);
		EncryptionDetails details = new EncryptionDetails();
		details.setEncryptionAlgorithm(TEST_ENCRYPT);
		details.setEncryptionKey(TEST_KEY);
		details.setInitializingVector(TEST_VECTOR);
		registration.setEncryption(details);
		ExportFilter filter = new ExportFilter();
		filter.setDeviceIdentifiers(TEST_DEVICE_NAMES);
		filter.setValueDescriptorIdentifiers(TEST_VALUE_DESCRIPTOR_NAMES);
		registration.setFilter(filter);
		registration.setFormat(TEST_FORMAT);
		registration.setDestination(TEST_DESTINATION);
		registration.setName(TEST_NAME);
		registration.setOrigin(TEST_ORIGIN);
		return registration;
	}

	static void checkTestData(ExportRegistration registration, String id) {
		assertEquals("Registration ID does not match saved id", id, registration.getId());
		assertEquals("Registration addressable name does not match saved name", TEST_ADDR_NAME,
				registration.getAddressable().getName());
		assertEquals("Registration addressable protocol does not match saved protocol", TEST_PROTOCOL,
				registration.getAddressable().getProtocol());
		assertEquals("Registration addressable address does not match saved address", TEST_ADDRESS,
				registration.getAddressable().getAddress());
		assertEquals("Registration addressable port does not match saved port", TEST_PORT,
				registration.getAddressable().getPort());
		assertEquals("Registration addressable publisher does not match saved publisher", TEST_PUBLISHER,
				registration.getAddressable().getPublisher());
		assertEquals("Registration addressable user does not match saved user", TEST_USER,
				registration.getAddressable().getUser());
		assertEquals("Registration addressable password does not match saved password", TEST_PASSWORD,
				registration.getAddressable().getPassword());
		assertEquals("Registration addressable topic does not match saved topic", TEST_TOPIC,
				registration.getAddressable().getTopic());
		assertEquals("Registration compression does not match saved compression", TEST_COMPRESSION,
				registration.getCompression());
		assertEquals("Registration enabled does not match saved enabled", TEST_ENABLED, registration.isEnable());
		assertEquals("Registration encrypt algorithm does not match saved encrypt algorithm", TEST_ENCRYPT,
				registration.getEncryption().getEncryptionAlgorithm());
		assertEquals("Registration encrypt key does not match saved encrypt key", TEST_KEY,
				registration.getEncryption().getEncryptionKey());
		assertEquals("Registration encrypt vector does not match saved encrypt vector", TEST_VECTOR,
				registration.getEncryption().getInitializingVector());
		assertEquals("Registration device filter does not match saved device filter", TEST_DEVICE_NAMES,
				registration.getFilter().getDeviceIdentifiers());
		assertEquals("Registration value descriptor filter does not match saved value descriptor filter",
				TEST_VALUE_DESCRIPTOR_NAMES, registration.getFilter().getValueDescriptorIdentifiers());
		assertEquals("Registration format does not match saved format", TEST_FORMAT, registration.getFormat());
		assertEquals("Registration destination does not match saved  destintation", TEST_DESTINATION, registration.getDestination());
		assertEquals("Registration name does not match saved name", TEST_NAME, registration.getName());
		assertEquals("Registration origin does not match saved origin", TEST_ORIGIN, registration.getOrigin());
		assertNotNull("Registration modified date is null", registration.getModified());
		assertNotNull("Registration create date is null", registration.getCreated());
	}

}
