package com.tensquare.encrypt.rsa;

/**
 * rsa加解密用的公钥和私钥
 * @author Administrator
 *
 */
public class RsaKeys {

	//生成秘钥对的方法可以参考这篇帖子
	//https://www.cnblogs.com/yucy/p/8962823.html

//	//服务器公钥
//	private static final String serverPubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6Dw9nwjBmDD/Ca1QnRGy"
//											 + "GjtLbF4CX2EGGS7iqwPToV2UUtTDDemq69P8E+WJ4n5W7Iln3pgK+32y19B4oT5q"
//											 + "iUwXbbEaAXPPZFmT5svPH6XxiQgsiaeZtwQjY61qDga6UH2mYGp0GbrP3i9TjPNt"
//											 + "IeSwUSaH2YZfwNgFWqj+y/0jjl8DUsN2tIFVSNpNTZNQ/VX4Dln0Z5DBPK1mSskd"
//											 + "N6uPUj9Ga/IKnwUIv+wL1VWjLNlUjcEHsUE+YE2FN03VnWDJ/VHs7UdHha4d/nUH"
//											 + "rZrJsKkauqnwJsYbijQU+a0HubwXB7BYMlKovikwNpdMS3+lBzjS5KIu6mRv1GoE"
//											 + "vQIDAQAB";
//
//	//服务器私钥(经过pkcs8格式处理)
//	private static final String serverPrvKeyPkcs8 = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDoPD2fCMGYMP8J"
//				 								 + "rVCdEbIaO0tsXgJfYQYZLuKrA9OhXZRS1MMN6arr0/wT5YniflbsiWfemAr7fbLX"
//				 								 + "0HihPmqJTBdtsRoBc89kWZPmy88fpfGJCCyJp5m3BCNjrWoOBrpQfaZganQZus/e"
//				 								 + "L1OM820h5LBRJofZhl/A2AVaqP7L/SOOXwNSw3a0gVVI2k1Nk1D9VfgOWfRnkME8"
//				 								 + "rWZKyR03q49SP0Zr8gqfBQi/7AvVVaMs2VSNwQexQT5gTYU3TdWdYMn9UeztR0eF"
//				 								 + "rh3+dQetmsmwqRq6qfAmxhuKNBT5rQe5vBcHsFgyUqi+KTA2l0xLf6UHONLkoi7q"
//				 								 + "ZG/UagS9AgMBAAECggEBANP72QvIBF8Vqld8+q7FLlu/cDN1BJlniReHsqQEFDOh"
//				 								 + "pfiN+ZZDix9FGz5WMiyqwlGbg1KuWqgBrzRMOTCGNt0oteIM3P4iZlblZZoww9nR"
//				 								 + "sc4xxeXJNQjYIC2mZ75x6bP7Xdl4ko3B9miLrqpksWNUypTopOysOc9f4FNHG326"
//				 								 + "0EMazVaXRCAIapTlcUpcwuRB1HT4N6iKL5Mzk3bzafLxfxbGCgTYiRQNeRyhXOnD"
//				 								 + "eJox64b5QkFjKn2G66B5RFZIQ+V+rOGsQElAMbW95jl0VoxUs6p5aNEe6jTgRzAT"
//				 								 + "kqM2v8As0GWi6yogQlsnR0WBn1ztggXTghQs2iDZ0YkCgYEA/LzC5Q8T15K2bM/N"
//				 								 + "K3ghIDBclB++Lw/xK1eONTXN+pBBqVQETtF3wxy6PiLV6PpJT/JIP27Q9VbtM9UF"
//				 								 + "3lepW6Z03VLqEVZo0fdVVyp8oHqv3I8Vo4JFPBDVxFiezygca/drtGMoce0wLWqu"
//				 								 + "bXlUmQlj+PTbXJMz4VTXuPl1cesCgYEA6zu5k1DsfPolcr3y7K9XpzkwBrT/L7LE"
//				 								 + "EiUGYIvgAkiIta2NDO/BIPdsq6OfkMdycAwkWFiGrJ7/VgU+hffIZwjZesr4HQuC"
//				 								 + "0APsqtUrk2yx+f33ZbrS39gcm/STDkVepeo1dsk2DMp7iCaxttYtMuqz3BNEwfRS"
//				 								 + "kIyKujP5kfcCgYEA1N2vUPm3/pNFLrR+26PcUp4o+2EY785/k7+0uMBOckFZ7GIl"
//				 								 + "FrV6J01k17zDaeyUHs+zZinRuTGzqzo6LSCsNdMnDtos5tleg6nLqRTRzuBGin/A"
//				 								 + "++xWn9aWFT+G0ne4KH9FqbLyd7IMJ9R4gR/1zseH+kFRGNGqmpi48MS61G0CgYBc"
//				 								 + "PBniwotH4cmHOSWkWohTAGBtcNDSghTRTIU4m//kxU4ddoRk+ylN5NZOYqTxXtLn"
//				 								 + "Tkt9/JAp5VoW/41peCOzCsxDkoxAzz+mkrNctKMWdjs+268Cy4Nd09475GU45khb"
//				 								 + "Y/88qV6xGz/evdVW7JniahbGByQhrMwm84R9yF1mNwKBgCIJZOFp9xV2997IY83S"
//				 								 + "habB/YSFbfZyojV+VFBRl4uc6OCpXdtSYzmsaRcMjN6Ikn7Mb9zgRHR8mPmtbVfj"
//				 								 + "B8W6V1H2KOPfn/LAM7Z0qw0MW4jimBhfhn4HY30AQ6GeImb2OqOuh3RBbeuuD+7m"
//				 								 + "LpFZC9zGggf9RK3PfqKeq30q";

	//服务器公钥
	private static final String serverPubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvZUwcWDCFbovtO2KoAtU\n" +
			"dkEtVD4uPV4Rn1RN5t2d31YjLZ//096HUvJqob+VvCTjbbhD2m7hjLaIIWIRlSVY\n" +
			"li2yAeLyO/Rzpzdcz8WK6VMDNIIguGt8RcHAgh/D/ZlGih08UEPv8cGpj7kBvEew\n" +
			"VHf5HF1fKORvFdrcabsJtd59TFdmAAR9yqKIZyAjeuC92wD05WXgChs8hMIT0CX/\n" +
			"HDbsei8t6AsePyoAhi60vu7wywJHXHf4n0R8NrPW2qOnet+A06BIw9nH8s0aubS4\n" +
			"sSwcJJb0PIrc86MTdJ25Toohrcn6uL6Ondmqq+X48xtaeQ3NtYdEUssDXfvkW40U\n" +
			"MwIDAQAB";

	//服务器私钥(经过pkcs8格式处理)
	private static final String serverPrvKeyPkcs8 = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC9lTBxYMIVui+0\n" +
			"7YqgC1R2QS1UPi49XhGfVE3m3Z3fViMtn//T3odS8mqhv5W8JONtuEPabuGMtogh\n" +
			"YhGVJViWLbIB4vI79HOnN1zPxYrpUwM0giC4a3xFwcCCH8P9mUaKHTxQQ+/xwamP\n" +
			"uQG8R7BUd/kcXV8o5G8V2txpuwm13n1MV2YABH3KoohnICN64L3bAPTlZeAKGzyE\n" +
			"whPQJf8cNux6Ly3oCx4/KgCGLrS+7vDLAkdcd/ifRHw2s9bao6d634DToEjD2cfy\n" +
			"zRq5tLixLBwklvQ8itzzoxN0nblOiiGtyfq4vo6d2aqr5fjzG1p5Dc21h0RSywNd\n" +
			"++RbjRQzAgMBAAECggEAdEk5gKHwCrG8p4b4+/hXI34RFtZZOI0l1Aw7CHwxZReJ\n" +
			"1meI3WVmritB2tsQNmqOEfPvsuFGejBQSeHElS5mKx/2Sw/ws3PbKNtdk5hA/6NK\n" +
			"mP+koFpVzNfuhCKF7l0BFqCeKUGywSCgKCc7+Egk0XsRkyN2xjdwKACqKDRw3VuA\n" +
			"QFQUxijxCpuXK9SlhKLAG14OTJlze2aUlVX32kDw8qxPMFg6Gvil+6vwPtEvVMYH\n" +
			"CBP+lrgV78bPZH2EGDo9hdVLkshkiEsAUf69T8ee2XcGA+JNO4ZB2E75H6l2X6e9\n" +
			"k+fQW8zSNvwNbUy2B0vKpWTg86bNpi1p5bug0gpT2QKBgQDg1z7ZH0kETNJsFrMP\n" +
			"3k8sa/doQdjB3rNCMO6akKAetNZ6cCDkQgrx3J4w6o7SrzZV9bQoJA9rMfvSpetO\n" +
			"qF9PR3/QoArh8upr9E3sPY6aw0DQLzH3D7TerhOoOrUaFFpBCC6jS89cKO16w5Ob\n" +
			"+gwymP7sp6ZGdYFaarSJBm6VTQKBgQDX2xUXdrH9qZJtsTThXsGK0prbflsBSkkm\n" +
			"H3ZV9bprl5vWV600yNmEmmwY5wXOmZ/vaQFhJaFcKzh0NBlzVDohn6yvXeN4BNve\n" +
			"TxzqnvB/f3E+rmRgejh4dqEYNGv8xvH52t5xWniyAk3N8QHaUgg4laJ2cfil5iIH\n" +
			"iboVuPePfwKBgQCZqOEN2AC5zJq+PiEwBhmL3VmfSekOTdmqsfBPd+nGMoal9L21\n" +
			"4aDDPKhr+9GSESaMRrhR+psDAoz8oGIZRp6ketPSS55EXxRwpO0gN82e3TQNU0PN\n" +
			"elF9IfDTNxQP97ra2PGurh/P9zSdgs39ej0d00vdhpHvc1zs4yHwx5GJvQKBgQDD\n" +
			"8GkK7YHQgvcaf3tDAOKrA1Xy3JX7a9VOt8yRZweb1vls7hWaDp/00MBDMqKA0c7u\n" +
			"YeEQsDnzEoCiaxCXMeO61djJL27maXK0MBhNmY0yDxtbDK6tLQTJxNWixSMpR+Yr\n" +
			"KdQ2DSv2WkUKJjXKWiCATMQ2xGozHd3R/eFfCpIePQKBgQDeuyHwU06DrG2FDT6T\n" +
			"L63BDWJf5h1LnwIaxE5qlAqPB0jp9zGSabR5Zm/QLEDSw+hvJ0nVOEzJQ10FT/8g\n" +
			"NJV6KWwtNL6sjgw+xgTcQvb0NGnATxoyM7pycxtnW857csr6ZPj7MdUmj9TXHSEd\n" +
			"3Eovw1K7b02hoLdRgfqZAJODcw";

	public static String getServerPubKey() {
		return serverPubKey;
	}

	public static String getServerPrvKeyPkcs8() {
		return serverPrvKeyPkcs8;
	}
	
}
