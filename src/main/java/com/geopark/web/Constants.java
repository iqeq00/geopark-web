package com.geopark.web;

/**
 * 常量类 common
 * 
 * @lichee
 */
public class Constants {

	public final static String ZERO = "0";
	public final static String ONE = "1";

	public static final String CharSetName = "utf8";

	/**
	 * 服务器端想app前端返回的代码
	 * 
	 * @author Administrator
	 *
	 */
	public class ServerApp {
		/** 成功 **/
		public final static String SERVER_RET_SUSSCESS = "0";
		/** 失败 **/
		public final static String SERVER_RET_FAILURE = "1";
	}

	public class CacheTime {
		/** app用户登录token缓存时间 **/

		public final static int APP_USER_TOKEN = 2 * 24 * 3600;

		/** app用户登录refeshtoken缓存时间 **/
		public final static int APP_USER_REFRESHTOEKN = 30 * 24 * 3600;

		/** 手机验证码缓存时间 **/
		public static final int SMS_VALID = 60 * 5;
	}


	public class ServerCode {
		/** 服务器通信成功、业务操作成功的状态码 **/
		public final static String SERVER_RET_SUSSCESS = "0";

		/** 服务器通信成功、业务操作失败的状态码 **/
		public final static String SERVER_RET_FAILER = "1";
		/** 未授权 **/
		public final static String SERVER_401 = "401";
	}

	public class UsedStatus {
		/** 状态可用 **/
		public final static String USABLE = "1";
		/** 状态不可用 **/
		public final static String UNUSABLE = "0";

	}

	public class Message {

		/************************
		 * 系统管理或通用消息
		 *************************/
		/** 操作成功 **/
		public final static String OPTION_SUCCESS = "操作成功";
		/** 操作失败 **/
		public final static String OPTION_FAILURE = "操作失败";
		/** 操作失败，没有对应权限 **/
		public final static String OPTION_FAILURE_NO_PERMISSION = "操作失败,没有权限";
		/** 代码或名称已存在 **/
		public final static String ADD_UPDATE_PROP_EXIST = "数据库已存在同名属性";
		/** 角色代码已存在 **/
		public final static String ROLE_CODENAME_EXIST = "角色代码或名称已存在";
		/** 角色已分配权限 **/
		public final static String ROLE_EXIST_PERMISSION = "角色已分配权限,请先解除角色权限关系";
	}

	public class RedisIndex {

		/* session在redis 中 的dbIndex */
		// public final static int SESSION_INDEX=0;

		/* 普通用户登录key 存放在redis中的 dbIndex */
		public final static int USER_LOGIN_INDEX = 1;

		/* 代理用户登录key 存放在redis中的 dbIndex */
		public final static int AGENT_LOGIN_INDEX = 2;
	}

	public class Picture {
		public static final String defaultSplit = ";";
		public static final String semicolonSplit = ",";
	}

	public class BizCode {
		public static final String LOGIN_SUCCESS = "1";
		public static final String LOGIN_FAIL = "0";
	}
	
	/*角色*/
	public class Role {
		/*系统管理员*/
		public static final String admin = "admin";
		
		/**
		 * bz admin
		 */
		public static final String bzadmin = "bzadmin";
	}

	/** 业务校验通过 **/
	public static final String SUCCESS = "success";
}
