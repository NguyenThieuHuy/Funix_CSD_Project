## How it works？
- `Selection sort`: liên tục chọn phần tử nhỏ nhất để thêm vào kết quả.
・Tìm phần tử nhỏ nhất và đặt nó vào vị trí đầu tiên.
・Tìm phần tử nhỏ nhất tiếp theo và đặt nó ở vị trí thứ hai.
・Lặp lại cho đến khi tất cả các phần tử ở đúng vị trí.

- `Insertion sort`: liên tục thêm phần tử mới vào kết quả đã sắp xếp.
・Lấy phần tử đầu tiên làm mảng con đã sắp xếp.
・Chèn phần tử thứ hai vào mảng con đã sắp xếp (thay đổi phần tử nếu cần).
・Chèn phần tử thứ ba vào mảng con đã sắp xếp.
Lặp lại cho đến khi tất cả các phần tử được chèn.

- `Bubble sort`: liên tục so sánh các cặp cạnh nhau và hoán đổi nếu cần thiết.
・Quét mảng, hoán đổi cặp phần tử liền kề nếu chúng không theo thứ tự tương đối. Điều này làm phần tử lớn nhất "nổi" lên trên.
・Quét mảng một lần nữa, làm "nổi" lên phần tử lớn thứ hai.
・Lặp lại cho đến khi tất cả các phần tử theo thứ tự.

## Efficiency to different kinds of array!

- `Sort array in reverse order`: Selection sort > Insertion sort ~ Bubble sort

- `Sorted array`: Insertion sort ~ Bubble sort >> Selection sort

- `Random array`: Selection sort = Insertion sort = Bubble sort

## Time Complexity!

# Best Case:
- `Selection sort`: Độ phức tạp trong trường hợp tốt nhất là O (N2) vì để tìm phần tử nhỏ nhất tại mỗi lần lặp, chúng ta sẽ phải duyệt qua toàn bộ mảng chưa được sắp xếp.

- `Bubble sort`: Độ phức tạp trong trường hợp tốt nhất là O (N). Nó xảy ra khi chúng ta có một mảng đã được sắp xếp, như trong trường hợp đó, chúng ta sẽ hoàn thành sau một lần kiểm.

- `Insertion sort`: Độ phức tạp trong trường hợp tốt nhất là O (N). Nó xảy ra khi chúng ta có một mảng đã được sắp xếp; như trong trường hợp đó, mỗi phần tử đã được đặt ở đúng vị trí của nó và không cần thực hiện thao tác hoán đổi.

# Worst Case:
- `Selection sort`: Độ phức tạp trong trường hợp xấu nhất là O (N2) vì để tìm phần tử nhỏ nhất tại mỗi lần lặp, chúng ta sẽ phải duyệt qua toàn bộ mảng chưa được sắp xếp.

- `Bubble sort`: Độ phức tạp trong trường hợp xấu nhất là O (N2). Nó xảy ra khi chúng ta có một mảng được sắp xếp ngược lại, như trong trường hợp đó, chúng ta sẽ phải thực hiện tất cả các bước.

- `Insertion sort`: Độ phức tạp trong trường hợp xấu nhất là O (N2). Nó xảy ra khi chúng ta có một mảng được sắp xếp ngược lại, như trong trường hợp đó, để tìm vị trí chính xác cho bất kỳ phần tử nào, chúng ta sẽ phải duyệt qua toàn bộ mảng đã sắp xếp mỗi lần.

# Average Case:
・Đối với tập dữ liệu ngẫu nhiên, cả ba thuật toán đều có độ phức tạp về thời gian là O (N2). Số nghịch đảo dự kiến ​​(cũng là trung bình) trong tập dữ liệu được tạo ngẫu nhiên có kích thước N có các phần tử riêng biệt là N * (N - 1) / 4.

・Trong `Bubble sort` và `Insertion sort`, chúng tôi hoán đổi các phần tử liền kề, điều này làm giảm số lần nghịch đảo đi 1 và trong một lần lặp, chúng tôi có thể thực hiện tối đa N - 1 hoán đổi liền kề. Vì vậy, để làm cho số nghịch đảo bằng không, chúng ta phải thực hiện nhiều hơn một lần lặp (khoảng N / 4 lần lặp), và do đó độ phức tạp trở thành O (N2).

・Trong `Selection sort`, chúng tôi chỉ thực hiện 1 hoán đổi (không liền kề) và đặt một phần tử vào đúng vị trí của nó. Điều này có thể làm giảm số lượng đảo ngược N-1, nhưng để tìm phần tử đó, chúng ta phải duyệt qua toàn bộ mảng chưa được sắp xếp, điều này xảy ra nhiều lần tạo nên độ phức tạp O (N2).