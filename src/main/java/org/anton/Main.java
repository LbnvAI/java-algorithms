package org.anton;

import static org.anton.hexlet.module2.streams.HM2Streams.*;

public class Main {
    public static void main(String[] args) {
        String[] ip = {
                "2a03:2880:2130:cf05:face:b00c:0:1",
                "::b36:3c:f0:7:937",
                "000::B36:3C:00F0:7:937",
                "0B0:0F09:7f05:e2F3:0D:0:e0:7000",
                "10:d3:2d06:24:400c:5ee0:be:3d",
                "::",
                "::1",
                "1::1",
                "2a02:cb41:0:0:0:0:0:7",
                "e:6c::647:50:0:7",
                "04:07A1:1404:0A0:A:080F:080:0",
                "2607:G8B0:4010:801::1004",
                "2001::0:64::2",
                "2001",
                "2001:::",
                "2.001::",
                "9f8:0:69S0:9:9:d9a:672:f90d",
                "1001:208:67:4f00:e3::2c6:0",
                "e1b6:1daf9:6:0:c50:8c4:90e:e",
                "C00D::a2195:2EA9:096",
                "d:0:4:a004:3b96:10b0:10:800:15",
                "5c03:0:a::b825:d690:4ce0:2831:acf0",
                ":1::1",
                "1::1:",
                "2a02:0cb41:0:0:0:0:0:7"
        };
        for(String s : ip) {
            System.out.println(isValidIPv6(s));
        }
    }
}