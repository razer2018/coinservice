package com.coindemo.common.role;

public enum RoleType {


	ADMIN(10L, "管理员"), 
	USER(20L, "用户");

	private Long id;
	private String name;

	private RoleType(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static String getName(byte type) {
		RoleType[] rtypes = RoleType.values();
		String result = "";
		for (RoleType rtype : rtypes) {
			if (type == rtype.getId()) {
				result = rtype.getName();
				break;
			}
		}
		return result;
	}
}