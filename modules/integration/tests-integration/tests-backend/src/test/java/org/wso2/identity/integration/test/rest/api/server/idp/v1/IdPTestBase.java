/*
 *  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.identity.integration.test.rest.api.server.idp.v1;

import io.restassured.RestAssured;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.wso2.identity.integration.test.rest.api.server.common.RESTAPIServerTestBase;

import java.io.IOException;

public class IdPTestBase extends RESTAPIServerTestBase {

    public static final String API_DEFINITION_NAME = "idp.yaml";
    public static final String API_VERSION = "v1";
    public static final String API_PACKAGE_NAME = "org.wso2.carbon.identity.api.server.idp.v1";
    public static final String IDP_API_BASE_PATH = "/identity-providers";
    public static final String PATH_SEPARATOR = "/";
    public static final String IDP_FEDERATED_AUTHENTICATORS_PATH = "federated-authenticators";
    public static final String IDP_PROVISIONING_PATH = "provisioning";
    public static final String IDP_OUTBOUND_CONNECTORS_PATH = "outbound-connectors";
    public static final String IDP_JIT_PATH = "jit";
    public static final String IDP_CLAIMS_PATH = "claims";
    public static final String IDP_ROLES_PATH = "roles";
    public static final String META_FEDERATED_AUTHENTICATORS_PATH = "meta/federated-authenticators";
    public static final String META_OUTBOUND_CONNECTORS_PATH = "meta/outbound-provisioning-connectors";
    public static final String IDP_TEMPLATE_PATH = "templates";
    public static final String SAMPLE_FEDERATED_AUTHENTICATOR_ID = "R29vZ2xlT0lEQ0F1dGhlbnRpY2F0b3I";
    public static final String SAMPLE_OUTBOUND_CONNECTOR_ID = "c2NpbQ";

    protected static String swaggerDefinition;

    static {
        try {
            swaggerDefinition = getAPISwaggerDefinition(API_PACKAGE_NAME, API_DEFINITION_NAME);
        } catch (IOException e) {
            Assert.fail(String.format("Unable to read the swagger definition %s from %s", API_DEFINITION_NAME,
                    API_PACKAGE_NAME), e);
        }
    }

    @AfterClass(alwaysRun = true)
    public void testConclude() throws Exception {

        super.conclude();
    }

    @BeforeMethod(alwaysRun = true)
    public void testInit() {

        RestAssured.basePath = basePath;
    }

    @AfterMethod(alwaysRun = true)
    public void testFinish() {

        RestAssured.basePath = StringUtils.EMPTY;
    }
}
