

## Unit Testing

Algorithms: Create Java tests to check the following Java classes in Lab_5 (with a short description of what each algorithm does):

1. **BubbleSort**.
	- Bubble sort is a simple sorting algorithm that repeatedly compares adjacent elements in a list and swaps them if they’re in the wrong order.
2. **QuickSort**: 
	- Quick sort is a much faster, divide-and-conquer sorting algorithm. Here’s how it works (in short):
		- Pick a pivot element from the list.
		- Partition the list into two parts:
			- elements smaller than the pivot
			- elements greater than the pivot
		- Recursively apply the same steps to each part.
		- Combine the results: sorted left + pivot + sorted right.
3. **MergeSort**: 
	- Merge sort is another divide-and-conquer sorting algorithm — very systematic and stable. Here’s how it works (short version):
		- Divide the list into two halves until each sublist has one element.
		- Merge the sublists back together in order, comparing elements as you go.
		- Continue merging until you have one fully sorted list.
4. **BinarySearch**: 
	- Binary search is a fast algorithm to find an element in a sorted list. Here’s how it works:
		- Look at the middle element of the list.
		- If it’s the one you want — done!
		- If your target is smaller, search the left half.
		- If it’s larger, search the right half.
		- Repeat until you find it or the list is empty.
5. **BFS**: 
	- BFS (Breadth-First Search) is a graph traversal algorithm that explores level by level — it visits all neighbors of a node before moving deeper. How it works:
		- Start from a root node.
		- Visit all its direct neighbors.
		- Then visit the neighbors’ neighbors, and so on.
		- Use a queue to keep track of nodes to visit next.


### Sonarqube results

Check the results of the tests above in Sonarqube