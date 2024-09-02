def create_service_api_description(api_name="service_1",aef_id="aef_id"):
    return {
        "apiName": api_name,
        "aefProfiles": [
            {
                "aefId": aef_id,
                "versions": [
                    {
                        "apiVersion": "v1",
                        "expiry": "2021-11-30T10:32:02.004000Z",
                        "resources": [
                            {
                                "resourceName": "string",
                                "commType": "REQUEST_RESPONSE",
                                "uri": "string",
                                "custOpName": "string",
                                "operations": [
                                    "GET"
                                ],
                                "description": "string"
                            }
                        ],
                        "custOperations": [
                            {
                                "commType": "REQUEST_RESPONSE",
                                "custOpName": "string",
                                "operations": [
                                    "GET"
                                ],
                                "description": "string"
                            }
                        ]
                    }
                ],
                "protocol": "HTTP_1_1",
                "dataFormat": "JSON",
                "securityMethods": ["PSK"],
                "interfaceDescriptions": [
                    {
                        "ipv4Addr": "string",
                        "port": 65535,
                        "securityMethods": ["PSK"]
                    },
                    {
                        "ipv4Addr": "string",
                        "port": 65535,
                        "securityMethods": ["PSK"]
                    }
                ]
            }
        ],
        "description": "ROBOT_TESTING",
        "supportedFeatures": "fffff",
        "shareableInfo": {
            "isShareable": True,
            "capifProvDoms": [
                "string"
            ]
        },
        "serviceAPICategory": "string",
        "apiSuppFeats": "fffff",
        "pubApiPath": {
            "ccfIds": [
                "string"
            ]
        },
        "ccfId": "string"
    }
