//Да се състави алгоритъм проверяващ дали даден двумерен масив е магически квадрат. 
//Магически квадрат е двумерен масив, на който сумите на елементите от всички редове, 
//стълбове и двата диагонала са еднакви.
#include <stdio.h>
int main()
{
    int square[4][4]= {{1,15,14,4},{12,6,7,9},{8,10,11,5},{13,3,2,16}};
    int flag=1,i,j,sum=0,tmp=0;
    for(i=0; i<4; i++)
    {
        for(j=0; j<4; j++)
            printf("%d ",square[i][j]);
        printf("\n");
    }
    sum=square[0][0]+square[0][1]+square[0][2]+square[0][3];
    for(i=1; i<4; i++)
    {
        for(j=0; j<4; j++)
            tmp+=square[i][j];
        if(tmp!=sum)
        {
            flag=0;
            break;

        }
        tmp=0;
    }
    if(flag==1)
        for(i=0; i<4; i++)
        {
            for(j=0; j<4; j++)
                tmp+=square[j][i];
            if(tmp!=sum)
            {
                flag=0;
                break;

            }
            tmp=0;
        }
    if(flag==1)
        for(i=0; i<4; i++)
        {
            tmp+=square[i][i];



        }
    if(tmp!=sum)
    {
        flag=0;
    }
    tmp=0;
    for(i=0,j=3; i<4; i++,j--)
        tmp+=square[i][j];

        if(tmp!=sum)
    {
        flag=0;
    }
        if(flag==1)
            printf("Kvadrata e magicheski,suma:%d\n",sum);
        else printf("Kvadrata ne e magicheski\n");
    return 0;
}
