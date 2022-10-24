#include <iostream>
#include <iomanip>
using namespace std;

//Template function that returns total of all values entered by user
template <class T>
T total(int n) {
	int i;
	// initialized variables
	T sum = 0;
	T value = 0;

	cout << endl << "Enter " << n << " values" << endl;
	// for loop statement to read input values and add up together and store into sum variables
	for (i = 1; i <= n; i++) {
		cout << "Enter value #" << i << ": ";
		cin >> value;
		sum += value;
		cout << endl;
	}
	return sum;
}

int main() {
	int n;
	//displays input for how many integer values
	//diplays output for integer total
	cout << "How many integer values do you wish to total: ";
	cin >> n;
	cout << "Total: " << total<int>(n) << endl << endl;

	//displays input for how many doubles values
	//displays output for double total
	cout << "How many double values do you wish to total: ";
	cin >> n;
	cout << "Total: " << total<double>(n) << endl << endl;

	system("pause");
	return 0;
}