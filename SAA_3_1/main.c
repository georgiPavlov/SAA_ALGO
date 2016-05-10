//Да се състави рекурсивна функция, която извежда в обратна последователност стойностите на отделните елементи от даден едномерен масив.
#include <stdio.h>
void print_arr(int a[],int n)
{
    if(n==0)
     printf("%d\n",a[n]);
     else
     {
          printf("%d ",a[n]);
         print_arr(a,n-1);
     }
}
int main()
{
    int a[4];
    int i;
    for(i=0;i<4;i++)
    a[i]=i+1;

    print_arr(a,4-1);
    return 0;
}
