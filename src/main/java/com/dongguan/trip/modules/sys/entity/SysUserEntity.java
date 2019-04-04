/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.dongguan.trip.modules.sys.entity;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:55
 */

@Entity
@Table(name = "sys_user")
@Setter
@Getter
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	*/
	@Id
	@JsonSerialize(using=ToStringSerializer.class)
	private Long userId;

	/**
	 * 用户名
	*/
	@Column(length = 255,unique=true)
	private String username;
	/**
	 * 加密的盐
	 */
	@Column(length = 255)
	private String salt;

	/**
	 * 用户真实名称
	 */
	@Column(length = 255)
	private String trueName;
	/**
	 * 密码
	 */

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(length = 255)
	private String password;
	/**
	 * 性别
	 */
	@Column(length = 4)
	private Integer gender;


	/**
	 * 手机号
	 */
	@Column(length = 255)
	private String mobile;

	/**
	 * 状态  0：正常   -1：不正常
	 */
	@Column(length = 4)
	private Integer status;

	/**
	 * 身份证
	 */
	@Column(length =18)
	private String idCode;
	/**
	 * 用户类别 0:普通 1:管理员
	 */
	@Column(length = 4)
	private Integer type;

	/**
	 * 创建时间
	 */
	@Column()
	private Date createTime;

	/**
	 * 更新时间
	 */
	@Column()
	private Date updateTime;

}
