#include <iostream>
using namespace std;

class CQueue {
    private:
        struct node {
            int value;
            node* next;
            node* prev;
        };
        node* start;
        node* end;

    public:
        CQueue::CQueue();
        void enqueue(int);
        int dequeue();
        void print();
};

CQueue::CQueue() {
    start = NULL;
    end = NULL;
}

void CQueue::enqueue(int val) {
    node* tmp = new node;
    tmp->value = val;
    tmp->next = start;
    tmp->prev = end;

    if (start == NULL && end == NULL) {
        tmp->next = tmp;
        tmp->prev = tmp;
        start = tmp;
        end = tmp;
    }
    else {
        end->next = tmp;
        start->prev = tmp;
        start = tmp;
    }
}

int CQueue::dequeue() {
    int val = end->value;

    end->prev->next = start;
    start->prev = end->prev;

    node* tmp = end;
    end = end->prev;

    delete(tmp);

    return val;
}

void CQueue::print() {
    node* crnt = start;
    do {
        cout << crnt->value << endl;
        crnt = crnt->next;
    } while(crnt != start);
}

int main() {
    CQueue q;

    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.print();

    cout << "dequeue" << endl;
    q.dequeue();
    q.print();

    system("PAUSE");
    return 0;
}
