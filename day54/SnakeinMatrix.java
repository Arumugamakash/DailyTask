package com.akash.day54;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeinMatrix {
	public static void main(String[] args) {
		int n = 3;
		List<String> list = new ArrayList<String>();
		list.add("DOWN");
		list.add("RIGHT");
		list.add("UP");
		System.out.println("OUTPUT is:" + solution1(n, list));
		System.out.println("OUTPUT is:" + solution2(n, list));
		System.out.println("OUTPUT is:" + solution3(n, list, 0, 0));

	}

	private static int solution1(int n, List<String> commands) {
		int pos = 0;
		for (int i = 0; i < commands.size(); i++) {
			String command = commands.get(i);//
			if (command.equals("RIGHT")) {
				pos++;
			} else if (command.equals("LEFT")) {
				pos--;
			} else if (command.equals("UP")) {
				pos = pos - n;
			} else {
				pos = pos + n;
			}
		}
		return pos;
	}

	private static int solution2(int n, List<String> list) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("RIGHT", +1);
		map.put("LEFT", -1);
		map.put("UP", -n);
		map.put("DOWN", +n);
		int ans = 0;
		for (String command : list) {
			ans += map.get(command);
		}
		System.out.println(map);
		return ans;
	}

	private static int solution3(int n, List<String> commands, int i, int pos) {
		if (i == commands.size()) {
			return pos;
		}
		if (commands.get(i).equals("RIGHT")) {
			pos = pos + 1;
		} else if (commands.get(i).equals("LEFT")) {
			pos = pos - 1;
		} else if (commands.get(i).equals("UP")) {
			pos = pos - n;
		} else {
			pos = pos + n;
		}
		return solution3(n, commands, i + 1, pos);
	}
}