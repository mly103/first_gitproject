package com.mly.demodev.test1.bean;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * User实体类
 * @author Administrator
 *
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
//@EqualsAndHashCode(callSuper=true)
public class User {

	private String username;
	private String password;
	private int age;
}
