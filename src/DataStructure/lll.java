package DataStructure;

import com.sun.deploy.util.ArrayUtil;
import com.sun.deploy.util.StringUtils;
import com.sun.deploy.util.SystemUtils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by Shawtung on 5/18/16.
 */
public class lll {

	public static void main(String[] args) {
		int[] ints = {1,2,3,4};


		char[] j = {'a','b','c'};

		String[] ttt = new String[] {"aa","bb","cc"};

		String[] asdf = Stream.of(ArrayUtils.toObject(ints)).map(String::valueOf).toArray(String[]::new);

		System.out.println(asdf);

/*
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<String> ar = new ArrayList<>();

		String[] k = {"aa","bb","cc"};
		String[] str = {"aaa","bbb","ccc"};
		System.out.println(String.join("",str));
		System.out.println(StringUtils.join(Arrays.asList(k),""));

*/

	}
}
