# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from service_apis.models.base_model_ import Model
from service_apis.models.data_format_any_of import DataFormatAnyOf
from service_apis import util

from service_apis.models.data_format_any_of import DataFormatAnyOf  # noqa: E501

class DataFormat(Model):
    """NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).

    Do not edit the class manually.
    """

    def __init__(self):  # noqa: E501
        """DataFormat - a model defined in OpenAPI

        """
        self.openapi_types = {
        }

        self.attribute_map = {
        }

    @classmethod
    def from_dict(cls, dikt) -> 'DataFormat':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The DataFormat of this DataFormat.  # noqa: E501
        :rtype: DataFormat
        """
        return util.deserialize_model(dikt, cls)
