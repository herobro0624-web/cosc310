# Bike Data Analysis

## Problem Formulation

### Problem 1 (Sorting)
"Given the lowest and highest cadences, do we see an increase or decrease in heartrate?"

This problem analyzes the relationship between cadence and heartrate by sorting the dataset based on cadence. By examining both the lowest and highest cadence values, we can observe how heartrate changes across extremes.

---

### Problem 2 (Searching / Time Analysis)
"How long did the rider spend time above the average altitude?"

This problem focuses on determining how much time the rider spent above the average altitude. It requires identifying all records where altitude exceeds the average and summing the time differences between consecutive timestamps.

---

## Solution Process

### Sorting Approach (Problem 1)

To analyze cadence vs heartrate:
- I used a **Merge Sort algorithm** (`Sorting.mergeSort`) to organize the data by cadence.
- I also used Java’s built-in `.sort()` to sort in descending order for comparison.

#### Why Merge Sort?
- **Time Complexity:** O(n log n)
- **Space Complexity:** O(n)
- Guarantees stable and efficient sorting for large datasets

#### Implementation Details:
- Sorted records by cadence (ascending and descending)
- Printed the first 10 valid entries (heartrate > 0)
- Compared low vs high cadence values

#### Result:
- Low cadence values (near 0) correspond to **lower heartrate values (~75–82 bpm)**
- High cadence values (100+) correspond to **higher heartrate values (~87–114 bpm)**

✅ Conclusion:  
There is a **positive correlation**—as cadence increases, heartrate generally increases.

---

### Searching / Time Analysis (Problem 2)

To determine time spent above average altitude:
1. Computed the **average altitude** using:
   - `map()` and `reduce()` to sum values
2. Sorted records by **timestamp** to ensure correct chronological order
3. Iterated through the dataset and:
   - Checked if altitude > average
   - Added the time difference between consecutive records

#### Why this approach?
- Requires **linear traversal** of time-ordered data
- More accurate than counting entries because timestamps may not be evenly spaced

#### Complexity:
- **Time Complexity:** O(n log n) (due to sorting) + O(n) traversal
- **Space Complexity:** O(1) additional space

#### Result:
- **Average altitude:** 37.53  
- **Time above average altitude:** 108,651 seconds (~30.18 hours)

---

## Final Output Summary

- Cadence vs Heartrate:
  - Low cadence → lower heartrate
  - High cadence → higher heartrate

- Altitude Analysis:
  - Average altitude: 37.53
  - Time above average altitude: 108,651 seconds

---

## Notes / Limitations

### Warning:
All data is influenced by outliers, which I cannot correct using Java (at the moment).

- Extremely high or low values may skew averages
- A more advanced statistical approach (e.g., median, standard deviation filtering) could improve accuracy

---

## Conclusion

The results show meaningful relationships in the dataset, particularly between cadence and heartrate, and provide insight into how the rider’s elevation changes over time.