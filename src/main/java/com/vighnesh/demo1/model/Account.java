package com.vighnesh.demo1.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Account {
    String id;
    String email;
    String password;
}
