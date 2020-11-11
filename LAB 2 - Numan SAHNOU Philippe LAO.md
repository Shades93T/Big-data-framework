# <center><font color=#0398fc>__LAB2 - YARN MapReduce2__</font></center>
## <center>_Big Data Frameworks I_</center>
### <center>Numan SAHNOU & Philippe LAO</center>
<br></br>
# __I - MapReduce JAVA__

## __1.8 - Remarkable trees of Paris__
***

### We used _filezilla_ to put the `trees.csv` dataset file into the home directory. 
### After that, we put it in our HDFS directory using the following command :
    hdfs dfs -put /home/nsahnou/trees.csv

</details>
<br></br>

## __1.8.1 - Districts containing trees (very easy)__


### I this part we will write a MapReduce job that displays the list of distinct districts containing trees in the file. 
### So after we created both the mapper and reducer for the districts job using `Java`, we can now run the job using the jar we updated in the edge node : 
    yarn jar /home/nsahnou/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar districts /user/nsahnou/trees.csv /user/nsahnou/lab2/output1.8

### __We can now check the output :__
    hdfs dfs -cat lab2/output1.8/part-r-00000
    ...
    11
    12
    13
    14
    15
    16
    17
    18
    19
    20
    3
    4
    5
    6
    7
    8
    9

## __1.8.2 - Show all existing species (very easy)__

### Now we want to write a MapReduce job that displays the list of different species trees in the `trees.csv` dataset.
### Same as previously we created our mapper and reducer for this job and we executed the new updated jar file : 
    yarn jar /home/nsahnou/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar species /user/nsahnou/trees.csv /user/nsahnou/lab2/output1.84

### __Here is the output__ : 
    hdfs dfs -cat lab2/output1.84/part-r-00000
    araucana
    atlantica
    australis
    baccata
    bignonioides
    biloba
    bungeana
    cappadocicum
    carpinifolia
    ...
    tomentosa
    tulipifera
    ulmoides
    virginiana
    x acerifolia
## __1.8.3 - Number of trees by species (easy)__

### In this part we would like to write a new MapReduce job that will calculates the number of trees of each species. 
### So contrary to the previous MapReduce job we created, this time the mapper must extract the kind of tree and write '1' next to it and the reducer will get the pair (key, value) with the same key. So this key is basically the kind of tree and the value is the number of such trees. It is almost the same principle as the `WordCount` job.
### Same process we executed the updated jar file : 
    yarn jar /home/nsahnou/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar treescount /user/nsahnou/trees.csv /user/nsahnou/lab2/output1.85

### __Console output :__
    hdfs dfs -cat lab2/output1.85/part-r-00000
    araucana        1
    atlantica       2
    australis       1
    baccata         2
    bignonioides    1
    ...
    sylvatica       8 
    tomentosa       2
    tulipifera      2
    ulmoides        1
    virginiana      2
    x acerifolia    11

## __1.8.4 - Maximum height per specie of tree (average)__

### We want now create a job that will calculates the height of the tallest tree of each kind. 
### For example, the tallest Acer is 16m, the tallest Platanus is 45m, etc.
### After we created the Map Reduce job to perform this request, here is the output : 
    yarn jar /home/nsahnou/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar maxheight /user/nsahnou/trees.csv /user/nsahnou/lab2/outputmax
    ...
    hdfs dfs -cat lab2/outputmax/part-r-00000

    araucana        9.0
    atlantica       25.0
    australis       16.0
    baccata 13.0
    bignonioides    15.0
    biloba  33.0
    bungeana        10.0
           ......
    tomentosa       20.0
    tulipifera      35.0
    ulmoides        12.0
    virginiana      14.0
    x acerifolia    45.0

## __1.8.5 - Sort the trees height from smallest to largest (average)__

### For the next job we will write an MapReduce job that sort the trees height from smallest to largest.
### Same process as previously, we created the MapReduce job and run it throught HDFS.

### __Console output :__ 
    yarn jar /home/nsahnou/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar sorttree /user/nsahnou/trees.csv /user/nsahnou/lab2/outputsort2
    ...
    hdfs dfs -cat lab2/outputsort2/part-r-00000

    2.0
    5.0
    6.0
    9.0
    10.0
    10.0
    10.0
    ....
    35.0
    35.0
    40.0
    40.0
    40.0
    42.0
    45.0

## __1.8.6 - District containing the oldest tree (difficult)__

### We want now to create a MapReduce job that will display the district where the oldest tree is. 
### So the mapper must extract the age and district of each tree.
### The reducer should consolidate all this data and __only output the district__ with the oldest tree :

### __Console output :__
    yarn jar /home/nsahnou/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar oldesttree /user/nsahnou/trees.csv /user/nsahnou/lab2/outputoldest4
    ...
    hdfs dfs -cat lab2/outputoldest4/part-r-00000
    5

## __1.8.6 - District containing the oldest tree (difficult)__