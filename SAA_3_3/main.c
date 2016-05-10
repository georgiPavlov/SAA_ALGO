//Дадена е рекурентна числова редица, напр. 0:1, 1:2, 2:3,....
//Да се състави рекурсивна функция, извеждаща N-тия член на редицата. N е естествено число от интервала [0..20].
#include <stdio.h>
void member(int n,int i)
{
    if(i==n) printf("%d:%d ",i,i+1);
    else member(n,i+1);
}
int main()
{

    int n;
    printf("Enter number:");
    scanf("%d",&n);
    member(n,0);
    return 0;
}
