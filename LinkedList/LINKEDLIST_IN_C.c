
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

typedef struct node{
 int data;
 node * next;
}NODE;


//1->2->3->4->5->6
//6->5->4->3->2->1

//create node
NODE * create_node(int value) {
  NODE * newNode = (NODE *) malloc(sizeof(NODE));
  newNode->data = value;
  newNode->next = NULL;
  return newNode;
}

//print
void printSingly(NODE * head) {
  if(head == NULL) return;
  while (head != NULL){
    printf(" the data is %d\n",head->data);
    head = head->next;
  }
  return;
}


// 3 pointer technique
NODE * singlyReverse(NODE * head) {
if(head == NULL) return head;

NODE * prev = NULL;
NODE * pres = head;
NODE * future = NULL;

  while(pres != NULL) {
    future = pres->next;
    pres->next = prev;
    prev= pres;
    pres = future; 
  }
return prev;
}

//recursive
//1->2->3->4->5->6
// head = 1,  front = 1, rear = 2, 2->3->4->5->6
// head = 2,  front = 2, rear = 3, 3->4->5->6
// head = 3,  front = 3, rear = 4, 4->5->6
// head = 4,  front = 4, rear = 5, 5->6
// head = 5,  front = 5, rear = 6, 6
// head = 6,  front = 6, rear = null, newhead = 6



// head = 6,  front = 5, rear = 6, newhead = 6
// head = 6,  front = 4, rear = 5, newhead = 6
// head = 6,  front = 3, rear = 4, newhead = 6
// head = 6,  front = 2, rear = 3, newhead = 6
// head = 6,  front = 1, rear = 2, newhead = 6






NODE * singlyRecursivelyReverse(NODE * head) {
if(head == NULL) {
  return head;
}
NODE * front  = head;
NODE * rear   = front->next;
NODE * newHead = NULL;
newHead = singlyRecursivelyReverse(rear);
if(rear == NULL) {
  newHead = front;
  return newHead;
}
rear->next = front;
front->next = NULL;
return newHead;
}

//if input is 2 , then we need to return 4
int nthNodeValueFromEnd(NODE * head, int n) {
  NODE * first = head;
  NODE * second = head;
  int count = n;
  while(count > 0){
    second =  second->next;
    count--;
  }
  //now we have first and second
  while(second !=NULL) {
    first = first->next;
    second = second->next;
  }
  return first->data;
}


//cycle in a linked list 
//1->2->3-> 4->5
//          |  |
//          6->7->8->9->NULL


//1->2->3->4->5->6

bool cycleInLinkedList(NODE * head) {
  if(head == NULL) return head;
  NODE * slow = head;
  NODE * fast = head;
  
  while(fast != NULL && fast->next != NULL){
      printf("slow is %d\n",slow->data);  
      printf("fast is %d\n",fast->data);  
      slow = slow->next;
      fast = fast->next->next;
      
      if(slow == fast && slow != NULL) {
        printf("\nfound the intersection %d\n",slow->data);
        return true;
      }


  }
  return false;
}



int main() {
  
  NODE * head = create_node(1);
  head->next = create_node(2);
  head->next->next = create_node(3);
  head->next->next->next = create_node(4);
  head->next->next->next->next = create_node(5);
  head->next->next->next->next->next = create_node(6);
  
  printf("===============singly 3 pointer reverse===================\n");
  head = singlyReverse(head);
  printSingly(head);
  head = singlyReverse(head);
  printf("===============singly Recursive reverse===================\n");
  head = singlyRecursivelyReverse(head);
  printSingly(head);
  head = singlyRecursivelyReverse(head);
  printf("===============Nth node from end===================\n");
  int output = nthNodeValueFromEnd(head, 2);
  printf("Nth node from end %d\n",output);
  
//cycle in a linked list 
//1->2->3-> 4->5
//          |  |
//          6<-7->8->9->NULL
          
  NODE * cyclehead = create_node(1);
  cyclehead->next = create_node(2);
  cyclehead->next->next = create_node(3);
  NODE * fourthNode = create_node(4);
  cyclehead->next->next->next = fourthNode;
  fourthNode->next = create_node(5);
  
  fourthNode->next->next = create_node(7);
  fourthNode->next->next->next = create_node(6);
  
  fourthNode->next->next->next->next = fourthNode;
   
  printf("is cycle %s\n",cycleInLinkedList(head)?"TRUE":"FALSE");
  printf("\n");
  printf("is cycle %s\n",cycleInLinkedList(cyclehead)?"TRUE":"FALSE");
}








