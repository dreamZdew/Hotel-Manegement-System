package org.WWHMS;

import java.time.LocalDate;

/*身份证相关*/

public class Idnumber {
	public String idnum, gender, birth, sage;

	public boolean islegal(String iidnum) {
		idnum = iidnum;
		if (idnum.length() == 18) // 身份证长度判断
		{// 利用身份证校验码校验
			int b[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
			int sum = 0;
			for (int i = 0; i < 17; i++)
				sum += (idnum.charAt(i) - 48) * b[i];
			sum %= 11;
			sum = 12 - sum;
			if (sum == 12)
				sum = 0;
			if (sum == 11)
				sum = 1;
			// 校验位应该与sum相等，注意考虑sum==10时校验位为X
			if (sum == idnum.charAt(17) - 48 || (sum == 10 && (idnum.charAt(17) == 'X' || idnum.charAt(17) == 'x'))) {// 校验码通过
				if (idnum.charAt(16) % 2 == 1)// 性别自动填入
					gender = "男";
				else
					gender = "女";
				birth = idnum.substring(6, 14);
				// 年龄自动填入
				String birthyear = birth.substring(0, 4), birthmonth = birth.substring(4, 6),
						birthday = birth.substring(6, 8);
				int birthyearnum = Integer.parseInt(birthyear), birthmonthnum = Integer.parseInt(birthmonth),
						birthdaynum = Integer.parseInt(birthday);
				birth = Integer.toString(birthyearnum) + "-" + Integer.toString(birthmonthnum) + "-"
						+ Integer.toString(birthdaynum);
				// 算年龄（周岁）
				LocalDate date = LocalDate.now();
				int nowyear = date.getYear(), nowmonth = date.getMonthValue(), nowday = date.getDayOfMonth();
				int age = nowyear - birthyearnum;
				if (nowmonth > birthmonthnum) {
				} else if (nowmonth < birthmonthnum)
					age -= 1;
				else {
					if (nowday < birthdaynum)
						age -= 1;
				}
				sage = (Integer.toString(age));
				return true;
			} else
				return false;
		}
		return false;
	}

}
