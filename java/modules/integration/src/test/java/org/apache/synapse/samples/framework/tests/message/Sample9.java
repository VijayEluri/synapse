/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.synapse.samples.framework.tests.message;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.samples.framework.SampleClientResult;
import org.apache.synapse.samples.framework.SynapseTestCase;
import org.apache.synapse.samples.framework.clients.StockQuoteSampleClient;

public class Sample9 extends SynapseTestCase {

    private static final Log log = LogFactory.getLog(Sample9.class);

    private StockQuoteSampleClient client;

    public Sample9() {
        super(9);
        client = getStockQuoteClient();
    }


    public void testDynamicSequences() {
        String addUrl = "http://localhost:9000/services/SimpleStockQuoteService";
        String trpUrl = "http://localhost:8280/";

        log.info("Running test: Dynamic Sequences with Registry");
        SampleClientResult result = client.requestStandardQuote(addUrl, trpUrl, null, "IBM" ,null);
        assertResponseReceived(result);
    }

}
