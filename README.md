## What's that?
It's a simple script that checks results from the paper: «Effects of Different Pre-Treatments on the 
Seed Germination of Carex Lasiocarpa.»

## What it does?
It iterates over all possible 3-multicombinations from set {0 .. 30}. Every multicombination represents possible
numbers of germination in three Petri dishes with 30 seeds each. For every multicombination the script turns
numbers of germinated seeds to percentage of germinated seeds and then calculates mean and standard deviation.
For standard deviation the script uses corrected ![Corrected sample SD][corrected] and uncorrected 
![Uncorrected sample SD][uncorrected] sample standard deviation formulas.

Then the script compares calculated mean and deviations of the multicombination with the data from the paper. 
If they are approximately equal the script prints the multicombination to the standard output.
 
## So what?
For the data from the table 3 (Effects of NaOH treatments on germination characters of C. lasiocarpa (Mean ±SD))
the script outputs the following:
    
    Paper data: 12.22% ± 4.16%
     2,  4,  5: 12.22% ± 5.09% (corrected), ± 4.16% (uncorrected)
    
    Paper data: 40.00% ± 4.71%
    10, 13, 13: 40.00% ± 5.77% (corrected), ± 4.71% (uncorrected)
    11, 11, 14: 40.00% ± 5.77% (corrected), ± 4.71% (uncorrected)
    
    Paper data: 30.00% ± 2.72%
     8,  9, 10: 30.00% ± 3.33% (corrected), ± 2.72% (uncorrected)
    
    Paper data: 50.00% ± 5.44%
    13, 15, 17: 50.00% ± 6.67% (corrected), ± 5.44% (uncorrected)
    
    Paper data: 70.00% ± 5.44%
    19, 21, 23: 70.00% ± 6.67% (corrected), ± 5.44% (uncorrected)
    
    Paper data: 55.56% ±10.30%
    14, 15, 21: 55.56% ±12.62% (corrected), ±10.30% (uncorrected)
    
    Paper data: 17.78% ± 6.85%
     3,  5,  8: 17.78% ± 8.39% (corrected), ± 6.85% (uncorrected)

It means that the authors of the paper used uncorrected sample standard deviation formula instead of the corrected.  

 [corrected]: http://quicklatex.com/cache3/ql_db0ba62d1516d840a9d4c7a1a6cbeef0_l3.png "Corrected sample standard deviation formula"
 [uncorrected]: http://quicklatex.com/cache3/ql_edcd9a2a230749255ddfce88503eea64_l3.png "Uncorrected sample standard deviation formula"