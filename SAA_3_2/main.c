//������ � ���������� ����� � ��������� [10..10000]. �� �� ������� ���������� �������, ���� ����� �� ������� ������ �� ������� ��.
#include <stdio.h>
int sum(int n,int a)
{

    if(n==0)  return a;
     else sum(n/10,a+n%10);
}
int main()
{
    int n;
    printf("Enter number:");
    scanf("%d",&n);
    printf("sum:%d\n",sum(n,0));
    return 0;
}
