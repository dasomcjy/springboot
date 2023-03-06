package com.mysite.member;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCreateForm {


    private Long id;

    private String name;

    private String email;

    private String password;

    private String address;

	}


