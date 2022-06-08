package com.test.task1;

public class IPConvert
{

    public static void main(String[] args)
    {
        IPConvert cl = new IPConvert();

        String ip_str = "192.168.2.99";

        for (String str : args)
        {
            System.out.println("arg = " + str);
            if (str.startsWith("-ip="))
            {
                String[] st = str.split("=");
                if(st[1].length() > 0)
                {
                    ip_str = st[1];
                    break;
                }
            }

        }

        long longip = cl.ipToLong(ip_str);

        System.out.println("ip address : " + ip_str + "\nlongip : " + longip);

        String ip_str_new = cl.longToIP(longip);

        System.out.println("longToIP result : " + ip_str_new);
    }

    public long ipToLong(String ipAddr)
    {
        long result = 0;
        try
        {
            String[] ipArr = ipAddr.split("\\.");
            for (int i = 0; i < ipArr.length; i++) {
                int pp = 3 - i;
                int ip = Integer.parseInt(ipArr[i]);
                result += ip * Math.pow(256, pp);
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public String longToIP(long li)
    {
        return ((li >> 24) & 0xFF) + "." +
                ((li >> 16) & 0xFF) + "." +
                ((li >> 8) & 0xFF) + "." +
                (li & 0xFF);
    }

}
