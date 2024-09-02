# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from capif_events.models.base_model_ import Model
from capif_events import util


class InvalidParam(Model):
    """NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).

    Do not edit the class manually.
    """

    def __init__(self, param=None, reason=None):  # noqa: E501
        """InvalidParam - a model defined in OpenAPI

        :param param: The param of this InvalidParam.  # noqa: E501
        :type param: str
        :param reason: The reason of this InvalidParam.  # noqa: E501
        :type reason: str
        """
        self.openapi_types = {
            'param': str,
            'reason': str
        }

        self.attribute_map = {
            'param': 'param',
            'reason': 'reason'
        }

        self._param = param
        self._reason = reason

    @classmethod
    def from_dict(cls, dikt) -> 'InvalidParam':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The InvalidParam of this InvalidParam.  # noqa: E501
        :rtype: InvalidParam
        """
        return util.deserialize_model(dikt, cls)

    @property
    def param(self):
        """Gets the param of this InvalidParam.

        Attribute's name encoded as a JSON Pointer, or header's name.  # noqa: E501

        :return: The param of this InvalidParam.
        :rtype: str
        """
        return self._param

    @param.setter
    def param(self, param):
        """Sets the param of this InvalidParam.

        Attribute's name encoded as a JSON Pointer, or header's name.  # noqa: E501

        :param param: The param of this InvalidParam.
        :type param: str
        """
        if param is None:
            raise ValueError("Invalid value for `param`, must not be `None`")  # noqa: E501

        self._param = param

    @property
    def reason(self):
        """Gets the reason of this InvalidParam.

        A human-readable reason, e.g. \"must be a positive integer\".  # noqa: E501

        :return: The reason of this InvalidParam.
        :rtype: str
        """
        return self._reason

    @reason.setter
    def reason(self, reason):
        """Sets the reason of this InvalidParam.

        A human-readable reason, e.g. \"must be a positive integer\".  # noqa: E501

        :param reason: The reason of this InvalidParam.
        :type reason: str
        """

        self._reason = reason
