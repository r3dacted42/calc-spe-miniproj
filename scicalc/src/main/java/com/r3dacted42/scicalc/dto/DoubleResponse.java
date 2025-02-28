package com.r3dacted42.scicalc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DoubleResponse(@JsonProperty("value") Double value) {
}
