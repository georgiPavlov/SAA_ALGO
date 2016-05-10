//Да се състави алгоритъм, който намира броя на седловите точки на даден двумерен масив. Седлова точка на двумерен масив е
//такъв елемент, който едновременно е минимален за стълба и максимален за реда, в който се намира или обратно.
//Освен това за да бъде точката седлова то в съответния ред или стълб не трябва да има друг елемент със същия екстремум.
#include <stdio.h>
int main()
{
    int a[3][3]= {{5,4,3},{6,5,8},{7,3,1}};
    int i,j,count=0,k,flag=0,min,max,occur;
    for(i=0; i<3; i++)
    {
        for(j=0; j<3; j++)
            printf("%d ",a[i][j]);
        printf("\n");
    }
    for(i=0; i<3; i++)
    {
        for(j=0; j<3; j++)
        {
            flag=0;
            occur=0;
            min=a[i][0];
            for(k=0; k<3; k++)
            {
                if(a[i][k]<min)
                    min=a[i][k];
                if(a[i][k]==a[i][j])
                    occur++;
            }
            if(occur<2&&min==a[i][j])
            {
                max=a[0][j];
                occur=0;

                for(k=0; k<3; k++)
                {
                    if(a[k][j]>max)
                        max=a[k][j];
                    if(a[k][j]==a[i][j])
                        occur++;
                }
                if(occur<2&&max==a[i][j])
                flag=1;

            }
            if(flag==1) count++;
            else
            {
              occur=0;
            max=a[i][0];
            for(k=0; k<3; k++)
            {
                if(a[i][k]>max)
                    max=a[i][k];
                if(a[i][k]==a[i][j])
                    occur++;
            }
            if(occur<2&&max==a[i][j])
            {
                min=a[0][j];
                occur=0;

                for(k=0; k<3; k++)
                {
                    if(a[k][j]<min)
                        min=a[k][j];
                    if(a[k][j]==a[i][j])
                        occur++;
                }
                if(occur<2&&min==a[i][j])
                flag=1;

            }
            if(flag==1) count++;
            }

        }
    }
    printf("Count:%d\n",count);

}
