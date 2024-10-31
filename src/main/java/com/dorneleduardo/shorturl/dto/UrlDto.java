package com.dorneleduardo.shorturl.dto;

import jakarta.validation.constraints.NotNull;

public record UrlDto(@NotNull String url) {


}
