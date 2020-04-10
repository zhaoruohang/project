package com.zrh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zrh.entity.Kfz;
import com.zrh.entity.Roles;
import com.zrh.entity.Users;
import com.zrh.servicre.UserService;
import com.zrh.util.RedisService;
import com.zrh.util.Result;

@RestController
@Transactional
public class UserController {
	@Resource(name = "userServiceImpl")
	private UserService userServiceImpl;
	@Resource(name = "redisService")
	private RedisService redisService;
	/*
	 * ��ѯ
	 */

	@RequestMapping("/getAll")
	@ResponseBody
	public String getAll(String userName, String beginDate, String endDate, String isLock, Integer limit,
			Integer page) {
		int page1 = (page - 1) * limit;
		List<Users> u = userServiceImpl.getAll(userName, beginDate, endDate, isLock, limit, page1);
		int count = userServiceImpl.getConut(userName, beginDate, endDate, isLock);
		String dd = Result.toClient("0", "", count, u);
		return dd;
	}

	/*
	 * ���
	 */
	@PostMapping("/addUser")
	public String addU(String id_a, String name_a, String pass_a, String suo_a) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String CreateTime = sdf.format(new Date());
		int a = userServiceImpl.addUser(id_a, name_a, pass_a, suo_a, CreateTime);
		String dd = null;
		if (a != 0) {
			dd = Result.toClient("0", "��ӳɹ�");
		} else {
			dd = Result.toClient("1", "���ʧ��");
		}
		return dd;
	}

	/*
	 * ɾ��
	 */
	@RequestMapping("/deleteUser")
	public String deleteU(String id_d) {
		int a = userServiceImpl.deleteUser(id_d);
		String dd = null;
		if (a != 0) {
			dd = Result.toClient("0", "ɾ���ɹ�");
		} else {
			dd = Result.toClient("1", "ɾ��ʧ��");
		}
		return dd;

	}

	/*
	 * �޸�
	 */
	@RequestMapping("/upateUser")
	public String updateU(String id_e, String name_e, String pass_e, String email_e, String tel_e) {
		int a = userServiceImpl.updateUser(id_e, name_e, pass_e, email_e, tel_e);
		String dd = null;
		if (a != 0) {
			dd = Result.toClient("0", "�޸ĳɹ�");
		} else {
			dd = Result.toClient("1", "�޸�ʧ��");
		}
		return dd;
	}

	/*
	 * ����
	 */
	@RequestMapping("/suo")
	public String a(String id) {
		String isLock = "��";
		int a = userServiceImpl.suo(id, isLock);
		String dd = null;
		if (a != 0) {
			dd = Result.toClient("0", "�����ɹ�");
		} else {
			dd = Result.toClient("1", "����ʧ��");
		}
		return dd;
	}

	/*
	 * ����
	 */
	@RequestMapping("/unsuo")
	public String b(String id) {
		String isLock = "��";
		int a = userServiceImpl.unsuo(id, isLock);
		String dd = null;
		if (a != 0) {
			dd = Result.toClient("0", "�����ɹ�");
		} else {
			dd = Result.toClient("1", "����ʧ��");
		}
		return dd;
	}

	/*
	 * ��������
	 */
	@RequestMapping("/pass")
	public String c(String id) {
		String Pass = "ysd123";
		int a = userServiceImpl.ressetPass(id, Pass);
		String dd = null;
		if (a != 0) {
			dd = Result.toClient("0", "���óɹ�");
		} else {
			dd = Result.toClient("1", "����ʧ��");
		}
		return dd;
	}

	/*
	 * ��ô�������
	 */
	@RequestMapping("/getUserRolesLeft")
	public List<Kfz> getUserRolesLeft() {
		List<Kfz> l = userServiceImpl.getLeft();
		return l;

	}

	/*
	 * ��ô�����Ҳ�
	 */
	@RequestMapping("/getUserRolesRightByid")
	public List<Kfz> getUserRolesRightByid(String UserId) {

		List<Kfz> l = userServiceImpl.getRight(UserId);

		return l;
	}

	/*
	 * �û���ӽ�ɫ
	 **/
	@RequestMapping("/addUserRoles")
	public List<Object> addUserRoles(String uId, String rId) {

		userServiceImpl.addUserRoles(uId, rId);
		return null;
	}

	/*
	 * �û�ɾ����ɫ
	 **/
	@RequestMapping("/delUserRoles")
	public List<Object> delUserRoles(String uId1, String rId1) {
		userServiceImpl.delUserRole(uId1, rId1);
		return null;
	}

	/*
	 * ��¼
	 */
	@RequestMapping("/login")
	public Map<String, Object> login(String LoginName, String PassWord) {
		Users u = userServiceImpl.login(LoginName, PassWord);
		Map<String, Object> resultmap = new HashMap<String, Object>();
		Map<String, Object> msgmap = new HashMap<String, Object>();
		if (u != null) {
			if (u.getPassword().equals(PassWord)) {
				// ������ȷ
				if (u.getIsLockout().equals("��")) {// ��������
					resultmap.put("msg", "�˺ű�����,�����");
				} else {
					// ����û�������µ�¼ʱ��
					SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String LastLoginTime = dft.format(new Date());
					userServiceImpl.updateLastTime(LoginName, LastLoginTime);
					String uid = u.getId();
					List<Roles> rs = userServiceImpl.getRolesByid(uid);
					List<String> rname = userServiceImpl.getrname(rs);
					System.out.println(rname);
					msgmap.put("rname", rname);
					msgmap.put("uid", uid);
					resultmap.put("code", 0);
					resultmap.put("u", u);
					resultmap.put("msg", msgmap);
					redisService.set("dd", "ddd");
					redisService.set("rname", rname);
					redisService.set("uid", uid);
				}
			}
		} else {
			resultmap.put("code", 1);
			resultmap.put("msg", "�û����������");
		}
		return resultmap;
	}
}
