#include<iostream>  
#include <algorithm>
#include <array> 
using namespace std; 
  
int recOpt(int arr[], int i) {
    if (i == 0) {
        return arr[0];
    } else if (i == 1) {
        return max(arr[0], arr[1]);
        //对于最后两个，抢或者不抢
    } else {
        return max(recOpt(arr, i-2) + arr[i], recOpt(arr, i-1));
    }
}

int dpOpt(int arr[]) {
    int dp[6] = {0};

    dp[0] = arr[0];
    dp[1] = max(arr[0], arr[1]);

    for (int i = 2; i < 6; i++) {
        dp[i] = max(dp[i-2]+arr[i], dp[i-1]);
    }
    return dp[5];
}

bool recSub(int arr[], int i, int target) {
    if (target == 0) {
        return true;
    } else if (i == 0) {
        return arr[0] == target;
    } else if (arr[i] > target) {
        return recSub(arr, i-1, target);
    } else {
        return recSub(arr, i-1, target-arr[i]) || 
               recSub(arr, i-1, target);
    }
}

bool dpSub(int arr[], int target) {
    bool subset[6][] = {false};
    
    for (int row = 0; row < 5; row++) {
        subset[row][0] = true;
    }

    for (int col = 0; col < 6; col++) {
        subset[0][col] = false;
    }

    for (int row = 1; i < 5; row++) {
        for (int col = 1; col < 6; col++) {
            if (arr[row] > target) {
                subset[row][col] = subset[row-1][col]; 
            } else {
                subset[row][col] = 
                subset[row-1][col-arr[row]] ||
                subset[row-1][col];
            }
        }
    }
    return subset[5][];
}

int main() {
    int arr[] = {4, 1, 40, 29, 19, 21};

    cout<<"recOpt = "<<recOpt(arr, 5)<<endl;

    cout<<"dpOpt = "<<dpOpt(arr)<<endl;

    if (recSub(arr, 5, 6)) {
        cout<<"True"<<endl;
    } else {
        cout<<"False"<<endl;
    }

}