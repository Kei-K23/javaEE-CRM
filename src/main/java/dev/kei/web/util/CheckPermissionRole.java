package dev.kei.web.util;

public class CheckPermissionRole {
	public static boolean checkIsAdminRole(int role) {
		return role == 1;
	}
}
