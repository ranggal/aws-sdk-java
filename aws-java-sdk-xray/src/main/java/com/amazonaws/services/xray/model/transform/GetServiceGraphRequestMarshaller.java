/*
 * Copyright 2012-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.xray.model.transform;

import java.io.ByteArrayInputStream;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.xray.model.*;
import com.amazonaws.transform.Marshaller;

import com.amazonaws.protocol.json.*;

/**
 * GetServiceGraphRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetServiceGraphRequestMarshaller implements Marshaller<Request<GetServiceGraphRequest>, GetServiceGraphRequest> {

    private final SdkJsonMarshallerFactory protocolFactory;

    public GetServiceGraphRequestMarshaller(SdkJsonMarshallerFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<GetServiceGraphRequest> marshall(GetServiceGraphRequest getServiceGraphRequest) {

        if (getServiceGraphRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        Request<GetServiceGraphRequest> request = new DefaultRequest<GetServiceGraphRequest>(getServiceGraphRequest, "AWSXRay");

        request.setHttpMethod(HttpMethodName.POST);

        String uriResourcePath = "/ServiceGraph";

        request.setResourcePath(uriResourcePath);

        try {
            final StructuredJsonGenerator jsonGenerator = protocolFactory.createGenerator();
            jsonGenerator.writeStartObject();

            if (getServiceGraphRequest.getStartTime() != null) {
                jsonGenerator.writeFieldName("StartTime").writeValue(getServiceGraphRequest.getStartTime());
            }
            if (getServiceGraphRequest.getEndTime() != null) {
                jsonGenerator.writeFieldName("EndTime").writeValue(getServiceGraphRequest.getEndTime());
            }
            if (getServiceGraphRequest.getNextToken() != null) {
                jsonGenerator.writeFieldName("NextToken").writeValue(getServiceGraphRequest.getNextToken());
            }

            jsonGenerator.writeEndObject();

            byte[] content = jsonGenerator.getBytes();
            request.setContent(new ByteArrayInputStream(content));
            request.addHeader("Content-Length", Integer.toString(content.length));
            if (!request.getHeaders().containsKey("Content-Type")) {
                request.addHeader("Content-Type", protocolFactory.getContentType());
            }
        } catch (Throwable t) {
            throw new SdkClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}
