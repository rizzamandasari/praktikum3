package org.d3ifcool.ima04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.*;

public class TestJurnal02 {

    private static final String[] INPUT = {
            "43","512"
    };
    private static final String[] OUTPUT = {
            "Penghasilan kotor = 43 juta Rupiah\nPajak 5% = Rp. 2150000\nPenghasilan bersih = Rp. 40850000",
			"Penghasilan kotor = 512 juta Rupiah\nPajak 30% = Rp. 153600000\nPenghasilan bersih = Rp. 358400000" 
    };

    @Test
    public void testJurnal() {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        for (int i = 0; i < INPUT.length; i++) {
            System.setIn(new ByteArrayInputStream(INPUT[i].getBytes()));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(bos));

            Jurnal02.main(null);

            assertEquals(OUTPUT[i] + "\n", bos.toString());
        }

        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}
