#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>

int cho(int k){
  int i;
  int t = 0;
  for(i = k/5;i>=0;i--){
    if ((k-5*i)%3 == 0) t = 1;
    if(t ==1) break;
  }
  if(t ==0){
    return -1;
  }
  return i;
}

int main(){
  int k;
  int b;
  scanf("%d",&k);
  int i;
  i = cho(k);
  if(i!=-1){
    b = i+ (k-5*i)/3;
  }
  else b = -1;

  printf("%d",b);
  return 0;
}