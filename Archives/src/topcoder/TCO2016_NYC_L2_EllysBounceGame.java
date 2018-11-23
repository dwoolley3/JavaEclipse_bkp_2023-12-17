package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class TCO2016_NYC_L2_EllysBounceGame
{
	public long getScore(int[] tiles)
	{
		int n = tiles.length;
		@SuppressWarnings("unused")
		int cnt = 0;
		for (int i = 0; i < n; i++)
			if (tiles[i] % 2 == 1) cnt++;			
			
		long max = 0, sum = 0;
		for (int i = 0; i < n; i++)
			for (int d = 0; d < 2; d++)
			{
				int[] t = new int[n];
				for (int j = 0; j < n; j++)
					t[j] = tiles[j];
				sum = getSum(t, i, d);
				max = Math.max(max, sum);
			}	
		
		return max;		
	}
	
	private long getSum(int[] t, int pos, int dir)
	{
		long sum = 0;
		int n = t.length;
//		boolean odd[] = new boolean[n];
//		for (int i = 0; i < n; i++)
//			if (t[pos] % 2 == 1) odd[i] = true;
		
		while (pos >= 0 && pos < n)
		{
			sum += t[pos];
			if ((t[pos] & 1) == 1)
			//if (odd[pos])
			{
				t[pos]++;
				dir = 1 - dir;
				//odd[pos] = false;
			}
			if (dir == 1) pos++; else pos--;
		}
		
		return sum;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, long p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		TCO2016_NYC_L2_EllysBounceGame obj;
		long answer;
		obj = new TCO2016_NYC_L2_EllysBounceGame();
		long startTime = System.currentTimeMillis();
		answer = obj.getScore(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p1);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p1;
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}
	public static void main(String[] args) {
		boolean all_right;
		all_right = true;
		
		int[] p0;
		long p1;
		
		// ----- test 0 -----
		p0 = new int[]{42,13,17,17};
		p1 = 139L;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{1337};
		p1 = 1337L;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{2,4,8,16,32,64,128,256,512,1024,2048};
		p1 = 4094L;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{1,2,2,2,2,1,2,2,2,2};
		p1 = 36L;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{795755685,581869303,404620563,708632712,545404205,133711906,372047868,949333986,579004999,323567404,418932836,944672732,196140741,809094427,946129058,30574577,182506778,15198493,150802600,138749191,676943010,177512688,126303054,81133258,183966551,471852627,84672537,867128744,857788837,275731772,609397213,20544910,811450930,483031419,361913171,547204602,892462744,522136404,173978710,131752569,478582453,867889991,153380496,551745921,647984700,910208077,283496852,368550363,379821990,712568903,40498239,113911604,103237637,39073007,684602223,812852787,479711181,746745228,735241235,296707007,262522458,870676136,136721027,359573809,189375153,547914047,198304613,640439653,417177802,25475624,758242872,764919655,310701088,537655880,361931892,14685971,213794688,107063881,147944789,444803289,884392679,540721924,638781100,902841101,7097711,219972874,879609715,156513984,802611721,755486970,103522060,967048445,913778155,94092596,519074050,884870761,248268555,339840186,53612697,826647953,185518682,263689968,375666519,12105076,481342795,242517397,698412072,529176049,511091142,958646068,140457297,971018539,172898400,830709769,461945557,529322873,781261465,823879998,961264979,76338301,68299843,767742622,95625158,769482974,121898334,257380088,292455642,772389186,468566955,817480336,174842016,799777367,944694477,678852157,595387439,23356646,641212875,988512771,105989509,817183892,684114203,49299351,92133643,427854501,797640594,287767371,45931780,58150107,303810412,933029416,503168826,397865509,844370146,650825879,78396939,193198052,649075580,949627106,32760104,53860494,510366104,290319952,726585506,886491639,781277163,741593945,933922382,147620738,355650504,308964799,227669234,375163529,42817073,685003585,57725501,883096448,634002468,893645501,856191918,29924130,325791710,736062367,231714001,515103007,15209164,748808127,948469521,530490811,283421979,150468288,557942924,663307953,851888285,696117850,16017443,663423247,51119002,172720542,447930742,668894616};
		p1 = 4760067425204L;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{795755685,581869303,404620563,708632712,545404205,133711906,372047868,949333986,579004999,323567404,418932836,944672732,196140741,809094427,946129058,30574577,182506778,15198493,150802600,138749191,676943010,177512688,126303054,81133258,183966551,471852627,84672537,867128744,857788837,275731772,609397213,20544910,811450930,483031419,361913171,547204602,892462744,522136404,173978710,131752569,478582453,867889991,153380496,551745921,647984700,910208077,283496852,368550363,379821990,712568903,40498239,113911604,103237637,39073007,684602223,812852787,479711181,746745228,735241235,296707007,262522458,870676136,136721027,359573809,189375153,547914047,198304613,640439653,417177802,25475624,758242872,764919655,310701088,537655880,361931892,14685971,213794688,107063881,147944789,444803289,884392679,540721924,638781100,902841101,7097711,219972874,879609715,156513984,802611721,755486970,103522060,967048445,913778155,94092596,519074050,884870761,248268555,339840186,53612697,826647953,185518682,263689968,375666519,12105076,481342795,242517397,698412072,529176049,511091142,958646068,140457297,971018539,172898400,830709769,461945557,529322873,781261465,823879998,961264979,76338301,68299843,767742622,95625158,769482974,121898334,257380088,292455642,772389186,468566955,817480336,174842016,799777367,944694477,678852157,595387439,23356646,641212875,988512771,105989509,817183892,684114203,49299351,92133643,427854501,797640594,287767371,45931780,58150107,303810412,933029416,503168826,397865509,844370146,650825879,78396939,193198052,649075580,949627106,32760104,53860494,510366104,290319952,726585506,886491639,781277163,741593945,933922382,147620738,355650504,308964799,227669234,375163529,42817073,685003585,57725501,883096448,634002468,893645501,856191918,29924130,325791710,736062367,231714001,515103007,15209164,748808127,948469521,530490811,283421979,150468288,557942924,663307953,851888285,696117850,16017443,663423247,51119002,172720542,447930742,668894616,
				795755685,581869303,404620563,708632712,545404205,133711906,372047868,949333986,579004999,323567404,418932836,944672732,196140741,809094427,946129058,30574577,182506778,15198493,150802600,138749191,676943010,177512688,126303054,81133258,183966551,471852627,84672537,867128744,857788837,275731772,609397213,20544910,811450930,483031419,361913171,547204602,892462744,522136404,173978710,131752569,478582453,867889991,153380496,551745921,647984700,910208077,283496852,368550363,379821990,712568903,40498239,113911604,103237637,39073007,684602223,812852787,479711181,746745228,735241235,296707007,262522458,870676136,136721027,359573809,189375153,547914047,198304613,640439653,417177802,25475624,758242872,764919655,310701088,537655880,361931892,14685971,213794688,107063881,147944789,444803289,884392679,540721924,638781100,902841101,7097711,219972874,879609715,156513984,802611721,755486970,103522060,967048445,913778155,94092596,519074050,884870761,248268555,339840186,53612697,826647953,185518682,263689968,375666519,12105076,481342795,242517397,698412072,529176049,511091142,958646068,140457297,971018539,172898400,830709769,461945557,529322873,781261465,823879998,961264979,76338301,68299843,767742622,95625158,769482974,121898334,257380088,292455642,772389186,468566955,817480336,174842016,799777367,944694477,678852157,595387439,23356646,641212875,988512771,105989509,817183892,684114203,49299351,92133643,427854501,797640594,287767371,45931780,58150107,303810412,933029416,503168826,397865509,844370146,650825879,78396939,193198052,649075580,949627106,32760104,53860494,510366104,290319952,726585506,886491639,781277163,741593945,933922382,147620738,355650504,308964799,227669234,375163529,42817073,685003585,57725501,883096448,634002468,893645501,856191918,29924130,325791710,736062367,231714001,515103007,15209164,748808127,948469521,530490811,283421979,150468288,557942924,663307953,851888285,696117850,16017443,663423247,51119002,172720542,447930742,668894616,
				795755685,581869303,404620563,708632712,545404205,133711906,372047868,949333986,579004999,323567404,418932836,944672732,196140741,809094427,946129058,30574577,182506778,15198493,150802600,138749191,676943010,177512688,126303054,81133258,183966551,471852627,84672537,867128744,857788837,275731772,609397213,20544910,811450930,483031419,361913171,547204602,892462744,522136404,173978710,131752569,478582453,867889991,153380496,551745921,647984700,910208077,283496852,368550363,379821990,712568903,40498239,113911604,103237637,39073007,684602223,812852787,479711181,746745228,735241235,296707007,262522458,870676136,136721027,359573809,189375153,547914047,198304613,640439653,417177802,25475624,758242872,764919655,310701088,537655880,361931892,14685971,213794688,107063881,147944789,444803289,884392679,540721924,638781100,902841101,7097711,219972874,879609715,156513984,802611721,755486970,103522060,967048445,913778155,94092596,519074050,884870761,248268555,339840186,53612697,826647953,185518682,263689968,375666519,12105076,481342795,242517397,698412072,529176049,511091142,958646068,140457297,971018539,172898400,830709769,461945557,529322873,781261465,823879998,961264979,76338301,68299843,767742622,95625158,769482974,121898334,257380088,292455642,772389186,468566955,817480336,174842016,799777367,944694477,678852157,595387439,23356646,641212875,988512771,105989509,817183892,684114203,49299351,92133643,427854501,797640594,287767371,45931780,58150107,303810412,933029416,503168826,397865509,844370146,650825879,78396939,193198052,649075580,949627106,32760104,53860494,510366104,290319952,726585506,886491639,781277163,741593945,933922382,147620738,355650504,308964799,227669234,375163529,42817073,685003585,57725501,883096448,634002468,893645501,856191918,29924130,325791710,736062367,231714001,515103007,15209164,748808127,948469521,530490811,283421979,150468288,557942924,663307953,851888285,696117850,16017443,663423247,51119002,172720542,447930742,668894616,
				795755685,581869303,404620563,708632712,545404205,133711906,372047868,949333986,579004999,323567404,418932836,944672732,196140741,809094427,946129058,30574577,182506778,15198493,150802600,138749191,676943010,177512688,126303054,81133258,183966551,471852627,84672537,867128744,857788837,275731772,609397213,20544910,811450930,483031419,361913171,547204602,892462744,522136404,173978710,131752569,478582453,867889991,153380496,551745921,647984700,910208077,283496852,368550363,379821990,712568903,40498239,113911604,103237637,39073007,684602223,812852787,479711181,746745228,735241235,296707007,262522458,870676136,136721027,359573809,189375153,547914047,198304613,640439653,417177802,25475624,758242872,764919655,310701088,537655880,361931892,14685971,213794688,107063881,147944789,444803289,884392679,540721924,638781100,902841101,7097711,219972874,879609715,156513984,802611721,755486970,103522060,967048445,913778155,94092596,519074050,884870761,248268555,339840186,53612697,826647953,185518682,263689968,375666519,12105076,481342795,242517397,698412072,529176049,511091142,958646068,140457297,971018539,172898400,830709769,461945557,529322873,781261465,823879998,961264979,76338301,68299843,767742622,95625158,769482974,121898334,257380088,292455642,772389186,468566955,817480336,174842016,799777367,944694477,678852157,595387439,23356646,641212875,988512771,105989509,817183892,684114203,49299351,92133643,427854501,797640594,287767371,45931780,58150107,303810412,933029416,503168826,397865509,844370146,650825879,78396939,193198052,649075580,949627106,32760104,53860494,510366104,290319952,726585506,886491639,781277163,741593945,933922382,147620738,355650504,308964799,227669234,375163529,42817073,685003585,57725501,883096448,634002468,893645501,856191918,29924130,325791710,736062367,231714001,515103007,15209164,748808127,948469521,530490811,283421979,150468288,557942924,663307953,851888285,696117850,16017443,663423247,51119002,172720542,447930742,668894616,
				795755685,581869303,404620563,708632712,545404205,133711906,372047868,949333986,579004999,323567404,418932836,944672732,196140741,809094427,946129058,30574577,182506778,15198493,150802600,138749191,676943010,177512688,126303054,81133258,183966551,471852627,84672537,867128744,857788837,275731772,609397213,20544910,811450930,483031419,361913171,547204602,892462744,522136404,173978710,131752569,478582453,867889991,153380496,551745921,647984700,910208077,283496852,368550363,379821990,712568903,40498239,113911604,103237637,39073007,684602223,812852787,479711181,746745228,735241235,296707007,262522458,870676136,136721027,359573809,189375153,547914047,198304613,640439653,417177802,25475624,758242872,764919655,310701088,537655880,361931892,14685971,213794688,107063881,147944789,444803289,884392679,540721924,638781100,902841101,7097711,219972874,879609715,156513984,802611721,755486970,103522060,967048445,913778155,94092596,519074050,884870761,248268555,339840186,53612697,826647953,185518682,263689968,375666519,12105076,481342795,242517397,698412072,529176049,511091142,958646068,140457297,971018539,172898400,830709769,461945557,529322873,781261465,823879998,961264979,76338301,68299843,767742622,95625158,769482974,121898334,257380088,292455642,772389186,468566955,817480336,174842016,799777367,944694477,678852157,595387439,23356646,641212875,988512771,105989509,817183892,684114203,49299351,92133643,427854501,797640594,287767371,45931780,58150107,303810412,933029416,503168826,397865509,844370146,650825879,78396939,193198052,649075580,949627106,32760104,53860494,510366104,290319952,726585506,886491639,781277163,741593945,933922382,147620738,355650504,308964799,227669234,375163529,42817073,685003585,57725501,883096448,634002468,893645501,856191918,29924130,325791710,736062367,231714001,515103007,15209164,748808127,948469521,530490811,283421979,150468288,557942924,663307953,851888285,696117850,16017443,663423247,51119002,172720542,447930742,668894616,
				795755685,581869303,404620563,708632712,545404205,133711906,372047868,949333986,579004999,323567404,418932836,944672732,196140741,809094427,946129058,30574577,182506778,15198493,150802600,138749191,676943010,177512688,126303054,81133258,183966551,471852627,84672537,867128744,857788837,275731772,609397213,20544910,811450930,483031419,361913171,547204602,892462744,522136404,173978710,131752569,478582453,867889991,153380496,551745921,647984700,910208077,283496852,368550363,379821990,712568903,40498239,113911604,103237637,39073007,684602223,812852787,479711181,746745228,735241235,296707007,262522458,870676136,136721027,359573809,189375153,547914047,198304613,640439653,417177802,25475624,758242872,764919655,310701088,537655880,361931892,14685971,213794688,107063881,147944789,444803289,884392679,540721924,638781100,902841101,7097711,219972874,879609715,156513984,802611721,755486970,103522060,967048445,913778155,94092596,519074050,884870761,248268555,339840186,53612697,826647953,185518682,263689968,375666519,12105076,481342795,242517397,698412072,529176049,511091142,958646068,140457297,971018539,172898400,830709769,461945557,529322873,781261465,823879998,961264979,76338301,68299843,767742622,95625158,769482974,121898334,257380088,292455642,772389186,468566955,817480336,174842016,799777367,944694477,678852157,595387439,23356646,641212875,988512771,105989509,817183892,684114203,49299351,92133643,427854501,797640594,287767371,45931780,58150107,303810412,933029416,503168826,397865509,844370146,650825879,78396939,193198052,649075580,949627106,32760104,53860494,510366104,290319952,726585506,886491639,781277163,741593945,933922382,147620738,355650504,308964799,227669234,375163529,42817073,685003585,57725501,883096448,634002468,893645501,856191918,29924130,325791710,736062367,231714001,515103007,15209164,748808127,948469521,530490811,283421979,150468288,557942924,663307953,851888285,696117850,16017443,663423247,51119002,172720542,447930742,668894616,
				795755685,581869303,404620563,708632712,545404205,133711906,372047868,949333986,579004999,323567404,418932836,944672732,196140741,809094427,946129058,30574577,182506778,15198493,150802600,138749191,676943010,177512688,126303054,81133258,183966551,471852627,84672537,867128744,857788837,275731772,609397213,20544910,811450930,483031419,361913171,547204602,892462744,522136404,173978710,131752569,478582453,867889991,153380496,551745921,647984700,910208077,283496852,368550363,379821990,712568903,40498239,113911604,103237637,39073007,684602223,812852787,479711181,746745228,735241235,296707007,262522458,870676136,136721027,359573809,189375153,547914047,198304613,640439653,417177802,25475624,758242872,764919655,310701088,537655880,361931892,14685971,213794688,107063881,147944789,444803289,884392679,540721924,638781100,902841101,7097711,219972874,879609715,156513984,802611721,755486970,103522060,967048445,913778155,94092596,519074050,884870761,248268555,339840186,53612697,826647953,185518682,263689968,375666519,12105076,481342795,242517397,698412072,529176049,511091142,958646068,140457297,971018539,172898400,830709769,461945557,529322873,781261465,823879998,961264979,76338301,68299843,767742622,95625158,769482974,121898334,257380088,292455642,772389186,468566955,817480336,174842016,799777367,944694477,678852157,595387439,23356646,641212875,988512771,105989509,817183892,684114203,49299351,92133643,427854501,797640594,287767371,45931780,58150107,303810412,933029416,503168826,397865509,844370146,650825879,78396939,193198052,649075580,949627106,32760104,53860494,510366104,290319952,726585506,886491639,781277163,741593945,933922382,147620738,355650504,308964799,227669234,375163529,42817073,685003585,57725501,883096448,634002468,893645501,856191918,29924130,325791710,736062367,231714001,515103007,15209164,748808127,948469521,530490811,283421979,150468288,557942924,663307953,851888285,696117850,16017443,663423247,51119002,172720542,447930742,668894616,
				795755685,581869303,404620563,708632712,545404205,133711906,372047868,949333986,579004999,323567404,418932836,944672732,196140741,809094427,946129058,30574577,182506778,15198493,150802600,138749191,676943010,177512688,126303054,81133258,183966551,471852627,84672537,867128744,857788837,275731772,609397213,20544910,811450930,483031419,361913171,547204602,892462744,522136404,173978710,131752569,478582453,867889991,153380496,551745921,647984700,910208077,283496852,368550363,379821990,712568903,40498239,113911604,103237637,39073007,684602223,812852787,479711181,746745228,735241235,296707007,262522458,870676136,136721027,359573809,189375153,547914047,198304613,640439653,417177802,25475624,758242872,764919655,310701088,537655880,361931892,14685971,213794688,107063881,147944789,444803289,884392679,540721924,638781100,902841101,7097711,219972874,879609715,156513984,802611721,755486970,103522060,967048445,913778155,94092596,519074050,884870761,248268555,339840186,53612697,826647953,185518682,263689968,375666519,12105076,481342795,242517397,698412072,529176049,511091142,958646068,140457297,971018539,172898400,830709769,461945557,529322873,781261465,823879998,961264979,76338301,68299843,767742622,95625158,769482974,121898334,257380088,292455642,772389186,468566955,817480336,174842016,799777367,944694477,678852157,595387439,23356646,641212875,988512771,105989509,817183892,684114203,49299351,92133643,427854501,797640594,287767371,45931780,58150107,303810412,933029416,503168826,397865509,844370146,650825879,78396939,193198052,649075580,949627106,32760104,53860494,510366104,290319952,726585506,886491639,781277163,741593945,933922382,147620738,355650504,308964799,227669234,375163529,42817073,685003585,57725501,883096448,634002468,893645501,856191918,29924130,325791710,736062367,231714001,515103007,15209164,748808127,948469521,530490811,283421979,150468288,557942924,663307953,851888285,696117850,16017443,663423247,51119002,172720542,447930742,668894616,
				795755685,581869303,404620563,708632712,545404205,133711906,372047868,949333986,579004999,323567404,418932836,944672732,196140741,809094427,946129058,30574577,182506778,15198493,150802600,138749191,676943010,177512688,126303054,81133258,183966551,471852627,84672537,867128744,857788837,275731772,609397213,20544910,811450930,483031419,361913171,547204602,892462744,522136404,173978710,131752569,478582453,867889991,153380496,551745921,647984700,910208077,283496852,368550363,379821990,712568903,40498239,113911604,103237637,39073007,684602223,812852787,479711181,746745228,735241235,296707007,262522458,870676136,136721027,359573809,189375153,547914047,198304613,640439653,417177802,25475624,758242872,764919655,310701088,537655880,361931892,14685971,213794688,107063881,147944789,444803289,884392679,540721924,638781100,902841101,7097711,219972874,879609715,156513984,802611721,755486970,103522060,967048445,913778155,94092596,519074050,884870761,248268555,339840186,53612697,826647953,185518682,263689968,375666519,12105076,481342795,242517397,698412072,529176049,511091142,958646068,140457297,971018539,172898400,830709769,461945557,529322873,781261465,823879998,961264979,76338301,68299843,767742622,95625158,769482974,121898334,257380088,292455642,772389186,468566955,817480336,174842016,799777367,944694477,678852157,595387439,23356646,641212875,988512771,105989509,817183892,684114203,49299351,92133643,427854501,797640594,287767371,45931780,58150107,303810412,933029416,503168826,397865509,844370146,650825879,78396939,193198052,649075580,949627106,32760104,53860494,510366104,290319952,726585506,886491639,781277163,741593945,933922382,147620738,355650504,308964799,227669234,375163529,42817073,685003585,57725501,883096448,634002468,893645501,856191918,29924130,325791710,736062367,231714001,515103007,15209164,748808127,948469521,530490811,283421979,150468288,557942924,663307953,851888285,696117850,16017443,663423247,51119002,172720542,447930742,668894616,			
				795755685,581869303,404620563,708632712,545404205,133711906,372047868,949333986,579004999,323567404,418932836,944672732,196140741,809094427,946129058,30574577,182506778,15198493,150802600,138749191,676943010,177512688,126303054,81133258,183966551,471852627,84672537,867128744,857788837,275731772,609397213,20544910,811450930,483031419,361913171,547204602,892462744,522136404,173978710,131752569,478582453,867889991,153380496,551745921,647984700,910208077,283496852,368550363,379821990,712568903,40498239,113911604,103237637,39073007,684602223,812852787,479711181,746745228,735241235,296707007,262522458,870676136,136721027,359573809,189375153,547914047,198304613,640439653,417177802,25475624,758242872,764919655,310701088,537655880,361931892,14685971,213794688,107063881,147944789,444803289,884392679,540721924,638781100,902841101,7097711,219972874,879609715,156513984,802611721,755486970,103522060,967048445,913778155,94092596,519074050,884870761,248268555,339840186,53612697,826647953,185518682,263689968,375666519,12105076,481342795,242517397,698412072,529176049,511091142,958646068,140457297,971018539,172898400,830709769,461945557,529322873,781261465,823879998,961264979,76338301,68299843,767742622,95625158,769482974,121898334,257380088,292455642,772389186,468566955,817480336,174842016,799777367,944694477,678852157,595387439,23356646,641212875,988512771,105989509,817183892,684114203,49299351,92133643,427854501,797640594,287767371,45931780,58150107,303810412,933029416,503168826,397865509,844370146,650825879,78396939,193198052,649075580,949627106,32760104,53860494,510366104,290319952,726585506,886491639,781277163,741593945,933922382,147620738,355650504,308964799,227669234,375163529,42817073,685003585,57725501,883096448,634002468,893645501,856191918,29924130,325791710,736062367,231714001,515103007,15209164,748808127,948469521,530490811,283421979,150468288,557942924,663307953,851888285,696117850,16017443,663423247,51119002,172720542,447930742,668894616};
		p1 = 483667545639462L;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!