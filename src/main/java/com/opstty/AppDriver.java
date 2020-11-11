package com.opstty;

import com.opstty.job.Districts;
import com.opstty.job.MaxHeight;
import com.opstty.job.Species;
import com.opstty.job.TreesCount;
import com.opstty.job.WordCount;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");
            programDriver.addClass("districts", Districts.class,
                    "A map/reduce program that counts the districts in the dataset input files.");
            programDriver.addClass("species", Species.class,
                    "A map/reduce program that counts the species in the dataset input files.");
            programDriver.addClass("treescount", TreesCount.class,
                    "A map/reduce program that counts the trees by species in the dataset input files.");
            programDriver.addClass("maxheight", MaxHeight.class,
                    "A map/reduce program that get the highest tree by species in the dataset input files.");
            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
