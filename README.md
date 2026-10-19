# Thư viện giải phương trình bậc hai — hoạt động 539

API Java 17 `QuadraticEquation.solve(a, b, c)` trả về `Solution` bất biến với trạng thái `NONE`, `ONE`, `TWO`, `INFINITE` và danh sách nghiệm thực tăng dần. Hỗ trợ phương trình bậc nhất, hằng số, nghiệm kép, hệ số không hữu hạn (báo lỗi). Các phép tính dùng độ chính xác `double`; không phải thư viện đại số chính xác tùy ý.

```sh
mvn clean package
java -cp target/quadratic-lib-1.0.0.jar com.codegym.math.Example 1 -3 2
```

Kết quả ví dụ: `TWO [1.0, 2.0]` (có thể sai số làm tròn ở chữ số cuối). File `target/quadratic-lib-1.0.0.jar` là thư viện độc lập, không cần JUnit lúc chạy. Có thể thêm JAR vào classpath ứng dụng khác rồi import `com.codegym.math.QuadraticEquation`.

Kiểm thử JUnit bao gồm 9 trường hợp: hai nghiệm, nghiệm kép, vô nghiệm thực, bậc nhất, hằng số, c = 0, nghiệm nhỏ dễ mất chính xác, hệ số lớn, hệ số NaN/Infinity. Chuẩn hóa hệ số và công thức q giảm tràn số và triệt tiêu số hạng khi tính nghiệm.

Mã tự triển khai với trợ giúp Codex theo yêu cầu CodeGym 539.
