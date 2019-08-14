import java.util.ArrayList;
import java.util.Scanner;
/*
 * Runs the Application.
 */
public class Application {

	public static void main(String[] args) {
		Patient [] heap = new Patient[19];
		
		Patient p1 = new Patient(15,"jack");
		Patient p2 = new Patient(16,"john");
		Patient p3 = new Patient(17,"stacey");
		Patient p4 = new Patient(18,"link");
		Patient p5 = new Patient(19,"darry");
		Patient p6 = new Patient(25,"welly");
		Patient p7 = new Patient(53,"dreen");
		Patient p8 = new Patient(29,"jaged");
		Patient p9 = new Patient(23,"lotey");
		Patient p10 = new Patient(62,"prosley");
		Patient p11 = new Patient(92,"waxteena");
		Patient p12 = new Patient(31,"jackle");
		Patient p13 = new Patient(33,"janet");
		Patient p14 = new Patient(34,"plackle");
		Patient p15 = new Patient(35,"dale");
		Patient p16 = new Patient(36,"jickle");
		Patient p17 = new Patient(37,"jaemen");
		Patient p18 = new Patient(38,"sally");
		
		
		heap[1] = p1;
		heap[2] = p2;
		heap[3] = p3;
		heap[4] = p4;
		heap[5] = p5;
		heap[6] = p6;
		heap[7] = p7;
		heap[8] = p8;
		heap[9] = p9;
		heap[10] = p10;
		heap[11] = p11;
		heap[12] = p12;
		heap[13] = p13;
		heap[14] = p14;
		heap[15] = p15;
		heap[16] = p16;
		heap[17] = p17;
		heap[18] = p18;
		
		
		ArrayList<Patient> heapList = new ArrayList<>();
		heapList.add(null);
		for (int i = 1; i < heap.length; i++) {
			heapList.add(heap[i]);
		}
		MaxHeapPriorityQueue arr = new MaxHeapPriorityQueue(heapList);
		Boolean exit = false;
		
		
		
		while(!exit) {
			System.out.println("Please chose from the options bellow:");
			System.out.println("1: Print Patient List In Max Heap Order");
			System.out.println("2: Print Patient List Sorted From Highst Priority to Lowest");
			System.out.println("3: Add A Patient To The List");
			System.out.println("4: View The Patient With The Highst Priority");
			System.out.println("5: Treat The Patient With The Highst Priority");
			System.out.println("6: Increase A Patients Priority");
			System.out.println("7: Exit");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			switch (choice) {
			case 1: arr.BuildMaxHeap();
					System.out.println(arr);
					break;
			case 2: arr.HeapSort();
					System.out.println(arr);
					break;
					
			case 3: if(arr.getSize() <= 20) {
						System.out.println("Enter The First Name Of The New Patient:");
						String name = scan.next();
						System.out.println("Enter The Priority Of The New Patient:");
						int priority = scan.nextInt();
						Patient p = new Patient(priority, name);
						arr.MaxHeapInsert(p);
						System.out.println(arr);
						break;
					} else {
						System.out.println("There Are To Many Patients In The List.");
					}
					break;
			case 4: System.out.println(arr.HeapMaximum());
					break;
			case 5: 
					System.out.println(arr.HeapExtractMax());
					System.out.println(arr);
					break;
			case 6: System.out.println("Select A Patient To Modify. Enter There Index Number:");
					System.out.println(arr);
					int index = scan.nextInt();
					System.out.println("What Would You Like " + arr.getPatientAtIndex(index).getName() + "'s New Priority To be?");
					int newPriority = scan.nextInt();
					Patient patient = new Patient(newPriority, arr.getPatientAtIndex(index).getName());
					arr.HeapIncreaseKey(index,patient );
					System.out.println(arr);
					break;
			case 7:	exit = true;
					break;
			}
		}	
	}
}
