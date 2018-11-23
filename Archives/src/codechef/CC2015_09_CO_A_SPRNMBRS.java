package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2015_09_CO_A_SPRNMBRS
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2015_09_CO_A_SPRNMBRS().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void solve()
	{

        int T = in.nextInt();
        for (int t = 0; t < T; t++)
        {
			long l = in.nextLong();	
			long r = in.nextLong();
			
			//ACRush solution
			long[] e2 = new long[128], e3 = new long[128];
			for (int i = 0; i < 128; i++)
			{
				e2[i] = (i > 0 ? e2[i-1]*2 : 1);
				e3[i] = (i > 0 ? e3[i-1]*3 : 1);
			}
			int ret=0;
			for (int d2 = 0; e2[d2] <=r ; d2++) 
				for (int d3=0; e2[d2]*e3[d3] <= r; d3++) 
					if ((d2>0 || d3==0) && e2[d2]*e3[d3] >= l) ret++;
			out.println(ret);	
			
			//Answers stored in array from another person's solution
//			long[] arr={1L, 2L, 4L, 6L, 8L, 12L, 16L, 18L, 24L, 32L, 36L, 48L, 54L, 64L, 72L, 96L, 108L, 128L, 144L, 162L, 192L, 216L, 256L, 288L, 324L, 384L, 432L, 486L, 512L, 576L, 648L, 768L, 864L, 972L, 1024L, 1152L, 1296L, 1458L, 1536L, 1728L, 1944L, 2048L, 2304L, 2592L, 2916L, 3072L, 3456L, 3888L, 4096L, 4374L, 4608L, 5184L, 5832L, 6144L, 6912L, 7776L, 8192L, 8748L, 9216L, 10368L, 11664L, 12288L, 13122L, 13824L, 15552L, 16384L, 17496L, 18432L, 20736L, 23328L, 24576L, 26244L, 27648L, 31104L, 32768L, 34992L, 36864L, 39366L, 41472L, 46656L, 49152L, 52488L, 55296L, 62208L, 65536L, 69984L, 73728L, 78732L, 82944L, 93312L, 98304L, 104976L, 110592L, 118098L, 124416L, 131072L, 139968L, 147456L, 157464L, 165888L, 186624L, 196608L, 209952L, 221184L, 236196L, 248832L, 262144L, 279936L, 294912L, 314928L, 331776L, 354294L, 373248L, 393216L, 419904L, 442368L, 472392L, 497664L, 524288L, 559872L, 589824L, 629856L, 663552L, 708588L, 746496L, 786432L, 839808L, 884736L, 944784L, 995328L, 1048576L, 1062882L, 1119744L, 1179648L, 1259712L, 1327104L, 1417176L, 1492992L, 1572864L, 1679616L, 1769472L, 1889568L, 1990656L, 2097152L, 2125764L, 2239488L, 2359296L, 2519424L, 2654208L, 2834352L, 2985984L, 3145728L, 3188646L, 3359232L, 3538944L, 3779136L, 3981312L, 4194304L, 4251528L, 4478976L, 4718592L, 5038848L, 5308416L, 5668704L, 5971968L, 6291456L, 6377292L, 6718464L, 7077888L, 7558272L, 7962624L, 8388608L, 8503056L, 8957952L, 9437184L, 9565938L, 10077696L, 10616832L, 11337408L, 11943936L, 12582912L, 12754584L, 13436928L, 14155776L, 15116544L, 15925248L, 16777216L, 17006112L, 17915904L, 18874368L, 19131876L, 20155392L, 21233664L, 22674816L, 23887872L, 25165824L, 25509168L, 26873856L, 28311552L, 28697814L, 30233088L, 31850496L, 33554432L, 34012224L, 35831808L, 37748736L, 38263752L, 40310784L, 42467328L, 45349632L, 47775744L, 50331648L, 51018336L, 53747712L, 56623104L, 57395628L, 60466176L, 63700992L, 67108864L, 68024448L, 71663616L, 75497472L, 76527504L, 80621568L, 84934656L, 86093442L, 90699264L, 95551488L, 100663296L, 102036672L, 107495424L, 113246208L, 114791256L, 120932352L, 127401984L, 134217728L, 136048896L, 143327232L, 150994944L, 153055008L, 161243136L, 169869312L, 172186884L, 181398528L, 191102976L, 201326592L, 204073344L, 214990848L, 226492416L, 229582512L, 241864704L, 254803968L, 258280326L, 268435456L, 272097792L, 286654464L, 301989888L, 306110016L, 322486272L, 339738624L, 344373768L, 362797056L, 382205952L, 402653184L, 408146688L, 429981696L, 452984832L, 459165024L, 483729408L, 509607936L, 516560652L, 536870912L, 544195584L, 573308928L, 603979776L, 612220032L, 644972544L, 679477248L, 688747536L, 725594112L, 764411904L, 774840978L, 805306368L, 816293376L, 859963392L, 905969664L, 918330048L, 967458816L, 1019215872L, 1033121304L, 1073741824L, 1088391168L, 1146617856L, 1207959552L, 1224440064L, 1289945088L, 1358954496L, 1377495072L, 1451188224L, 1528823808L, 1549681956L, 1610612736L, 1632586752L, 1719926784L, 1811939328L, 1836660096L, 1934917632L, 2038431744L, 2066242608L, 2147483648L, 2176782336L, 2293235712L, 2324522934L, 2415919104L, 2448880128L, 2579890176L, 2717908992L, 2754990144L, 2902376448L, 3057647616L, 3099363912L, 3221225472L, 3265173504L, 3439853568L, 3623878656L, 3673320192L, 3869835264L, 4076863488L, 4132485216L, 4294967296L, 4353564672L, 4586471424L, 4649045868L, 4831838208L, 4897760256L, 5159780352L, 5435817984L, 5509980288L, 5804752896L, 6115295232L, 6198727824L, 6442450944L, 6530347008L, 6879707136L, 6973568802L, 7247757312L, 7346640384L, 7739670528L, 8153726976L, 8264970432L, 8589934592L, 8707129344L, 9172942848L, 9298091736L, 9663676416L, 9795520512L, 10319560704L, 10871635968L, 11019960576L, 11609505792L, 12230590464L, 12397455648L, 12884901888L, 13060694016L, 13759414272L, 13947137604L, 14495514624L, 14693280768L, 15479341056L, 16307453952L, 16529940864L, 17179869184L, 17414258688L, 18345885696L, 18596183472L, 19327352832L, 19591041024L, 20639121408L, 20920706406L, 21743271936L, 22039921152L, 23219011584L, 24461180928L, 24794911296L, 25769803776L, 26121388032L, 27518828544L, 27894275208L, 28991029248L, 29386561536L, 30958682112L, 32614907904L, 33059881728L, 34359738368L, 34828517376L, 36691771392L, 37192366944L, 38654705664L, 39182082048L, 41278242816L, 41841412812L, 43486543872L, 44079842304L, 46438023168L, 48922361856L, 49589822592L, 51539607552L, 52242776064L, 55037657088L, 55788550416L, 57982058496L, 58773123072L, 61917364224L, 62762119218L, 65229815808L, 66119763456L, 68719476736L, 69657034752L, 73383542784L, 74384733888L, 77309411328L, 78364164096L, 82556485632L, 83682825624L, 86973087744L, 88159684608L, 92876046336L, 97844723712L, 99179645184L, 103079215104L, 104485552128L, 110075314176L, 111577100832L, 115964116992L, 117546246144L, 123834728448L, 125524238436L, 130459631616L, 132239526912L, 137438953472L, 139314069504L, 146767085568L, 148769467776L, 154618822656L, 156728328192L, 165112971264L, 167365651248L, 173946175488L, 176319369216L, 185752092672L, 188286357654L, 195689447424L, 198359290368L, 206158430208L, 208971104256L, 220150628352L, 223154201664L, 231928233984L, 235092492288L, 247669456896L, 251048476872L, 260919263232L, 264479053824L, 274877906944L, 278628139008L, 293534171136L, 297538935552L, 309237645312L, 313456656384L, 330225942528L, 334731302496L, 347892350976L, 352638738432L, 371504185344L, 376572715308L, 391378894848L, 396718580736L, 412316860416L, 417942208512L, 440301256704L, 446308403328L, 463856467968L, 470184984576L, 495338913792L, 502096953744L, 521838526464L, 528958107648L, 549755813888L, 557256278016L, 564859072962L, 587068342272L, 595077871104L, 618475290624L, 626913312768L, 660451885056L, 669462604992L, 695784701952L, 705277476864L, 743008370688L, 753145430616L, 782757789696L, 793437161472L, 824633720832L, 835884417024L, 880602513408L, 892616806656L, 927712935936L, 940369969152L, 990677827584L, 1004193907488L, 1043677052928L, 1057916215296L, 1099511627776L, 1114512556032L, 1129718145924L, 1174136684544L, 1190155742208L, 1236950581248L, 1253826625536L, 1320903770112L, 1338925209984L, 1391569403904L, 1410554953728L, 1486016741376L, 1506290861232L, 1565515579392L, 1586874322944L, 1649267441664L, 1671768834048L, 1694577218886L, 1761205026816L, 1785233613312L, 1855425871872L, 1880739938304L, 1981355655168L, 2008387814976L, 2087354105856L, 2115832430592L, 2199023255552L, 2229025112064L, 2259436291848L, 2348273369088L, 2380311484416L, 2473901162496L, 2507653251072L, 2641807540224L, 2677850419968L, 2783138807808L, 2821109907456L, 2972033482752L, 3012581722464L, 3131031158784L, 3173748645888L, 3298534883328L, 3343537668096L, 3389154437772L, 3522410053632L, 3570467226624L, 3710851743744L, 3761479876608L, 3962711310336L, 4016775629952L, 4174708211712L, 4231664861184L, 4398046511104L, 4458050224128L, 4518872583696L, 4696546738176L, 4760622968832L, 4947802324992L, 5015306502144L, 5083731656658L, 5283615080448L, 5355700839936L, 5566277615616L, 5642219814912L, 5944066965504L, 6025163444928L, 6262062317568L, 6347497291776L, 6597069766656L, 6687075336192L, 6778308875544L, 7044820107264L, 7140934453248L, 7421703487488L, 7522959753216L, 7925422620672L, 8033551259904L, 8349416423424L, 8463329722368L, 8796093022208L, 8916100448256L, 9037745167392L, 9393093476352L, 9521245937664L, 9895604649984L, 10030613004288L, 10167463313316L, 10567230160896L, 10711401679872L, 11132555231232L, 11284439629824L, 11888133931008L, 12050326889856L, 12524124635136L, 12694994583552L, 13194139533312L, 13374150672384L, 13556617751088L, 14089640214528L, 14281868906496L, 14843406974976L, 15045919506432L, 15251194969974L, 15850845241344L, 16067102519808L, 16698832846848L, 16926659444736L, 17592186044416L, 17832200896512L, 18075490334784L, 18786186952704L, 19042491875328L, 19791209299968L, 20061226008576L, 20334926626632L, 21134460321792L, 21422803359744L, 22265110462464L, 22568879259648L, 23776267862016L, 24100653779712L, 25048249270272L, 25389989167104L, 26388279066624L, 26748301344768L, 27113235502176L, 28179280429056L, 28563737812992L, 29686813949952L, 30091839012864L, 30502389939948L, 31701690482688L, 32134205039616L, 33397665693696L, 33853318889472L, 35184372088832L, 35664401793024L, 36150980669568L, 37572373905408L, 38084983750656L, 39582418599936L, 40122452017152L, 40669853253264L, 42268920643584L, 42845606719488L, 44530220924928L, 45137758519296L, 45753584909922L, 47552535724032L, 48201307559424L, 50096498540544L, 50779978334208L, 52776558133248L, 53496602689536L, 54226471004352L, 56358560858112L, 57127475625984L, 59373627899904L, 60183678025728L, 61004779879896L, 63403380965376L, 64268410079232L, 66795331387392L, 67706637778944L, 70368744177664L, 71328803586048L, 72301961339136L, 75144747810816L, 76169967501312L, 79164837199872L, 80244904034304L, 81339706506528L, 84537841287168L, 85691213438976L, 89060441849856L, 90275517038592L, 91507169819844L, 95105071448064L, 96402615118848L, 100192997081088L, 101559956668416L, 105553116266496L, 106993205379072L, 108452942008704L, 112717121716224L, 114254951251968L, 118747255799808L, 120367356051456L, 122009559759792L, 126806761930752L, 128536820158464L, 133590662774784L, 135413275557888L, 137260754729766L, 140737488355328L, 142657607172096L, 144603922678272L, 150289495621632L, 152339935002624L, 158329674399744L, 160489808068608L, 162679413013056L, 169075682574336L, 171382426877952L, 178120883699712L, 180551034077184L, 183014339639688L, 190210142896128L, 192805230237696L, 200385994162176L, 203119913336832L, 211106232532992L, 213986410758144L, 216905884017408L, 225434243432448L, 228509902503936L, 237494511599616L, 240734712102912L, 244019119519584L, 253613523861504L, 257073640316928L, 267181325549568L, 270826551115776L, 274521509459532L, 281474976710656L, 285315214344192L, 289207845356544L, 300578991243264L, 304679870005248L, 316659348799488L, 320979616137216L, 325358826026112L, 338151365148672L, 342764853755904L, 356241767399424L, 361102068154368L, 366028679279376L, 380420285792256L, 385610460475392L, 400771988324352L, 406239826673664L, 411782264189298L, 422212465065984L, 427972821516288L, 433811768034816L, 450868486864896L, 457019805007872L, 474989023199232L, 481469424205824L, 488038239039168L, 507227047723008L, 514147280633856L, 534362651099136L, 541653102231552L, 549043018919064L, 562949953421312L, 570630428688384L, 578415690713088L, 601157982486528L, 609359740010496L, 633318697598976L, 641959232274432L, 650717652052224L, 676302730297344L, 685529707511808L, 712483534798848L, 722204136308736L, 732057358558752L, 760840571584512L, 771220920950784L, 801543976648704L, 812479653347328L, 823564528378596L, 844424930131968L, 855945643032576L, 867623536069632L, 901736973729792L, 914039610015744L, 949978046398464L, 962938848411648L, 976076478078336L, 1014454095446016L, 1028294561267712L, 1068725302198272L, 1083306204463104L, 1098086037838128L, 1125899906842624L, 1141260857376768L, 1156831381426176L, 1202315964973056L, 1218719480020992L, 1235346792567894L, 1266637395197952L, 1283918464548864L, 1301435304104448L, 1352605460594688L, 1371059415023616L, 1424967069597696L, 1444408272617472L, 1464114717117504L, 1521681143169024L, 1542441841901568L, 1603087953297408L, 1624959306694656L, 1647129056757192L, 1688849860263936L, 1711891286065152L, 1735247072139264L, 1803473947459584L, 1828079220031488L, 1899956092796928L, 1925877696823296L, 1952152956156672L, 2028908190892032L, 2056589122535424L, 2137450604396544L, 2166612408926208L, 2196172075676256L, 2251799813685248L, 2282521714753536L, 2313662762852352L, 2404631929946112L, 2437438960041984L, 2470693585135788L, 2533274790395904L, 2567836929097728L, 2602870608208896L, 2705210921189376L, 2742118830047232L, 2849934139195392L, 2888816545234944L, 2928229434235008L, 3043362286338048L, 3084883683803136L, 3206175906594816L, 3249918613389312L, 3294258113514384L, 3377699720527872L, 3423782572130304L, 3470494144278528L, 3606947894919168L, 3656158440062976L, 3706040377703682L, 3799912185593856L, 3851755393646592L, 3904305912313344L, 4057816381784064L, 4113178245070848L, 4274901208793088L, 4333224817852416L, 4392344151352512L, 4503599627370496L, 4565043429507072L, 4627325525704704L, 4809263859892224L, 4874877920083968L, 4941387170271576L, 5066549580791808L, 5135673858195456L, 5205741216417792L, 5410421842378752L, 5484237660094464L, 5699868278390784L, 5777633090469888L, 5856458868470016L, 6086724572676096L, 6169767367606272L, 6412351813189632L, 6499837226778624L, 6588516227028768L, 6755399441055744L, 6847565144260608L, 6940988288557056L, 7213895789838336L, 7312316880125952L, 7412080755407364L, 7599824371187712L, 7703510787293184L, 7808611824626688L, 8115632763568128L, 8226356490141696L, 8549802417586176L, 8666449635704832L, 8784688302705024L, 9007199254740992L, 9130086859014144L, 9254651051409408L, 9618527719784448L, 9749755840167936L, 9882774340543152L, 10133099161583616L, 10271347716390912L, 10411482432835584L, 10820843684757504L, 10968475320188928L, 11118121133111046L, 11399736556781568L, 11555266180939776L, 11712917736940032L, 12173449145352192L, 12339534735212544L, 12824703626379264L, 12999674453557248L, 13177032454057536L, 13510798882111488L, 13695130288521216L, 13881976577114112L, 14427791579676672L, 14624633760251904L, 14824161510814728L, 15199648742375424L, 15407021574586368L, 15617223649253376L, 16231265527136256L, 16452712980283392L, 17099604835172352L, 17332899271409664L, 17569376605410048L, 18014398509481984L, 18260173718028288L, 18509302102818816L, 19237055439568896L, 19499511680335872L, 19765548681086304L, 20266198323167232L, 20542695432781824L, 20822964865671168L, 21641687369515008L, 21936950640377856L, 22236242266222092L, 22799473113563136L, 23110532361879552L, 23425835473880064L, 24346898290704384L, 24679069470425088L, 25649407252758528L, 25999348907114496L, 26354064908115072L, 27021597764222976L, 27390260577042432L, 27763953154228224L, 28855583159353344L, 29249267520503808L, 29648323021629456L, 30399297484750848L, 30814043149172736L, 31234447298506752L, 32462531054272512L, 32905425960566784L, 33354363399333138L, 34199209670344704L, 34665798542819328L, 35138753210820096L, 36028797018963968L, 36520347436056576L, 37018604205637632L, 38474110879137792L, 38999023360671744L, 39531097362172608L, 40532396646334464L, 41085390865563648L, 41645929731342336L, 43283374739030016L, 43873901280755712L, 44472484532444184L, 45598946227126272L, 46221064723759104L, 46851670947760128L, 48693796581408768L, 49358138940850176L, 51298814505517056L, 51998697814228992L, 52708129816230144L, 54043195528445952L, 54780521154084864L, 55527906308456448L, 57711166318706688L, 58498535041007616L, 59296646043258912L, 60798594969501696L, 61628086298345472L, 62468894597013504L, 64925062108545024L, 65810851921133568L, 66708726798666276L, 68398419340689408L, 69331597085638656L, 70277506421640192L, 72057594037927936L, 73040694872113152L, 74037208411275264L, 76948221758275584L, 77998046721343488L, 79062194724345216L, 81064793292668928L, 82170781731127296L, 83291859462684672L, 86566749478060032L, 87747802561511424L, 88944969064888368L, 91197892454252544L, 92442129447518208L, 93703341895520256L, 97387593162817536L, 98716277881700352L, 100063090197999414L, 102597629011034112L, 103997395628457984L, 105416259632460288L, 108086391056891904L, 109561042308169728L, 111055812616912896L, 115422332637413376L, 116997070082015232L, 118593292086517824L, 121597189939003392L, 123256172596690944L, 124937789194027008L, 129850124217090048L, 131621703842267136L, 133417453597332552L, 136796838681378816L, 138663194171277312L, 140555012843280384L, 144115188075855872L, 146081389744226304L, 148074416822550528L, 153896443516551168L, 155996093442686976L, 158124389448690432L, 162129586585337856L, 164341563462254592L, 166583718925369344L, 173133498956120064L, 175495605123022848L, 177889938129776736L, 182395784908505088L, 184884258895036416L, 187406683791040512L, 194775186325635072L, 197432555763400704L, 200126180395998828L, 205195258022068224L, 207994791256915968L, 210832519264920576L, 216172782113783808L, 219122084616339456L, 222111625233825792L, 230844665274826752L, 233994140164030464L, 237186584173035648L, 243194379878006784L, 246512345193381888L, 249875578388054016L, 259700248434180096L, 263243407684534272L, 266834907194665104L, 273593677362757632L, 277326388342554624L, 281110025686560768L, 288230376151711744L, 292162779488452608L, 296148833645101056L, 300189270593998242L, 307792887033102336L, 311992186885373952L, 316248778897380864L, 324259173170675712L, 328683126924509184L, 333167437850738688L, 346266997912240128L, 350991210246045696L, 355779876259553472L, 364791569817010176L, 369768517790072832L, 374813367582081024L, 389550372651270144L, 394865111526801408L, 400252360791997656L, 410390516044136448L, 415989582513831936L, 421665038529841152L, 432345564227567616L, 438244169232678912L, 444223250467651584L, 461689330549653504L, 467988280328060928L, 474373168346071296L, 486388759756013568L, 493024690386763776L, 499751156776108032L, 519400496868360192L, 526486815369068544L, 533669814389330208L, 547187354725515264L, 554652776685109248L, 562220051373121536L, 576460752303423488L, 584325558976905216L, 592297667290202112L, 600378541187996484L, 615585774066204672L, 623984373770747904L, 632497557794761728L, 648518346341351424L, 657366253849018368L, 666334875701477376L, 692533995824480256L, 701982420492091392L, 711559752519106944L, 729583139634020352L, 739537035580145664L, 749626735164162048L, 779100745302540288L, 789730223053602816L, 800504721583995312L, 820781032088272896L, 831979165027663872L, 843330077059682304L, 864691128455135232L, 876488338465357824L, 888446500935303168L, 900567811781994726L, 923378661099307008L, 935976560656121856L, 948746336692142592L, 972777519512027136L, 986049380773527552L, 999502313552216064L, 1038800993736720384L, 1052973630738137088L, 1067339628778660416L, 1094374709451030528L, 1109305553370218496L, 1124440102746243072L, 1168651117953810432L, 1184595334580404224L, 1200757082375992968L, 1231171548132409344L, 1247968747541495808L, 1264995115589523456L, 1297036692682702848L, 1314732507698036736L, 1332669751402954752L, 1385067991648960512L, 1403964840984182784L, 1423119505038213888L, 1459166279268040704L, 1479074071160291328L, 1499253470328324096L, 1558201490605080576L, 1579460446107205632L, 1601009443167990624L, 1641562064176545792L, 1663958330055327744L, 1686660154119364608L, 1729382256910270464L, 1752976676930715648L, 1776893001870606336L, 1801135623563989452L, 1846757322198614016L, 1871953121312243712L, 1897492673384285184L, 1945555039024054272L, 1972098761547055104L, 1999004627104432128L, 2077601987473440768L, 2105947261476274176L, 2134679257557320832L, 2188749418902061056L, 2218611106740436992L, 2248880205492486144L, 2337302235907620864L, 2369190669160808448L, 2401514164751985936L, 2462343096264818688L, 2495937495082991616L, 2529990231179046912L, 2594073385365405696L, 2629465015396073472L, 2665339502805909504L, 2701703435345984178L, 2770135983297921024L, 2807929681968365568L, 2846239010076427776L, 2918332558536081408L, 2958148142320582656L, 2998506940656648192L};	
//			long L=reader.nextLong();
//			long R=reader.nextLong();
//			long lower=lowerbound(arr, arr.length,L);
//			long upper=upperbound(arr, arr.length,R);
//			out.println((upper-lower));
				
//			//Slow solution
//			long ans = 0;
//			for (long i = l; i <= r; i++)
//			{
//				int cnt = 0;			
//				for (long j = 1; j <= i; j++)
//					if (GCD(i,j) == 1) cnt++;
//				
//				if (i % cnt == 0) {
//					ans++;
//					out.println(i + " " + cnt);
//				}
//			}
//			out.println(ans);	
        }		
	}

    long GCD(long a, long b)
    {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    
	//-----------------------------------------------------
	void runWithFiles() {
		in = new FastReader(new File("input.txt"));
		try {
			out = new PrintWriter(new File("output.txt"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		solve();
		out.close();
	}
	
	class FastReader
	{
	    BufferedReader br;
	    StringTokenizer tokenizer;
	    
	    public FastReader(InputStream stream)
	    {
	        br = new BufferedReader(new InputStreamReader(stream));
	        tokenizer = null;
	    }
		public FastReader(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
				tokenizer = null;
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	    
	    private String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens())
	            try {
	            	tokenizer = new StringTokenizer(br.readLine());
	            }
	            catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        return tokenizer.nextToken();
	    }
		public String nextLine() {
			try	{
				return br.readLine();
			}
			catch(Exception e) {
				throw(new RuntimeException());
			}
		}

	    int nextInt() {
	        return Integer.parseInt(next());
	    }
	    long nextLong() {
	        return Long.parseLong(next());
	    }
	    double nextDouble() {
	        return Double.parseDouble(next());
	    }	    
	    BigInteger nextBigInteger() {
	        return new BigInteger(next());
	    }
	    BigDecimal nextBigDecimal() {
	        return new BigDecimal(next());
	    }
	}
}