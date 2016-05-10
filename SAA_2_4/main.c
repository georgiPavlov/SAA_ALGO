//Програма за проверка дали между елементите на редицата а0, а1, а2,..., аn са изпълнени релациите: а0 < a1 > a2 < a3...
#include <stdio.h>
int check(int a[7])
{
   int i;
   for(i=1;i<7;i++)
   {
       if(i%2==0)
        if(a[i-1]<a[i]||a[i]>a[i+1])
         return 0;
   }
   return 1;
}
int main()
{
    int a[7] = {0,2,1,4,3,5,2};
    int b[7] = {0,2,1,4,5,3,2};
    if(check(a)==0)
     printf("Ne e izpulneno za a");
     else printf("Izpulneno e za a");
 if(check(b)==0)
     printf("Ne e izpulneno za b");
     else printf("Izpulneno e za b");
     return 0;
     }
